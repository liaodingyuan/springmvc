/**
 * 
 */
package basecc.concurrent.chart2;

/**
 * <p>
 * Title:InterruptedTest
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
public class InterruptedTest {

	public static void main(String[] args) throws InterruptedException {

		Thread t1 = new Thread() {
			@Override
			public void run() {
				while (true) {
					// 检查中断标志位
					if (Thread.currentThread().isInterrupted()) {
						System.out.println("Interrupted");
						break;
					}
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						System.out.println("线程被中断");
						// 重新设置中断状态（中断线程 ）
						Thread.currentThread().interrupt();
					}
					Thread.yield();
				}
			}
		};
		t1.start();
		Thread.sleep(2000);
		t1.interrupt();
	}

}
