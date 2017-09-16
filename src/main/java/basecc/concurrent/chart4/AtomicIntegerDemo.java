/**
 * 
 */
package basecc.concurrent.chart4;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 * Title:AtomicIntegerDemo
 * </p>
 * <p>
 * Description:�������̰߳�ȫ����demo�� �ڲ��ֶ�ʹ��volatile�ؼ��֡� private volatile int value;
 * �洢value�ֶ���AtomicInteger�����е�ƫ���� private static final long offset;
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��9��2��
 */
public class AtomicIntegerDemo {

	// �������̰߳�ȫ����
	static AtomicInteger ii = new AtomicInteger();

	public static class AddThread implements Runnable {

		@Override
		public void run() {

			for (int i = 0; i < 1000000; i++) {
				ii.incrementAndGet();// �̰߳�ȫ��
			}
		}

	}

	public static void main(String[] args) throws InterruptedException {
		Thread[] ts = new Thread[10];

		for (int i = 0; i < 10; i++) {
			ts[i] = new Thread(new AddThread());
		}
		for (int i = 0; i < 10; i++) {
			ts[i].start();
		}
		for (int i = 0; i < 10; i++) {
			ts[i].join();
		}

		System.out.println(ii);

		// AtomicInteger ���ʹ�������и��ߵ����ܡ�
	}

}
