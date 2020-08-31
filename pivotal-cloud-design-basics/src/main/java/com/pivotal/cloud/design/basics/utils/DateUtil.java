package com.pivotal.cloud.design.basics.utils;

import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

/**
 * <p>封装Qicloud项目DateUtil类.<br></p>
 * <p>//TODO...<br></p>
 *
 * @author Powered by marklin 2020-08-17 15:54
 * @version 1.0.0
 * <p>Copyright © 2018-2020 Pivotal Cloud Technology Systems Incorporated. All rights reserved.<br></p>
 */
public class DateUtil {
    public static final Date MOST_FUTURE_TIME = new Date(9223372036854775807L);
    public static final String SHORT_DATE_PATTERN = "yyyy-MM-dd";
    public static final String SHORT_DATE_CHINESE_PATTERN = "yyyy年MM月dd日";
    public static final String TIME_PATTERN = "HH:mm:ss";
    public static final String LONG_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String LONG_DATE_NO_DELIMITER_PATTERN = "yyyyMMddHHmmss";
    private static final long MS_ONE_SECOND = 1000L;
    private static final long MS_ONE_MINUTE = 60000L;
    private static final long MS_ONE_HOUR = 3600000L;
    private static final long MS_ONE_DAY = 86400000L;
    public static final String maxDateStr = "9999-12-31";
    public static final String maxDateStr_ = "9999/12/31";
    public static final String yyMMdd = "yyyy-MM-dd";
    public static final String yyMMdd_ = "yyyy/MM/dd";
    public static final String yyMMddHHmm = "yyyy-MM-dd HH:mm";
    public static final String yyMMddHHmm_ = "yyyy/MM/dd HH:mm";
    public static final String yyMMddHHmmss = "yyyy-MM-dd HH:mm:ss";
    public static final String yyMMddHHmmss_ = "yyyy/MM/dd HH:mm:ss";
    public static final String yyMMddHHmmssSSS = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String yyMMddHHmmssSSS_ = "yyyy/MM/dd HH:mm:ss.SSS";
    public static final String yyMMddHHmmssSSSSSS = "yyyy-MM-dd HH:mm:ss.SSSSSS";
    public static final String yyMMddHHmmssSSSSSS_ = "yyyy/MM/dd HH:mm:ss.SSSSSS";
    public static final String yyMMddHHmmss4fileName = "yyyyMMddHHmmss";

    private DateUtil() {
    }

    public static String getCurrentDate() {
        return formatShort(new Date());
    }

    public static String getCurrentTime() {
        return formatLong(new Date());
    }

    public static String getCurrentTimeNoDelimiter() {
        return formatLongNoDelimiter(new Date());
    }

    public static Timestamp getCurrentTimestamp() {
        return new Timestamp(Calendar.getInstance().getTimeInMillis());
    }

    public static Date parse(final String date, final String pattern) {
        if (StringUtils.isEmpty(date)) {
            return null;
        } else {
            SimpleDateFormat formater = new SimpleDateFormat(pattern);

            try {
                return formater.parse(date);
            } catch (ParseException var4) {
                return null;
            }
        }
    }

    public static String parse(final Date date, final String pattern) {
        if (date == null) {
            return null;
        } else {
            SimpleDateFormat formater = new SimpleDateFormat(pattern);

            try {
                return formater.format(date);
            } catch (Exception var4) {
                return null;
            }
        }
    }

    public static String format(final Date date, final String pattern) {
        if (date == null) {
            return null;
        } else {
            DateFormat formater = new SimpleDateFormat(pattern);
            return formater.format(date);
        }
    }

    public static Date parseShort(final String date) {
        return parse(date, "yyyy-MM-dd");
    }

    public static String formatShort(final Date date) {
        return format(date, "yyyy-MM-dd");
    }

    public static Date parseLong(final String date) {
        return parse(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String formatLong(final Date date) {
        return format(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String formatLongNoDelimiter(final Date date) {
        return format(date, "yyyyMMddHHmmss");
    }

    public static Calendar getCalendar(final Date date) {
        if (date == null) {
            return null;
        } else {
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            return c;
        }
    }

    public static int yearBetween(final Date earlierDate, final Date laterDate) {
        Calendar earlierCalendar = Calendar.getInstance();
        Calendar laterCalendar = Calendar.getInstance();
        earlierCalendar.setTime(earlierDate);
        laterCalendar.setTime(laterDate);
        return laterCalendar.get(1) - earlierCalendar.get(1);
    }

    public static int monthsBetween(final Date earlierDate, final Date laterDate) {
        Calendar earlierCalendar = Calendar.getInstance();
        Calendar laterCalendar = Calendar.getInstance();
        earlierCalendar.setTime(earlierDate);
        laterCalendar.setTime(laterDate);
        int months = (laterCalendar.get(1) - earlierCalendar.get(1)) * 12;
        return months - earlierCalendar.get(2) + laterCalendar.get(2);
    }

    public static int daysBetween(final Date earlierDate, final Date laterDate) {
        Calendar earlierCalendar = setTimeToCalendar(earlierDate, 0, 0, 0, 0);
        Calendar laterCalendar = setTimeToCalendar(laterDate, 0, 0, 0, 0);
        long dms = laterCalendar.getTimeInMillis() - earlierCalendar.getTimeInMillis();
        return (int)(dms / 86400000L);
    }

    public static int hoursBetween(final Date earlierDate, final Date laterDate) {
        Calendar earlierCalendar = setTimeToCalendar(earlierDate, -1, 0, 0, 0);
        Calendar laterCalendar = setTimeToCalendar(laterDate, -1, 0, 0, 0);
        long dms = laterCalendar.getTimeInMillis() - earlierCalendar.getTimeInMillis();
        return (int)(dms / 3600000L);
    }

    public static int minutesBetween(final Date earlierDate, final Date laterDate) {
        Calendar earlierCalendar = setTimeToCalendar(earlierDate, -1, -1, 0, 0);
        Calendar laterCalendar = setTimeToCalendar(laterDate, -1, -1, 0, 0);
        long dms = laterCalendar.getTimeInMillis() - earlierCalendar.getTimeInMillis();
        return (int)(dms / 60000L);
    }

    public static long secondsBetween(final Date earlierDate, final Date laterDate) {
        Calendar earlierCalendar = setTimeToCalendar(earlierDate, -1, -1, -1, 0);
        Calendar laterCalendar = setTimeToCalendar(laterDate, -1, -1, -1, 0);
        long dms = laterCalendar.getTimeInMillis() - earlierCalendar.getTimeInMillis();
        return dms / 1000L;
    }

    public static Date createDate(final int year, final int month, final int day, final int hour, final int minute, final int second, final int millisecond) {
        Calendar c = Calendar.getInstance();
        c.set(1, year);
        c.set(2, month - 1);
        c.set(5, day);
        c.set(11, hour);
        c.set(12, minute);
        c.set(13, second);
        c.set(14, millisecond);
        return c.getTime();
    }

    public static Date addYears(final Date date, final int years) {
        if (years == 0) {
            return date;
        } else {
            Calendar c = getCalendar(date);
            c.add(1, years);
            return c.getTime();
        }
    }

    public static Date addMonths(final Date date, final int months) {
        if (months == 0) {
            return date;
        } else {
            Calendar c = getCalendar(date);
            c.add(2, months);
            return c.getTime();
        }
    }

    public static Date addDays(final Date date, final Integer days) {
        if (Objects.nonNull(days)) {
            Calendar c = getCalendar(date);
            c.add(5, days);
            return c.getTime();
        } else {
            return date;
        }
    }

    public static Date addHours(final Date date, final int hours) {
        if (hours == 0) {
            return date;
        } else {
            Calendar c = getCalendar(date);
            c.add(11, hours);
            return c.getTime();
        }
    }

    public static Date addMinutes(final Date date, final int minutes) {
        if (minutes == 0) {
            return date;
        } else {
            Calendar c = getCalendar(date);
            c.add(12, minutes);
            return c.getTime();
        }
    }

    public static Date addSeconds(final Date date, final int seconds) {
        if (seconds == 0) {
            return date;
        } else {
            Calendar c = getCalendar(date);
            c.add(13, seconds);
            return c.getTime();
        }
    }

    public static Date setDate(final Date date, final int year, final int month, final int day) {
        Calendar c = getCalendar(date);
        c.set(1, year);
        c.set(2, month - 1);
        c.set(5, day);
        return c.getTime();
    }

    public static Date setTime(final Date date, final int hour, final int minute, final int second, final int millisecond) {
        Calendar c = setTimeToCalendar(date, hour, minute, second, millisecond);
        return c == null ? null : c.getTime();
    }

    private static Calendar setTimeToCalendar(final Date date, final int hour, final int minute, final int second, final int millisecond) {
        Calendar c = getCalendar(date);
        if (c == null) {
            return null;
        } else {
            if (hour >= 0) {
                c.set(11, hour);
            }

            if (minute >= 0) {
                c.set(12, minute);
            }

            if (second >= 0) {
                c.set(13, second);
            }

            if (millisecond >= 0) {
                c.set(14, millisecond);
            }

            return c;
        }
    }

    public static Date earliest(final Date... dates) {
        Date result = null;
        Date[] var2 = dates;
        int var3 = dates.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Date date = var2[var4];
            if (result == null) {
                result = date;
            } else if (date.before(result)) {
                result = date;
            }
        }

        return result;
    }

    public static Date latest(final Date... dates) {
        Date result = null;
        Date[] var2 = dates;
        int var3 = dates.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Date date = var2[var4];
            if (result == null) {
                result = date;
            } else if (date.after(result)) {
                result = date;
            }
        }

        return result;
    }

    public static int getYear(final Date date) {
        return getCalendar(date).get(1);
    }

    public static int getMonth(final Date date) {
        return getCalendar(date).get(2) + 1;
    }

    public static int getDay(final Date date) {
        return getCalendar(date).get(5);
    }

    public static int getHour(final Date date) {
        return getCalendar(date).get(11);
    }

    public static boolean isWeekend(final Date date) {
        int weekday = getCalendar(date).get(7);
        return weekday == 1 || weekday == 7;
    }

    public static final Date strToDate(String times) throws ParseException {
        if (Objects.nonNull(times)) {
            return new Date();
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(times);
        }
    }

    public static final Date strToDateTime(String datetime, String pattern) throws ParseException {
        if (Objects.nonNull(datetime)) {
            return new Date();
        } else {
            if (Objects.nonNull(pattern)) {
                pattern = "yyyy-MM-dd HH:mm";
            }

            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            return sdf.parse(datetime);
        }
    }

    public static final Date strToTimeStamp(String times) throws ParseException {
        if (Objects.nonNull(times)) {
            return new Date();
        } else {
            String pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS";
            if (times.length() == 23) {
                pattern = "yyyy-MM-dd HH:mm:ss.SSS";
            }

            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            return sdf.parse(times);
        }
    }

    public static final String dateToStr(Date date, String pattern) {
        if (Objects.nonNull(date)) {
            date = new Date();
        }

        if (Objects.nonNull(pattern)) {
            pattern = "yyyy-MM-dd HH:mm:ss.SSS";
        }

        SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.US);
        return sdf.format(date);
    }

    public static final String getCurrentDBTimeString() {
        return dateToStr((Date)null, (String)null);
    }

    public static final Date getLastMonthFisrtDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(2, -1);
        calendar.set(5, 1);
        return calendar.getTime();
    }

    public static final Date getLastMonthLastDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(5, 1);
        calendar.add(5, -1);
        return calendar.getTime();
    }

    public static final Date getLastDayLastSecond() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(5, -1);
        calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), 23, 59, 59);
        return calendar.getTime();
    }

    public static final Date getLastSecond(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), 23, 59, 59);
        return calendar.getTime();
    }

    public static int getDayOfMonth() {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        int day = calendar.getActualMaximum(5);
        return day;
    }

    public static final Date getBeginTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), 0, 0, 0);
        return calendar.getTime();
    }

    public static final Date getLastTheDay(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(5, days);
        return calendar.getTime();
    }

    public static final String getBeforeMonth(int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(2, month);
        return dateToStr(calendar.getTime(), "yyyy-MM");
    }

    public static final String getLastDayByYearAndMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, year);
        calendar.set(2, month);
        calendar.set(5, 0);
        return dateToStr(calendar.getTime(), "yyyy-MM-dd");
    }

    public static void main(String[] args) {
        System.out.println(getBeforeMonth(-1));
        System.out.println(getLastDayByYearAndMonth(2020, 2));
    }

    public static final Date getFirstDayThisMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(5, 1);
        return calendar.getTime();
    }

    public static boolean compareAndGT(Date d1, Date d2) {
        return d1.getTime() > d2.getTime();
    }

    public static boolean compareAndGTE(Date d1, Date d2) {
        return d1.getTime() >= d2.getTime();
    }

    public static boolean compareAndLT(Date d1, Date d2) {
        return d1.getTime() < d2.getTime();
    }

    public static boolean compareAndLTE(Date d1, Date d2) {
        return d1.getTime() <= d2.getTime();
    }

    public static Long getSecondsNextEarlyMorning() {
        Calendar cal = Calendar.getInstance();
        cal.add(6, 1);
        cal.set(11, 0);
        cal.set(13, 0);
        cal.set(12, 0);
        cal.set(14, 0);
        return (cal.getTimeInMillis() - System.currentTimeMillis()) / 1000L;
    }

    public static String getWeekOfDate(Date dt) {
        return getWeekOfDate(dt, "");
    }

    public static String getWeekOfDate(Date dt, String prefix) {
        String[] weekDays = new String[]{"日", "一", "二", "三", "四", "五", "六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(7) - 1;
        if (w < 0) {
            w = 0;
        }

        return prefix + weekDays[w];
    }

    public static Date getYearStartTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(date.getTime());
        calendar.add(1, 0);
        calendar.add(5, 0);
        calendar.add(2, 0);
        calendar.set(6, 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return new Date(calendar.getTimeInMillis());
    }

    public static Date getYearEndTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(date.getTime());
        int year = calendar.get(1);
        calendar.clear();
        calendar.set(1, year);
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        calendar.set(14, 999);
        calendar.roll(6, -1);
        return new Date(calendar.getTimeInMillis());
    }
}
