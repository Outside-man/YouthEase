package hziee.smvc.mapper;

import hziee.smvc.model.Friend;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface FriendMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Friend record);

    Friend selectByPrimaryKey(Integer id);

    List<Friend> selectAll();

    int updateByPrimaryKey(Friend record);
}