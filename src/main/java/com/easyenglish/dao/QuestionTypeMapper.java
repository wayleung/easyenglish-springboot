package com.easyenglish.dao;

import com.easyenglish.dto.QuestionType;
import com.easyenglish.dto.QuestionTypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionTypeMapper {
    int countByExample(QuestionTypeExample example);

    int deleteByExample(QuestionTypeExample example);

    int deleteByPrimaryKey(Integer qtId);

    int insert(QuestionType record);

    int insertSelective(QuestionType record);

    List<QuestionType> selectByExample(QuestionTypeExample example);

    QuestionType selectByPrimaryKey(Integer qtId);

    int updateByExampleSelective(@Param("record") QuestionType record, @Param("example") QuestionTypeExample example);

    int updateByExample(@Param("record") QuestionType record, @Param("example") QuestionTypeExample example);

    int updateByPrimaryKeySelective(QuestionType record);

    int updateByPrimaryKey(QuestionType record);
}