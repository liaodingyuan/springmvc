/**
 * 
 */
package basecc.lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;

import basecc.lambda.functioninterface.BufferedReaderProcess;

/**
 * <p>
 * Title:TestLambda
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
public class TestLambda {

	public static void main(String[] args) throws IOException {
		// java7 <>可以推断出具体类型
		List<String> listOfStrings = new ArrayList<>();
		
		Comparator<Apple> byWeight = new Comparator<Apple>() {

			@Override
			public int compare(Apple o1, Apple o2) {
				return o1.getWeight().compareTo(o2.getWeight());
			}
		};
		// 使用lambda表达式重写内部类实现行为传递功能。使用函数对象和内部类和lambda都是行为参数化传递、依次更简便。
		// 能直接接受一个lambda表达式，是因为这个表达式对应着Comparator里面唯一的抽象方法的签名。
		Comparator<Apple> byWeight2 = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());

		// 函数式接口的抽象方法签名基本上就是lambda表达式的签名，这也是为什么函数是接口
		// 只有一个抽象方法的原因之一吧？
		Runnable r = () -> {
			System.out.println("this is lambda.");
		};
		Runnable r2 = new Runnable() {

			@Override
			public void run() {
				System.out.println("this is lambda 2.");

			}

		};
		process(r);
		process(r2);
		process(() -> {
			System.out.println("this lambda 3.");
		});
		lambdaTest();
	}

	public static void process(Runnable r) {
		r.run();
	}

	// Callable<String>也是一个函数式接口，返回的lambda可以匹配它的函数签名。函数接口的方法签名是() -> String
	public Callable<String> fetch() {
		return () -> "trck example;";
	}

	public static String processFile() throws IOException {
		// java7，把需要释放资源的创建代码放到try的括号里面，就不需要释放了
		try (BufferedReader br = new BufferedReader(new FileReader("d:\\a.txt"))) {
			return br.readLine();
		}
	}

	public static String processFile(BufferedReaderProcess brp) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader("d:\\a.txt"))) {
			return brp.process(br);
		}
	}
	
	public static void lambdaTest() throws IOException {
		// br.readLine()+br.readLine() 就是函数是接口BufferedReaderProcess的方法process的实现
		String result = processFile((BufferedReader br)->br.readLine()+br.readLine());
		System.out.println("result:"+result);
		
	}
}
