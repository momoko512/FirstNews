package FirstNews.dao;

import FirstNews.mybean.News;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class NewsDao {
    private Dao dao = new Dao();

    /**
     * 映射sql的标识字符串，
     * FirstNews.mybatis.mapper是userMapper.xml文件中mapper标签的namespace属性的值，
     * getNewsbyid是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
     */
    //根据id获取一个News
    public News getNewsbyid(int id) {
        String statement = "FirstNews.mybatis.newsmapper.getNewsbyid";//映射sql的标识字符串
        return dao.selectOne(statement, id);
    }

    //根据参数获取n个News
    public List<News> getNewsbyn(int n) {
        String statement = "FirstNews.mybatis.newsmapper.getNewsbyn";//映射sql的标识字符串
        return dao.selectList(statement, n);
    }

    //根据参数搜索title和detail得到News,实现搜索功能
    public List<News> doSearch(HashSet<String> hashSet) {
        String statement = "FirstNews.mybatis.newsmapper.searchintitleanddetail";
        List<News> news = new ArrayList<News>();
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            String search = iterator.next();
            news = dao.selectList(statement, search);

        }
        return news;
    }

    //通过审核的加入news表
    public void add(News news) {
        String statement = "FirstNews.mybatis.newsmapper.add";
        dao.insert(statement, news);
    }
}