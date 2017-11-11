/**
 * 
 */
package liaody.thinkinjava.chart15;

/**
 * <p>
 * Title:Holder
 * </p>
 * <p>
 * Description:简单演示一个泛型类（单个泛型参数）
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年11月5日
 */
public class Holder<T> {
	private T a;

	public Holder(T a) {
		this.a = a;
	}

	public void set(T a) {
		this.a = a;
	}

	public T get() {
		return this.a;
	}

	public static void main(String[] agrs) {
		Holder<String> h = new Holder<String>("黄加益");
		System.out.println(h.get());
	}
}
