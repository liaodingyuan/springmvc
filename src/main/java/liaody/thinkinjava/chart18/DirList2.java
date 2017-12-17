/**
 * 
 */
package liaody.thinkinjava.chart18;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/**
 * <p>
 * Title:DirList2
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��11��28��
 */
public class DirList2 {

	public static FilenameFilter filter(final String regex) {
		// ֱ��ʹ��new�ؼ���newһ���ӿڣ�����ʵ�ָýӿڵ������ͣ�����ֱ��ʹ�������ڲ��ࣩ
		return new FilenameFilter() {
			// ���ܹ��й�����
			private Pattern pattern = Pattern.compile(regex);

			@Override
			public boolean accept(File dir, String name) {
				return pattern.matcher(regex).matches();
			}

		};
	}	
}
