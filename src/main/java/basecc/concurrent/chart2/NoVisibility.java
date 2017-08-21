/**
 * 
 */
package basecc.concurrent.chart2;

/**
 * <p>
 * Title:NoVisibility
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017Äê8ÔÂ20ÈÕ
 */
public class NoVisibility {

	private static boolean ready;
	private static int munber;

	private static class ReaderThread extends Thread {
		public void run() {
			while (!ready)
				System.out.println(munber);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		new ReaderThread().start();
		Thread.sleep(1000);
		munber = 42;
		ready = true;
		Thread.sleep(10000);
	}
}
