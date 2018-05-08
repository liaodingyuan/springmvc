/**
 * 
 */
package basecc.lambda.functioninterface;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * <p>
 * Title:BufferedReaderProcess
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2018年5月5日
 */
@FunctionalInterface
public interface BufferedReaderProcess {
	/**
	 * Lambda仅可用于上下文是函数式接口的情况。你需要创建一个能匹配 BufferedReader ->
	 * String，还可以抛出IOException异常的接口。让我们把这一接口叫作 BufferedReaderProcessor吧。
	 * 
	 * @param br
	 * @return
	 */
	// 任何函数式接口都不允许抛出受检异常（checked exception）。如果你需要Lambda
	// 表达式来抛出异常，有两种办法：定义一个自己的函数式接口，并声明受检异常
	String process(BufferedReader br) throws IOException;
}
