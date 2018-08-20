package firstnews.service;

public class DetailService {
  /*  public All detail(HttpServletRequest httpServletRequest)throws Exception{
        org.apache.logging.log4j.Logger log = LogManager.getLogger(SimpleExceptionResovler.class);
        httpServletRequest.setCharacterEncoding("utf-8");
        All all=new All();
        String uri = httpServletRequest.getRequestURI();
        String suburi=uri.substring(uri.lastIndexOf("/")+1);
        httpServletRequest.getSession().setAttribute("page", suburi);
        String subid = uri.substring(uri.lastIndexOf("/")+5, uri.lastIndexOf("."));
        int id = Integer.parseInt(subid);
        String subtype=uri.substring(uri.lastIndexOf(".")+1);
        if(subtype.equals("contribute")){
            Contribute contribute = new ContributeDAO().getbyid(id);
            all=contribute;
        }
        if(subtype.equals("news")){
            News news=new NewsDao().getNewsbyid(id);
            all=news;
        }
        return all;
    }
    */
}
