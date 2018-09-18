package com.easyenglish.service.Impl;

import com.easyenglish.dao.VideoEnglishMapper;
import com.easyenglish.dto.VideoEnglish;
import com.easyenglish.dto.VideoEnglishExample;
import com.easyenglish.dto.VideoEnglishExample.Criteria;
import com.easyenglish.service.VideoEnglishService;
import com.easyenglish.vo.Page;
import com.easyenglish.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class VideoEnglishServiceImpl implements VideoEnglishService {
	@Autowired
	private VideoEnglishMapper videoEnglishMapper;
	
	
	@Override
	public int selectCount() {
		VideoEnglishExample example = new VideoEnglishExample();
		// TODO Auto-generated method stub
		return videoEnglishMapper.countByExample(example );
	}

	@Override
	public int insertSelective(VideoEnglish record) {
		// TODO Auto-generated method stub
		record.setCreateTime(new Date());
		return videoEnglishMapper.insertSelective(record);
	}

	@Override
	public int deleteByPrimaryKey(Integer tvId) {
		// TODO Auto-generated method stub
		return videoEnglishMapper.deleteByPrimaryKey(tvId);
	}

	@Override
	public int updateByPrimaryKeySelective(VideoEnglish record) {
		// TODO Auto-generated method stub
		record.setUpdateTime(new Date());
		return videoEnglishMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public VideoEnglish selectByPrimaryKey(Integer tvId) {
		// TODO Auto-generated method stub
		return videoEnglishMapper.selectByPrimaryKey(tvId);
	}

	@Override
	public PageResult<VideoEnglish> selectAllByPage(Page page) {
		// TODO Auto-generated method stub
		Integer startPos = page.getStartPos();
		Integer pageSize = page.getPageSize();
		Integer pageNow = page.getPageNow();

		List<VideoEnglish> selectAllByPage = videoEnglishMapper.selectAllByPage(page);
		if(selectAllByPage==null){
			return new PageResult<VideoEnglish>(null, 0,
					pageSize, 0);
		}else{
			Integer totalCount  = selectCount();
			page.setTotalCount(totalCount);
			Integer totalPage = page.getTotalPageCount();
			if(pageNow<1){
				page.setPageNow(1);
				pageNow = 1;

			}else if(pageNow>page.getTotalPageCount()){
				page.setPageNow(totalPage);
				pageNow = totalPage;
			}


			return new PageResult<VideoEnglish>(selectAllByPage, totalCount,
					pageSize, pageNow);
		}


	}

	@Override
	public PageResult<VideoEnglish> selectByKeyWordByPage(String keyWord, Page page) {
		// TODO Auto-generated method stub
		Integer startPos = page.getStartPos();
		Integer pageSize = page.getPageSize();
		Integer pageNow = page.getPageNow();

		List<VideoEnglish> selectByKeyWord = videoEnglishMapper.selectByKeyWord(keyWord,startPos,pageSize);
		if(selectByKeyWord==null){
			return new PageResult<VideoEnglish>(null, 0,
					pageSize, 0);
		}else{
			Integer totalCount  = videoEnglishMapper.selectCountByKeyWord(keyWord);
			page.setTotalCount(totalCount);
			Integer totalPage = page.getTotalPageCount();
			if(pageNow<1){
				page.setPageNow(1);
				pageNow = 1;

			}else if(pageNow>page.getTotalPageCount()){
				page.setPageNow(totalPage);
				pageNow = totalPage;
			}

			return new PageResult<VideoEnglish>(selectByKeyWord, totalCount,
					pageSize, pageNow);

		}



	}

	@Override
	public int selectCountByKeyWord(String keyWord) {
		return videoEnglishMapper.selectCountByKeyWord(keyWord);
	}



	@Override
    @Transactional
	public PageResult<VideoEnglish> selectAllByGradeByPage(Integer gradeId, Page page) {
		Integer startPos = page.getStartPos();
		Integer pageSize = page.getPageSize();
		Integer pageNow = page.getPageNow();

		VideoEnglishExample example = new VideoEnglishExample();
		Criteria criteria = example.createCriteria();
		criteria.andGradeEqualTo(gradeId);
		// TODO Auto-generated method stub
		List<VideoEnglish> selectByExample = videoEnglishMapper.selectAllByGradeByPage(gradeId,startPos,pageSize);

		if(selectByExample==null){
			return new PageResult<VideoEnglish>(null, 0,
					pageSize, 0);
		}else{
			VideoEnglishExample example_count = new VideoEnglishExample();
			Criteria criteria_count = example_count.createCriteria();
			criteria_count.andGradeEqualTo(gradeId);
			Integer totalCount  = videoEnglishMapper.countByExample(example_count);
			page.setTotalCount(totalCount);
			Integer totalPage = page.getTotalPageCount();
			if(pageNow<1){
				page.setPageNow(1);
				pageNow = 1;

			}else if(pageNow>page.getTotalPageCount()){
				page.setPageNow(totalPage);
				pageNow = totalPage;
			}

			return new PageResult<VideoEnglish>(selectByExample, totalCount,
					pageSize, pageNow);
		}

		



	}

	@Override
    @Transactional
    public PageResult<VideoEnglish> selectAllByTextBookByPage(Integer textbook, Page page) {
		// TODO Auto-generated method stub
		Integer startPos = page.getStartPos();
		Integer pageSize = page.getPageSize();
		Integer pageNow = page.getPageNow();
		VideoEnglishExample example = new VideoEnglishExample();
		Criteria criteria = example.createCriteria();
		criteria.andTextbookEqualTo(textbook);
		// TODO Auto-generated method stub
		List<VideoEnglish> selectByExample = videoEnglishMapper.selectAllByTextBookByPage(textbook,startPos,pageSize);


		if(selectByExample==null){
			return new PageResult<VideoEnglish>(null, 0,
					pageSize, 0);
		}else{
			VideoEnglishExample example_count = new VideoEnglishExample();
			Criteria criteria_count = example_count.createCriteria();
			criteria_count.andTextbookEqualTo(textbook);
			Integer totalCount  = videoEnglishMapper.countByExample(example_count);
			page.setTotalCount(totalCount);
			Integer totalPage = page.getTotalPageCount();
			if(pageNow<1){
				page.setPageNow(1);
				pageNow = 1;

			}else if(pageNow>page.getTotalPageCount()){
				page.setPageNow(totalPage);
				pageNow = totalPage;
			}




			return new PageResult<VideoEnglish>(selectByExample, totalCount,
					pageSize, pageNow);
		}


	}

	@Override
	public VideoEnglish selectVideoEnglishByTitle(String title, Page page) {
		VideoEnglishExample example =  new VideoEnglishExample();
		Criteria criteria = example.createCriteria();
		criteria.andTitleEqualTo(title);
		List<VideoEnglish> videoEnglishs = videoEnglishMapper.selectByExample(example);
		return videoEnglishs.get(0);
	}

}
