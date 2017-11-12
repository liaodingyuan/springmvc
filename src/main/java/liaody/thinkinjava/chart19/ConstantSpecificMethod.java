/**
 * 
 */
package liaody.thinkinjava.chart19;

import java.util.Date;

/**
 * <p>
 * Title:ConstantSpecificMethod
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
public enum ConstantSpecificMethod {

	DATE_TIME {
		@Override
		String getInfo() {

			return new Date().toString();
		}
	},
	CLASSPATH {
		@Override
		String getInfo() {

			return "java path";
		}
	},
	VERSRION {
		@Override
		String getInfo() {

			return "1.8";
		}
	};
	abstract String getInfo();

	public static void main(String[] args) {

		for(ConstantSpecificMethod v:values())
		{
			System.out.println(v.getInfo());
		}
	}
}
