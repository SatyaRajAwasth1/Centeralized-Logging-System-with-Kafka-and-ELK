package np.com.esewa.demo.service1.logger.reporting;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.NONE)
public class RequestCorrelation {
    public static final String CORRELATION_ID_HEADER = "correlationId";

    private static final ThreadLocal<String> id = new InheritableThreadLocal<>();

    public static String getId() {
        return id.get();
    }

    public static void setId(String correlationId) {
        id.set(correlationId);
    }
}
