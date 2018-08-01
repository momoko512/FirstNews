package FirstNews.dao;

import FirstNews.mybean.Contribute;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ContributeDao {
    private Dao dao = new Dao();

    public void addContribute(Contribute contribute) {
        String statement = "FirstNews.mybatis.contributemapper.add";
        SqlSession sqlSession = dao.getSession();
        sqlSession.insert(statement, contribute);
        sqlSession.commit();
        sqlSession.close();
    }

    //根据参数获取n个review=0的contribute
    public List<Contribute> getbyn(int n) {
        String statement = "FirstNews.mybatis.contributemapper.getbyn";//映射sql的标识字符串
        return dao.getSession().selectList(statement, n);
    }
    //根据参数获取n个pass=1的contribute
    public List<Contribute> getbypass(int n) {
        String statement = "FirstNews.mybatis.contributemapper.getbypass";
        return dao.getSession().selectList(statement, n);
    }

    public List<Contribute> getbyname(String name) {
        String statement = "FirstNews.mybatis.contributemapper.getbyname";//映射sql的标识字符串
        return dao.getSession().selectList(statement, name);
    }

    public Contribute getbyid(int id) {
        String statement = "FirstNews.mybatis.contributemapper.getbyid";//映射sql的标识字符串
        return dao.getSession().selectOne(statement,id);
    }
    public void update(String statement,Contribute contribute) {
        SqlSession sqlSession = dao.getSession();
        sqlSession.update(statement,contribute);
        sqlSession.commit();
        sqlSession.close();
    }

    public void updatereview(Contribute contribute) {
        String statement = "FirstNews.mybatis.contributemapper.updatereview";
        update(statement,contribute);
    }
    public void updatepass(Contribute contribute) {
        String statement = "FirstNews.mybatis.contributemapper.updatepass";
        update(statement,contribute);
    }
    public void delete(int id) {
        String statement = "FirstNews.mybatis.contributemapper.delete";
        SqlSession sqlSession = dao.getSession();
        sqlSession.delete(statement,id);
        sqlSession.commit();
        sqlSession.close();
    }


}
