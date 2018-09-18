package com.easyenglish.service;

import com.easyenglish.dto.Admin;
import com.easyenglish.vo.Page;
import com.easyenglish.vo.PageResult;

public interface AdminService {

    int selectCount();

    int insertSelective(Admin record);

    int deleteByPrimaryKey(Integer tvId);

    int updateByPrimaryKeySelective(Admin record);

    Admin selectByPrimaryKey(Integer tvId);

    Admin selectByUsername(String username);

    PageResult<Admin> selectAllByPage(Page page);

    PageResult<Admin> selectByKeyWordByPage(String keyWord);


}
