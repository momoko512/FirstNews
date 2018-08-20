package firstnews.controller;


import firstnews.dao.ContributeDAO;
import firstnews.domain.Contribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/contribute")
public class ContributeController {

    @Autowired
    private ContributeDAO contributeDAO;

    //首页获取n条pass=1的contribute
    @GetMapping("home/{n}")
    public final ResponseModel<List<Contribute>> getByPass(@PathVariable Integer n) {
        List<Contribute> list = contributeDAO.getByPass(n);
        return ResponseModel.SUCCESS(list);
    }
    //根据ID获取contribute
    @GetMapping("id")
    public final Contribute getById(Integer id) {
        return contributeDAO.getbyid(id);
    }
/*

    @RequestMapping(value = "/submitedit")
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.setCharacterEncoding("utf-8");
        Contribute contribute = new Contribute();
        contribute = new EdtiService().get(contribute, httpServletRequest);
        new ContributeDAO().addContribute(contribute);
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
        List<Contribute> contributes = new ContributeDAO().getbyname(name);
        return new ModelAndView("mycontribute", "contributes", contributes);
    }


    @RequestMapping(value = "/*.delete")
    public ModelAndView delete(HttpServletRequest httpServletRequest) throws Exception {
        List<Contribute> contributes =new EdtiService().delete(httpServletRequest);
        return new ModelAndView("mycontribute", "contributes", contributes);
    }
    */
}