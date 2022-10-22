package in.ashokit;

import java.time.Duration;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;

@RestController
public class AreaCalculationController {
	
	private final Bucket bucket;
	
	public AreaCalculationController() {
		Bandwidth limit = Bandwidth.classic(20, Refill.greedy(20, Duration.ofMinutes(1)));
		this.bucket = Bucket4j.builder().addLimit(limit).build();
	}

	@PostMapping(value="/api/v1/area/rectangle")
	public ResponseEntity<AreaV1> rectangle(@RequestBody RectangleDimensionsV1 dim) {
		if(bucket.tryConsume(1)) {
			return new ResponseEntity<>(new AreaV1("rectangle", dim.getLength()*dim.getWidth()), HttpStatus.OK);
		}
		
		return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).build();
	}
	
	@PostMapping(value = "/api/v1/area/triangle")
    public ResponseEntity<AreaV1> triangle(@RequestBody TriangleDimensionsV1 dimensions) {

        return new ResponseEntity<>(new AreaV1("triangle", 2 * dimensions.getHeight() * dimensions.getBase()), HttpStatus.OK);
    }

}
