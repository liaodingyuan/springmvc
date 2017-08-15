/**
 * 
 */
package basecc.pattern.factory.simple;

/**
 * <p>
 * Title:MainboardFactory
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017Äê8ÔÂ12ÈÕ
 */
public class MainboardFactory {
	public static Mainboard createMainboard(int type) {
		Mainboard mainboard = null;
		if (type == 1) {
			mainboard = new IntelMainboard(755);
		} else if (type == 2) {
			mainboard = new AmdMainboard(938);
		}
		return mainboard;
	}
}
