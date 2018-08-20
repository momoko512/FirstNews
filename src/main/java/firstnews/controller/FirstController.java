package firstnews.controller;

import firstnews.controller.exception.UriException;
import firstnews.dao.ContributeDAO;
import firstnews.dao.ImageDAO;
import firstnews.dao.NewsDAO;
import firstnews.domain.Image;
import firstnews.service.ImageService;
import firstnews.service.UserLoginService;
import firstnews.service.WeatherService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


@org.springframework.stereotype.Controller
public class FirstController {
    @Autowired
    private NewsDAO newsDAO;
    @Autowired
    private ImageDAO imageDAO;
    @Autowired
    private ContributeDAO contributeDAO;


    @RequestMapping(value = {"/","first"})
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        return new ModelAndView("first");
    }

    @RequestMapping(value = {"*.newsimage", "work/*.image"})
    public void showFirstImage(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        getNewsImage(httpServletRequest, httpServletResponse);
    }

    private void getNewsImage(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        String uri = httpServletRequest.getRequestURI();
        int imageid = Integer.parseInt(uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf(".")));
        byte[] image = newsDAO.getByid(imageid).getImage();
        if (image == null) {
            throw new UriException("showNewsImage>>>>uri:" + uri + "imagenumber" + imageid);
        }
        new ImageService(image, httpServletResponse);
    }

    @RequestMapping(value = {"*.contributeimage"})
    public void showContributeImage(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        getContributeImage(httpServletRequest, httpServletResponse);
    }

    private void getContributeImage(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        String uri = httpServletRequest.getRequestURI();
        int imageid = Integer.parseInt(uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf(".")));
        byte[] image = contributeDAO.getbyid(imageid).getImage();
        /*if (image == null) {
            throw new UriException("showImage>>>>uri:" + uri + "imagenumber" + imageid);
        }*/
        new ImageService(image, httpServletResponse);
    }



    @RequestMapping(value = {"leftadv", "leftadv", "rightadv1", "rightadv2", "rightadv3", "contribute1", "contribute2"})
    public void adv(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        getAdvImg(httpServletRequest, httpServletResponse);
    }

    public void getAdvImg(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        String uri = httpServletRequest.getRequestURI();
        String type = uri.substring(uri.lastIndexOf("/") + 1);
        Image image = imageDAO.getByType(type);
        if (image == null) {
            throw new UriException("showadv()>>>>uri=" + uri + ">>>s=" + type);
        }
        byte[] imagebyte = image.getImage();
        httpServletResponse.setContentType("image/jpeg");
        new ImageService(imagebyte, httpServletResponse);

    }

    @RequestMapping(value = "/weather")
    public void sendWeather(HttpServletResponse httpServletResponse) throws Exception {
        JSONObject weatherjson = new WeatherService().getWeather();//getWeather(httpServletRequest);
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        PrintWriter pr = httpServletResponse.getWriter();
        try {

            pr.print(weatherjson);
            pr.flush();
        } finally {
            pr.close();

        }


    }

}