package cn.simon.util;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.util.HashMap;

/**
 * @author ：Simon
 * @date ：Created in 2022/8/29 1:55
 * @description：
 * @modified By：
 * @version: v1.0
 */
public class YiJuHuaUtil {
    public static String getContent(){
        // https://www.tianapi.com/apiview/181
        String url = "http://api.tianapi.com/caihongpi/index";
        HashMap<String, Object> param = new HashMap<>();
        param.put("key","你的key");
        String response = HttpUtil.get(url, param);
        JSONObject jsonObject = JSONUtil.parseObj(response);
        JSONArray newslist = (JSONArray) jsonObject.get("newslist");
        JSONObject contents = (JSONObject)newslist.get(0);
        return (String) contents.get("content");
    }
}
