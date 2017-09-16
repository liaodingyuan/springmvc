/**
 * 
 */
package basecc.pattern.producer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * <p>
 * Title:MainApp
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年9月3日
 */
public class MainApp {
	public static void main(String[] args) throws InterruptedException {

		// 建立缓冲区
		BlockingQueue<PCData> queue = new LinkedBlockingQueue<PCData>(10);
		Producer p1 = new Producer(queue);
		Producer p2 = new Producer(queue);
		Producer p3 = new Producer(queue);

		Consumer c1 = new Consumer(queue);
		Consumer c2 = new Consumer(queue);
		Consumer c3 = new Consumer(queue);

		// 创建线程池
		ExecutorService service = Executors.newCachedThreadPool();
		service.execute(p1);
		service.execute(p2);
		service.execute(p3);
		service.execute(c1);
		service.execute(c2);
		service.execute(c3);

		Thread.sleep(10 * 1000);
		p1.stop();
		p2.stop();
		p3.stop();
		service.shutdown();
	}

}
