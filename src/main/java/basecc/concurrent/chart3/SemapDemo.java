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
 * Description:ÿ�λ��ӡ
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��8��27��
 */
public class SemapDemo implements Runnable {

	// ͬʱ׼��5���߳�ͬʱ����
	final Semaphore semp = new Semaphore(5);

	@Override
	public void run() {
		try {
			semp.acquire();
			// �ٽ���
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getId() + ":done");
			// �ٽ���
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
