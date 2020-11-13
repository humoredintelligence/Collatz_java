
public class Calculate {
	long highNumber;
	int threadCount;
	
	//set number we are reaching for
	public void setHighNumber(long n) {
		highNumber = n;
	}
	
	//Returns the High Number
	public long getHighNumber() {
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
	
	//Constructor if no filecount or thread count is given.
	public Calculate() {
		setHighNumber(25);
		setThreadCount(2);
	}
	
	//Constructor for Running a new file if no thread count is given
	public Calculate(long n) {
		setHighNumber(n);
		setThreadCount(2);
	}
	
	//Constructor for running a new file if a thread count and high number are both given.
	public Calculate(long n, int m) {
		setHighNumber(n);
		setThreadCount(m);
	}

	public void collatz() {
		int i = 0; //Increment Counter, initializes to zero before the number runs
		long f = getHighNumber(); //Allows me to manipulate the number without changing n.
		
		//This loop will actually run the counter until it finishes
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
		System.out.println("Collatz of " + getHighNumber() + " is " + i);
	}
}
