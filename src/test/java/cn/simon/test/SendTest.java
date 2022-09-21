package cn.simon.test;

import cn.simon.controller.PushController;
import cn.simon.entity.Weather;
import cn.simon.util.TianQiUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ：Simon
 * @date ：Created in 2022/9/21 20:00
 * @description：测试推送
 * @modified By：
 * @version: v1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {cn.simon.WxPushEasyApplication.class})
public class SendTest {
    @Autowired
    private PushController pushController;

    @Test
    public void testPush(){
        pushController.push();
    }
}
