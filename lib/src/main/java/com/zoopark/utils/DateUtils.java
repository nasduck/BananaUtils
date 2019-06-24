package com.zoopark.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期时间相关工具类
 */
public class DateUtils {

    // 默认样式
    public static final String FORMAT_DEFAULT = "yyyy-MM-dd HH:mm:ss";

    // 显示 年
    public static final String FORMAT_Y    = "yyyy";
    public static final String FORMAT_CN_Y = "yyyy年";

    // 显示 年月
    public static final String FORMAT_YM = "yyyy-MM";

    // 月日
    public static final String FORMAT_CN_MD = "MM月dd日";

    // 显示 时分
    public static final String FORMAT_HM = "HH:mm";

    // 显示 月日时分
    public static final String FORMAT_MD_HM    = "MM-dd HH:mm";
    public static final String FORMAT_CN_MD_HM = "MM月dd日 HH:mm";

    // 显示 年月日
    public static final String FORMAT_YMD       = "yyyy-MM-dd";
    public static final String FORMAT_YMD_SHORT = "yy-MM-dd";
    public static final String FORMAT_CN_YMD    = "yyyy年MM月dd日";

    // 显示 年月日时分
    public static final String FORMAT_YMD_HM    = "yyyy-MM-dd HH:mm";
    public static final String FORMAT_CN_YMD_HM = "yyyy年MM月dd日 HH:mm";

    // 显示 年月日时分秒
    public static final String FORMAT_YMD_HMS    = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_CN_YMD_HMS = "yyyy年MM月dd日 HH:mm:ss";

    // 显示 年月日时分秒.毫秒
    public static final String FORMAT_FULL = "yyyy-MM-dd HH:mm:ss.S";

    /**
     * 得到传入时间的 String 形式
     *
     * @param time 时间毫秒级
     * @param pattern 模版
     * @return 返回对应时间和模版的 String 形式
     */
    public static String getDateString(long time, String pattern){
        String output = new SimpleDateFormat(pattern).format(new Date(time));
        String[] outputArray = output.split(" ");

        if(outputArray.length > 1) {
            if(isToday(time)) {
                return "今天 " + outputArray[1];
            } else {
                return output;
            }
        } else {
            return output;
        }
    }

    /**
     * 得到传入时间的 String 形式
     *
     * @param date 日期
     * @param pattern 模版
     * @return 返回对应时间和模版的 String 形式
     */
    public static String getDateString(Date date, String pattern){

        String output = new SimpleDateFormat(pattern).format(date);
        String[] outputArray = output.split(" ");

        if(outputArray.length > 1) {
            if(isToday(date)) {
                return "今天 " + outputArray[1];
            } else {
                return output;
            }
        } else {
            return output;
        }
    }

    /**
     * 使用参数Format将字符串转为Date
     */
    public static Date getStringDate(String strDate, String pattern) throws ParseException {
        return StringUtils.isEmpty(strDate) ? null : new SimpleDateFormat(
                pattern).parse(strDate);
    }

    /**
     * 增加天数
     * @param strDate
     * @param days
     * @param pattern
     * @return
     */
    public static String addDays(String strDate, int days, String pattern) {
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(getStringDate(strDate, pattern));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        cal.add(Calendar.DATE, days);// 30为增加的天数，可以改变的
        Date d = cal.getTime();
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(d);
    }

    /**
     * 增加天数
     * @param date
     * @param days
     * @param pattern
     * @return
     */
    public static Date addDays(Date date, int days, String pattern) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);// 30为增加的天数，可以改变的
        Date d = cal.getTime();
        return d;
    }

    /**
     * 获取当前时间戳
     *
     * @return 当前时间戳
     */
    public static long getTimeStamp() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTimeInMillis();
    }

    /**
     * 返回当前月份
     *
     * @param date 日期
     * @return 当前月份
     */
    public static int getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }


    /**
     * 返回当前日
     *
     * @param date 日期
     * @return 当前日
     */
    public static int getDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }


    /**
     * 返回小时
     *
     * @param date 日期
     * @return 当前小时
     */
    public static int getHour(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }


    /**
     * 返回分钟
     *
     * @param date 日期
     * @return 当前分钟
     */
    public static int getMinute(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MINUTE);
    }


    /**
     * 返回秒钟
     *
     * @param date 日期
     * @return 当前秒钟
     */
    public static int getSecond(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.SECOND);
    }


    /**
     * 返回毫秒
     *
     * @param date 日期
     * @return 当前毫秒
     */
    public static long getMillis(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getTimeInMillis();
    }

    /**
     * 判断是否是当天
     *
     * @param time 需要判断的时间
     * @return true 是当天
     */
    public static boolean isToday(long time) {
        String curDate = new SimpleDateFormat(FORMAT_YMD).format(getTimeStamp());
        String srcDate = new SimpleDateFormat(FORMAT_YMD).format(new Date(time));

        return curDate.equals(srcDate);
    }

    /**
     * 判断是否是当天
     *
     * @param date 需要判断的时间
     * @return true 是当天
     */
    public static boolean isToday(Date date) {
        String curDate = new SimpleDateFormat(FORMAT_YMD).format(getTimeStamp());
        String srcDate = new SimpleDateFormat(FORMAT_YMD).format(date);

        return curDate.equals(srcDate);
    }

}
