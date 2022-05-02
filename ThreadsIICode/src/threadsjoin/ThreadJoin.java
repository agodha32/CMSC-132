package threadsjoin;

public class ThreadJoin extends Thread {

	public void run() {
		for (int i = 1; i <= 3; i++) {
			try {
				Thread.sleep((int) (Math.random() * 3000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		Thread thread1 = new ThreadJoin();
		Thread thread2 = new ThreadJoin();

		thread1.start();
		thread2.start();

		try {
			thread1.join(); // makes current thread wait for thread1 to finish
			thread2.join(); // makes current thread wait for thread2 to finish
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Done");
	}
}
