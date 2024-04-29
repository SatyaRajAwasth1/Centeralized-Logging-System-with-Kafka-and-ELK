package np.com.esewa.demo.service1.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@Service
public class SampleServiceImpl implements SampleService{

    private int n = 0;
    private final RestTemplate restTemplate;

    public SampleServiceImpl(@Qualifier("internalCallingRestTemplate") RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String callToService2(String msg) {
        log.info("Calling service2 with msg: {}", msg);
        String url = UriComponentsBuilder.fromUriString("http://localhost:8081/api/v1/service2").queryParam("msg",msg).build().toUriString();
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() ->
                restTemplate.getForEntity(url, String.class).getBody());

        try {
            return future.get();
        } catch (Exception e) {
            log.error("Exception occurred while calling service2: {}", e.getMessage());
            return null;
        }
    }

    @Override
    public void test() {
        System.out.println("Value of n: "+n +" HashCode: "+this);
        n++;
    }
}
