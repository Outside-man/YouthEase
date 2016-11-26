package hziee.smvc.service;

import com.sun.tools.javac.util.List;
import com.zlzkj.core.mybatis.SqlRunner;
import com.zlzkj.core.sql.Row;
import com.zlzkj.core.sql.SQLBuilder;
import hziee.smvc.mapper.UserMapper;
import hziee.smvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/11/26.
 */
@Service
@Transactional
public class UserService  {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SqlRunner sqlRunner;

    public Integer delete(Integer id){
        return userMapper.deleteByPrimaryKey(id);
    }
    public Integer insert(User entity){

        userMapper.insert(entity);
        return entity.getUserid();
    }
    public User findByID(Integer id){
        return (User)userMapper.selectByPrimaryKey(id);
    }
    public User getUser(String email,String password){
        String hash=org.apache.commons.codec.digest.DigestUtils.md5Hex(password);
        User realUser= userMapper.selectByEmail(email);
        if(realUser==null) return null;
        if(realUser.getUserPasswordHash().equals(hash)){
            return realUser;
        }else{
            return null;
        }

    }

}
