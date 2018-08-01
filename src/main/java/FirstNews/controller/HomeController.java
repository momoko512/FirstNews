package FirstNews.controller;

import FirstNews.service.UserLoginService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@org.springframework.stereotype.Controller
public class HomeController implements Controller {
    @Override
    @RequestMapping(value = "/")
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        new UserLoginService().logincook(httpServletRequest,httpServletResponse);
        httpServletRequest.getRequestDispatcher("first").forward(httpServletRequest,httpServletResponse);
        return null;
    }
}
