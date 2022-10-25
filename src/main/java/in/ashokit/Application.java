package in.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Application {
	private static final String REST_URL = "http://www.equifax.com/gteScores";
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	

}
