package FirstNews.dao;

import FirstNews.mybean.User;

public class UserDao {
    private Dao dao = new Dao();

    public User getuserbyname(String name) {
        String statement = "FirstNews.mybatis.usermapper.getuserbyname";//映射sql的标识字符串
        //执行查询返回一个唯一user对象的sql
        return dao.selectOne(statement, name);
    }

    public void addUser(User user) {
        String statement = "FirstNews.mybatis.usermapper.add";
        dao.insert(statement, user);
    }

    public void update(User user) {
        String statement = "FirstNews.mybatis.usermapper.update";
        dao.update(statement, user);
    }
}