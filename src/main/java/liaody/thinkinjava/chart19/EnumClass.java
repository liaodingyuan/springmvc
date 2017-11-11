/**
 * 
 */
package liaody.thinkinjava.chart19;

/**
 * <p>
 * Title:EnumClass
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��11��11��
 */
public class EnumClass {

	public static void main(String[] args) {
		// .values()�����ϸ���enumʵ����enum����������˳��������е�ʵ����
		for (Shrubbery s : Shrubbery.values()) {
			System.out.println("ordinal��������senumʵ����enum��������˳��" + s.ordinal());
			System.out.println("Enumʵ����Comparable�ӿں�Serailizable�ӿڣ����п���ʹ��comparaTo����");
			System.out.println(s.compareTo(Shrubbery.CRAWLING));
			System.out.println(s.getDeclaringClass());
			System.out.println(s.name());
		}
		
		for(String s:"GROUND,CRAWLING,HANGING".split(",")) {
			Shrubbery shru = Enum.valueOf(Shrubbery.class, s);
			System.out.println(shru.name());
		}
	}
}

/**
 * <p>
 * Title:Shrubbery
 * </p>
 * <p>
 * Description:����ö������
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��11��11��
 */
enum Shrubbery {
	GROUND, CRAWLING, HANGING;
	public static void main(String[] args) {
		System.out.println("Here is Enum!");
	}
}

class InnerClass{
	public static void main(String[] args) {

		System.out.println("This's Inner Class��");
	}
}
