package np.com.esewa.demo.service1.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@Service
public class SampleServiceImpl implements SampleService{

    private final RestTemplate restTemplate;

    public SampleServiceImpl(@Qualifier("internalCallingRestTemplate") RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String callToService2(String msg) {
        log.info("Calling service2 with msg: {}", msg);
        String url = UriComponentsBuilder.fromUriString("http://localhost:8081/api/v1/service2").queryParam("msg",msg).build().toUriString();
        return restTemplate.getForEntity(url, String.class).getBody();
    }
}
