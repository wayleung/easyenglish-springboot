package com.easyenglish.service.Impl;

import com.easyenglish.dao.AdminMapper;
import com.easyenglish.dto.Admin;
import com.easyenglish.dto.AdminExample;
import com.easyenglish.service.AdminService;

import com.easyenglish.vo.Page;
import com.easyenglish.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public int selectCount() {
        return 0;
    }

    @Override
    public int insertSelective(Admin record) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Integer tvId) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Admin record) {
        return 0;
    }

    @Override
    public Admin selectByPrimaryKey(Integer tvId) {
        return null;
    }

    @Override
    public Admin selectByUsername(String username) {
        AdminExample example = new AdminExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<Admin> admins = adminMapper.selectByExample(example);

        if(admins!=null&&admins.size()>0){
            return admins.get(0);
        }else{
            return null;
        }
    }

    @Override
    public PageResult<Admin> selectAllByPage(Page page) {
        return null;
    }

    @Override
    public PageResult<Admin> selectByKeyWordByPage(String keyWord) {
        return null;
    }
}
