package hziee.smvc.service;

import java.util.ArrayList;
import java.util.List;
import com.zlzkj.core.mybatis.SqlRunner;
import com.zlzkj.core.sql.Row;
import com.zlzkj.core.sql.SQLBuilder;
import hziee.smvc.mapper.CommentMapper;
import hziee.smvc.model.Comment;
import hziee.smvc.model.Forum;
import hziee.smvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/12/8.
 */
@Service
@Transactional
public class CommentService{
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private  PicService picService;
    @Autowired
    private SqlRunner sqlRunner;
    @Autowired
    private  PostService postService;
    public List<Row> GetCommentsOfForum(Integer forumId){
        SQLBuilder sqlBuilder = SQLBuilder.getSQLBuilder(Comment.class);
        //  System.out.println("List washed");
        String sql  = sqlBuilder.fields().where("forum_id=#{0}").selectSql();
        //  System.out.println("List washed");
        List<Row> list = sqlRunner.select(sql,forumId);
        List<Row> commentList = new ArrayList<>();
        // System.out.println("List washed");
        for(Row r:list) {
            Integer id = (Integer) r.get("id");
            Comment temp = commentMapper.selectByPrimaryKey(id);
            Row rr = new Row();
            rr.put("comment",temp);
            rr.put("iconUrl",picService.getIconUrl(temp.getUserId()));
            User user = userService.getUser(temp.getUserId());
            if(user!=null)
            rr.put("username",user.getNuserName());
            commentList.add(rr);
        }

        return commentList;
    }
    public int DeleteComment(Integer id){
       return  commentMapper.deleteByPrimaryKey(id);
    }
    public int AddNewComment(Comment whichComment){
        int i=commentMapper.insert(whichComment);
        Integer id=whichComment.getForumId();
        Forum forum =postService.getForumFromId(id);
        forum.setFloors(forum.getFloors()+1);
        return i;
    }
    public Comment GetComment(Integer id){
        return commentMapper.selectByPrimaryKey(id);
    }

}
