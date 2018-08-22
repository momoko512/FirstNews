package firstnews.dao;

import firstnews.domain.Contribute;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface ContributeDAO {
    //将投稿存入contribute表
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void add(Contribute contribute);

    //根据参数获取n个review=0的contribute
    List<Contribute> getbyn(Integer n);

    //根据参数获取n个pass=1的contribute
    List<Contribute> getByPass(Integer n);

    //根据用户名搜索
    List<Contribute> getbyname(String name);

    //根据id搜索
    Contribute getbyid(Integer id);

    //更改审核状态
    void updatereview(Contribute contribute);

    //更改通过状态
    void updatepass(Contribute contribute);

    //根据id删除
    void delete(Integer id);

}
/*
import firstnews.domain.ContributeDO;
import firstnews.domain.query.ContributeQuery;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ContributeDAO {

    @Select("select * from contribute")
    List<ContributeDO> findByQuery(ContributeQuery query);

    @Insert("insert into contribute(name,title,detail,review,pass) values(#{name},#{title},#{detail},#{review},#{pass} )")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Integer insert(ContributeDO contributeDO);

    @Delete("delete from contribute where id=#{id}")
    Integer remove(Integer id);


    @Insert("update contribute set name=#{name},title=#{title}, detail=#{detail},review=#{review},pass=#{[pass}")
    Integer update(ContributeDO contributeDO);

    List<ContributeDO> getByPass(int n);

}
*/