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
 * Description:��ʾjoin������ʹ��
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��8��20��
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
		// ��main�̣߳�Ҳ�������̣߳��е���at�̵߳�join��������ʾ���߳�Ը��ȴ�at�߳����֮��
		// �ڼ���������
		at.join();
		System.out.println(ii);
	}
}
