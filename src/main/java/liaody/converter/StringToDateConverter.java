/**
 * 
 */
package liaody.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
* <p>Title:StringToDateConverter </p>
* <p>Description: �Զ�������ת��������Ҫ��springmvc�����ļ���ע��</p>
* <p>Company: </p>
* @author liaody
* @date 2017��7��16��
*/
public class StringToDateConverter implements Converter<String,Date>{

	// ��������ģ�����磺yyyy-mm-dd
	private String datePattern;
	public void setDatePattern(String datePattern) {
		this.datePattern = datePattern;
	}
	@Override
	public Date convert(String date) {

		SimpleDateFormat dateFormat = new SimpleDateFormat(this.datePattern);
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("����ת��ʧ��");
			return null;
		}
		

	}

}
