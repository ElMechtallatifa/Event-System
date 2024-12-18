package com.test.mapper;

import com.test.pojo.Command;
import com.test.pojo.Ticket;

import com.test.pojo.Event;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 40255
 * @description 
 * @createDate 2023-07-04 19:42:12
 * @Entity com.test.pojo.Command
 */
@Repository
public interface TicketMapper{
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Ticket record);

    Ticket selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Ticket record);

    List<Ticket> queryAll();

    List<Ticket> getByTwo(Ticket record);

}




