package FirstNews.controller;

import FirstNews.service.UserLoginService;
import FirstNews.service.WeatherService;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

@org.springframework.stereotype.Controller
public class HomeController implements Controller {
    @Override
    @RequestMapping(value = "/")
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        new UserLoginService().logincook(httpServletRequest,httpServletResponse);
        httpServletRequest.getRequestDispatcher("first").forward(httpServletRequest,httpServletResponse);
        return null;
    }
   @RequestMapping(value = "/weather")
public void sendWeather(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws Exception{
        JSONObject weatherjson=new WeatherService().getWeather();//getWeather(httpServletRequest);
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        PrintWriter pr=httpServletResponse.getWriter();
        pr.print(weatherjson);
       System.out.println(weatherjson);
        pr.flush();
        pr.close();
    }

}
