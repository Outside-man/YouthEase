package hziee.smvc.service;

import com.zlzkj.core.mybatis.SqlRunner;
import com.zlzkj.core.sql.Row;
import com.zlzkj.core.sql.SQLBuilder;
import com.zlzkj.core.util.UploadUtils;
import hziee.smvc.mapper.PictureMapper;
import hziee.smvc.model.Picture;
import hziee.smvc.model.User;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
/**
 * Created by Administrator on 2016/12/9.
 */
@Service
@Transactional
public class PicService {
    @Autowired
    public PictureMapper pictureMapper;
    @Autowired
    private SqlRunner sqlRunner;
    
    
    
    public Picture getUserIcon(User user){
        Integer  id = user.getId();
        SQLBuilder sqlBuilder  = SQLBuilder.getSQLBuilder(Picture.class);
        String sqlex  = sqlBuilder.fields("id,pic_name,user_id").where("user_id=#{0}").selectSql();
        List<Row> row = sqlRunner.select(sqlex,id);
        String result=null;
        Picture picture=null;
        for(Row r:row){
            Integer picId = (Integer) r.get("id");
            picture =pictureMapper.selectByPrimaryKey(picId);
            return picture;
        }
        return  picture;
    }
    public String getIconUrl(User user){
       Picture picture  = getUserIcon(user);
        String picUrl=null;
        if(picture!=null)
            picUrl  = picture.getPicName();
        String iconUrl = UploadUtils.parseFileUrl(picUrl);
        return   iconUrl;
    }
    public String getUserPicName(User user){

        Picture picture = getUserIcon(user);
        if(picture!=null)
         return picture.getPicName();
        return "default.jpg";
    }
}
