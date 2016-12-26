package hziee.smvc.service;

import hziee.smvc.model.Contact;
import hziee.smvc.model.Forum;
import hziee.smvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.sun.org.apache.xalan.internal.lib.ExsltStrings.split;

/**
 * Created by Administrator on 2016/12/26.
 */
@Service
@Transactional
public class SearchService {

    @Autowired
    private PageContentService pageContentService;
    @Autowired
    private PageService pageService;
    public List SearchServices(String s, Class<?> types){
        String part[] =  s.split("[.|/]");
        String result = part[part.length - 2];
        String resultPart[]= result.split("[_]");
        ///地址错误
        if(resultPart.length>3){
            return null;
        }
        String condition =  resultPart[1];
        Integer page = Integer.parseInt(resultPart[2]);
        List list= pageContentService.getPagedContent(page,types,condition);
        String parts[]=condition.split("[|]");
        return list;
    }
    public String[] GetKeywords(String url){
        String part[] =  url.split("[.|/]");
        String result = part[part.length - 2];
        String resultPart[]= result.split("[_]");
        String condition =  resultPart[1];
        String results[] =  condition.split("[=]");
        System.out.println("result size"+results.length);
        return results;
    }
    public Class<?> GetSearchedContetType(String url){
        String part[] =  url.split("[.|/]");
        String result = part[part.length - 2];
        String resultPart[]= result.split("[_]");
        String type =  resultPart[0];
        if(type.equals("user")){
            return User.class;
        }
        if(type.equals("forum")){
            return Forum.class;
        }
        if(type.equals("Contact")){
            return Contact.class;
        }
        return null;
    }
}
