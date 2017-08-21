/**
 * 
 */
package basecc.concurrent.chart2;

/**
 * <p>
 * Title:ThreadGroupName
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
public class ThreadGroupName implements Runnable {
	// 即使不使用Override注解，程序也不会报错，也还是会重写父类或者实现接口中的方法
	@Override
	public void run() {
		String groupName = Thread.currentThread().getThreadGroup().getName() + "-" + Thread.currentThread().getName();
		while (true) {
			System.out.println("I am " + groupName);
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
	ThreadGroup tg = new ThreadGroup("PrintGroup");
	Thread t1 = new Thread(tg,new ThreadGroupName(),"T1");
	Thread t2 = new Thread(tg,new ThreadGroupName(),"T2");
	t1.start();
	t2.start();	
	System.out.println(tg.activeCount());
	tg.list();
	}

}
