package firstnews.controller;

import org.springframework.web.bind.annotation.RestController;


@RestController
//@RequestMapping("/search")
public class SearchController {
 /*   @Autowired
    NewsDAO newsDAO;
    @Autowired
    ContributeDAO contributeDAO;

    @GetMapping("{searchword}")
    public void doSearch(@PathVariable String searchWword) throws Exception {
        HashSet<String> word = new HashSet<>();
        char[] searchvaluetochar = searchWword.toCharArray();
        for (char c : searchvaluetochar) {
            word.add(Character.toString(c));
        }
        word.remove(" ");
        List<News> list = newsDAO.search();
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        JSONArray searchresult = new JSONArray();
        for (News anews : list) {
            HashMap<String, String> map = new HashMap<>();
            map.put("id", anews.getId() + "");
            map.put("title", anews.getTitle());
            searchresult.put(map);
        }
        JSONObject obj = new JSONObject();
        obj.put("searchresult", searchresult);

        PrintWriter writer = httpServletResponse.getWriter();
        writer.print(obj);

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

    }
*/

    //把搜索框输入String内容转换成hashset并去掉空格
 /*   private HashSet<String> searchWord() throws Exception {
        HashSet<String> word = new HashSet<>();

        StringBuffer searchvalue = new StringBuffer();
        String str = null;


        StringBuilder searchvalue = new StringBuilder();

        char[] searchvaluetochar = searchvalue.toString().toCharArray();
        for (char c : searchvaluetochar) {
            word.add(Character.toString(c));
        }
        word.remove(" ");
        return word;
    }*/
}
