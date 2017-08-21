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
 * @date 2017年8月20日
 */
public class PriorityDemo {

	public static class HeightPriority extends Thread {
		static int count = 1;

		public void run() {
			while (true) {
				// 内置的对象锁，不使用参数的效果是一样的
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
		// 设置线程优先级，高优先级任务应该比低优先级先完成
		high.setPriority(Thread.MAX_PRIORITY);
		lower.setPriority(Thread.MIN_PRIORITY);
		lower.start();
		high.start();
	}

}
