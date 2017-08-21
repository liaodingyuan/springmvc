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
 * Description: ��ʾwait��notify����
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��8��20��
 */
public class SimpleWN {

	// ��Ϊ������ʹ��
	final static Object object = new Object();

	public static class T1 extends Thread {
		public void run() {
			// �����д��object�Ļ�����ʹ�õ�������
			synchronized (object) {
				System.out.println(System.currentTimeMillis() + ":T1 start!");
				try {
					System.out.println(":T1 wait for object");
					// ����wait������ʱ����Ҫ��ö�������������wait����֮����ͷŶ�����
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
				// ����notify������ʱ��Ҳ��Ҫ��ö�����
				object.notify();// Ӧ��ʹ��notifyAll����
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
