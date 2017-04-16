package hziee.smvc.mapper;

import hziee.smvc.model.Contact;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface ContactMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Contact record);

    Contact selectByPrimaryKey(Integer id);

    List<Contact> selectAll();

    int updateByPrimaryKey(Contact record);
}