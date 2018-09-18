package com.easyenglish.service;

import com.easyenglish.dto.TextVideo;
import com.easyenglish.vo.Page;
import com.easyenglish.vo.PageResult;

public interface TextVideoService {
	int selectCount();
	
    int insertSelective(TextVideo record);
	
	int deleteByPrimaryKey(Integer tvId);
	
	int updateByPrimaryKeySelective(TextVideo record);
	
	TextVideo selectByPrimaryKey(Integer tvId);
	
	PageResult<TextVideo> selectAllByPage(Page page);

	PageResult<TextVideo> selectByKeyWordByPage(String keyWord, Page page);

	int selectCountByKeyWord(String keyWord);


	PageResult<TextVideo> selectAllByGradeByPage(Integer grade_id, Page page);

	PageResult<TextVideo> selectAllByTextBookByPage(Integer textBook_id, Page page);

	TextVideo selectTextVideoByTitle(String title, Page page);
}
