package firstnews.dao;

import firstnews.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface UserDao {
    User get(String name);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    void add(User user);

    void update(User user);

}
