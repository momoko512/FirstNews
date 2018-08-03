package FirstNews.dao;

import FirstNews.mybean.Contribute;

import java.util.List;

public class ContributeDao {
    private Dao dao = new Dao();

    public void addContribute(Contribute contribute) {
        String statement = "FirstNews.mybatis.contributemapper.add";
        dao.insert(statement, contribute);
    }

    //根据参数获取n个review=0的contribute
    public List<Contribute> getbyn(int n) {
        String statement = "FirstNews.mybatis.contributemapper.getbyn";//映射sql的标识字符串
        return dao.selectList(statement, n);
    }

    //根据参数获取n个pass=1的contribute
    public List<Contribute> getbypass(int n) {
        String statement = "FirstNews.mybatis.contributemapper.getbypass";
        return dao.selectList(statement, n);
    }

    public List<Contribute> getbyname(String name) {
        String statement = "FirstNews.mybatis.contributemapper.getbyname";//映射sql的标识字符串
        return dao.selectList(statement, name);
    }

    public Contribute getbyid(int id) {
        long start = System.currentTimeMillis();
        String statement = "FirstNews.mybatis.contributemapper.getbyid";//映射sql的标识字符串
        System.out.println(Thread.currentThread().getName());
        System.out.println("get session cost " + (System.currentTimeMillis() - start) + " ms");
        Contribute c = dao.selectOne(statement, id);
        System.out.println("selectOne cost " + (System.currentTimeMillis() - start) + " ms");
        return c;
        //return dao.selectOne(statement,id);
    }

    public void update(String statement, Contribute contribute) {
        dao.update(statement, contribute);
    }

    public void updatereview(Contribute contribute) {
        String statement = "FirstNews.mybatis.contributemapper.updatereview";
        update(statement, contribute);
    }

    public void updatepass(Contribute contribute) {
        String statement = "FirstNews.mybatis.contributemapper.updatepass";
        update(statement, contribute);
    }

    public void delete(int id) {
        String statement = "FirstNews.mybatis.contributemapper.delete";
        dao.delete(statement, id);
    }


}
