
public class Calculate {
	int highNumber;
	int threadCount;
	int counter;
	String collatzArray[];
	
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
	
	//Sets counter
	public void setCounter(int n) {
		counter = n;
	}
	
	//Gets counter
	public int getCounter() {
		return counter;
	}
	
	//Constructor if no filecount or thread count is given.
	public Calculate() {
		setHighNumber(25);
		setThreadCount(2);
		setCounter(1);
		collatzArray = new String[(int) getHighNumber() - getCounter()];
	}
	
	//Constructor for Running a new file if no thread count is given
	public Calculate(int n) {
		setHighNumber(n);
		setThreadCount(2);
		setCounter(1);
		collatzArray = new String[(int) getHighNumber() - getCounter()];
	}
	
	//Constructor for running a new file if a thread count and high number are both given.
	public Calculate(int n, int m) {
		setHighNumber(n);
		setThreadCount(m);
		setCounter(1);
		collatzArray = new String[(int) getHighNumber() - getCounter()];
	}

	public void collatz() {
		int i = 0; //Increment Counter, initializes to zero before the number runs
		int n = getHighNumber();
		long f; //Allows me to manipulate the number without changing n.
		int j = 0;
		//This loop will actually run the counter until it finishes
		for (getCounter() ;  getCounter() < getHighNumber(); setCounter(getCounter() + 1)) {
			f = n;
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
			collatzArray[j] = n + "," + i;
			j++;
			n--;
			i=0;
		}
		for (String element: collatzArray) {
			System.out.println(element);
		}
	}
}
