/**
 * 
 */
package basecc.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * Title:DateUtils
 * </p>
 * <p>
 * Description:日期类型工具类。
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2018年2月27日
 */
public class DateUtils {

	/**
	 * yy-MM-dd
	 */
	public static final String yy_MM_dd = "yy-MM-dd";
	/**
	 * yyyy-MM
	 */
	public static final String yyyy_MM = "yyyy-MM";

	/**
	 * 计算开始时间结束时间相差多少天的日期集合
	 * 
	 * @param dateStart
	 *            开始时间，如：2017-11-11
	 * @param dateEnd
	 *            结束时间 如：2017-11-13
	 * @param style
	 *            将字符串格式化，DateUtils.yyyy_MM_dd
	 * @return 输出结果:[2017-11-11, 2017-11-12, 2017-11-13]
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static ArrayList getDayList(String dateStart, String dateEnd, String style) {
		ArrayList list = new ArrayList();
		SimpleDateFormat myFormatter = new SimpleDateFormat(style);
		Date date1 = null;
		Date date2 = null;
		try {
			// String 转换为Date使用parse，Date转换为String施工format
			date1 = myFormatter.parse(dateStart);
			date2 = myFormatter.parse(dateEnd);
		} catch (Exception ex1) {
			System.out.println("日期转换格式应和传入的日期格式一致" + ex1.toString());
		}
		long day = (date2.getTime() - date1.getTime()) / (24 * 60 * 60 * 1000) + 1;
		long date3 = date1.getTime();
		for (int i = 0; i < day; i++) {
			String dateStr = myFormatter.format((new Date(date3)));
			list.add(dateStr);
			date3 = date3 + 24 * 60 * 60 * 1000;
		}
		return list;
	}

	/**
	 * 传入年-月，算出中间隔了几个月
	 * 
	 * @param dateStart
	 *            开始时间 年-月
	 * @param dateEnd
	 *            结束时间 年-月
	 * @param style
	 * @return
	 * @throws ParseException
	 *
	 *             例如传入参数 "2017-11","2018-02","yyyy-MM",
	 *             输出的结果是2017-11,2017-12,2018-01,2018-02
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List getYearAndMonthList(String dateStart, String dateEnd, String style) {
		List list = new ArrayList();
		SimpleDateFormat sdf = new SimpleDateFormat(style);
		try {
			Calendar c1 = Calendar.getInstance();
			Calendar c2 = Calendar.getInstance();
			c1.setTime(sdf.parse(dateStart));
			c2.setTime(sdf.parse(dateEnd));
			int year = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
			int monthDistance;
			// 开始日期若小月结束日期
			if (year < 0) {
				year = -year;
				monthDistance = year * 12 + c1.get(Calendar.MONTH) - c2.get(Calendar.MONTH);
			}
			monthDistance = year * 12 + c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
			int cyear;
			int cmonth;
			for (int i = 0; i < monthDistance + 1; i++) {
				// 获取开始时间的年份
				cyear = c1.get(c1.YEAR);
				// 这里的月份要加1才是开始时间的月份
				c1.add(c1.MONTH, 1);
				// 这里第一次加完之后是开始时间的月份
				cmonth = c1.get(c1.MONTH);
				// 0代表12月
				if (cmonth == 0) {
					cmonth = 12;
				}
				String yearAndMonth;
				if (cmonth < 10) {
					yearAndMonth = cyear + "" + "-" + "0" + cmonth + "";
				} else {
					yearAndMonth = cyear + "" + "-" + cmonth + "";
				}
				list.add(yearAndMonth);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
