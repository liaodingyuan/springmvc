/**
 * 
 */
package basecc.concurrent.chart3;

import java.util.concurrent.locks.ReentrantLock;

/**
* <p>Title:ReenterLock </p>
* <p>Description: 演示简单的重入锁</p>
* <p>Company: </p>
* @author liaody
* @date 2017年8月20日
*/
public class ReenterLock implements Runnable{

	public ReentrantLock lock = new ReentrantLock();
	// 需要是static才会形成临界区
	public static int ii = 0;
	@Override
	public void run() {

		for (int i = 0; i <1000000; i++) {
			lock.lock();
			lock.lock();
			try {
				ii++;
			}finally {			
				lock.unlock();
				lock.unlock();
			}
		}

	}

	public static void main(String[] args) throws InterruptedException {
		
	ReenterLock lock = new ReenterLock();
	Thread t1 = new Thread(lock);
	Thread t2 = new Thread(lock);
	t1.start();
	t2.start();
	t1.join();
	t2.join();
	System.out.println(ii);
	
	
	
	}
}
