package firstnews.service;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

public class ImageService {
    OutputStream out;

    public ImageService(byte[] b, HttpServletResponse httpServletResponse) throws Exception {
        httpServletResponse.setContentType("image/jpeg");
        out = httpServletResponse.getOutputStream();
        try {
            out.write(b);
            out.flush();
        }finally {
            out.close();
        }


    }



}
