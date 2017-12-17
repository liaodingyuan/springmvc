/**
 * 
 */
package liaody.thinkinjava.chart18;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * <p>
 * Title:DirList
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
public class DirList {

	public static void main(String[] args) {
		
		File path = new File(".");
		String[] list= {"xx.test","ww.test","xx.java","1.ee","hhhh"};
		Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
		for(String tmpString :list) {
			System.out.println(tmpString);
		}

	}
}

class DirFilter implements FilenameFilter {

	// ������ʽ
	private Pattern pattern;

	/**
	 * default constructor
	 * 
	 * @param regex
	 */
	public DirFilter(final String regex) {
		pattern = Pattern.compile(regex);
	}

	@Override
	public boolean accept(File dir, String name) {
		return pattern.matcher(name).matches();
	}

}
