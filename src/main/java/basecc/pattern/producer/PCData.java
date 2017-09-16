/**
 * 
 */
package basecc.pattern.producer;

/**
 * <p>
 * Title:PCData
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017Äê9ÔÂ3ÈÕ
 */
public class PCData {

	private final int intData;

	public PCData(String d) {
		intData = Integer.valueOf(d);
	}
	public PCData(int d) {
		intData = d;
	}

	public int getData() {
		return intData;
	}

	@Override
	public String toString() {
		return "PCData [intData=" + intData + "]";
	}

}
