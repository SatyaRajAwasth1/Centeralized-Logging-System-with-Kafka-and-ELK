package np.com.esewa.demo.service1.logger.config;

import np.com.esewa.demo.service1.logger.reporting.RequestCorrelation;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class CorrelationIdInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        String correlationId = request.getHeaders().getFirst(RequestCorrelation.CORRELATION_ID_HEADER);
        if (correlationId == null || correlationId.isBlank()) {
            correlationId = RequestCorrelation.getId();
            request.getHeaders().add(RequestCorrelation.CORRELATION_ID_HEADER, correlationId);
        }

        return execution.execute(request, body);
    }
}