package com.easyenglish.service;

import com.easyenglish.dto.User;
import com.easyenglish.vo.Page;
import com.easyenglish.vo.PageResult;

public interface UserService {

    int selectCount();

    int insertSelective(User record);

    int deleteByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    User selectByPrimaryKey(Integer userId);

    User selectByUsername(String username);

    PageResult<User> selectByKeyWordByPage(Page page, String keyWord);

    PageResult<User> selectAllByPage(Page page);

    PageResult<User> selectAllBySchoolGradeClassByPage(Page page, Integer school_id, Integer grade_id, Integer class_id);

    PageResult<User> selectByNameByPage(Page page, String name);
}
