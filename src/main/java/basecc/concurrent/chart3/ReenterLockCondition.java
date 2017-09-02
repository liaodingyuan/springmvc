/**
 * 
 */
package basecc.concurrent.chart3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * Title:ReenterLockCondition
 * </p>
 * <p>
 * Description: ���������Condition����ʹ�õļ�ʾ��
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��8��24��
 */
public class ReenterLockCondition implements Runnable {
	public static ReentrantLock lock = new ReentrantLock();
	public static Condition condition = lock.newCondition();

	public ReenterLockCondition() {

	}

	public static void main(String[] arsg) throws InterruptedException {

		ReenterLockCondition rc = new ReenterLockCondition();
		Thread t1 = new Thread(rc);
		t1.start();
		Thread.sleep(2000);
		// �����̼߳���ִ�У�ִ��singleAll/single������ʱ��Ҳ����Ҫ�Ȼ�����ġ� ϵͳ
		// �ӵ�ǰ��Condition����ĵȴ������л���һ���̣߳������ѵ��̻߳����³��Ի����֮�󶨵�������
		lock.lock();
		condition.signalAll();// singal֮�������ͷ�
		lock.unlock();
	}

	@Override
	public void run() {

		try {

			lock.lock();
			condition.await();// ʹ��await��ʱ��Ҫ���̳߳���������������֮����ͷŸð�����
			System.out.println("Thread is going on!");

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			lock.unlock();
		}

	}

}
