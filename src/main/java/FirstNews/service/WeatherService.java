package FirstNews.service;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class WeatherService {
    private static final Logger logger = LogManager.getLogger(WeatherService.class);

    //根据IP获取城市
    private  String getCity() {//HttpServletRequest request) {
        String city = null;
        try {
            String ip = "223.85.221.44";//getIpAddr(request);
            URL url = new URL("http://ip.taobao.com/service/getIpInfo.php?ip=" + ip);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestMethod("GET");
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream is = conn.getInputStream();
                LineIterator lineIterator = IOUtils.lineIterator(is, "utf-8");
                StringBuilder getfromurl = new StringBuilder();
                while (lineIterator.hasNext()) {
                    getfromurl.append(lineIterator.nextLine());
                }
                JSONObject getfromurljson = new JSONObject(getfromurl.toString());
                city = getfromurljson.getJSONObject("data").getString("city");
                is.close();
            }
        } catch (Exception e) {
            logger.error(e.getStackTrace());
        }
     return city;

    }



    //获取ip
    private String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("http_client_ip");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip != null && ip.indexOf(",") != -1) {
            ip = ip.substring(ip.lastIndexOf(",") + 1, ip.length()).trim();
        }
        return ip;
    }

    public  JSONObject getWeather() {//(HttpServletRequest request) {
        JSONObject weatherjson=new JSONObject();
        Map<String, String> weathermap = new HashMap();
        try {
            String city=getCity();
            String urlcity = URLEncoder.encode(city,"utf-8");// getCity(request);
            URL url = new URL("https://www.sojson.com/open/api/weather/json.shtml?city="+urlcity);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestMethod("GET");
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream is = conn.getInputStream();
                LineIterator lineIterator = IOUtils.lineIterator(is, "utf-8");
                StringBuilder stringBuilder = new StringBuilder();
                while (lineIterator.hasNext()) {
                   stringBuilder.append(lineIterator.next()+"\n");
                }
                IOUtils.closeQuietly(is);
                String getweather = stringBuilder.toString();
                weatherjson=new JSONObject(getweather);
                weatherjson=weatherjson.getJSONObject("data").getJSONArray("forecast").getJSONObject(0);
                String tempreture=weatherjson.getString("high").split(" ")[1]+"/"+weatherjson.getString("low").split(" ")[1];
                weathermap.put("city",city);
                weathermap.put("tempreture",tempreture);
                weathermap.put("weatherdetail",weatherjson.getString("type"));
                weatherjson=new JSONObject();
                weatherjson.put("weather",weathermap);
            }
        } catch (Exception e) {
            logger.error(e.getStackTrace());
        }
        return weatherjson;
    }
}
