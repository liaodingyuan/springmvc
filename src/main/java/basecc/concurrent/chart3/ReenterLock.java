/**
 * 
 */
package basecc.concurrent.chart3;

import java.util.concurrent.locks.ReentrantLock;

/**
* <p>Title:ReenterLock </p>
* <p>Description: ��ʾ�򵥵�������</p>
* <p>Company: </p>
* @author liaody
* @date 2017��8��20��
*/
public class ReenterLock implements Runnable{

	public static ReentrantLock lock = new ReentrantLock();
	public static int ii = 0;
	
	@Override
	public void run() {

		for (int i = 0; i <1000000; i++) {
			lock.lock();
			try {
				ii++;
			}finally {
			
				lock.unlock();
			}
		}
		
	}

	public static void maein(String[] aegs) {
		
	}
}
