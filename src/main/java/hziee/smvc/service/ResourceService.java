package hziee.smvc.service;

import com.zlzkj.core.base.MyMultipartResolver;
import com.zlzkj.core.mybatis.SqlRunner;
import com.zlzkj.core.util.UploadUtils;
import hziee.smvc.mapper.PictureMapper;
import hziee.smvc.model.Picture;
import hziee.smvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/12.
 */
@Service
@Transactional
public class ResourceService {
    public static final String FILE_PATH = "/upload/";
    @Autowired
    public PictureMapper pictureMapper;
    @Autowired
    public SqlRunner sqlRunner;
    @Autowired
    private PicService picService;
    public String UploadIcon(MultipartFile file, HttpServletRequest request){
        if(!file.isEmpty()){
            System.out.println("hiiiii");
            Map m = UploadUtils.saveMultipartFile(file);
            System.out.println();
            User user =(User)request.getSession().getAttribute("user");
            Integer userId =  user.getId();
            String picName = (String)m.get("saveName");
            Picture  picture = new Picture();
            picture.setPicName(picName);
            picture.setUserId(userId);
            Picture temp=null;
            if(picService.getUserIcon(user)!=null){
                temp = picService.getUserIcon(user);
                picture.setId(temp.getId());
                pictureMapper.updateByPrimaryKey(picture);
                return picName;
            }
            pictureMapper.insert(picture);
            return picName;
        }
        return null;
    }
}
