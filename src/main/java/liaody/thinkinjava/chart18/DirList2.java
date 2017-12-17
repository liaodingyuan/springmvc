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
 * @date 2017年11月28日
 */
public class DirList2 {

	public static FilenameFilter filter(final String regex) {
		// 直接使用new关键字new一个接口，返回实现该接口的子类型（这里直接使用匿名内部类）
		return new FilenameFilter() {
			// 不能够有构造器
			private Pattern pattern = Pattern.compile(regex);

			@Override
			public boolean accept(File dir, String name) {
				return pattern.matcher(regex).matches();
			}

		};
	}	
}
