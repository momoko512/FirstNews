package FirstNews.controller.work;

import FirstNews.dao.ContributeDao;
import FirstNews.mybean.Contribute;
import FirstNews.service.ImageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@org.springframework.stereotype.Controller
public class Review implements Controller {
    private byte[] b;
    private ContributeDao contributeDao = new ContributeDao();

    @RequestMapping(value = "/work/*.review")
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.setCharacterEncoding("utf-8");
        String uri = httpServletRequest.getRequestURI();
        String resulturi = uri.substring(uri.lastIndexOf("/")+7, uri.lastIndexOf("."));
        int id = Integer.parseInt(resulturi);
        Contribute contribute = contributeDao.getbyid(id);
        httpServletRequest.getSession().setAttribute("contribute",contribute);
        contribute.setReview(1);
        contributeDao.updatereview(contribute);
        b = contribute.getImage();
        return new ModelAndView("work/reviewdetail", "contribute", contribute);
    }

    @RequestMapping(value = "/work/image")
    public void shouImage(HttpServletResponse httpServletResponse) {
        httpServletResponse.setContentType("image/jpeg");
        new ImageService(b, httpServletResponse);
    }

    @RequestMapping(value = "/work/submitreview")
    public ModelAndView nextReview(HttpServletRequest httpServletRequest) {
        Contribute contribute;
        int hide = Integer.parseInt(httpServletRequest.getParameter("hide"));
        if (hide == 1) {
            contribute=(Contribute) httpServletRequest.getSession().getAttribute("contribute");
            contribute.setPass(hide);
            contributeDao.updatepass(contribute);
        }
        List<Contribute> contributes = contributeDao.getbyn(1);
        if (contributes.isEmpty()) {
            try {
                return new ModelAndView("work/end");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        contribute = contributes.get(0);
        httpServletRequest.getSession().setAttribute("contribute",contribute);
        b = contribute.getImage();
        contribute.setReview(1);
        contributeDao.updatereview(contribute);
        return new ModelAndView("work/reviewdetail", "contribute", contribute);
    }

    @RequestMapping(value = "/work/review")
    public ModelAndView toreview(){
        ContributeDao contributeDao=new ContributeDao();
        List<Contribute> contributes=contributeDao.getbyn(5);
        return new ModelAndView("work/review","contributes",contributes);
    }
}