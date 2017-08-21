/**
 * 
 */
package basecc.concurrent.chart2;

import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;

/**
 * <p>
 * Title:JoinMain
 * </p>
 * <p>
 * Description:演示join方法的使用
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年8月20日
 */
public class JoinMain {

	public volatile static int ii = 0;

	public static class AddThread extends Thread {
		public void run() {
			for (int i = 0; i < 1000000; i++) {
				ii++;// not thread safe
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {

		AddThread at = new AddThread();
		at.start();
		// 在main线程（也就是主线程）中调用at线程的join方法，表示主线程愿意等待at线程完成之后
		// 在继续往下走
		at.join();
		System.out.println(ii);
	}
}
