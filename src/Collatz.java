
public class Collatz {

	public static void main (String[] args) {
		long highNumber = 99;
		Calculate running = new Calculate(highNumber);
		running.collatz();
	}
}
