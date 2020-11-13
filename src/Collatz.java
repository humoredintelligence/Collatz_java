
public class Collatz {
	public static void collatz(long n) {
		int i = 0; //Increment Counter, initializes to zero before the number runs
		long f = n; //Allows me to manipulate the number without changing n.
		//This loop will actually run the counter until it finishs
		while(f != 1) {
			System.out.print(f + " ");
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
		System.out.println(" ");
		System.out.println("Collatz of " + n + " is " + i);
	}
	public static void main (String[] args) {
		long n = 2147483647;
		collatz(n);
	}
}
