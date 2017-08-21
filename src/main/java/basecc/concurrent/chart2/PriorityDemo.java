/**
 * 
 */
package basecc.concurrent.chart2;

/**
 * <p>
 * Title:PriorityDemo
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��8��20��
 */
public class PriorityDemo {

	public static class HeightPriority extends Thread {
		static int count = 1;

		public void run() {
			while (true) {
				// ���õĶ���������ʹ�ò�����Ч����һ����
				synchronized (PriorityDemo.class) {
					count++;
					if (count > 100000000) {
						System.out.println("HeightPriority is complete");
						break;
					}
				}
			}
		}
	}

	public static class LowPriority extends Thread {
		static int count = 1;

		public void run() {
			while (true) {
				count++;
				if (count > 100000000) {
					System.out.println("LowPriority is complete");
					break;
				}
			}
		}
	}

	public static void main(String[] args) {

		Thread high = new HeightPriority();
		Thread lower = new LowPriority();
		// �����߳����ȼ��������ȼ�����Ӧ�ñȵ����ȼ������
		high.setPriority(Thread.MAX_PRIORITY);
		lower.setPriority(Thread.MIN_PRIORITY);
		lower.start();
		high.start();
	}

}
