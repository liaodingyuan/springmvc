/**
 * 
 */
package basecc.pattern.factory.simple;

/**
 * <p>
 * Title:Client
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
public class Client {
	public static void main(String[] args) {
		ComputerEngineer cf = new ComputerEngineer();
		cf.makeComputer(1, 1);
	}
}
