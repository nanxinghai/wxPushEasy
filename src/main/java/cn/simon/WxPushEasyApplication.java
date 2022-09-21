package cn.simon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author ：Simon
 * @date ：Created in 2022/9/21 19:54
 * @description：
 * @modified By：
 * @version: v1.0
 */
@SpringBootApplication
@EnableScheduling   // 定时任务
public class WxPushEasyApplication {
    public static void main(String[] args) {
        SpringApplication.run(WxPushEasyApplication.class, args);
    }
}
