package FirstNews.controller;

import FirstNews.dao.ContributeDao;
import FirstNews.mybean.Contribute;
import FirstNews.service.EdtiService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@org.springframework.stereotype.Controller
public class ContributeController implements Controller {
    @Override
    @RequestMapping(value = "/submitedit")
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.setCharacterEncoding("utf-8");
        Contribute contribute = new Contribute();
        contribute = new EdtiService().get(contribute, httpServletRequest);
        new ContributeDao().addContribute(contribute);
        return new ModelAndView("submitedit");
    }

    @RequestMapping(value = "/edit")
    public ModelAndView toEdit(HttpServletRequest httpServletRequest) {
        String uri = httpServletRequest.getRequestURI();
        String suburi=uri.substring(uri.lastIndexOf("/")+1);
        httpServletRequest.getSession().setAttribute("page", suburi);
        return new ModelAndView("contribute");
    }


    @RequestMapping(value = "/mycontribute")
    public ModelAndView myContribute(HttpServletRequest httpServletRequest) {
        String uri = httpServletRequest.getRequestURI();
        String suburi=uri.substring(uri.lastIndexOf("/")+1);
        httpServletRequest.getSession().setAttribute("page", suburi);
        String name = httpServletRequest.getSession().getAttribute("name").toString();
        List<Contribute> contributes = new ContributeDao().getbyname(name);
        return new ModelAndView("mycontribute", "contributes", contributes);
    }


    @RequestMapping(value = "/*.delete")
    public ModelAndView delete(HttpServletRequest httpServletRequest) throws Exception {
        List<Contribute> contributes =new EdtiService().delete(httpServletRequest);
        return new ModelAndView("mycontribute", "contributes", contributes);
    }
}