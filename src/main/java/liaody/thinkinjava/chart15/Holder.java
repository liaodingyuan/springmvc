/**
 * 
 */
package liaody.thinkinjava.chart15;

/**
 * <p>
 * Title:Holder
 * </p>
 * <p>
 * Description:����ʾһ�������ࣨ�������Ͳ�����
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��11��5��
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
		Holder<String> h = new Holder<String>("�Ƽ���");
		System.out.println(h.get());
	}
}
