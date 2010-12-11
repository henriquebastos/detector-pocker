package timer;

public class Timer {

	public static void main(String[] args) throws InterruptedException {
		while (true) marcaTempo();
	}

	private static void marcaTempo() throws InterruptedException {
		long t0 = System.currentTimeMillis();
		while (true) {
			if (System.currentTimeMillis() - t0 > 1000 * 60 * 5)
				break;
			Thread.sleep(1000);
		}
		System.err.println("ACABOU *************");
	}

}
