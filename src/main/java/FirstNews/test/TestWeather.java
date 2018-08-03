package FirstNews.test;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestWeather {
    public static void m(String[] args) {
        try {
            get("成都");
        }catch (Exception e){e.printStackTrace();}
    }
    public static void get(String city) throws Exception {
        URL url = new URL("http://ws.webxml.com.cn/WebServices/WeatherWebService.asmx/getWeatherbyCityName?theCityName="+city);
        System.out.println(url);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestMethod("GET");
        if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
            InputStream is = conn.getInputStream();
            LineIterator lineIterator = IOUtils.lineIterator(is, "utf-8");
            while (lineIterator.hasNext()) {
                String s = lineIterator.next();
                System.out.println(s);
            }
            is.close();
        }
    }
}