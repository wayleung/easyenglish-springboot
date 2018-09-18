package com.easyenglish.dao;

import com.easyenglish.dto.TextVideo;
import com.easyenglish.dto.TextVideoExample;
import com.easyenglish.vo.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TextVideoMapper {
    int countByExample(TextVideoExample example);

    int deleteByExample(TextVideoExample example);

    int deleteByPrimaryKey(Integer tvId);

    int insert(TextVideo record);

    int insertSelective(TextVideo record);

    List<TextVideo> selectByExampleWithBLOBs(TextVideoExample example);

    List<TextVideo> selectByExample(TextVideoExample example);

    TextVideo selectByPrimaryKey(Integer tvId);

    int updateByExampleSelective(@Param("record") TextVideo record, @Param("example") TextVideoExample example);

    int updateByExampleWithBLOBs(@Param("record") TextVideo record, @Param("example") TextVideoExample example);

    int updateByExample(@Param("record") TextVideo record, @Param("example") TextVideoExample example);

    int updateByPrimaryKeySelective(TextVideo record);

    int updateByPrimaryKeyWithBLOBs(TextVideo record);

    int updateByPrimaryKey(TextVideo record);
    
    List<TextVideo> selectAllByPage(Page page);

    //当只有一个参数时 @Param可以不用 但有多个参数时  @Param要用

    List<TextVideo> selectByKeyWord(@Param("keyWord") String keyWord, @Param("startPos") Integer startPos, @Param("pageSize") Integer pageSize);

    List<TextVideo> selectAllByGradeByPage(@Param("gradeId") Integer gradeId, @Param("startPos") Integer startPos, @Param("pageSize") Integer pageSize);

    List<TextVideo> selectAllByTextBookByPage(@Param("textbook") Integer textbook, @Param("startPos") Integer startPos, @Param("pageSize") Integer pageSize);



    int selectCountByKeyWord(String keyWord);

}