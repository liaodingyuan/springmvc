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
 * @date 2018��5��5��
 */
public class TestLambda {

	public static void main(String[] args) throws IOException {
		// java7 <>�����ƶϳ���������
		List<String> listOfStrings = new ArrayList<>();
		
		Comparator<Apple> byWeight = new Comparator<Apple>() {

			@Override
			public int compare(Apple o1, Apple o2) {
				return o1.getWeight().compareTo(o2.getWeight());
			}
		};
		// ʹ��lambda���ʽ��д�ڲ���ʵ����Ϊ���ݹ��ܡ�ʹ�ú���������ڲ����lambda������Ϊ���������ݡ����θ���㡣
		// ��ֱ�ӽ���һ��lambda���ʽ������Ϊ������ʽ��Ӧ��Comparator����Ψһ�ĳ��󷽷���ǩ����
		Comparator<Apple> byWeight2 = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());

		// ����ʽ�ӿڵĳ��󷽷�ǩ�������Ͼ���lambda���ʽ��ǩ������Ҳ��Ϊʲô�����ǽӿ�
		// ֻ��һ�����󷽷���ԭ��֮һ�ɣ�
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

	// Callable<String>Ҳ��һ������ʽ�ӿڣ����ص�lambda����ƥ�����ĺ���ǩ���������ӿڵķ���ǩ����() -> String
	public Callable<String> fetch() {
		return () -> "trck example;";
	}

	public static String processFile() throws IOException {
		// java7������Ҫ�ͷ���Դ�Ĵ�������ŵ�try���������棬�Ͳ���Ҫ�ͷ���
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
		// br.readLine()+br.readLine() ���Ǻ����ǽӿ�BufferedReaderProcess�ķ���process��ʵ��
		String result = processFile((BufferedReader br)->br.readLine()+br.readLine());
		System.out.println("result:"+result);
		
	}
}
