/**
 * 
 */
package basecc.concurrent.chart2;

/**
 * <p>
 * Title:DaemonDemo
 * </p>
 * <p>
 * Description:演示守护线程
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年8月20日
 */
public class DaemonDemo {

	public static class DemoT extends Thread {
		public void run() {

			while (true) {
				System.out.println("I am alive");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t = new DemoT();
		// 设置守护线程必须在调用start之前调用，否则会得到一个异常
		t.setDaemon(true);
		t.start();
		// 在主线程退出之后只剩一个守护线程，整个程序也会随之结束，如果不把线程设置为守护线程。那么
		// 该线程会循环打印 I am alive
		Thread.sleep(2000);
	}
}
