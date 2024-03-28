package np.com.esewa.demo.service1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Service1Application {

	public static void main(String[] args) {
		System.setProperty("logback.ContextSelector", "org.slf4j.helpers.ContextAwareContextSelector");
		SpringApplication.run(Service1Application.class, args);
	}

}
