package FirstNews.dao;

import FirstNews.mybean.Work;
import org.apache.ibatis.session.SqlSession;

public class WorkDao {
    private Dao dao = new Dao();
    public Work getbyname(String name) {
        String statement = "FirstNews.mybatis.workmapper.getbyname";//映射sql的标识字符串
        //执行查询返回一个唯一user对象的sql
        return dao.getSession().selectOne(statement, name);
    }
    public void addwork(Work work) {
        String statement = "FirstNews.mybatis.workmapper.add";
        SqlSession sqlSession = dao.getSession();
        sqlSession.insert(statement, work);
        sqlSession.commit();
        sqlSession.close();
    }

}
