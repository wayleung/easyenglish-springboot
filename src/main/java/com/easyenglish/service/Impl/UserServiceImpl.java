package com.easyenglish.service.Impl;

import com.easyenglish.dao.UserMapper;
import com.easyenglish.dto.User;
import com.easyenglish.dto.UserExample;
import com.easyenglish.dto.UserExample.Criteria;
import com.easyenglish.service.UserService;
import com.easyenglish.vo.Page;
import com.easyenglish.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public int selectCount() {
        UserExample example  =  new UserExample();
        return userMapper.countByExample(example);
    }

    @Override
    public int insertSelective(User record) {
        record.setRegisterTime(new Date());
        return userMapper.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        record.setUpdateTime(new Date());
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public User selectByPrimaryKey(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public User selectByUsername(String username) {
        UserExample example = new UserExample();
        Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(example);
        if(users!=null&&users.size()>0){
            return users.get(0);
        }else{
            return null;
        }

    }

    @Override
    public PageResult<User> selectByKeyWordByPage(Page page, String keyWord) {
        Integer startPos = page.getStartPos();
        Integer pageSize = page.getPageSize();
        Integer pageNow = page.getPageNow();
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


        List<User> selectByKeyWord = userMapper.selectByKeyWord(page,keyWord);

        return new PageResult<User>(selectByKeyWord, totalCount,
                pageSize, pageNow);

    }

    @Override
    public PageResult<User> selectAllByPage(Page page) {

        Integer startPos = page.getStartPos();
        Integer pageSize = page.getPageSize();
        Integer pageNow = page.getPageNow();
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

        if(totalCount==0){
            return new PageResult<User>(new ArrayList<User>(), totalCount,
                    pageSize, pageNow);
        }

        List<User> selectAllByPage = userMapper.selectAllByPage(page);



        return new PageResult<User>(selectAllByPage, totalCount,
                pageSize, pageNow);
    }



    @Override
    public PageResult<User> selectAllBySchoolGradeClassByPage(Page page, Integer school_id, Integer grade_id, Integer class_id) {
        Integer startPos = page.getStartPos();
        Integer pageSize = page.getPageSize();
        Integer pageNow = page.getPageNow();
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

        UserExample example = new UserExample();
        Criteria criteria = example.createCriteria();
        if(school_id!=null){
            criteria.andSchoolEqualTo(school_id);
        }
        if(grade_id!=null){
            criteria.andGradeEqualTo(grade_id);
        }
        if(class_id!=null){
            criteria.andGradeEqualTo(class_id);
        }
        List<User> selectByExample = userMapper.selectByExample(example);

        return new PageResult<User>(selectByExample, totalCount,
                pageSize, pageNow);
    }


    @Override
    public PageResult<User> selectByNameByPage(Page page, String name) {
        Integer startPos = page.getStartPos();
        Integer pageSize = page.getPageSize();
        Integer pageNow = page.getPageNow();
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

        UserExample example = new UserExample();
        Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);
        List<User> selectByExample = userMapper.selectByExample(example);

        return new PageResult<User>(selectByExample, totalCount,
                pageSize, pageNow);
    }





}
