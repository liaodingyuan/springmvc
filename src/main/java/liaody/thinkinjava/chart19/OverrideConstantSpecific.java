/**
 * 
 */
package liaody.thinkinjava.chart19;

/**
 * <p>
 * Title:ConstantSpecific
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017Äê11ÔÂ12ÈÕ
 */
public enum OverrideConstantSpecific {

	NUT, BOLT, WASHER {
		void f() {
			System.out.println("Overriden Method");
		}
	};
	void f() {
		System.out.println("default behavior");
	}

	public static void main(String[] args) {
		for (OverrideConstantSpecific s : values()) {
			s.f();
		}
	}

}
