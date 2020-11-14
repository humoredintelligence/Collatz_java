import java.time.Duration;
import java.time.Instant;

public class MTCollatz {
	public static void main (String[] args) {
		int highNumber = Integer.parseInt(args[0]);
		int threadCount = Integer.parseInt(args[1]);
		int counter = 2;
		Calculate[] worker = new Calculate[threadCount];
		Instant start = Instant.now(); //Timer Start
		int j = highNumber; //Countdown from highest number to lowest
		do { //Begins run through of each number sequentially
			for (int k = 0 ; k < threadCount; k++) { //Starts a new thread until maximum number of threads are running.
				worker[k] = new Calculate(j); //Create thread
				worker[k].start(); //Begin work within thread
				j--; //Count backwards from high number to low
				counter++; // Make sure system stops when high number is reached
			} 
		} while (counter < highNumber);
		Instant finish = Instant.now(); //Stop timer
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

