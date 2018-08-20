package firstnews.controller;

import firstnews.dao.NewsDAO;
import firstnews.domain.News;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {
    private static final Logger logger = LogManager.getLogger(NewsController.class);
    @Autowired
    private NewsDAO newsDAO;

    //首页获取n条news
    @GetMapping("home/{n}")
    public ResponseModel<List<News>> getByn(@PathVariable Integer n) {
        List<News> list = newsDAO.getByn(n);
        return ResponseModel.SUCCESS(list);
    }

    @GetMapping("id")
    public News getByid(Integer id) {
        return newsDAO.getByid(id);
    }

    @GetMapping("search")
    public ResponseModel<List<News>> search(String keyword) {
        HashSet<String> word = new HashSet<>();
        char[] keywordtochar = keyword.toCharArray();
        for (char c : keywordtochar) {
            word.add(Character.toString(c));
        }
        word.remove(" ");
        List searchkeyword = new ArrayList();
        for (String str : word) {
            searchkeyword.add("%" + str + "%");
        }
        List<News> list = newsDAO.searchList(searchkeyword);
        return ResponseModel.SUCCESS(list);

    }

    @GetMapping("searchtest")
    public ResponseModel<List<News>> searchtest(String keyword) {
        List<News> list = newsDAO.search(keyword);
        return ResponseModel.SUCCESS(list);

    }
}
