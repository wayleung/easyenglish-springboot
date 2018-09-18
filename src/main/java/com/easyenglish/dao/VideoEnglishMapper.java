package com.easyenglish.dao;

import com.easyenglish.dto.VideoEnglish;
import com.easyenglish.dto.VideoEnglishExample;
import com.easyenglish.vo.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideoEnglishMapper {
    int countByExample(VideoEnglishExample example);

    int deleteByExample(VideoEnglishExample example);

    int deleteByPrimaryKey(Integer tvId);

    int insert(VideoEnglish record);

    int insertSelective(VideoEnglish record);

    List<VideoEnglish> selectByExampleWithBLOBs(VideoEnglishExample example);

    List<VideoEnglish> selectByExample(VideoEnglishExample example);

    VideoEnglish selectByPrimaryKey(Integer tvId);

    int updateByExampleSelective(@Param("record") VideoEnglish record, @Param("example") VideoEnglishExample example);

    int updateByExampleWithBLOBs(@Param("record") VideoEnglish record, @Param("example") VideoEnglishExample example);

    int updateByExample(@Param("record") VideoEnglish record, @Param("example") VideoEnglishExample example);

    int updateByPrimaryKeySelective(VideoEnglish record);

    int updateByPrimaryKeyWithBLOBs(VideoEnglish record);

    int updateByPrimaryKey(VideoEnglish record);
    
    List<VideoEnglish> selectAllByPage(Page page);

    //当只有一个参数时 @Param可以不用 但有多个参数时  @Param要用

    List<VideoEnglish> selectByKeyWord(@Param("keyWord") String keyWord, @Param("startPos") Integer startPos, @Param("pageSize") Integer pageSize);

    List<VideoEnglish> selectAllByGradeByPage(@Param("gradeId") Integer gradeId, @Param("startPos") Integer startPos, @Param("pageSize") Integer pageSize);

    List<VideoEnglish> selectAllByTextBookByPage(@Param("textbook") Integer textbook, @Param("startPos") Integer startPos, @Param("pageSize") Integer pageSize);



    int selectCountByKeyWord(String keyWord);

}