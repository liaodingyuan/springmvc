/**
 * 
 */
package liaody.thinkinjava.chart10;

/**
 * <p>
 * Title:Parce1
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��10��29��
 */
public class Parce1 {

	class Contents {
		private int i = 11;

		public int value() {
			return i;
		}
	}

	class Destination {
		private String label;

		public Destination(String label) {
			this.label = label;
		}

		public String readLabel() {
			return label;
		}
	}
	/**
	 * ʹ���ڲ���
	 */
	public void ship(String dest) {
		Contents content = new Contents();
		Destination d = new Destination(dest);
		System.out.println(d.readLabel());
		
	}
	
	public Contents contents() {
		return new Contents();
	}
	public static void main(String[] args) {
	
		Parce1 p = new Parce1();
		p.ship("�Ƽ���");
		// �����ڲ���ķ�ʽ
		Parce1.Contents content = p.contents();
		Parce1.Destination destination = p.new Destination("");
	}
}
