package com.bluepha.common.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * *****************************************************************************
 *
 *               Copyright(c) 2021 by 北京蓝晶微生物科技有限公司.
 *
 *                       All rights reserved.
 *
 *******************************************************************************
 *     File Name         :   DateUtils.java
 *
 *     Description       :   日期处理工具类
 * -----------------------------------------------------------------------------
 *     No.        Date              Revised by           Description
 *     0       2021-06-18             WuJi	               Created
 ********************************************************************************
 */

public class DateUtils {

    private static LocalDate date = LocalDate.now();

    private static LocalDateTime localDateTime = LocalDateTime.now();

    private static DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * @author  WuJi
     * @time    2021-06-18 09:10
     * @return  ServerResponse
     * @throws  Exception
     * 方法说明： 获取当前年月日
     */
    public static String getDate(){
        return date.toString();
    }

    /**
     * @author  WuJi
     * @time    2021-06-18 09:10
     * @return  ServerResponse
     * @throws  Exception
     * 方法说明： 获取当前年月日 时分秒
     */
    public static String getDateTime(){
        return localDateTime.format(df);
    }

    /**
     * @author  WuJi
     * @time    2021-06-18 09:10
     * @return  ServerResponse
     * @throws  Exception
     * 方法说明： 获取当前年月
     */
    public static String getYearAndMonth(){
        return date.toString().substring(0,7);
    }

}
