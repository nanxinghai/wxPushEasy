package cn.simon.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ：Simon
 * @date ：Created in 2022/9/21 20:06
 * @description：2022-08-25 星期四  (当前时间格式化)
 * @modified By：
 * @version: v1.0
 */
public class TimeFormatUtil {
    /**
     * 将当前系统时间转换成字符串，类似：2022-08-25 星期四
     * @return
     */
    public static String format(){
        SimpleDateFormat myFmt3 = new SimpleDateFormat("yyyy-MM-dd E");
        Date now = new Date();
        return myFmt3.format(now);
    }
}
