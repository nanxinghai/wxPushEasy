package cn.simon.util;

/**
 * @author ：Simon
 * @date ：Created in 2022/9/21 21:28
 * @description：计算星座（参数示例：2028-09-09）
 * @modified By：
 * @version: v1.0
 */
public class ConstellationUtil {
    public static String getAstro(String birthday) {
        String[] split = birthday.split("-");
        Integer month = Integer.valueOf(split[1]);
        Integer day = Integer.valueOf(split[2]);
        String[] starArr = {"魔羯座","水瓶座", "双鱼座", "牡羊座",
                "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座" };
        int[] DayArr = {22, 20, 19, 21, 21, 21, 22, 23, 23, 23, 23, 22};  // 两个星座分割日
        int index = month;
        // 所查询日期在分割日之前，索引-1，否则不变
        if (day < DayArr[month - 1]) {
            index = index - 1;
        }
        if(month == 12){
            index = 0;
        }
        // 返回索引指向的星座string
        return starArr[index];
    }
}
