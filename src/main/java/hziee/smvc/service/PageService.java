package hziee.smvc.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/12/25.
 */
@Service
@Transactional
public class PageService {
    private Integer contentPerCount;
    public void setContentPerCount(Integer contentPerCount) {
        this.contentPerCount = contentPerCount;
    }
    public PageService(){
        contentPerCount=8;
    }
    public Integer getPagesCount(Integer size){
        System.out.println("总内容数:"+size);
        size-=1;
        if(size<0) size=0;
        double shifter =  (double)size/(double)contentPerCount;
        return (int)shifter+1;
    }

    public Integer getContentPerCount() {
        return contentPerCount;
    }
    public Integer getStart(Integer page){
        return
                (page-1)*contentPerCount;
    }
}
