package FirstNews.controller;

import FirstNews.mybean.First;
import FirstNews.service.FirstService;
import FirstNews.service.ImageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@org.springframework.stereotype.Controller
public class FirstController implements Controller {
    private First first=new First();
    @Override
    @RequestMapping(value="/first")
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        this.first=new FirstService().showfirst(httpServletRequest);
        return new ModelAndView("first","first",first);
    }
    @RequestMapping(value = {"*.image","work/*.image"})
    public void showFirstImage(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws Exception{
        new ImageService().showFirstImage(httpServletRequest,httpServletResponse,first);
    }
    @RequestMapping(value = {"leftadv","leftadv","rightadv1","rightadv2","rightadv3","contribute1","contribute2"})
    public void adv(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws Exception{
        new ImageService().showadv(httpServletRequest,httpServletResponse);
    }
}