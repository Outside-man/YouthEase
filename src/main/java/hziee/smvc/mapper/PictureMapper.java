package hziee.smvc.mapper;

import hziee.smvc.model.Picture;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface PictureMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Picture record);

    Picture selectByPrimaryKey(Integer id);

    List<Picture> selectAll();

    int updateByPrimaryKey(Picture record);
}