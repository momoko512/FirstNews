package FirstNews.dao;
import FirstNews.mybean.User;
import org.apache.ibatis.session.SqlSession;

public class UserDao {
    private Dao dao = new Dao();

    public User getuserbyname(String name) {
        String statement = "FirstNews.mybatis.usermapper.getuserbyname";//映射sql的标识字符串
        //执行查询返回一个唯一user对象的sql
        return dao.getSession().selectOne(statement, name);
    }

    public void addUser(User user) {
        String statement = "FirstNews.mybatis.usermapper.add";
        SqlSession sqlSession = dao.getSession();
        sqlSession.insert(statement, user);
        sqlSession.commit();
        sqlSession.close();
    }

    public void update(User user) {
        String statement = "FirstNews.mybatis.usermapper.update";
        SqlSession sqlSession = dao.getSession();
        sqlSession.update(statement,user);
        sqlSession.commit();
        sqlSession.close();
    }
}