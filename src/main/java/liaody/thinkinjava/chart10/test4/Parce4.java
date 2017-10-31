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
 * @date 2017年10月29日
 */
public class Parce4 {
	/**
	 * 
	* <p>Title:PContents </p>
	* <p>Description:除了本类意外，其他都不可见 </p>
	* <p>Company: </p>
	* @author liaody
	* @date 2017年10月29日
	 */
	private class PContents implements Contents {
		private int ii = 11;

		@Override
		public int value() {
			return ii;
		}
	}
/**
 * 子类和同一个包中的可见
* <p>Title:PDestination </p>
* <p>Description: </p>
* <p>Company: </p>
* @author liaody
* @date 2017年10月29日
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
