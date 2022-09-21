package cn.simon.controller;

import cn.simon.entity.Weather;
import cn.simon.util.*;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author ：Simon
 * @date ：Created in 2022/9/21 19:58
 * @description：消息推送类
 * @modified By：
 * @version: v1.0
 */
@Component
public class PushController {
    @Value("${wx.appID}")
    private String appID;
    @Value("${wx.appsecret}")
    private String appsecret;
    @Autowired
    private TianQiUtil tianQiUtil;

    public void push(){
        try {
            //1，配置
            WxMpInMemoryConfigStorage wxStorage = new WxMpInMemoryConfigStorage();
            wxStorage.setAppId(appID);
            wxStorage.setSecret(appsecret);
            WxMpService wxMpService = new WxMpServiceImpl();
            wxMpService.setWxMpConfigStorage(wxStorage);
            //2,准备推送消息
            WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                    .toUser("关注的微信号")
                    .templateId("模板id")
                    .build();
            String city = "成都";
            // 2.1 获取今日时间
            String today = TimeFormatUtil.format();
            // 2.2 获取天气数据
            Weather weather = tianQiUtil.getWeather(city);
            // 2.3 获取星座数据
            String birthday = "2000-01-01";
            String astro = ConstellationUtil.getAstro(birthday);
            // 2.4 获取距离生日天数
            String birthDay = BirthdayUtil.getBirthDay(birthday);
            // 2.5 获取每日一句
            String content = YiJuHuaUtil.getContent();
            // 2.6 将每日一句转换成英语
            String engContent = YiJuHuaEnglishUtil.getContent(content);
            //3,发送模版消息，这里需要配置你的信息
            templateMessage.addData(new WxMpTemplateData("today",today,"#00BFFF"));
            templateMessage.addData(new WxMpTemplateData("city",city,"#4169E1"));
            templateMessage.addData(new WxMpTemplateData("text",weather.getText(),"#B22222"));
            templateMessage.addData(new WxMpTemplateData("temp",weather.getTemp(),"#FF7256"));
            templateMessage.addData(new WxMpTemplateData("windDir",weather.getWindDir(),"#FF34B3"));
            templateMessage.addData(new WxMpTemplateData("windScale",weather.getWindScale(),"#9ACD32"));
            templateMessage.addData(new WxMpTemplateData("windSpeed",weather.getWindSpeed(),"#9ACD32"));
            templateMessage.addData(new WxMpTemplateData("humidity",weather.getHumidity(),"#87CEFF"));
            templateMessage.addData(new WxMpTemplateData("constell",astro,"#C87CFB"));
            templateMessage.addData(new WxMpTemplateData("birthday",birthDay,"#00CCFF"));
            templateMessage.addData(new WxMpTemplateData("content",content,"#00CCFF"));
            templateMessage.addData(new WxMpTemplateData("engContent",engContent,"#FF69B4"));

            // 4,开始推送
            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        } catch (Exception e) {
            System.out.println("推送失败：" + e.getMessage());
            e.printStackTrace();
        }
    }
}
