package com.easyenglish.dao;

import com.easyenglish.dto.Textbook;
import com.easyenglish.dto.TextbookExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TextbookMapper {
    int countByExample(TextbookExample example);

    int deleteByExample(TextbookExample example);

    int deleteByPrimaryKey(Integer tbId);

    int insert(Textbook record);

    int insertSelective(Textbook record);

    List<Textbook> selectByExample(TextbookExample example);

    Textbook selectByPrimaryKey(Integer tbId);

    int updateByExampleSelective(@Param("record") Textbook record, @Param("example") TextbookExample example);

    int updateByExample(@Param("record") Textbook record, @Param("example") TextbookExample example);

    int updateByPrimaryKeySelective(Textbook record);

    int updateByPrimaryKey(Textbook record);
}