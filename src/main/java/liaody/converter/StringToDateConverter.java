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
* <p>Description: 自定义日期转换器，需要在springmvc配置文件中注册</p>
* <p>Company: </p>
* @author liaody
* @date 2017年7月16日
*/
public class StringToDateConverter implements Converter<String,Date>{

	// 定义日期模板例如：yyyy-mm-dd
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
			System.out.println("日期转换失败");
			return null;
		}
		

	}

}
