package FirstNews.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Dao {
    //private final String resource = "mybatisconf.xml";
    private static SqlSessionFactory sqlSessionFactory = initSessionFactory();

    public SqlSession getSession() {
        return sqlSessionFactory.openSession();
    }


    /**
     * Retrieve a single row mapped from the statement key
     *
     * @param <T>       the returned object type
     * @param statement
     * @return Mapped object
     */
    <T> T selectOne(String statement) {
        SqlSession session = getSession();
        try {
            return session.selectOne(statement);
        } finally {
            session.close();
        }
    }

    /**
     * Retrieve a single row mapped from the statement key and parameter.
     *
     * @param <T>       the returned object type
     * @param statement Unique identifier matching the statement to use.
     * @param parameter A parameter object to pass to the statement.
     * @return Mapped object
     */
    <T> T selectOne(String statement, Object parameter) {
        SqlSession session = getSession();
        try {
            return session.selectOne(statement, parameter);
        } finally {
            session.close();
        }
    }

    /**
     * Retrieve a list of mapped objects from the statement key and parameter.
     *
     * @param <E>       the returned list element type
     * @param statement Unique identifier matching the statement to use.
     * @return List of mapped object
     */
    <E> List<E> selectList(String statement) {
        SqlSession session = getSession();
        try {
            return session.selectList(statement);
        } finally {
            session.close();
        }
    }

    /**
     * Retrieve a list of mapped objects from the statement key and parameter.
     *
     * @param <E>       the returned list element type
     * @param statement Unique identifier matching the statement to use.
     * @param parameter A parameter object to pass to the statement.
     * @return List of mapped object
     */
    <E> List<E> selectList(String statement, Object parameter) {
        SqlSession session = getSession();
        try {
            return session.selectList(statement, parameter);
        } finally {
            session.close();
        }
    }

    /**
     * Execute an insert statement.
     *
     * @param statement Unique identifier matching the statement to execute.
     * @return int The number of rows affected by the insert.
     */
    int insert(String statement) {
        SqlSession session = getSession();
        try {
            return session.insert(statement);
        } finally {
            session.close();
        }
    }

    /**
     * Execute an insert statement with the given parameter object. Any generated
     * autoincrement values or selectKey entries will modify the given parameter
     * object properties. Only the number of rows affected will be returned.
     *
     * @param statement Unique identifier matching the statement to execute.
     * @param parameter A parameter object to pass to the statement.
     * @return int The number of rows affected by the insert.
     */
    int insert(String statement, Object parameter) {
        SqlSession session = getSession();
        try {
            return session.insert(statement, parameter);
        } finally {
            session.close();
        }
    }

    /**
     * Execute an update statement. The number of rows affected will be returned.
     *
     * @param statement Unique identifier matching the statement to execute.
     * @return int The number of rows affected by the update.
     */
    int update(String statement) {
        SqlSession session = getSession();
        try {
            return session.update(statement);
        } finally {
            session.close();
        }
    }

    /**
     * Execute an update statement. The number of rows affected will be returned.
     *
     * @param statement Unique identifier matching the statement to execute.
     * @param parameter A parameter object to pass to the statement.
     * @return int The number of rows affected by the update.
     */
    int update(String statement, Object parameter) {
        SqlSession session = getSession();
        try {
            return session.update(statement, parameter);
        } finally {
            session.close();
        }
    }

    /**
     * Execute a delete statement. The number of rows affected will be returned.
     *
     * @param statement Unique identifier matching the statement to execute.
     * @return int The number of rows affected by the delete.
     */
    int delete(String statement) {
        SqlSession session = getSession();
        try {
            return session.delete(statement);
        } finally {
            session.close();
        }
    }

    /**
     * Execute a delete statement. The number of rows affected will be returned.
     *
     * @param statement Unique identifier matching the statement to execute.
     * @param parameter A parameter object to pass to the statement.
     * @return int The number of rows affected by the delete.
     */
    int delete(String statement, Object parameter) {
        SqlSession session = getSession();
        try {
            return session.delete(statement, parameter);
        } finally {
            session.close();
        }
    }

    private static SqlSessionFactory initSessionFactory() {
        SqlSession session;
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatisconf.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //构建sqlSession的工厂
        return new SqlSessionFactoryBuilder().build(reader);
    }
}
