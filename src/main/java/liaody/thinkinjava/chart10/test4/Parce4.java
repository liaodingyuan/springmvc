/**
 * 
 */
package liaody.thinkinjava.chart10.test4;

/**
 * <p>
 * Title:Parce4
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��10��29��
 */
public class Parce4 {
	/**
	 * 
	* <p>Title:PContents </p>
	* <p>Description:���˱������⣬���������ɼ� </p>
	* <p>Company: </p>
	* @author liaody
	* @date 2017��10��29��
	 */
	private class PContents implements Contents {
		private int ii = 11;

		@Override
		public int value() {
			return ii;
		}
	}
/**
 * �����ͬһ�����еĿɼ�
* <p>Title:PDestination </p>
* <p>Description: </p>
* <p>Company: </p>
* @author liaody
* @date 2017��10��29��
 */
	protected class PDestination implements Destination {

		private String label;

		private PDestination(String label) {
			this.label = label;
		}

		@Override
		public String readLable() {
			return label;
		}

	}
	
	public Destination destination(String s) {
		return new PDestination(s);
	}
	
	public Contents contents() {
		return new PContents();
	}
//	public static void main(String[] args) {
		
//	}
}
