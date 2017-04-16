package hziee.smvc.mapper;

import hziee.smvc.model.Media;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface MediaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Media record);

    Media selectByPrimaryKey(Integer id);

    List<Media> selectAll();

    int updateByPrimaryKey(Media record);
}