package FirstNews.controller;

import FirstNews.controller.exception.SimpleExceptionResovler;
import org.apache.logging.log4j.LogManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@org.springframework.stereotype.Controller
public class ExitController implements Controller{
    @Override
    @RequestMapping(value = "/exit")
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.getSession().setAttribute("name",null);
        Cookie[] cookies= httpServletRequest.getCookies();
        if(cookies!=null&&cookies.length>0){
            for(Cookie c:cookies){
                if(c.getName().equals("name")||c.getName().equals("password")){
                    c.setMaxAge(0);
                    httpServletResponse.addCookie(c);
                }
            }
        }
        String uri=httpServletRequest.getSession().getAttribute("page").toString();
        org.apache.logging.log4j.Logger log = LogManager.getLogger(SimpleExceptionResovler.class);
        log.info(uri);
        if(uri.equals("edit")||uri.contains(".contribute")||uri.equals("mycontribute")){
            uri="first";}
        httpServletRequest.getRequestDispatcher(uri).forward(httpServletRequest,httpServletResponse);
        return null;
    }
}
