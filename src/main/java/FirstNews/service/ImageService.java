package FirstNews.service;

import FirstNews.dao.ImageDao;
import FirstNews.controller.exception.UriException;
import FirstNews.mybean.First;
import FirstNews.mybean.Image;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

public class ImageService {
    public ImageService(){}
    public ImageService(byte[] b, HttpServletResponse httpServletResponse){
        try {
            OutputStream out = httpServletResponse.getOutputStream();
            out.write(b);
            out.flush();
        }catch (Exception e){}
    }
    public void showFirstImage(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,First first)throws Exception{
        String uri=httpServletRequest.getRequestURI();
        int imagenumber=Integer.parseInt(uri.substring(uri.lastIndexOf("/")+1,uri.lastIndexOf(".")));

        byte[] b=first.getNews().get(imagenumber).getImage();
        if(b==null){throw new UriException("showFirstImage>>>>uri:"+uri+"imagenumber"+imagenumber);}
        httpServletResponse.setContentType("image/jpeg");
        new ImageService(b, httpServletResponse);
    }
    public void showadv(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse)throws Exception{
        String uri=httpServletRequest.getRequestURI();
        String s=uri.substring(uri.lastIndexOf("/")+1);
        Image image=new ImageDao().getbytype(s);
        if(image==null){throw new UriException("showadv()>>>>uri="+uri+">>>s="+s);}
        byte[] b=image.getImage();
        httpServletResponse.setContentType("image/jpeg");
        new ImageService(b, httpServletResponse);


    }

}
