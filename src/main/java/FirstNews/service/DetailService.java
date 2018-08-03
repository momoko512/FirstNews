package FirstNews.service;

import FirstNews.dao.ContributeDao;
import FirstNews.dao.NewsDao;
import FirstNews.controller.exception.SimpleExceptionResovler;
import FirstNews.mybean.All;
import FirstNews.mybean.Contribute;
import FirstNews.mybean.News;
import org.apache.logging.log4j.LogManager;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class DetailService {
    public All detail(HttpServletRequest httpServletRequest)throws Exception{
        org.apache.logging.log4j.Logger log = LogManager.getLogger(SimpleExceptionResovler.class);
        httpServletRequest.setCharacterEncoding("utf-8");
        All all=new All();
        String uri = httpServletRequest.getRequestURI();
        log.info(uri);
        String suburi=uri.substring(uri.lastIndexOf("/")+1);
        httpServletRequest.getSession().setAttribute("page", suburi);
        String subid = uri.substring(uri.lastIndexOf("/")+5, uri.lastIndexOf("."));
        int id = Integer.parseInt(subid);
        String subtype=uri.substring(uri.lastIndexOf(".")+1);
        log.info(subtype);
        if(subtype.equals("contribute")){
            Contribute contribute = new ContributeDao().getbyid(id);
            all=contribute;
        }
        if(subtype.equals("news")){
            News news=new NewsDao().getNewsbyid(id);
            all=news;
        }
        System.out.println("end"+new Date());
        return all;
    }
}
