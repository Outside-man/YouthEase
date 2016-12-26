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
        double shifter =  (double)size/(double)contentPerCount;
        if((int)shifter==shifter&&shifter!=0){
            shifter-=1.0;
            System.out.println("shifter:"+shifter);
        }
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
