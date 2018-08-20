package firstnews.dao;

import firstnews.domain.News;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface NewsDAO {

    //根据id获取一个News
    News getByid(int id);

    //根据参数获取n个News
    List<News> getByn(int n);

    //根据参数搜索title和detail得到News,实现搜索功能
    List<News> search(String searchset);

    //通过审核的加入news表
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void add(News news);

    List<News> searchList(List keyword);


}
