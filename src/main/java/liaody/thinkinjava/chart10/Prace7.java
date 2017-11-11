/**
 * 
 */
package liaody.thinkinjava.chart10;

import javax.swing.text.AbstractDocument.Content;

import liaody.thinkinjava.chart10.Parce1.Contents;

/**
 * <p>
 * Title:Prace7
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年10月29日
 */
public class Prace7 {

	/**
	 * 使用匿名内部类（直接返回实现某个接口的类） 意思是创建一个继承（实现自XX（这是一个接口）的匿名内部类）
	 * 如果基类需要一个带参数的构造器，可以在方法传入参数
	 * 
	 * @param xx
	 * @return
	 */
	public Selector getTmpC(String xx) {
		// 创建一个继承Selector接口的匿名类对象
		// 通过new表达式返回的引用被自动转型为对Selector的引用
		return new Selector() {
			private int ii = 90;

			// 怎样才能够有使用这里面自己心增加的方法
			// TODO
			public int value() {
				return ii;
			}

			public String param() {
				return xx;
			}

			@Override
			public boolean end() {
				System.out.println("这是测试用的end方法");
				return false;
			}

			@Override
			public Object current() {
				System.out.println("这里是测试用的Current方法");
				return null;
			}

			@Override
			public void next() {
				System.out.println("这里是测试用的next方法");
			}
		};
	}

	/**
	 * 这里的参数不需要使用final关键字进行修饰，因为这里没有使用到x座位内部对象。
	 * 这里的参数x，并不要求一定是final的，应为x传递给匿名类的基类构造器，它并不会在匿名内部类中
	 * 直接被使用。在匿名内部类中被使用的变量必须是使用final此时的（JDK1.8中不要求）
	 * 匿名内部类没有构造器，应为它根本就没有名字呀。但是可以通过实例初始化达到效果
	 * @param x
	 * @return
	 */
	public Wrapping wrapping(String x) {
		return new Wrapping(x) {
		};
	}

	/**
	 * 如果定义一个匿名内部类，并且希望它使用在其外部定义的对象，那么编译器会要求其参数时final的 否则编译会错误。 内部类被定义在局部时： 1.
	 * 不可以被成员修饰符修饰； 2. 可以直接访问外部类中的成员，因为还持有外部类中的引用； 3.
	 * 但是不可以访问它所在局部中的变量，只能访问被final修饰的局部变量。
	 * 这里之所以只能用final修饰的参数，是变量作用域的原因。虽然匿名内部类被定义在方法内部，
	 * 但匿名内部类是单独的个体，编译时随外部类一起被编译成为Outer$1.class文件，并不是方法被调用时才会被执行。
	 * 方法中的局部变量只是在方法被调用时被创建在栈内存中，
	 * 调用完毕会自动清空栈，所以，匿名内部类要想使用方法内部的变量，只能将该变量用final修饰，即定义为常量。 *
	 * 
	 * 但是，如果你使用的JDK为1.8版本，就算局部变量不用final修饰，编译也会通过，而且可以正常运行。
	 * 但编译器会默认该变量为final类型。这也许是新版本的一个bug吧。
	 * 
	 * @param parameter
	 * @return
	 */
	// TODO JDK 1.8
	public DestinationME destination(String parameter) {
		return new DestinationME("justtest") {
			// TODO
			private String param = parameter;

			@Override
			public String value() {
				return param;
			}

		};
	}

	public static void main(String[] args) {
		Prace7 抛 = new Prace7();
		Selector selector = 抛.getTmpC("");
		selector.current();
		selector.end();
		selector.next();
		DestinationME destinationLocal = 抛.destination("黄加益");
		destinationLocal.value();
	}

}
