### 微信模板推送简单版
#### 快速开始

将代码拉至本地

```shell
git clone https://github.com/nanxinghai/wxPushEasy.git
```

用idea将其打开为maven项目，并等待其加载jar包

![image-20220921214741749](https://raw.githubusercontent.com/nanxinghai/PicGo/main/202209212147894.png)

#### 需要自己替换的内容

##### 1.yml文件中的appID和appsecret

![image-20220921214843378](https://raw.githubusercontent.com/nanxinghai/PicGo/main/202209212148478.png)

注册微信测试号地址：[https://mp.weixin.qq.com/debug/cgi-bin/sandbox?t=sandbox/login](https://mp.weixin.qq.com/debug/cgi-bin/sandbox?t=sandbox/login)

注册完成之后，会出现以下界面

![image-20220921215045744](https://raw.githubusercontent.com/nanxinghai/PicGo/main/202209212150841.png)

将上方页面的appID和appsecret，填入上方中

##### 2.注册和风api获取天气数据

官网地址：[https://dev.qweather.com/](https://dev.qweather.com/)

注册好之后，创建自己的应用，如下

![image-20220921215408537](https://raw.githubusercontent.com/nanxinghai/PicGo/main/202209212154635.png)

![image-20220921215425400](https://raw.githubusercontent.com/nanxinghai/PicGo/main/202209212154506.png)

将你的key和publicID替换掉yml中的数据

##### 3.获取每日一句彩虹屁api

地址：[https://www.tianapi.com/apiview/181](https://www.tianapi.com/apiview/181)

![image-20220921215723263](https://raw.githubusercontent.com/nanxinghai/PicGo/main/202209212157374.png)

![image-20220921215740800](https://raw.githubusercontent.com/nanxinghai/PicGo/main/202209212157900.png)

将你的key替换掉代码里的内容

##### 4.最后一步

扫描你刚刚创建的测试公众号，会出现关注用户，将关注用户的微信号替换下图内容

![image-20220921215953676](https://raw.githubusercontent.com/nanxinghai/PicGo/main/202209212159764.png)

只需拿一个微信号即可

![image-20220921220040056](https://raw.githubusercontent.com/nanxinghai/PicGo/main/202209212200162.png)

去测试公众号页面新增一个模板，模板决定着你发送什么内容

![image-20220921220205712](https://raw.githubusercontent.com/nanxinghai/PicGo/main/202209212202813.png)

![image-20220921220236780](https://raw.githubusercontent.com/nanxinghai/PicGo/main/202209212202886.png)

模板标题想写什么写什么

模板内容可以将项目doc目录下的模板.txt文件中的内容复制到   你要填的模板内容中

点击提交后会生成模板ID

将代码中的模板ID替换掉

![image-20220921220426796](https://raw.githubusercontent.com/nanxinghai/PicGo/main/202209212204922.png)

#### 大功告成

最后，点击项目的测试类

![image-20220921220532159](https://raw.githubusercontent.com/nanxinghai/PicGo/main/202209212205261.png)

我想你已经收到消息了，那么便成功了，希望你能有所收获，感谢你的关注

Github开源：[https://github.com/nanxinghai/wxPushEasy](https://github.com/nanxinghai/wxPushEasy)

Gitee开源：[https://gitee.com/xiaoerff/wxPushEasy](https://gitee.com/xiaoerff/wxPushEasy)

