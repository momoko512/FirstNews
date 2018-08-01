package FirstNews.service;

import FirstNews.dao.ContributeDao;
import FirstNews.mybean.All;
import FirstNews.mybean.Contribute;
import FirstNews.mybean.Image;
import FirstNews.mybean.News;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class EdtiService {
    public <T extends All> T get(T t, HttpServletRequest httpServletRequest) throws Exception{
        //从编辑页面获取news或者contribute加入数据库
        boolean isMultipart = ServletFileUpload.isMultipartContent(httpServletRequest);
        if (isMultipart) {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setHeaderEncoding("utf-8");
            if(t instanceof News){
            t.setName(httpServletRequest.getSession().getAttribute("workname").toString());}
            if(t instanceof Contribute){
                t.setName(httpServletRequest.getSession().getAttribute("name").toString());}

            //解析请求
                List<FileItem> items = upload.parseRequest(httpServletRequest);
                for (FileItem item : items) {
                    String fieldName = item.getFieldName();
                    //为contribute或者news对象获取属性值，以便存入数据库contribute表
                    if (fieldName.equals("title")) {
                        String title=item.getString("utf-8");
                        if(title.contains("form")||title.contains("script")){
                            title=title.replaceAll("script","s cript");
                            title=title.replaceAll("form","f orm");
                        }
                        t.setTitle(title);
                    }
                    if (fieldName.equals("detail")) {
                        String detail=item.getString("utf-8");
                        if(detail.contains("form")||detail.contains("script")){
                            detail=detail.replaceAll("script","s cript");
                            detail=detail.replaceAll("form","f orm");
                        }
                        t.setDetail(detail);                    }
                    if (fieldName.equals("image") && item.getSize() != 0) {
                        t.setImage(item.get());
                    }
                }
        } else {
            throw new Exception("get not isMultipart");
        }
        return t;
    }

    public Image[] getadv(HttpServletRequest httpServletRequest) throws Exception{
        Image[] images=new Image[4];
        for(int i=0;i<4;i++){
            images[i]=new Image();
        }
        boolean isMultipart = ServletFileUpload.isMultipartContent(httpServletRequest);
        if (isMultipart) {
            {
                DiskFileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(factory);
                upload.setHeaderEncoding("utf-8");
                //解析请求
                    List<FileItem> items = upload.parseRequest(httpServletRequest);
                    for (FileItem item : items) {
                        String fieldName = item.getFieldName();
                        String[] rightadv = new String[]{"leftadv","rightadv1", "rightadv2", "rightadv3"};
                        for (int i = 0; i < 4; i++) {
                            if (fieldName.equals(rightadv[i])) {
                                images[i].setImage(item.get());
                                images[i].setType(rightadv[i]);
                            }
                        }
                        String[] rightlink = new String[]{"leftlink","rightlink1", "rightlink2", "rightlink3"};
                        for (int i = 0; i < 4; i++) {
                            if (fieldName.equals(rightlink[i])) {
                                images[i].setLink(item.getString("utf-8"));
                            }
                        }
                    }
            }
        }else {throw new Exception("getadv not isMultipart");}
        return images;
    }
    public Image getcontribute(HttpServletRequest httpServletRequest) throws Exception{
        Image image=new Image();
        boolean isMultipart = ServletFileUpload.isMultipartContent(httpServletRequest);
        if (isMultipart) {
            {
                DiskFileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(factory);
                upload.setHeaderEncoding("utf-8");
                    List<FileItem> items = upload.parseRequest(httpServletRequest);
                    for (FileItem item : items) {
                        String fieldName = item.getFieldName();
                        image.setType(fieldName);
                        image.setImage(item.get());
                        image.setLink("contribute");
                    }
            }
        } else {throw new Exception("getcontribute not isMultipart");}

        return image;
    }

    public List<Contribute> delete(HttpServletRequest httpServletRequest) throws Exception{
        httpServletRequest.setCharacterEncoding("utf-8");
        String uri = httpServletRequest.getRequestURI();
        String resulturi = uri.substring(5, uri.lastIndexOf("."));
        int id = Integer.parseInt(resulturi);
        new ContributeDao().delete(id);
        String name = httpServletRequest.getSession().getAttribute("name").toString();
        return new ContributeDao().getbyname(name);
    }
}