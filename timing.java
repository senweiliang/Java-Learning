package instantAndDuration;

import java.time.Duration;
import java.time.Instant;

public class InstantAndDuration {

	public static void main(String[] args) {

		Instant start=Instant.now();
		//code
        //
        //
		Instant end=Instant.now();	
		
		Duration elapse=Duration.between(start, end);
		System.out.println(elapse.toMillis());
		
	}

}
