package com.ywf.untils;

import java.text.DateFormat;
import java.text.ParseException;
/**
* 时间工具类
* json
* xml
* text
* @author zhangkq
*
*/
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtil {
	public static String SYSTEM_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static String SYSTEM_DATE_NOW = "yyyyMMdd";
	public static String SYSTEM_DATE_NOW_HH = "yyyyMMddHH";
	public static String SYSTEM_TIIME_FORMAT = "MMddHHmmss";
	public static String SYSTEM_TIME_FORMAT = "yyyy/MM/dd";
	public static String SYSTEM_DATETIME_PORMAT = "yyyy-MM-dd";
	public static String SYSTEM_PORMAT = "yyyyMMdd";
	public static String MONTH_PORMAT = "yyyyMM";
	public static String MONTH_PORMAT_ = "yyyy/MM";

	public static SimpleDateFormat simpleDateFormat_duibi = new SimpleDateFormat("yyyyMMdd");

	/**
	 * 获取当前日期和时间的英文显示
	 * 
	 * @return
	 */
	public static String getNow() {
		return new SimpleDateFormat(SYSTEM_DATE_FORMAT).format(new Date());
	}

	public static String getNowDate_() {
		return new SimpleDateFormat(SYSTEM_DATETIME_PORMAT).format(new Date());
	}

	public static String getNowDate() {
		return new SimpleDateFormat(SYSTEM_DATE_NOW).format(new Date());
	}

	public static String getNowDate_HH() {
		return new SimpleDateFormat(SYSTEM_DATE_NOW_HH).format(new Date());
	}

	public static String getNowDate2() {
		return new SimpleDateFormat(SYSTEM_TIME_FORMAT).format(new Date());
	}

	public static String getYesterDay() {
		return getDateAfter(1, SYSTEM_TIME_FORMAT);
	}

	public static String getYesterDay_() {
		return getDateAfter(1, SYSTEM_DATE_NOW);
	}

	public static String getBefor14Day() {
		return getDateAfter(14, SYSTEM_TIME_FORMAT);
	}

	/**
	 * 获取当前时间戳
	 * 
	 * @return
	 */
	public static String getTimes() {
		return new SimpleDateFormat(SYSTEM_TIIME_FORMAT).format(new Date());
	}

	// 计算日期
	public static String getDateAfter(int day, String formart) {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat sd = new SimpleDateFormat(formart);
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
		return sd.format(now.getTime());
	}

	/**
	 * 转换特定格式的
	 * 
	 * @param dates
	 * @param formata
	 * @param formatb
	 * @return
	 */
	public static String toFormat(String dates, String formata, String formatb) {
		DateFormat format1 = new SimpleDateFormat(formata);
		DateFormat format2 = new SimpleDateFormat(formatb);
		Date date = null;
		String str2 = null;
		try {
			date = format1.parse(dates);
			str2 = format2.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str2;
	}

	/**
	 * 获取当前日期的前几个日期
	 * 
	 * @param count
	 * @return
	 */
	public static List<String> getDaysBeforeNow(String begin, int count, String format) {
		List<String> list = new ArrayList<String>();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			Date beginDate = sdf.parse(begin);
			Calendar c = Calendar.getInstance();
			c.setTime(beginDate);
			list.add(begin);
			for (int i = 0; i < count - 1; i++) {
				c.add(Calendar.DATE, -1);
				list.add(sdf.format(c.getTime()));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static String getBeforeNow(String begin, int num) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(SYSTEM_DATE_NOW);
			Date beginDate = sdf.parse(begin);
			Calendar c = Calendar.getInstance();
			c.setTime(beginDate);
			c.add(Calendar.DATE, num);
			return sdf.format(c.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static int getDays(String beginTime, String endTime, String pattern) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			Date beginDate = sdf.parse(beginTime);
			Date endDate = sdf.parse(endTime);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(beginDate);
			int day1 = calendar.get(Calendar.DAY_OF_YEAR);
			calendar.setTime(endDate);
			int day2 = calendar.get(Calendar.DAY_OF_YEAR);
			return day2 - day1 + 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 获取指定天数之前日期
	 * 
	 * @param num
	 * @return
	 */
	public static String getNumDaysAgo(int num) {
		SimpleDateFormat sdf = new SimpleDateFormat(SYSTEM_DATE_NOW);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, -num);
		return sdf.format(calendar.getTime());
	}

	/**
	 * 获取指定天数之前日期
	 * 
	 * @param num
	 * @return
	 */
	public static String getNumDaysHourAgo(int num) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, -num);
		return sdf.format(calendar.getTime());
	}

	/**
	 * 获取两个日期间所有的日期
	 * 
	 * @param begin
	 * @param end
	 * @param pattern
	 * @param timeType
	 *            取自Calendar.MONTH
	 * @return
	 */
	public static List<String> getDatesBetweenTwoDate(String begin, String end, String pattern, int timeType) {
		List<String> list = new ArrayList<String>();
		list.add(begin);
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			Date beginDate = sdf.parse(begin);
			Date endDate = sdf.parse(end);
			Calendar cal = Calendar.getInstance();
			cal.setTime(beginDate);
			boolean bContinue = true;
			while (bContinue) {
				cal.add(timeType, 1);
				if (endDate.after(cal.getTime())) {
					list.add(sdf.format(cal.getTime()));
				} else {
					break;
				}
			}
			list.add(end);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static String get2LastSaturDay() {
		Calendar date = Calendar.getInstance(Locale.CHINA);
		date.setFirstDayOfWeek(Calendar.MONDAY);// 将每周第一天设为星期一，默认是星期天
		date.add(Calendar.WEEK_OF_MONTH, -2);// 周数减二，即上上周
		date.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);// 日子设为星期六
		return new SimpleDateFormat(SYSTEM_DATE_NOW).format(date.getTime());
	}

	public static String getLastThursday() {
		Calendar date = Calendar.getInstance(Locale.CHINA);
		date.setFirstDayOfWeek(Calendar.MONDAY);// 将每周第一天设为星期一，默认是星期天
		date.add(Calendar.WEEK_OF_MONTH, -1);// 周数减二，即上上周
		date.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);// 日子设为星期五
		return new SimpleDateFormat(SYSTEM_TIME_FORMAT).format(date.getTime());
	}

	public static String getLastMonth31Day() {
		Calendar date = Calendar.getInstance(Locale.CHINA);
		date.add(Calendar.MONTH, -1);// 月份减1
		return new SimpleDateFormat(MONTH_PORMAT_).format(date.getTime()) + "/01";
	}

	public static boolean isDate(String dateStr) {
		try {
			String rexp = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";
			Pattern pat = Pattern.compile(rexp);
			Matcher mat = pat.matcher(dateStr);
			return mat.matches();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 
	 * @param time
	 * @return
	 */
	public static String getStandTimeHour(String time) {
		String dateStr = getNowDate();
		String hour = time.substring(0, 2);
		return dateStr + hour;
	}

	public static SimpleDateFormat simpleDateFormat_hour = new SimpleDateFormat("yyyyMMddHH");
	public static SimpleDateFormat suffix_simpleDateFormat = new SimpleDateFormat("mm");

	public static String getStandardDate_N_Ago_Hour(Integer n) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, -n);
		calendar.add(Calendar.HOUR, -1);
		String prefix = simpleDateFormat_hour.format(calendar.getTime());
		return prefix;
	}

	public static String getStandardDate_N_Ago_start(Integer n) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, -n);
		String prefix = simpleDateFormat_duibi.format(calendar.getTime()) + "00_00-00";
		return prefix;
	}

	public static String getStandardDate_N_Ago_start_Hour(Integer n) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, -n);
		String prefix = simpleDateFormat_duibi.format(calendar.getTime()) + "00";
		return prefix;
	}

	public static String getLastMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.MONTH, -1);
		String prefix = new SimpleDateFormat("yyyyMM").format(calendar.getTime());
		return prefix;
	}

	public static void main(String[] args) {
		System.out.println(getLastMonth());
	}

}
