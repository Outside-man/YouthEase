package hziee.smvc.service;
import  java.util.List;

import com.zlzkj.core.mybatis.SqlRunner;
import com.zlzkj.core.sql.Row;
import com.zlzkj.core.sql.SQLBuilder;
import hziee.smvc.mapper.UserMapper;
import hziee.smvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private static final int FIND_FAILED= -1;
    public Integer delete(Integer id){
        return userMapper.deleteByPrimaryKey(id);
    }
    public Integer insert(User entity){
        userMapper.insert(entity);
        return entity.getId();
    }
    public User NewUser(User user){
        System.out.println(user.getEmail());
        String hash=hashPassword(user.getPasswordHash());
        user.setPasswordHash(hash);
        insert(user);
        return user;
    }
    public User getUser(Integer id ){
       return  userMapper.selectByPrimaryKey(id);
    }
    public String hashPassword(String s){
        String newPass = org.apache.commons.codec.digest.DigestUtils.md5Hex(s);
        return newPass;
    }
    public Integer selectUserIdFromEmail(String s){

        SQLBuilder sqlBuilder  = SQLBuilder.getSQLBuilder(User.class);
        String sqlex= sqlBuilder.fields("id,email").where("email=#{0}").selectSql();
        List<Row> list = sqlRunner.select(sqlex,s);
        Integer id = null;
        for(Row r:list){
            id = (Integer) r.get("id");
        }
        if(id==null)
            return FIND_FAILED;
        return id;
    }
    public boolean UserExisted(String email){
        if(selectUserIdFromEmail(email)==FIND_FAILED) return false;
        return true;
    }
    public User findByID(Integer id){
        return (User)userMapper.selectByPrimaryKey(id);
    }
    public User getUser(String email, String password){
        String hash=org.apache.commons.codec.digest.DigestUtils.md5Hex(password);
      //  System.out.println(hash);
        Integer userId = selectUserIdFromEmail(email);
        System.out.println(userId);
        User realUser= userMapper.selectByPrimaryKey(userId);
       // System.out.println(realUser);
      //  System.out.println(realUser.getPasswordHash());
        if(realUser==null)
            return null;
        if(realUser.getPasswordHash().equals(hash)){
            return realUser;
        }else{
            return null;
        }

    }
    public User updateUser(User whichUser){
        String hash;
        User pastUserInfo  = userMapper.selectByPrimaryKey(whichUser.getId());
        if(whichUser.getPasswordHash()!=null){
            pastUserInfo.setPasswordHash(hashPassword(whichUser.getPasswordHash()));
        }
        if(whichUser.getNuserName()!=null){
            pastUserInfo.setNuserName(whichUser.getNuserName());
        }
        if(whichUser.getRealName()!=null){
            pastUserInfo.setRealName(whichUser.getRealName());
        }
        int id=userMapper.updateByPrimaryKey(pastUserInfo);
        return userMapper.selectByPrimaryKey(id);
    }

}
