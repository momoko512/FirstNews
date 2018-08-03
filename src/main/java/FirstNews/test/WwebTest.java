package FirstNews.test;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class WwebTest {
    public static void m(String[] args) throws Exception {
        new WwebTest().get("15102851776", "");
    }

    public void get(String mobileCode, String userID) throws Exception {
        URL url = new URL("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx/getMobileCodeInfo?mobileCode=" + mobileCode + "&userID=" + userID);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestMethod("GET");
        if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
            InputStream is = conn.getInputStream();
            LineIterator lineIterator= IOUtils.lineIterator(is,"utf-8");
            while(lineIterator.hasNext()){
                String s=lineIterator.next();
                System.out.println(s);
            }
            is.close();
        }
    }

}
