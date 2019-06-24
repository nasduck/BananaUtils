package com.zoopark.utils;

import java.math.BigDecimal;

/**
 * 小数点后几位工具类
 */
public class DecimalUtils {

    /**
     * 四省五入保留两位小数
     * @param num
     * @return
     */
    public static String keepTwoString(Double num) {
        if (num == null) return "0.00";
        return new BigDecimal(num).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
    }

    public static String keepTwoString(Float num) {
        if (num == null) return "0.00";
        return new BigDecimal(num).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
    }

    public static String keepTwoString(String num) {
        if (num == null || num == "") return "0.00";
        return new BigDecimal(num).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
    }

    public static Double keepTwoDouble(Double num) {
        if (num == null) return 0.00;
        return new BigDecimal(num).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static Double keepTwoDouble(String num) {
        return new BigDecimal(num).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static String keepOneString(Double num) {
        return new BigDecimal(num).setScale(1, BigDecimal.ROUND_HALF_UP).toString();
    }

    public static String keepZeroString(Double num) {
        if (num == null) return "0";
        return new BigDecimal(num).setScale(0, BigDecimal.ROUND_HALF_UP).toString();
    }

    public static String keepZeroString(String num) {
        return new BigDecimal(num).setScale(0, BigDecimal.ROUND_HALF_UP).toString();
    }

}
