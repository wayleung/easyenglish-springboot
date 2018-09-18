package com.easyenglish.dao;

import com.easyenglish.dto.TestComment;
import com.easyenglish.dto.TestCommentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TestCommentMapper {
    int countByExample(TestCommentExample example);

    int deleteByExample(TestCommentExample example);

    int deleteByPrimaryKey(Integer tcId);

    int insert(TestComment record);

    int insertSelective(TestComment record);

    List<TestComment> selectByExample(TestCommentExample example);

    TestComment selectByPrimaryKey(Integer tcId);

    int updateByExampleSelective(@Param("record") TestComment record, @Param("example") TestCommentExample example);

    int updateByExample(@Param("record") TestComment record, @Param("example") TestCommentExample example);

    int updateByPrimaryKeySelective(TestComment record);

    int updateByPrimaryKey(TestComment record);
}