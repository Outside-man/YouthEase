package hziee.smvc.mapper;

import hziee.smvc.model.Comment;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface CommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    Comment selectByPrimaryKey(Integer id);

    List<Comment> selectAll();

    int updateByPrimaryKey(Comment record);
}