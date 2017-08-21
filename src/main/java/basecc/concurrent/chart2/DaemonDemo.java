/**
 * 
 */
package basecc.concurrent.chart2;

/**
 * <p>
 * Title:DaemonDemo
 * </p>
 * <p>
 * Description:��ʾ�ػ��߳�
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��8��20��
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
		// �����ػ��̱߳����ڵ���start֮ǰ���ã������õ�һ���쳣
		t.setDaemon(true);
		t.start();
		// �����߳��˳�֮��ֻʣһ���ػ��̣߳���������Ҳ����֮��������������߳�����Ϊ�ػ��̡߳���ô
		// ���̻߳�ѭ����ӡ I am alive
		Thread.sleep(2000);
	}
}
