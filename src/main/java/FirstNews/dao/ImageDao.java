package FirstNews.dao;

import FirstNews.mybean.Image;
import org.apache.ibatis.session.SqlSession;

public class ImageDao {
    private Dao dao=new Dao();
    public void add(Image image){
        String statement = "FirstNews.mybatis.imagemapper.add";
        SqlSession sqlSession = dao.getSession();
        sqlSession.insert(statement, image);
        sqlSession.commit();
        sqlSession.close();
    }
    public Image getbytype(String type) {
        String statement = "FirstNews.mybatis.imagemapper.getbytype";//映射sql的标识字符串
        return dao.getSession().selectOne(statement, type);
    }
    /*
    public News getNewsbyid(int id) {
        String statement = "FirstNews.mybatis.newsmapper.getNewsbyid";//映射sql的标识字符串
        News news =dao.getSession().selectOne(statement, id);
        return news;
    }
*/

}
