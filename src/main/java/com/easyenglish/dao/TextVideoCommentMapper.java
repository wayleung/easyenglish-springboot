package com.easyenglish.dao;

import com.easyenglish.dto.TextVideoComment;
import com.easyenglish.dto.TextVideoCommentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TextVideoCommentMapper {
    int countByExample(TextVideoCommentExample example);

    int deleteByExample(TextVideoCommentExample example);

    int deleteByPrimaryKey(Integer tcId);

    int insert(TextVideoComment record);

    int insertSelective(TextVideoComment record);

    List<TextVideoComment> selectByExample(TextVideoCommentExample example);

    TextVideoComment selectByPrimaryKey(Integer tcId);

    int updateByExampleSelective(@Param("record") TextVideoComment record, @Param("example") TextVideoCommentExample example);

    int updateByExample(@Param("record") TextVideoComment record, @Param("example") TextVideoCommentExample example);

    int updateByPrimaryKeySelective(TextVideoComment record);

    int updateByPrimaryKey(TextVideoComment record);
}