package np.com.esewa.demo.service1.controler;

import np.com.esewa.demo.service1.service.SampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class SampleController {

    private final SampleService service;
    private static final Logger logger = LoggerFactory.getLogger(SampleController.class);

    public SampleController(SampleService service) {
        this.service = service;
    }

    @GetMapping("/api/v1/eg")
    public ResponseEntity<String> sayHey(@RequestParam String msg){
        logger.info("This is a msg from client: {}", msg);
        index();
        return new ResponseEntity<>( service.callToService2(msg), HttpStatus.OK);
    }

    @GetMapping()
    public String index() {
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");

        return "Howdy! Check out the Logs to see the output...";
    }

}
