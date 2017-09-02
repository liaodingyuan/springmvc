/**
 * 
 */
package basecc.concurrent.chart3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * Title:IntLock
 * </p>
 * <p>
 * Description:一个简单的使用重入锁造成死锁的demo
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年8月21日
 */
public class IntLock implements Runnable {

	private static ReentrantLock lock1 = new ReentrantLock();
	private static ReentrantLock lock2 = new ReentrantLock();
	int lock;

	public IntLock(int lock) {
		this.lock = lock;
	}

	public static void main(String[] args) {

	}

	@Override
	public void run() {

		try {

			if (1 == lock) {
				// 首先申请lock1，然后sleep一段时间让另一条线程获得lock2
				lock1.lockInterruptibly();;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				lock2.lockInterruptibly();
			} else {
				// 首先申请lock1，然后sleep一段时间让另一条线程获得lock2
				lock2.lock();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				lock1.lock();
			}

		} catch (InterruptedException e) {
			// TODO: handle exception
		} finally {

		}

	}

}
