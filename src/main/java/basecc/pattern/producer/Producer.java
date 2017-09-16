/**
 * 
 */
package basecc.pattern.producer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 * Title:Producer
 * </p>
 * <p>
 * Description:������
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��9��2��
 */
public class Producer implements Runnable {
	private volatile boolean isRunning = true;
	// �ڴ����ݻ�����
	private BlockingQueue<PCData> queue;
	// ����
	private static AtomicInteger count = new AtomicInteger();
	public static final int SLEEP_TIME = 1000;

	public Producer(BlockingQueue<PCData> queue) {
		this.queue = queue;
	}

	public void stop() {
		isRunning = false;
	}

	@Override
	public void run() {
		PCData data = null;
		Random r = new Random();
		System.out.println("start producer id=" + Thread.currentThread().getId());
		try {
			while (isRunning) {
				Thread.sleep(r.nextInt());
				// ��������������
				data = new PCData(count.incrementAndGet());
				System.out.println(data + " is put  into the queue.");
				// �ύ���ݵ�������
				if (!queue.offer(data, 2, TimeUnit.SECONDS)) {
					System.out.println("failed to put data:" + data);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
