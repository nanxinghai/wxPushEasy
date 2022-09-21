package cn.simon.util;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.simon.entity.Weather;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author ：Simon
 * @date ：Created in 2022/9/21 20:11
 * @description：
 * @modified By：
 * @version: v1.0
 */
@Component
public class TianQiUtil {
    @Value("${hefeng.key}")
    private String key;
    @Value("${hefeng.publicID}")
    private String publicID;

    /**
     * 传入城市名请求城市id（才能获取天气api）
     * @param city
     * @return
     * @throws Exception
     */
    public String getLocationId(String city) throws Exception {
        // 开发文档：https://dev.qweather.com/docs/api/geo/city-lookup/
        String url = "https://geoapi.qweather.com/v2/city/lookup";
        HashMap<String, Object> param = new HashMap<>();
        param.put("location",city);
        param.put("key",key);
        // 加密
        String signature = getSignature(param, key);
        param.put("sign",signature);
        String response = HttpUtil.get(url, param);
        JSONObject jsonObject = JSONUtil.parseObj(response);
        JSONArray location = (JSONArray) jsonObject.get("location");
        String locationID = "";
        for (Object o : location) {
            if(((JSONObject) o).get("adm2").equals(city)){
                locationID = (String) ((JSONObject) o).get("id");
            }
        }
        return locationID;
    }


    /**
     *  传入城市名获取城市天气
     * @param city 城市名
     * @return
     * @throws Exception
     */
    public Weather getWeather(String city) throws Exception {
        // 开发文档：https://dev.qweather.com/docs/api/weather/weather-now/
        String url = "https://devapi.qweather.com/v7/weather/now";
        HashMap<String, Object> param = new HashMap<>();
        param.put("key",key);
        String locationId = getLocationId(city);
        param.put("location",locationId);
        // 加密
        String signature = getSignature(param, key);
        param.put("sign",signature);
        String response = HttpUtil.get(url, param);
        JSONObject jsonObject = JSONUtil.parseObj(response);
        JSONObject now = (JSONObject) jsonObject.get("now");
        Weather weather = now.toBean(Weather.class);
        return weather;
    }
    /**
     * 和风天气签名生成算法-JAVA版本
     * @param  params 请求参数集，所有参数必须已转换为字符串类型
     * @param  secret 签名密钥（用户的认证key）
     * @return 签名
     * @throws IOException
     */
    public String getSignature(HashMap<String, Object> params, String secret) throws Exception {
        // 先将参数以其参数名的字典序升序进行排序
        Map<String, Object> sortedParams = new TreeMap<>(params);
        Set<Map.Entry<String, Object>> entrys       = sortedParams.entrySet();

        // 遍历排序后的字典，将所有参数按"key=value"格式拼接在一起
        StringBuilder baseString = new StringBuilder();
        for ( Map.Entry<String, Object> param : entrys ) {
            //sign参数 和 空值参数 不加入算法
            if ( param.getValue()!=null && !"".equals(param.getKey().trim()) && !"sign".equals(param.getKey  ().trim()) &&!"key".equals(param.getKey().trim()) && !"".equals(String.valueOf(param.getValue()).trim()) ) {
                baseString.append(param.getKey().trim()).append("=").append(String.valueOf(param.getValue()).trim()).append  ("&");
            }
        }
        if ( baseString.length() > 0 ) {
            baseString.deleteCharAt(baseString.length() - 1).append(secret);
        }
        // 使用MD5对待签名串求签
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(baseString.toString().getBytes("UTF-8"));
            return new String(encodeHex(bytes));
        } catch (GeneralSecurityException ex) {
            throw ex;
        }
    }

    public char[] encodeHex(byte[] data) {
        int    l        = data.length;
        char[] out      = new char[l << 1];
        int    i        = 0;
        char[] toDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        for ( int var5 = 0; i < l; ++i ) {
            out[var5++] = toDigits[(240 & data[i]) >>> 4];
            out[var5++] = toDigits[15 & data[i]];
        }
        return out;
    }
}
