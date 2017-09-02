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
 * Description:һ���򵥵�ʹ�����������������demo
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��8��21��
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
				// ��������lock1��Ȼ��sleepһ��ʱ������һ���̻߳��lock2
				lock1.lockInterruptibly();;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				lock2.lockInterruptibly();
			} else {
				// ��������lock1��Ȼ��sleepһ��ʱ������һ���̻߳��lock2
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
