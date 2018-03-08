/**
 * 
 */
package basecc.juc.mysynchronized;

/**
 * <p>
 * Title:MyThread
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2018年1月3日
 */
public class Demo2 extends Thread {

	public static void main(String[] args) {

		Thread t1 = new MyThread("t1");
		Thread t2 = new MyThread("t2");
		t1.start();
		t2.start();
	}

}

class MyThread extends Thread {
	public MyThread(final String name) {
		super(name);
	}

	@Override
	public void run() {
		// 使用对象锁对同步代码
		//synchronized (this) {// 获取对象锁，一个对象只有一个对象锁。
			try {
				for (int index = 0; index < 20; index++) {
					Thread.sleep(100);
					System.out.println(Thread.currentThread().getName() + " loop " + index);
				}
			} catch (InterruptedException ie) {

				ie.printStackTrace();
			}
		//}
	}
}