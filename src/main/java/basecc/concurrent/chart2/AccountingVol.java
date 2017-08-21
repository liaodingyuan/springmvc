/**
 * 
 */
package basecc.concurrent.chart2;

/**
 * <p>
 * Title:AccountingVol
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
public class AccountingVol implements Runnable {

	static AccountingVol instance = new AccountingVol();
	static volatile int ii = 0;

	public static void increase() {
		ii++;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100000000; i++) {
			increase();
		}

	}

	public static void main(String[] args) throws InterruptedException {

		Thread t1 = new Thread(instance);
		Thread t2 = new Thread(instance);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(ii);
	}

}
