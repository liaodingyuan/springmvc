/**
 * 
 */
package basecc.pattern.proxy.dynamicProxy2.aspect;

/**
 * <p>
 * Title:MyAspect
 * </p>
 * <p>
 * Description:一个切面，含有要对目标类增强的方法。
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2018年1月21日
 */
public class MyAspect {

	public void before() {
		System.out.println("前置通知");

	}

	public void after() {
		System.out.println("后置通知");
	}

}
