/**
 * 
 */
package basecc.concurrent.chart3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * <p>
 * Title:SemapDemo
 * </p>
 * <p>
 * Description:每次会打印
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年8月27日
 */
public class SemapDemo implements Runnable {

	// 同时准许5条线程同时访问
	final Semaphore semp = new Semaphore(5);

	@Override
	public void run() {
		try {
			semp.acquire();
			// 临界区
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getId() + ":done");
			// 临界区
			semp.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] agrs) {

		ExecutorService exec = Executors.newFixedThreadPool(20);
		final SemapDemo demo = new SemapDemo();
		for (int i = 0; i < 20; i++) {
			exec.submit(demo);
		}
		exec.shutdown();
	}

}
