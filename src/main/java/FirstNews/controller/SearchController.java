package FirstNews.controller;

import FirstNews.dao.NewsDao;
import FirstNews.mybean.News;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


@org.springframework.stereotype.Controller
public class SearchController implements Controller {

    @RequestMapping(value = "/search")
    public void sear(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        NewsDao newsDao = new NewsDao();
        List<News> list = newsDao.doSearch(SearchWord(httpServletRequest));
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        JSONArray searchresult=new JSONArray();
        for(News anews:list){
            HashMap<String, String> map = new HashMap<>();
            map.put("id",anews.getId()+"");
            map.put("title",anews.getTitle());
            searchresult.put(map);
        }
        JSONObject obj = new JSONObject();
        obj.put("searchresult", searchresult);

        PrintWriter writer = httpServletResponse.getWriter();
        writer.print(obj);
/*
        HashMap<String, String> map1 = new HashMap<>();
        map1.put("aaa", "bbb");
        map1.put("ccc", "ddd");
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("aaa", "fff");
        map2.put("ccc", "hhh");

        JSONArray array = new JSONArray();
        array.put(map1);
        array.put(map2);

        JSONObject obj = new JSONObject();
        obj.put("array", array);

        PrintWriter writer = httpServletResponse.getWriter();
        writer.print(obj);
*/
    }

    //把搜索框输入String内容转换成hashset并去掉空格
    private HashSet<String> SearchWord(HttpServletRequest httpServletRequest) throws Exception {
        HashSet<String> word = new HashSet<>();
      /*
        StringBuffer searchvalue = new StringBuffer();
        String str=null;

        while ((str=reader.readLine()) != null) {
            JSONObject myjson = new JSONObject(str);
            str = myjson.getString("search");
            searchvalue.append(str);
        }
        */
      StringBuilder searchvalue=new StringBuilder();
        InputStream input=httpServletRequest.getInputStream();
       try {
           LineIterator it = IOUtils.lineIterator(input, "utf-8");
           if (it.hasNext()) {
               String line = it.nextLine();
               JSONObject myjson=new JSONObject(line);
               line=myjson.getString("search");
               searchvalue.append(line);
           }
       }finally {
           IOUtils.closeQuietly(input);
       }
        char[] searchvaluetochar = searchvalue.toString().toCharArray();
        for (char c : searchvaluetochar) {
            word.add(Character.toString(c));
        }
        word.remove(" ");
        return word;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        return null;
    }
}
