/**
 * 
 */
package basecc.lambda.functioninterface;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * <p>
 * Title:BufferedReaderProcess
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
@FunctionalInterface
public interface BufferedReaderProcess {
	/**
	 * Lambda���������������Ǻ���ʽ�ӿڵ����������Ҫ����һ����ƥ�� BufferedReader ->
	 * String���������׳�IOException�쳣�Ľӿڡ������ǰ���һ�ӿڽ��� BufferedReaderProcessor�ɡ�
	 * 
	 * @param br
	 * @return
	 */
	// �κκ���ʽ�ӿڶ��������׳��ܼ��쳣��checked exception�����������ҪLambda
	// ���ʽ���׳��쳣�������ְ취������һ���Լ��ĺ���ʽ�ӿڣ��������ܼ��쳣
	String process(BufferedReader br) throws IOException;
}
