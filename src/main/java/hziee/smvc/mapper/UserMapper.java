package hziee.smvc.mapper;

import hziee.smvc.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    User selectByPrimaryKey(Integer userid);
    User selectByEmail(String email);
    List<User> selectAll();

    int updateByPrimaryKey(User record);
}