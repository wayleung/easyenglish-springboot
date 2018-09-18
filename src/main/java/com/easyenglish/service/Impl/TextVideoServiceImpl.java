package com.easyenglish.service.Impl;

import com.easyenglish.dao.TextVideoMapper;
import com.easyenglish.dto.TextVideo;
import com.easyenglish.dto.TextVideoExample;
import com.easyenglish.dto.TextVideoExample.Criteria;
import com.easyenglish.service.TextVideoService;

import com.easyenglish.vo.Page;
import com.easyenglish.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class TextVideoServiceImpl implements TextVideoService {
	@Autowired
	private TextVideoMapper textVideoMapper;
	
	
	@Override
	public int selectCount() {
		TextVideoExample example = new TextVideoExample();
		// TODO Auto-generated method stub
		return textVideoMapper.countByExample(example );
	}

	@Override
	public int insertSelective(TextVideo record) {
		// TODO Auto-generated method stub
		record.setCreateTime(new Date());
		return textVideoMapper.insertSelective(record);
	}

	@Override
	public int deleteByPrimaryKey(Integer tvId) {
		// TODO Auto-generated method stub
		return textVideoMapper.deleteByPrimaryKey(tvId);
	}

	@Override
	public int updateByPrimaryKeySelective(TextVideo record) {
		// TODO Auto-generated method stub
		record.setUpdateTime(new Date());
		return textVideoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public TextVideo selectByPrimaryKey(Integer tvId) {
		// TODO Auto-generated method stub
		return textVideoMapper.selectByPrimaryKey(tvId);
	}

	@Override
	public PageResult<TextVideo> selectAllByPage(Page page) {
		// TODO Auto-generated method stub
		Integer startPos = page.getStartPos();
		Integer pageSize = page.getPageSize();
		Integer pageNow = page.getPageNow();

		List<TextVideo> selectAllByPage = textVideoMapper.selectAllByPage(page);
		if(selectAllByPage==null){
			return new PageResult<TextVideo>(null, 0,
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


			return new PageResult<TextVideo>(selectAllByPage, totalCount,
					pageSize, pageNow);
		}


	}

	@Override
	public PageResult<TextVideo> selectByKeyWordByPage( String keyWord,Page page) {
		// TODO Auto-generated method stub
		Integer startPos = page.getStartPos();
		Integer pageSize = page.getPageSize();
		Integer pageNow = page.getPageNow();

		List<TextVideo> selectByKeyWord = textVideoMapper.selectByKeyWord(keyWord,startPos,pageSize);
		if(selectByKeyWord==null){
			return new PageResult<TextVideo>(null, 0,
					pageSize, 0);
		}else{
			Integer totalCount  = textVideoMapper.selectCountByKeyWord(keyWord);
			page.setTotalCount(totalCount);
			Integer totalPage = page.getTotalPageCount();
			if(pageNow<1){
				page.setPageNow(1);
				pageNow = 1;

			}else if(pageNow>page.getTotalPageCount()){
				page.setPageNow(totalPage);
				pageNow = totalPage;
			}

			return new PageResult<TextVideo>(selectByKeyWord, totalCount,
					pageSize, pageNow);

		}



	}

	@Override
	public int selectCountByKeyWord(String keyWord) {
		return textVideoMapper.selectCountByKeyWord(keyWord);
	}



	@Override
    @Transactional
	public PageResult<TextVideo> selectAllByGradeByPage( Integer gradeId,Page page) {
		Integer startPos = page.getStartPos();
		Integer pageSize = page.getPageSize();
		Integer pageNow = page.getPageNow();

		TextVideoExample example = new TextVideoExample();
		Criteria criteria = example.createCriteria();
		criteria.andGradeEqualTo(gradeId);
		// TODO Auto-generated method stub
		List<TextVideo> selectByExample = textVideoMapper.selectAllByGradeByPage(gradeId,startPos,pageSize);

		if(selectByExample==null){
			return new PageResult<TextVideo>(null, 0,
					pageSize, 0);
		}else{
			TextVideoExample example_count = new TextVideoExample();
			Criteria criteria_count = example_count.createCriteria();
			criteria_count.andGradeEqualTo(gradeId);
			Integer totalCount  = textVideoMapper.countByExample(example_count);
			page.setTotalCount(totalCount);
			Integer totalPage = page.getTotalPageCount();
			if(pageNow<1){
				page.setPageNow(1);
				pageNow = 1;

			}else if(pageNow>page.getTotalPageCount()){
				page.setPageNow(totalPage);
				pageNow = totalPage;
			}

			return new PageResult<TextVideo>(selectByExample, totalCount,
					pageSize, pageNow);
		}

		



	}

	@Override
    @Transactional
    public PageResult<TextVideo> selectAllByTextBookByPage( Integer textbook,Page page) {
		// TODO Auto-generated method stub
		Integer startPos = page.getStartPos();
		Integer pageSize = page.getPageSize();
		Integer pageNow = page.getPageNow();
		TextVideoExample example = new TextVideoExample();
		Criteria criteria = example.createCriteria();
		criteria.andTextbookEqualTo(textbook);
		// TODO Auto-generated method stub
		List<TextVideo> selectByExample = textVideoMapper.selectAllByTextBookByPage(textbook,startPos,pageSize);


		if(selectByExample==null){
			return new PageResult<TextVideo>(null, 0,
					pageSize, 0);
		}else{
			TextVideoExample example_count = new TextVideoExample();
			Criteria criteria_count = example_count.createCriteria();
			criteria_count.andTextbookEqualTo(textbook);
			Integer totalCount  = textVideoMapper.countByExample(example_count);
			page.setTotalCount(totalCount);
			Integer totalPage = page.getTotalPageCount();
			if(pageNow<1){
				page.setPageNow(1);
				pageNow = 1;

			}else if(pageNow>page.getTotalPageCount()){
				page.setPageNow(totalPage);
				pageNow = totalPage;
			}




			return new PageResult<TextVideo>(selectByExample, totalCount,
					pageSize, pageNow);
		}


	}

	@Override
	public TextVideo selectTextVideoByTitle( String title,Page page) {
		TextVideoExample example =  new TextVideoExample();
		Criteria criteria = example.createCriteria();
		criteria.andTitleEqualTo(title);
		List<TextVideo> textVideos = textVideoMapper.selectByExample(example);
		return textVideos.get(0);
	}

}
