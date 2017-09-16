/**
 * 
 */
package basecc.concurrent.chart4;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 * Title:AtomicIntegerDemo
 * </p>
 * <p>
 * Description:无锁的线程安全整数demo。 内部字段使用volatile关键字。 private volatile int value;
 * 存储value字段在AtomicInteger对象中的偏移量 private static final long offset;
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年9月2日
 */
public class AtomicIntegerDemo {

	// 无锁的线程安全整数
	static AtomicInteger ii = new AtomicInteger();

	public static class AddThread implements Runnable {

		@Override
		public void run() {

			for (int i = 0; i < 1000000; i++) {
				ii.incrementAndGet();// 线程安全的
			}
		}

	}

	public static void main(String[] args) throws InterruptedException {
		Thread[] ts = new Thread[10];

		for (int i = 0; i < 10; i++) {
			ts[i] = new Thread(new AddThread());
		}
		for (int i = 0; i < 10; i++) {
			ts[i].start();
		}
		for (int i = 0; i < 10; i++) {
			ts[i].join();
		}

		System.out.println(ii);

		// AtomicInteger 会比使用锁具有更高的性能。
	}

}
