package FirstNews.service;

import FirstNews.dao.ContributeDao;
import FirstNews.dao.NewsDao;
import FirstNews.controller.exception.SimpleExceptionResovler;
import FirstNews.mybean.Contribute;
import FirstNews.mybean.First;
import FirstNews.mybean.News;
import org.apache.logging.log4j.LogManager;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class FirstService {
    public First showfirst(HttpServletRequest httpServletRequest) throws Exception{
        org.apache.logging.log4j.Logger log = LogManager.getLogger(SimpleExceptionResovler.class);
        httpServletRequest.setCharacterEncoding("utf-8");
        String uri=httpServletRequest.getRequestURI();
        String suburi=uri.substring(uri.lastIndexOf("/")+1);
        httpServletRequest.getSession().setAttribute("page",suburi);
        List<Contribute> contributes =new ContributeDao().getbypass(5);
        List<News> news=new NewsDao().getNewsbyn(5);
        First first=new First();
        first.setContributes(contributes);
        first.setNews(news);
        return first;
    }
}
