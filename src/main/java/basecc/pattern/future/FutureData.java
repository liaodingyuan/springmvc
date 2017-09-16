/**
 * 
 */
package basecc.pattern.future;

/**
 * <p>
 * Title:FutureData
 * </p>
 * <p>
 * escription:是实现Future模式的关键，实际上是RealData的代理，封装了获取RealData的等待过程。
 * 该类实现了一个快速返回的RealData包装。它只是一个包装，或者说是一个realdata的虚拟实现。
 * 它可以很快被构造并返回。当使用Future的getResult方法的时候，如果实际的数据还没有准备好
 * 那么程序就会阻塞，等待RealData准备好并注入到Future中，才最终返回数据。
 * 
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年9月3日
 */
public class FutureData implements Data {
	// Future是RealData的包装
	protected RealData realdata = null;

	protected boolean isReady = false;

	public synchronized void setResult(RealData realdata) {

		if (isReady) {
			return;
		}
		this.realdata = realdata;
		isReady = true;
		// RealData构造完成。通知getResult。
		notifyAll();
	}

	/*
	 * 会等待RealData构造完成。
	 * 
	 * @see basecc.pattern.future.Data#getResult()
	 */
	@Override
	public String getResult() {
		while (!isReady) {
			try {
				// 一直等待，知道RealData注入
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 由RealData实现
		return realdata.result;
	}

}
