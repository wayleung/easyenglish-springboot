package com.easyenglish.service.Impl;

import com.easyenglish.dao.GradeMapper;
import com.easyenglish.dto.Grade;
import com.easyenglish.dto.GradeExample;
import com.easyenglish.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    GradeMapper gradeMapper;

    @Override
    public List<Grade> selectAll() {
        GradeExample example = new GradeExample();
        return gradeMapper.selectByExample(example);
    }
}
