package hziee.smvc.service;

import com.zlzkj.core.mybatis.SqlRunner;
import com.zlzkj.core.sql.Row;
import com.zlzkj.core.sql.SQLBuilder;
import com.zlzkj.core.util.UploadUtils;
import hziee.smvc.mapper.MediaMapper;
import hziee.smvc.model.Media;
import hziee.smvc.model.Picture;
import hziee.smvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2016/12/28.
 */
@Service
@Transactional
public class MediaService {
    @Autowired
    private SqlRunner sqlRunner;
    @Autowired
    private MediaMapper mediaMapper;
    public Media getMediaForum(Integer id){
        SQLBuilder sqlBuilder  = SQLBuilder.getSQLBuilder(Media.class);
        String sqlex  = sqlBuilder.fields("id,media_name,forum_id").where("forum_id=#{0}").selectSql();
        List<Row> row = sqlRunner.select(sqlex,id);
        String result=null;
        Media media = null;
        for(Row r:row){
            Integer picId = (Integer) r.get("id");
            media  = mediaMapper.selectByPrimaryKey(picId);
            return media;
        }
        return  media ;
    }
    public String getMediaUrl(Integer id){
       Media media  = getMediaForum(id);
        String picUrl=null;
        if(media!=null)
            picUrl  = media.getMediaName();
        String mediaUrl = UploadUtils.parseFileUrl(picUrl);
        return   mediaUrl;
    }
}
