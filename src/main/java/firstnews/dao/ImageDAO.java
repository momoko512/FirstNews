package firstnews.dao;

import firstnews.domain.Image;
import org.apache.ibatis.annotations.Mapper;

@Mapper

public interface ImageDAO {
    public void add(Image image);

    public Image getByType(String type);

    public Image getByid(Integer id);
}

