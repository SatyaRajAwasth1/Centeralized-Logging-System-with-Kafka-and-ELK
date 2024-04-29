package np.com.esewa.demo.service2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Service2Controller {

    Logger logger = LoggerFactory.getLogger(Service2Controller.class);

    @GetMapping("/api/v1/service2")
    ResponseEntity<Map<String, Object>> sampleController(@RequestParam String msg){
        logger.info("Message request: {}", msg);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Hey, response from service2: "+msg);
        logger.info("Responding with: {}", response);
        return ResponseEntity.ok(response);
    }
}
