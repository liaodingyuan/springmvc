/**
 * 
 */
package basecc.concurrent.chart3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * Title:ReenterLockCondition
 * </p>
 * <p>
 * Description: 重入锁配合Condition条件使用的简单示例
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年8月24日
 */
public class ReenterLockCondition implements Runnable {
	public static ReentrantLock lock = new ReentrantLock();
	public static Condition condition = lock.newCondition();

	public ReenterLockCondition() {

	}

	public static void main(String[] arsg) throws InterruptedException {

		ReenterLockCondition rc = new ReenterLockCondition();
		Thread t1 = new Thread(rc);
		t1.start();
		Thread.sleep(2000);
		// 唤醒线程继续执行，执行singleAll/single方法的时候也是需要先获得锁的。 系统
		// 从当前的Condition对象的等待队列中唤醒一个线程，被唤醒的线程会重新尝试获得与之绑定的重入锁
		lock.lock();
		condition.signalAll();// singal之后会把锁释放
		lock.unlock();
	}

	@Override
	public void run() {

		try {

			lock.lock();
			condition.await();// 使用await的时候要求线程持有重入锁，调用之后会释放该把锁。
			System.out.println("Thread is going on!");

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			lock.unlock();
		}

	}

}
