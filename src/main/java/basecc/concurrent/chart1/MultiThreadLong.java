/**
 * 
 */
package basecc.concurrent.chart1;

/**
 * <p>
 * Title:MultiThreadLong
 * </p>
 * <p>
 * Description: 演示64位的类型数据在32位虚拟机上的读写并不是原子性的。
 * 注意64位虚拟机下不会有数据错误。
 * 
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年8月20日
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
				Thread.yield();// 线程谦让，让其他的线程能够有机会获得cpu（但是该线程仍然回去竞争cpu）
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
