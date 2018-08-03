package FirstNews.test;

import FirstNews.wstest.*;

public class WebTest1 {
    public static void m(String[] args) {
        get("15828687479","");
    }
    public static void get(String mobileCode,String userID){
        MobileCodeWS mobileCodeWS=new MobileCodeWS();
        MobileCodeWSSoap mobileCodeWSSoap=mobileCodeWS.getMobileCodeWSSoap();
        String s =mobileCodeWSSoap.getMobileCodeInfo(mobileCode,userID);
        System.out.println(s);
    }
}
