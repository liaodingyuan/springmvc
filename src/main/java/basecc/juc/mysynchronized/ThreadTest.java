/**
 * 
 */
package basecc.juc.mysynchronized;

/**
 * <p>
 * Title:ThreadTest
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2018年1月4日
 */
public class ThreadTest {

	public static void main(String[] args) {

		// 各个实例之间并没有出现竞争，每一条线程都是独立的，各自卖10张
//		MyThread2 t1 = new MyThread2();
//		MyThread2 t2 = new MyThread2();v /////////////////////k
//		MyThread2 t3 = new MyThread2();
//		t1.start();
//		t2.start();
//		t3.start();
//		
		// mt3是一个runnable对象，三条线程共享一个runnable对象，形成了竞争条件。
		MyThread3 mt3 = new MyThread3();
		Thread t1 = new Thread(mt3);
		Thread t2 = new Thread(mt3);
		Thread t3 = new Thread(mt3);
		t1.start();
		t2.start();
		t3.start(); 
	}

}
/**
 * 
* <p>Title:MyThread2 </p>
* <p>Description: 实现线程的第一种方式，继承Thread类。Thread类本身实现runnable接口。</p>
* <p>Company: </p>
* @author liaody
* @date 2018年1月4日
 */
class MyThread2 extends Thread {

	private int ticket = 15;

	@Override
	public void run() {

		for (int index = 0; index < 20; index++) {
			if (this.ticket > 0) {
				try {
					System.out.println(this.getName() + " 卖票：ticket" + this.ticket--);
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	}
}

class MyThread3 implements Runnable {

	private int ticket=15;

	@Override
	public void run() {
		for (int index = 0; index < 20; index++) {
			if (this.ticket > 0) {
				try {
					System.out.println(Thread.currentThread().getName() + " 卖票：ticket" + this.ticket--);
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}

	}

}
