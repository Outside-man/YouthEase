package hziee.smvc.service;

import hziee.smvc.mapper.CommentMapper;
import hziee.smvc.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2016/12/8.
 */
@Service
@Transactional
public class CommentService{
    @Autowired
    public CommentMapper commentMapper;
    public String PostComment(Comment comment,Integer ForumId){
    return "123";
    }


}
