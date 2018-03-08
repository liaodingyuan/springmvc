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
 * @date 2018��1��3��
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
		// ʹ�ö�������ͬ������
		//synchronized (this) {// ��ȡ��������һ������ֻ��һ����������
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