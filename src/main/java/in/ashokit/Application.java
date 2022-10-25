package in.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import java.util.*;

@SpringBootApplication
@EnableCaching
public class Application {
	private Map<String,Object> cache = new HashMap<String,Object>();
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	public void loadDataToCache() {
			//logic
	}

}
