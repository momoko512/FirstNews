package FirstNews.controller.work;

import FirstNews.dao.ImageDao;
import FirstNews.dao.NewsDao;
import FirstNews.mybean.Image;
import FirstNews.mybean.News;
import FirstNews.service.EdtiService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@org.springframework.stereotype.Controller
public class editnews implements Controller {
    @Override
    @RequestMapping(value = "/work/editnews")
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        return new ModelAndView("work/submitnews");
    }

    @RequestMapping(value = "/work/submitnews")
    public ModelAndView submitnews(HttpServletRequest httpServletRequest) throws Exception {
        httpServletRequest.setCharacterEncoding("utf-8");
        News news =new News();
        news=new EdtiService().get(news,httpServletRequest);
        new NewsDao().add(news);
        return new ModelAndView("submitedit");
    }
    @RequestMapping(value = "/work/submitadvs")
    public ModelAndView submitadvs(HttpServletRequest httpServletRequest) throws Exception{
        Image[] images=new EdtiService().getadv(httpServletRequest);
        for(Image image:images) {
                new ImageDao().add(image);
        }
     return new ModelAndView("work/workhome");
    }
    @RequestMapping(value = "/work/submitconimg")
    public ModelAndView submitconimg(HttpServletRequest httpServletRequest) throws Exception{
        Image image=new EdtiService().getcontribute(httpServletRequest);
            new ImageDao().add(image);
        return new ModelAndView("work/workhome");
    }


}
