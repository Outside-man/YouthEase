package hziee.smvc.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zlzkj.core.mybatis.SqlRunner;
import com.zlzkj.core.sql.Row;
import com.zlzkj.core.sql.SQLBuilder;
import hziee.smvc.mapper.ForumMapper;
import hziee.smvc.model.Forum;
import hziee.smvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2016/12/8.
 */
@Service
@Transactional
public class PostService {
    @Autowired
    private SqlRunner sqlRunner;
    @Autowired
    public ForumMapper forumMapper;
    public void AddNewForum(Forum forum, User user){
        forum.setUserId(user.getId());
        forum.setTypes("emotion");
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String hehe = dateFormat.format(now);
        forum.setAdditionStatus(hehe+"  "+user.getNuserName()+ " "+user.getEmail());
        forumMapper.insert(forum);
    }

    public Forum  getForumFromId(Integer id){
        Forum forum = forumMapper.selectByPrimaryKey(id);
        if(forum==null){
            return null;
        }
        return  forum;
    }
    public List<Forum> GetUsersForum(Integer id){

        SQLBuilder sqlBuilder = SQLBuilder.getSQLBuilder(Forum.class);
        //  System.out.println("List washed");
        String sql  = sqlBuilder.fields().where("user_id=#{0}").selectSql();
        //  System.out.println("List washed");
        List<Row> list = sqlRunner.select(sql,id);
        List<Forum> forumList = new ArrayList<>();
        // System.out.println("List washed");
        for(Row r:list) {
            Integer idd = (Integer) r.get("id");
            Forum temp = forumMapper.selectByPrimaryKey(idd);
            forumList.add(temp);
        }
        return forumList;
    }
    public List<Forum> GetTypesOfForum(String str){
        SQLBuilder sqlBuilder = SQLBuilder.getSQLBuilder(Forum.class);
      //  System.out.println("List washed");
        String sql  = sqlBuilder.fields().where("types=#{0}").selectSql();
      //  System.out.println("List washed");
        List<Row> list = sqlRunner.select(sql,str);
        List<Forum> forumList = new ArrayList<>();
       // System.out.println("List washed");
        for(Row r:list) {
            Integer id = (Integer) r.get("id");
            Forum temp = forumMapper.selectByPrimaryKey(id);
            forumList.add(temp);
        }
        return forumList;
    }
    public List<Forum> getAllForum(){
        return forumMapper.selectAll();
    }
}
