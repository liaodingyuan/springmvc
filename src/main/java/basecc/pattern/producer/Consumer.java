/**
 * 
 */
package basecc.pattern.producer;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * <p>
 * Title:Consumer
 * </p>
 * <p>
 * Description: ������
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��9��3��
 */
public class Consumer implements Runnable {
	// ������������
	private BlockingQueue<PCData> queue;
	public static final int SLEEP_TIME = 1000;

	public Consumer(BlockingQueue<PCData> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {

		System.out.println("start consumer id =" + Thread.currentThread().getId());
		Random r = new Random();
		try {
			while (true) {

				// ���û�����ݵĻ���������
				PCData data = queue.take();
				if (null != data) {
					// ����ƽ��
					int re = data.getData() * data.getData();
					System.out.println(MessageFormat.format("{0}*{1}={2}", data.getData(), data.getData(), re));
					Thread.sleep(r.nextInt(SLEEP_TIME));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// ���������жϱ�־
			Thread.currentThread().interrupt();
		}

	}

}
