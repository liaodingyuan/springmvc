/**
 * 
 */
package basecc.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * <p>
 * Title:FunctionTest
 * </p>
 * <p>
 * Description: Function<T, R>�ӿڶ�����һ������apply�ķ�����������һ��
 * ����T�Ķ��󣬲�����һ������R�Ķ����������Ҫ����һ��Lambda��������������Ϣӳ�� ��������Ϳ���ʹ������ӿ�
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2018��5��5��
 */
public class FunctionTest {
	/**
	 * @FunctionalInterface public interface Function<T, R>{ R apply(T t); }
	 */
	public static void main(String[] args) {

		// (String s)->s.length() ��apply��ʵ��
		List<Integer> l = localmap(Arrays.asList("str","12345","hhhhhhhh"),(String s)->s.length());
		l.forEach((Integer i)->System.out.println(i.toString()));
	}
	//����һ��list������ÿһ��Ԫ�صĳ���
	public static <T,R> List<R> localmap(List<T> list,Function<T,R> f){
		List<R> result = new ArrayList<R>();
		for(T i:list) {
			// �ͻ���ȥ���ã���ôʵ������
			result.add(f.apply(i));
		}		
		return result;
	}

}
