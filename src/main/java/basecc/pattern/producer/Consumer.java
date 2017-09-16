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
 * Description: 消费者
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年9月3日
 */
public class Consumer implements Runnable {
	// 共享缓冲区数据
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

				// 如果没有数据的话进行阻塞
				PCData data = queue.take();
				if (null != data) {
					// 计算平方
					int re = data.getData() * data.getData();
					System.out.println(MessageFormat.format("{0}*{1}={2}", data.getData(), data.getData(), re));
					Thread.sleep(r.nextInt(SLEEP_TIME));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// 重新设置中断标志
			Thread.currentThread().interrupt();
		}

	}

}
