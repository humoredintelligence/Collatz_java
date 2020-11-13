
public class Collatz {

	public static void main (String[] args) {
		int highNumber = 20;
		Calculate running = new Calculate(highNumber);
		running.collatz();
	}
}
