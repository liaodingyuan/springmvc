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
 * Description:�������͹����ࡣ
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2018��2��27��
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
	 * ���㿪ʼʱ�����ʱ��������������ڼ���
	 * 
	 * @param dateStart
	 *            ��ʼʱ�䣬�磺2017-11-11
	 * @param dateEnd
	 *            ����ʱ�� �磺2017-11-13
	 * @param style
	 *            ���ַ�����ʽ����DateUtils.yyyy_MM_dd
	 * @return ������:[2017-11-11, 2017-11-12, 2017-11-13]
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static ArrayList getDayList(String dateStart, String dateEnd, String style) {
		ArrayList list = new ArrayList();
		SimpleDateFormat myFormatter = new SimpleDateFormat(style);
		Date date1 = null;
		Date date2 = null;
		try {
			// String ת��ΪDateʹ��parse��Dateת��ΪStringʩ��format
			date1 = myFormatter.parse(dateStart);
			date2 = myFormatter.parse(dateEnd);
		} catch (Exception ex1) {
			System.out.println("����ת����ʽӦ�ʹ�������ڸ�ʽһ��" + ex1.toString());
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
	 * ������-�£�����м���˼�����
	 * 
	 * @param dateStart
	 *            ��ʼʱ�� ��-��
	 * @param dateEnd
	 *            ����ʱ�� ��-��
	 * @param style
	 * @return
	 * @throws ParseException
	 *
	 *             ���紫����� "2017-11","2018-02","yyyy-MM",
	 *             ����Ľ����2017-11,2017-12,2018-01,2018-02
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
			// ��ʼ������С�½�������
			if (year < 0) {
				year = -year;
				monthDistance = year * 12 + c1.get(Calendar.MONTH) - c2.get(Calendar.MONTH);
			}
			monthDistance = year * 12 + c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
			int cyear;
			int cmonth;
			for (int i = 0; i < monthDistance + 1; i++) {
				// ��ȡ��ʼʱ������
				cyear = c1.get(c1.YEAR);
				// ������·�Ҫ��1���ǿ�ʼʱ����·�
				c1.add(c1.MONTH, 1);
				// �����һ�μ���֮���ǿ�ʼʱ����·�
				cmonth = c1.get(c1.MONTH);
				// 0����12��
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
