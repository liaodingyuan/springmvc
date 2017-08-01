/**
 * 
 */
package basecc.pattern.observer;

import java.util.List;
import java.util.Observer;

/**
 * <p>
 * Title:Subject
 * </p>
 * <p>
 * Description: 抽象主题角色
 * 抽象主题角色把所有对观察者对象的引用保存在一个聚集（比如ArrayList对象）里，每个主题都可以有任何数量的观察者。抽象主题提供一个接口，可以增加和删除观察者对象，抽象主题角色又叫做抽象被观察者(Observable)角色。
 * 
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年8月2日
 */
public abstract class Subject {
	
	private List<Observer> observers;

}
