package firstnews.service;

public class FirstService {
   /* private static Logger log = LogManager.getLogger(SimpleExceptionResovler.class);
    public First showfirst(HttpServletRequest httpServletRequest) throws Exception{

        httpServletRequest.setCharacterEncoding("utf-8");
        String uri=httpServletRequest.getRequestURI();
        String suburi=uri.substring(uri.lastIndexOf("/")+1);
        httpServletRequest.getSession().setAttribute("page",suburi);
        List<Contribute> contributes =new ContributeDAO().getbypass(5);
        List<News> news=new NewsDao().getNewsbyn(5);
        First first=new First();
        first.setContributes(contributes);
        first.setNews(news);
        return first;
    }
    */
}
