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
* @date 2017��8��2��
*/
public class MyObserver implements Observer{

 // Ҫע�����Observer��һ���ӿڣ�Observerable��һ����
	@Override
	public void update(Observable o, Object arg) {
		
	System.out.println("������Observer��Update������");
	
	System.out.println("����һ���۲���");
	
		
	}

}
