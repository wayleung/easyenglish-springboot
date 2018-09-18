package com.easyenglish.service;

import com.easyenglish.dto.VideoEnglish;
import com.easyenglish.vo.Page;
import com.easyenglish.vo.PageResult;

public interface VideoEnglishService {
	int selectCount();

    int insertSelective(VideoEnglish record);

	int deleteByPrimaryKey(Integer tvId);

	int updateByPrimaryKeySelective(VideoEnglish record);

	VideoEnglish selectByPrimaryKey(Integer tvId);

	PageResult<VideoEnglish> selectAllByPage(Page page);

	PageResult<VideoEnglish> selectByKeyWordByPage(String keyWord, Page page);

	int selectCountByKeyWord(String keyWord);


	PageResult<VideoEnglish> selectAllByGradeByPage(Integer grade_id, Page page);

	PageResult<VideoEnglish> selectAllByTextBookByPage(Integer textBook_id, Page page);

	VideoEnglish selectVideoEnglishByTitle(String title, Page page);
}
