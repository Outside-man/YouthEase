package hziee.smvc.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.zlzkj.core.mybatis.SqlRunner;
import com.zlzkj.core.sql.Row;
import com.zlzkj.core.sql.SQLBuilder;
import hziee.smvc.mapper.ContactMapper;
import hziee.smvc.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2016/12/16.
 */
@Service
@Transactional
public class ContactService {
    @Autowired
    private ContactMapper contactMapper;
    @Autowired
    private SqlRunner sqlRunner;
    public int AddContact(Contact whichContact){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        whichContact.setTime(df.format(new Date()));
        int k= contactMapper.insert(whichContact);

        return  k;
    }
    public List<Contact> getAllContact(){
        return contactMapper.selectAll();
    }
    public List getPagedContact(Integer page,PageService pageService){
        SQLBuilder sqlBuilder = SQLBuilder.getSQLBuilder(Contact.class);
        String sql= sqlBuilder.fields().where("limt #{0},#{1}").selectSql();
        List<Row> list = sqlRunner.select(sql,pageService.getStart(page),pageService.getContentPerCount());
        return  list;
    }
    public void DeleteContatc(Integer id){
        contactMapper.deleteByPrimaryKey(id);
    }
}
