/**
 * 
 */
package basecc.pattern.future;

/**
 * <p>
 * Title:RealData
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��9��3��
 */
public class RealData implements Data {

	protected final String result;

	public RealData(String data) {
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < 10; i++) {
			sb.append(data);
			// ģ��һ���ܺ�ʱ�Ĳ���
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		result = sb.toString();
	}

	/*
	 *  return the result
	 * 
	 * @see basecc.pattern.future.Data#getResult()
	 */
	@Override
	public String getResult() {
		return result;
	}

}
