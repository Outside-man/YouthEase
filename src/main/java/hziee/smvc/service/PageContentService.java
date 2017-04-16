package hziee.smvc.service;

import com.zlzkj.core.mybatis.SqlRunner;
import com.zlzkj.core.sql.Row;
import com.zlzkj.core.sql.SQLBuilder;
import hziee.smvc.mapper.CommentMapper;
import hziee.smvc.mapper.ContactMapper;
import hziee.smvc.mapper.ForumMapper;
import hziee.smvc.mapper.MessageMapper;
import hziee.smvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/26.
 */
@Service
@Transactional
public class PageContentService {
    @Autowired
    private PageService pageService;
    @Autowired
    private ContactMapper contactMapper;
    @Autowired
    private ForumMapper forumMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private SqlRunner sqlRunner;
    public List getPagedContent(Integer page,Class<?> contentClass){
            SQLBuilder sqlBuilder = SQLBuilder.getSQLBuilder(contentClass);
            String sql= sqlBuilder.fields().where("true limit #{0},#{1}").selectSql();
            List<Row> list = sqlRunner.select(sql,pageService.getStart(page),pageService.getContentPerCount());
            return  list;
    }
    public List getPagedContent(Integer page,Class<?> contentClass,String condition){
        SQLBuilder sqlBuilder = SQLBuilder.getSQLBuilder(contentClass);
        String s=sqlBuilder.getPojoName();
        s="s_"+s;
        sqlBuilder.getTableFields();
        System.out.println("condtion:"+condition);
        String element[]=condition.split("=");
        String sqlex="SELECT * from "+s +" where "+element[0]+" like '%"+element[1]+"%'"+"limit "+pageService.getStart(page)+","+pageService.getContentPerCount();
        List<Row> list = sqlRunner.select(sqlex);
        return  list;
    }
    public List getPageContentExact(Integer page,Class<?> contentClass,String condition){
        SQLBuilder sqlBuilder = SQLBuilder.getSQLBuilder(contentClass);
        String s=sqlBuilder.getPojoName();
        s="s_"+s;
        sqlBuilder.getTableFields();
        System.out.println("condtion:"+condition);
        String element[]=condition.split("=");
        String sqlex="SELECT * from "+s +" where "+element[0]+"="+element[1]+" limit "+pageService.getStart(page)+","+pageService.getContentPerCount();
        System.out.println(sqlex);
        List<Row> list = sqlRunner.select(sqlex);
        return  list;
    }
    public List GetAllMatched(String types,String match,Class<?> contentClass){
        SQLBuilder sqlBuilder  = SQLBuilder.getSQLBuilder(contentClass);
        String content  = sqlBuilder.getPojoName();
        content  = "s_"+content;
        String sqlex="SELECT * from "+content+" where "+types+" like '%"+match+"%'";
        List<Row> list = sqlRunner.select(sqlex);
        return list;
    }
}
