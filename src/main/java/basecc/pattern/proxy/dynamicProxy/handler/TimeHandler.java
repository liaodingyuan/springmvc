/**
 * 
 */
package basecc.pattern.proxy.dynamicProxy.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Calendar;

/**
 * <p>
 * Title:TimeHandler
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2018Äê1ÔÂ21ÈÕ
 */
public class TimeHandler implements InvocationHandler {
	private Object target;

	public TimeHandler(final Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Calendar calendar = Calendar.getInstance();

        System.out.println("start time:" + calendar.get(Calendar.HOUR_OF_DAY));

        Object obj = method.invoke(target);

        System.out.println("end time:" + calendar.get(Calendar.HOUR_OF_DAY));
		return obj;
	}

}
