import java.time.Duration;
import java.time.Instant;

public class Collatz {
	public static void main (String[] args) {
		int highNumber = Integer.parseInt(args[0]);
		int threadCount = Integer.parseInt(args[1]);
		int counter = 2;
		Calculate[] worker = new Calculate[threadCount];
		Instant start = Instant.now();
		int j = highNumber;
		while (counter < highNumber) {
			for (int k = 0 ; k < threadCount; k++) {
				worker[k] = new Calculate(j);
				worker[k].start();
				j--;
				counter++;
			}
//			for (int k = 0 ; k < threadCount; k++) {
//				try {
//					worker[k].join();
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
		}
		Instant finish = Instant.now();
		System.out.println(highNumber + "," + threadCount + "," + Duration.between(start, finish).toMillis());
		for (int k = 0 ; k < threadCount; k++) {
			try {
			worker[k].join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
		return;
		
	}
}
