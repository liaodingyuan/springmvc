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
 * @date 2018��1��4��
 */
public class ThreadTest {

	public static void main(String[] args) {

		// ����ʵ��֮�䲢û�г��־�����ÿһ���̶߳��Ƕ����ģ�������10��
//		MyThread2 t1 = new MyThread2();
//		MyThread2 t2 = new MyThread2();v /////////////////////k
//		MyThread2 t3 = new MyThread2();
//		t1.start();
//		t2.start();
//		t3.start();
//		
		// mt3��һ��runnable���������̹߳���һ��runnable�����γ��˾���������
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
* <p>Description: ʵ���̵߳ĵ�һ�ַ�ʽ���̳�Thread�ࡣThread�౾��ʵ��runnable�ӿڡ�</p>
* <p>Company: </p>
* @author liaody
* @date 2018��1��4��
 */
class MyThread2 extends Thread {

	private int ticket = 15;

	@Override
	public void run() {

		for (int index = 0; index < 20; index++) {
			if (this.ticket > 0) {
				try {
					System.out.println(this.getName() + " ��Ʊ��ticket" + this.ticket--);
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
					System.out.println(Thread.currentThread().getName() + " ��Ʊ��ticket" + this.ticket--);
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}

	}

}
