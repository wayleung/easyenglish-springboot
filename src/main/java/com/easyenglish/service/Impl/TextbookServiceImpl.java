package com.easyenglish.service.Impl;

import com.easyenglish.dao.TextbookMapper;
import com.easyenglish.dto.Textbook;
import com.easyenglish.dto.TextbookExample;
import com.easyenglish.service.TextbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TextbookServiceImpl implements TextbookService {
    @Autowired
    TextbookMapper textbookMapper;


    @Override
    public List<Textbook> selectAll() {
        TextbookExample example  =  new TextbookExample();
        return textbookMapper.selectByExample(example);
    }
}
