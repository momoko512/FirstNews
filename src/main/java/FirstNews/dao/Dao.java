package FirstNews.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

   public class Dao {
    //private final String resource = "mybatisconf.xml";
    public SqlSession getSession() {
        SqlSession session;
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatisconf.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql的sqlSession
        session = sessionFactory.openSession();
        return session;
    }
}
