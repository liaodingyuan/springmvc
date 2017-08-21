/**
 * 
 */
package basecc.concurrent.chart2;

import javax.servlet.jsp.tagext.TryCatchFinally;

/**
 * <p>
 * Title:SimpleWN
 * </p>
 * <p>
 * Description: 演示wait和notify方法
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年8月20日
 */
public class SimpleWN {

	// 作为对象锁使用
	final static Object object = new Object();

	public static class T1 extends Thread {
		public void run() {
			// 如果不写明object的话，则使用的是类锁
			synchronized (object) {
				System.out.println(System.currentTimeMillis() + ":T1 start!");
				try {
					System.out.println(":T1 wait for object");
					// 调用wait方法的时候需要获得对象锁，调用了wait方法之后或释放对象锁
					object.wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static class T2 extends Thread {
		public void run() {
			synchronized (object) {
				System.out.println(System.currentTimeMillis() + ":T2 start ! notify one thread");
				// 调用notify方法的时候也需要获得对象锁
				object.notify();// 应该使用notifyAll方法
				System.out.println(System.currentTimeMillis() + ":T2 end!");
				try {
					Thread.sleep(2000);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}

	public static void main(String[] args) {
		Thread t1 = new T1();
		Thread t2 = new T2();
		t1.start();
		t2.start();
	}
}
