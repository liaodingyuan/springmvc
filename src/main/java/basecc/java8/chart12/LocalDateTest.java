/**
 * 
 */
package basecc.java8.chart12;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

/**
* <p>Title:LocalDate </p>
* <p>Description:����java8���ṩ��ʱ������������ </p>
* <p>Company: </p>
* @author liaody
* @date 2018��5��6��
*/
public class LocalDateTest {

	/**
	 * ʹ��LocalDte��LocalTime
	 */
	public static void test001() {
		LocalDate date = LocalDate.of(2012, 3, 18);

		int year = date.getYear();
		Month month = date.getMonth();
		int day = date.getDayOfMonth();
		DayOfWeek dow = date.getDayOfWeek();
		int len = date.lengthOfMonth();
		boolean leap = date.isLeapYear();
		System.out.println(year);
		System.out.println(month);
		System.out.println(dow);
		System.out.println(day);
		System.out.println(len);
		// �ж��ǲ�������-
		System.out.println(leap);
		
		// ��ȡ��ǰ������
		LocalDate today = LocalDate.now();
	}
	
	public static void test002() {
		LocalTime time = LocalTime.of(23, 23,3);
		int hour = time.getHour();
		int minute = time.getMinute();
		int second = time.getSecond();
		System.out.println("time:"+String.valueOf(hour)+String.valueOf(minute)+String.valueOf(second));
	}
	/**
	 * ����Date��Time
	 */
	public static void test003() {
		LocalDate date = LocalDate.parse("2014-03-18");
		LocalTime time = LocalTime.parse("13:45:20");		
		LocalDateTime dt1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
		LocalDateTime dt2 = LocalDateTime.of(date, time);
		LocalDateTime dt3 = date.atTime(13, 45, 20);
		LocalDateTime dt4 = date.atTime(time);
		LocalDateTime dt5 = time.atDate(date);
		// LocalDateTime��LocalDate��LocalTime��
		LocalDate date1 = dt1.toLocalDate();
		LocalTime time1 = dt1.toLocalTime();
	}
	public static void main(String[] args) {
		
//		test001();
		test002();
	}
	
}
