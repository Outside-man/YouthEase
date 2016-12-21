package hziee.smvc.service;

import com.zlzkj.core.mybatis.SqlRunner;
import com.zlzkj.core.sql.Row;
import com.zlzkj.core.sql.SQLBuilder;
import hziee.smvc.mapper.MessageMapper;
import hziee.smvc.model.Forum;
import hziee.smvc.model.Message;
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
public class MessageService {
    @Autowired
    private SqlRunner sqlRunner;
    @Autowired
    private MessageMapper messageMapper;
    public Message NewMessage(Message message,String type){
        message.setType(type);
        if(!Legality(message))  return message;
        int i=messageMapper.insert(message);
        return messageMapper.selectByPrimaryKey(i);
    }
    public Message NewMessage(Message message){
        Integer newId= null;
        if(message.getType()==null||message.getType().equals(""))
            return NewMessage(message,"default");
        if(!Legality(message))  return message;
        newId = messageMapper.insert(message);
        return messageMapper.selectByPrimaryKey(newId);
    }
    public List<Message> GetUsersMessage(Integer id){
        SQLBuilder sqlBuilder = SQLBuilder.getSQLBuilder(Message.class);
        String sql  = sqlBuilder.fields().where("target_id=#{0}").selectSql();
        List<Row> list = sqlRunner.select(sql,id);
        List<Message> messageArrayList = new ArrayList<>();
        // System.out.println("List washed");
        for(Row r:list) {
            Integer idd = (Integer) r.get("id");
            Message temp = messageMapper.selectByPrimaryKey(idd);
            messageArrayList.add(temp);
        }
        return messageArrayList;
    }
    public boolean Legality(Message m){
        if(m.getType().equals("friend_making")){
            SQLBuilder sqlBuilder = SQLBuilder.getSQLBuilder(Message.class);
            String sql  = sqlBuilder.fields().where("target_id=#{0} and source_id=#{1} ").selectSql();
            List<Row> list = sqlRunner.select(sql,m.getTargetId(),m.getSourceId());
            if(list==null||list.size()==0){
                return true;
            }else{
                return false;
            }
        }
        return true;
    }
    public int DeleteMessage(Integer id){
        return messageMapper.deleteByPrimaryKey(id);
    }
}
