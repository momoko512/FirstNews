package FirstNews.controller;
import FirstNews.mybean.User;
import FirstNews.service.RegistService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@org.springframework.stereotype.Controller
public class RegistResultController implements Controller{

    @Override
    @RequestMapping(value = "/registresult")
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        User user=new RegistService().regist(httpServletRequest,httpServletResponse);
        return new ModelAndView("registresult", "user",user);
    }
    @RequestMapping(value = "/register")
    public ModelAndView regist(){
        return new ModelAndView("register");
    }

}
