package cn.simon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：Simon
 * @date ：Created in 2022/8/29 0:55
 * @description：
 * @modified By：
 * @version: v1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Weather {
    // 温度，默认单位：摄氏度
    private String temp;
    // 体感温度，默认单位：摄氏度
    private String feelsLike;
    // 天气状况的文字描述，包括阴晴雨雪等天气状态的描述
    private String text;
    // 风向
    private String windDir;
    // 风力等级
    private String windScale;
    // 风速
    private String windSpeed;
    // 相对湿度，百分比数值
    private String humidity;
}
