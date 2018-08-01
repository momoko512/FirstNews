package FirstNews.controller;

import FirstNews.mybean.All;
import FirstNews.mybean.Contribute;
import FirstNews.service.DetailService;
import FirstNews.service.ImageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@org.springframework.stereotype.Controller
public class DetailController implements Controller {
    private byte[] b;

    @Override
    @RequestMapping(value = {"/*.contribute","/*.news"})
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        All all=new DetailService().detail(httpServletRequest);
        b=all.getImage();
        return new ModelAndView("view","contribute",all);

    }
    @RequestMapping(value = "image")
    public void showImage(HttpServletResponse httpServletResponse) {
        httpServletResponse.setContentType("image/jpeg");
        new ImageService(b, httpServletResponse);
    }
}