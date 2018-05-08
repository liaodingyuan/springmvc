/**
 * 
 */
package basecc.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
* <p>Title:ConsumerTest </p>
* <p>Description: java.util.function.Consumer<T>������һ������accept�ĳ��󷽷��������ܷ���T
�Ķ���û�з��أ�void�� ���������Ҫ��������T�Ķ��󣬲�����ִ��ĳЩ�������Ϳ���ʹ��
����ӿڡ����磬���������������һ��forEach����������һ��Integers���б���������
ÿ��Ԫ��ִ�в�����</p>
* <p>Company: </p>
* @author liaody
* @date 2018��5��5��
*/
public class ConsumerTest {
	/**
	public interface Consumer<T>{
void accept(T t);
}

	 *
	 */
	public static void main(String[] args) {
	
		forEach(
				Arrays.asList(1,2,3,4,5),
				(Integer i) -> System.out.println(i)
				);
	}
	
	public static <T> void forEach(List<T> list,Consumer<T> c) {
		for(T i:list) {
			// (Integer i) -> System.out.println(i)��accept��ʵ��
			// �ͻ��˺���Ҫ���ú����ӿ��еĳ��󷽷������տͻ��˵��õ�ʱ�򣬴��뺯���ӿ��г��󷽷���ʵ�֡�
			c.accept(i);
		}
	}

}
