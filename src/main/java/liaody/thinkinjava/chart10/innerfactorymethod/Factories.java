/**
 * 
 */
package liaody.thinkinjava.chart10.innerfactorymethod;

import liaody.thinkinjava.chart10.ClassInnerInterface;

/**
* <p>Title:Factories </p>
* <p>Description: </p>
* <p>Company: </p>
* @author liaody
* @date 2017Äê11ÔÂ4ÈÕ
*/
public class Factories {

	public static void serverConsumer(ServerFactory factory) {
		Server s = factory.getServer();
		s.method1();
		s.method2();
	}
	public static void main(String[] args) {
		serverConsumer(Implementation1.factory);
		serverConsumer(Implementation2.factory);
		ClassInnerInterface.Test.main(args);;
	}
}
