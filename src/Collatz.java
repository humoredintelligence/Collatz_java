import java.time.Duration;
import java.time.Instant;

public class Collatz {
	public static void main (String[] args) {
		int highNumber = 47;
		int threadCount = 2;
		int counter = 1;
		Calculate[] worker = new Calculate[threadCount];
		//String collatzArray[] = new String[highNumber - 2]; 
		Instant start = Instant.now();
		int j = highNumber;
		while (counter < highNumber) {
			for (int k = 0 ; k < threadCount; k++) {
				worker[k] = new Calculate(j);
				worker[k].start();
				j--;
				counter++;
			}
		}
		Instant finish = Instant.now();
		System.out.println(highNumber + "," + threadCount + "," + Duration.between(start, finish).toMillis());
	}
}
