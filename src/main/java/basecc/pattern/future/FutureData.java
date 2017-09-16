/**
 * 
 */
package basecc.pattern.future;

/**
 * <p>
 * Title:FutureData
 * </p>
 * <p>
 * escription:��ʵ��Futureģʽ�Ĺؼ���ʵ������RealData�Ĵ�����װ�˻�ȡRealData�ĵȴ����̡�
 * ����ʵ����һ�����ٷ��ص�RealData��װ����ֻ��һ����װ������˵��һ��realdata������ʵ�֡�
 * �����Ժܿ챻���첢���ء���ʹ��Future��getResult������ʱ�����ʵ�ʵ����ݻ�û��׼����
 * ��ô����ͻ��������ȴ�RealData׼���ò�ע�뵽Future�У������շ������ݡ�
 * 
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��9��3��
 */
public class FutureData implements Data {
	// Future��RealData�İ�װ
	protected RealData realdata = null;

	protected boolean isReady = false;

	public synchronized void setResult(RealData realdata) {

		if (isReady) {
			return;
		}
		this.realdata = realdata;
		isReady = true;
		// RealData������ɡ�֪ͨgetResult��
		notifyAll();
	}

	/*
	 * ��ȴ�RealData������ɡ�
	 * 
	 * @see basecc.pattern.future.Data#getResult()
	 */
	@Override
	public String getResult() {
		while (!isReady) {
			try {
				// һֱ�ȴ���֪��RealDataע��
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// ��RealDataʵ��
		return realdata.result;
	}

}
