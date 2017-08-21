/**
 * 
 */
package basecc.concurrent.chart1;

/**
 * <p>
 * Title:MultiThreadLong
 * </p>
 * <p>
 * Description: ��ʾ64λ������������32λ������ϵĶ�д������ԭ���Եġ�
 * ע��64λ������²��������ݴ���
 * 
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��8��20��
 */
public class MultiThreadLong {

	public static long t = 0;

	public static class ChangeT implements Runnable {

		private long to;

		private ChangeT(long to) {
			this.to = to;
		}

		@Override
		public void run() {
			while (true) {
				MultiThreadLong.t = to;
				Thread.yield();// �߳�ǫ�ã����������߳��ܹ��л�����cpu�����Ǹ��߳���Ȼ��ȥ����cpu��
			}
		}

	}

	public static class ReaderT implements Runnable {
		@Override
		public void run() {

			while (true) {
				long tmp = MultiThreadLong.t;
				if (tmp != 333L && tmp != 111L && tmp != 999L && tmp != -444L) {
					System.out.println(tmp);
				}
				Thread.yield();
			}

		}

	}

	public static void main(String[] args) {

		new Thread(new ChangeT(111L)).start();
		new Thread(new ChangeT(333L)).start();
		new Thread(new ChangeT(999L)).start();
		new Thread(new ChangeT(-444L)).start();
		new Thread(new ReaderT()).start();
	}

}
