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
 * Description: ���������ɫ
 * ���������ɫ�����жԹ۲��߶�������ñ�����һ���ۼ�������ArrayList�����ÿ�����ⶼ�������κ������Ĺ۲��ߡ����������ṩһ���ӿڣ��������Ӻ�ɾ���۲��߶��󣬳��������ɫ�ֽ������󱻹۲���(Observable)��ɫ��
 * 
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��8��2��
 */
public abstract class Subject {
	
	private List<Observer> observers;

}
