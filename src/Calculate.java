import java.util.concurrent.Semaphore;
import java.lang.Thread;

public class Calculate extends Thread {
	int highNumber;
	int threadCount;
	//Semaphore creator to stop Race Conditions
	static Semaphore semaphore = new Semaphore(1);
	
	//set number we are reaching for
	public void setHighNumber(int n) {
		highNumber = n;
	}
	
	//Returns the High Number
	public int getHighNumber() {
		return highNumber;
	}
	
	//Sets the number of threads
	public void setThreadCount(int n) {
		threadCount = n;
	}
	
	//Gets the Number of Threads
	public int getThreadCount() {
		return threadCount;
	}
	
	
	//Constructor if no file count or thread count is given.
	public Calculate() {
		setHighNumber(25);
		setThreadCount(2);
	}
	
	//Constructor for Running a new file if no thread count is given
	public Calculate(int n) {
		setHighNumber(n);
		setThreadCount(2);
	}
	
	//Constructor for running a new file if a thread count and high number are both given.
	public Calculate(int n, int m) {
		setHighNumber(n);
		setThreadCount(m);
	}

	public void run() {
		int i = 0; //Increment Counter, initializes to zero before the number runs
		int n = getHighNumber();
		long f = n; //Allows me to manipulate the number without changing n.
		try {
			semaphore.acquire();
			if (n < 2) return;
			try {
				semaphore.release();
				while(f != 1) {
					if (f == 1) return;
					else if (f % 2 == 0) {
						f = f / 2;
						i++;
					}
					else {
						f = (3*f + 1);
						i++;
					}	
				}
			}
			finally {
				System.err.println(n + "," + i);
			}
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
