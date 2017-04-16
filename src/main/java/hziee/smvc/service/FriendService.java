package hziee.smvc.service;

import com.zlzkj.core.mybatis.SqlRunner;
import com.zlzkj.core.sql.Row;
import com.zlzkj.core.sql.SQLBuilder;
import hziee.smvc.mapper.FriendMapper;
import hziee.smvc.model.Forum;
import hziee.smvc.model.Friend;
import hziee.smvc.model.Message;
import hziee.smvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/21.
 */
@Service
@Transactional
public class FriendService {
    @Autowired
    private FriendMapper friendMapper;
    @Autowired
    private   UserService userService;
    @Autowired
    private SqlRunner sqlRunner;
    public Friend NewFriend(Integer userId,Integer friendId){
        Friend f= new Friend();
        f.setUserId(userId);
        f.setFriendId(friendId);
        int key = friendMapper.insert(f);
        return friendMapper.selectByPrimaryKey(key);
    }
    public boolean BecomeFriend(Integer id1,Integer id2){
        if(!HasFriend(id1,id2)){
            NewFriend(id1,id2);
            NewFriend(id2,id1);
            return true;
        }else{
            return  false;
        }

    }
    public boolean HasFriend(Integer id1,Integer id2){
        SQLBuilder sqlBuilder = SQLBuilder.getSQLBuilder(Friend.class);
        String sql  = sqlBuilder.fields().where("user_id=#{0} and friend_id=#{1}").selectSql();
        List<Row> list = sqlRunner.select(sql,id1,id2);
        if(list.size()!=0)
            return  true;
        return  false;
    }
    public boolean DeFriend(Integer id1,Integer id2){
        SQLBuilder sqlBuilder = SQLBuilder.getSQLBuilder(Friend.class);
        String sql  = sqlBuilder.fields().where("user_id=#{0} and friend_id=#{1}").selectSql();
        List<Row> list = sqlRunner.select(sql,id1,id2);
        for(Row r:list){
            Integer friendId = (Integer)r.get("id");
            friendMapper.deleteByPrimaryKey(friendId);
        }
        return true;
    }
    public boolean DeFriends(Integer id1,Integer id2){
        DeFriend(id1,id2);
        DeFriend(id2,id1);
        return true;
    }
    public List<User> GetFriendOfUser(Integer id){
        SQLBuilder sqlBuilder = SQLBuilder.getSQLBuilder(Friend.class);
        String sql  = sqlBuilder.fields().where("user_id=#{0}").selectSql();
        List<Row> list = sqlRunner.select(sql,id);
        List<User> userList = new ArrayList<User>();
        System.out.println("好友列表大小"+list.size());
        for(Row r:list){
            Integer userId = (Integer)r.get("friendId");
            User newUser = (User)userService.getUser(userId);
            userList.add(newUser);
        }
        return userList;
    }
}
