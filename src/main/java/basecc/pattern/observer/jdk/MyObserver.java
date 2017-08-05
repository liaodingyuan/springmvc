/**
 * 
 */
package basecc.pattern.observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
* <p>Title:Observer </p>
* <p>Description: </p>
* <p>Company: </p>
* @author liaody
* @date 2017年8月2日
*/
public class MyObserver implements Observer{

 // 要注意的是Observer是一个接口，Observerable是一个类
	@Override
	public void update(Observable o, Object arg) {
		
	System.out.println("调用了Observer的Update方法。");
	
	System.out.println("这是一个观察者");
	
		
	}

}
