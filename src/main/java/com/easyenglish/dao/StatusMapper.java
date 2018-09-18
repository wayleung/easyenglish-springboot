package com.easyenglish.dao;

import com.easyenglish.dto.Status;
import com.easyenglish.dto.StatusExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StatusMapper {
    int countByExample(StatusExample example);

    int deleteByExample(StatusExample example);

    int deleteByPrimaryKey(Integer sId);

    int insert(Status record);

    int insertSelective(Status record);

    List<Status> selectByExample(StatusExample example);

    Status selectByPrimaryKey(Integer sId);

    int updateByExampleSelective(@Param("record") Status record, @Param("example") StatusExample example);

    int updateByExample(@Param("record") Status record, @Param("example") StatusExample example);

    int updateByPrimaryKeySelective(Status record);

    int updateByPrimaryKey(Status record);
}