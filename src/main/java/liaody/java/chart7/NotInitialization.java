/**
 * 
 */
package liaody.java.chart7;

/**
 * <p>
 * Title:NotInitialization
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��11��12��
 */
public class NotInitialization {

	public static void main(String[] args) {

		// ��û��ʵ�ʷ���ռ䣬���Բ��ᴥ������ĳ�ʼ�����̡�
		SuperClass[] superC = new SuperClass[10];
		// ������������1��ͨ�����������ø���ľ�̬��Ա�����ᴥ������ĳ�ʼ��
		System.out.println(SubClass.value);
	}
}
