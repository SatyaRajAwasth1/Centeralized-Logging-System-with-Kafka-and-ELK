package np.com.esewa.demo.service1.logger.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import np.com.esewa.demo.service1.logger.reporting.RequestCorrelation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

import static np.com.esewa.demo.service1.logger.reporting.RequestCorrelation.CORRELATION_ID_HEADER;

public class CorrelationIdFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(CorrelationIdFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String correlationId = request.getHeader(CORRELATION_ID_HEADER);
        if (correlationId == null || correlationId.isEmpty()) {
            correlationId = UUID.randomUUID().toString();
        }
        logger.info("Correlation ID: {}", correlationId);

        RequestCorrelation.setId(correlationId);
        logger.trace("MDC before setting correlation ID: {}", MDC.getCopyOfContextMap());
        MDC.put(CORRELATION_ID_HEADER, correlationId);
        logger.trace("MDC after setting correlation ID: {}", MDC.getCopyOfContextMap());

        try {
            filterChain.doFilter(request, response);
        } finally {
            MDC.remove(CORRELATION_ID_HEADER);
            logger.trace("MDC after removing correlation ID: {}", MDC.getCopyOfContextMap());
        }
    }

}

