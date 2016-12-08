package hziee.smvc.mapper;

import hziee.smvc.model.Forum;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface ForumMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Forum record);

    Forum selectByPrimaryKey(Integer id);

    List<Forum> selectAll();

    int updateByPrimaryKey(Forum record);
}