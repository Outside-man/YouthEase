package hziee.smvc.mapper;

import hziee.smvc.model.Forum;
import java.util.List;

public interface ForumMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Forum record);

    Forum selectByPrimaryKey(Integer id);

    List<Forum> selectAll();

    int updateByPrimaryKey(Forum record);
}