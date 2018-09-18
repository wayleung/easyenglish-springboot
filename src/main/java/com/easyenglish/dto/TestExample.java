package com.easyenglish.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TestExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andTestIdIsNull() {
            addCriterion("test_id is null");
            return (Criteria) this;
        }

        public Criteria andTestIdIsNotNull() {
            addCriterion("test_id is not null");
            return (Criteria) this;
        }

        public Criteria andTestIdEqualTo(Integer value) {
            addCriterion("test_id =", value, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdNotEqualTo(Integer value) {
            addCriterion("test_id <>", value, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdGreaterThan(Integer value) {
            addCriterion("test_id >", value, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("test_id >=", value, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdLessThan(Integer value) {
            addCriterion("test_id <", value, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdLessThanOrEqualTo(Integer value) {
            addCriterion("test_id <=", value, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdIn(List<Integer> values) {
            addCriterion("test_id in", values, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdNotIn(List<Integer> values) {
            addCriterion("test_id not in", values, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdBetween(Integer value1, Integer value2) {
            addCriterion("test_id between", value1, value2, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdNotBetween(Integer value1, Integer value2) {
            addCriterion("test_id not between", value1, value2, "testId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andGradeIsNull() {
            addCriterion("grade is null");
            return (Criteria) this;
        }

        public Criteria andGradeIsNotNull() {
            addCriterion("grade is not null");
            return (Criteria) this;
        }

        public Criteria andGradeEqualTo(Integer value) {
            addCriterion("grade =", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotEqualTo(Integer value) {
            addCriterion("grade <>", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThan(Integer value) {
            addCriterion("grade >", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThanOrEqualTo(Integer value) {
            addCriterion("grade >=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThan(Integer value) {
            addCriterion("grade <", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThanOrEqualTo(Integer value) {
            addCriterion("grade <=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeIn(List<Integer> values) {
            addCriterion("grade in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotIn(List<Integer> values) {
            addCriterion("grade not in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeBetween(Integer value1, Integer value2) {
            addCriterion("grade between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotBetween(Integer value1, Integer value2) {
            addCriterion("grade not between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andTextbookIsNull() {
            addCriterion("textbook is null");
            return (Criteria) this;
        }

        public Criteria andTextbookIsNotNull() {
            addCriterion("textbook is not null");
            return (Criteria) this;
        }

        public Criteria andTextbookEqualTo(Integer value) {
            addCriterion("textbook =", value, "textbook");
            return (Criteria) this;
        }

        public Criteria andTextbookNotEqualTo(Integer value) {
            addCriterion("textbook <>", value, "textbook");
            return (Criteria) this;
        }

        public Criteria andTextbookGreaterThan(Integer value) {
            addCriterion("textbook >", value, "textbook");
            return (Criteria) this;
        }

        public Criteria andTextbookGreaterThanOrEqualTo(Integer value) {
            addCriterion("textbook >=", value, "textbook");
            return (Criteria) this;
        }

        public Criteria andTextbookLessThan(Integer value) {
            addCriterion("textbook <", value, "textbook");
            return (Criteria) this;
        }

        public Criteria andTextbookLessThanOrEqualTo(Integer value) {
            addCriterion("textbook <=", value, "textbook");
            return (Criteria) this;
        }

        public Criteria andTextbookIn(List<Integer> values) {
            addCriterion("textbook in", values, "textbook");
            return (Criteria) this;
        }

        public Criteria andTextbookNotIn(List<Integer> values) {
            addCriterion("textbook not in", values, "textbook");
            return (Criteria) this;
        }

        public Criteria andTextbookBetween(Integer value1, Integer value2) {
            addCriterion("textbook between", value1, value2, "textbook");
            return (Criteria) this;
        }

        public Criteria andTextbookNotBetween(Integer value1, Integer value2) {
            addCriterion("textbook not between", value1, value2, "textbook");
            return (Criteria) this;
        }

        public Criteria andTotalMarkIsNull() {
            addCriterion("total_mark is null");
            return (Criteria) this;
        }

        public Criteria andTotalMarkIsNotNull() {
            addCriterion("total_mark is not null");
            return (Criteria) this;
        }

        public Criteria andTotalMarkEqualTo(Float value) {
            addCriterion("total_mark =", value, "totalMark");
            return (Criteria) this;
        }

        public Criteria andTotalMarkNotEqualTo(Float value) {
            addCriterion("total_mark <>", value, "totalMark");
            return (Criteria) this;
        }

        public Criteria andTotalMarkGreaterThan(Float value) {
            addCriterion("total_mark >", value, "totalMark");
            return (Criteria) this;
        }

        public Criteria andTotalMarkGreaterThanOrEqualTo(Float value) {
            addCriterion("total_mark >=", value, "totalMark");
            return (Criteria) this;
        }

        public Criteria andTotalMarkLessThan(Float value) {
            addCriterion("total_mark <", value, "totalMark");
            return (Criteria) this;
        }

        public Criteria andTotalMarkLessThanOrEqualTo(Float value) {
            addCriterion("total_mark <=", value, "totalMark");
            return (Criteria) this;
        }

        public Criteria andTotalMarkIn(List<Float> values) {
            addCriterion("total_mark in", values, "totalMark");
            return (Criteria) this;
        }

        public Criteria andTotalMarkNotIn(List<Float> values) {
            addCriterion("total_mark not in", values, "totalMark");
            return (Criteria) this;
        }

        public Criteria andTotalMarkBetween(Float value1, Float value2) {
            addCriterion("total_mark between", value1, value2, "totalMark");
            return (Criteria) this;
        }

        public Criteria andTotalMarkNotBetween(Float value1, Float value2) {
            addCriterion("total_mark not between", value1, value2, "totalMark");
            return (Criteria) this;
        }

        public Criteria andDoCountIsNull() {
            addCriterion("do_count is null");
            return (Criteria) this;
        }

        public Criteria andDoCountIsNotNull() {
            addCriterion("do_count is not null");
            return (Criteria) this;
        }

        public Criteria andDoCountEqualTo(Integer value) {
            addCriterion("do_count =", value, "doCount");
            return (Criteria) this;
        }

        public Criteria andDoCountNotEqualTo(Integer value) {
            addCriterion("do_count <>", value, "doCount");
            return (Criteria) this;
        }

        public Criteria andDoCountGreaterThan(Integer value) {
            addCriterion("do_count >", value, "doCount");
            return (Criteria) this;
        }

        public Criteria andDoCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("do_count >=", value, "doCount");
            return (Criteria) this;
        }

        public Criteria andDoCountLessThan(Integer value) {
            addCriterion("do_count <", value, "doCount");
            return (Criteria) this;
        }

        public Criteria andDoCountLessThanOrEqualTo(Integer value) {
            addCriterion("do_count <=", value, "doCount");
            return (Criteria) this;
        }

        public Criteria andDoCountIn(List<Integer> values) {
            addCriterion("do_count in", values, "doCount");
            return (Criteria) this;
        }

        public Criteria andDoCountNotIn(List<Integer> values) {
            addCriterion("do_count not in", values, "doCount");
            return (Criteria) this;
        }

        public Criteria andDoCountBetween(Integer value1, Integer value2) {
            addCriterion("do_count between", value1, value2, "doCount");
            return (Criteria) this;
        }

        public Criteria andDoCountNotBetween(Integer value1, Integer value2) {
            addCriterion("do_count not between", value1, value2, "doCount");
            return (Criteria) this;
        }

        public Criteria andReadCountIsNull() {
            addCriterion("read_count is null");
            return (Criteria) this;
        }

        public Criteria andReadCountIsNotNull() {
            addCriterion("read_count is not null");
            return (Criteria) this;
        }

        public Criteria andReadCountEqualTo(Integer value) {
            addCriterion("read_count =", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountNotEqualTo(Integer value) {
            addCriterion("read_count <>", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountGreaterThan(Integer value) {
            addCriterion("read_count >", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("read_count >=", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountLessThan(Integer value) {
            addCriterion("read_count <", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountLessThanOrEqualTo(Integer value) {
            addCriterion("read_count <=", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountIn(List<Integer> values) {
            addCriterion("read_count in", values, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountNotIn(List<Integer> values) {
            addCriterion("read_count not in", values, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountBetween(Integer value1, Integer value2) {
            addCriterion("read_count between", value1, value2, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountNotBetween(Integer value1, Integer value2) {
            addCriterion("read_count not between", value1, value2, "readCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountIsNull() {
            addCriterion("like_count is null");
            return (Criteria) this;
        }

        public Criteria andLikeCountIsNotNull() {
            addCriterion("like_count is not null");
            return (Criteria) this;
        }

        public Criteria andLikeCountEqualTo(Integer value) {
            addCriterion("like_count =", value, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountNotEqualTo(Integer value) {
            addCriterion("like_count <>", value, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountGreaterThan(Integer value) {
            addCriterion("like_count >", value, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("like_count >=", value, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountLessThan(Integer value) {
            addCriterion("like_count <", value, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountLessThanOrEqualTo(Integer value) {
            addCriterion("like_count <=", value, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountIn(List<Integer> values) {
            addCriterion("like_count in", values, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountNotIn(List<Integer> values) {
            addCriterion("like_count not in", values, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountBetween(Integer value1, Integer value2) {
            addCriterion("like_count between", value1, value2, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountNotBetween(Integer value1, Integer value2) {
            addCriterion("like_count not between", value1, value2, "likeCount");
            return (Criteria) this;
        }

        public Criteria andHandInCountIsNull() {
            addCriterion("hand_in_count is null");
            return (Criteria) this;
        }

        public Criteria andHandInCountIsNotNull() {
            addCriterion("hand_in_count is not null");
            return (Criteria) this;
        }

        public Criteria andHandInCountEqualTo(Integer value) {
            addCriterion("hand_in_count =", value, "handInCount");
            return (Criteria) this;
        }

        public Criteria andHandInCountNotEqualTo(Integer value) {
            addCriterion("hand_in_count <>", value, "handInCount");
            return (Criteria) this;
        }

        public Criteria andHandInCountGreaterThan(Integer value) {
            addCriterion("hand_in_count >", value, "handInCount");
            return (Criteria) this;
        }

        public Criteria andHandInCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("hand_in_count >=", value, "handInCount");
            return (Criteria) this;
        }

        public Criteria andHandInCountLessThan(Integer value) {
            addCriterion("hand_in_count <", value, "handInCount");
            return (Criteria) this;
        }

        public Criteria andHandInCountLessThanOrEqualTo(Integer value) {
            addCriterion("hand_in_count <=", value, "handInCount");
            return (Criteria) this;
        }

        public Criteria andHandInCountIn(List<Integer> values) {
            addCriterion("hand_in_count in", values, "handInCount");
            return (Criteria) this;
        }

        public Criteria andHandInCountNotIn(List<Integer> values) {
            addCriterion("hand_in_count not in", values, "handInCount");
            return (Criteria) this;
        }

        public Criteria andHandInCountBetween(Integer value1, Integer value2) {
            addCriterion("hand_in_count between", value1, value2, "handInCount");
            return (Criteria) this;
        }

        public Criteria andHandInCountNotBetween(Integer value1, Integer value2) {
            addCriterion("hand_in_count not between", value1, value2, "handInCount");
            return (Criteria) this;
        }

        public Criteria andNeedTimeIsNull() {
            addCriterion("need_time is null");
            return (Criteria) this;
        }

        public Criteria andNeedTimeIsNotNull() {
            addCriterion("need_time is not null");
            return (Criteria) this;
        }

        public Criteria andNeedTimeEqualTo(Integer value) {
            addCriterion("need_time =", value, "needTime");
            return (Criteria) this;
        }

        public Criteria andNeedTimeNotEqualTo(Integer value) {
            addCriterion("need_time <>", value, "needTime");
            return (Criteria) this;
        }

        public Criteria andNeedTimeGreaterThan(Integer value) {
            addCriterion("need_time >", value, "needTime");
            return (Criteria) this;
        }

        public Criteria andNeedTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("need_time >=", value, "needTime");
            return (Criteria) this;
        }

        public Criteria andNeedTimeLessThan(Integer value) {
            addCriterion("need_time <", value, "needTime");
            return (Criteria) this;
        }

        public Criteria andNeedTimeLessThanOrEqualTo(Integer value) {
            addCriterion("need_time <=", value, "needTime");
            return (Criteria) this;
        }

        public Criteria andNeedTimeIn(List<Integer> values) {
            addCriterion("need_time in", values, "needTime");
            return (Criteria) this;
        }

        public Criteria andNeedTimeNotIn(List<Integer> values) {
            addCriterion("need_time not in", values, "needTime");
            return (Criteria) this;
        }

        public Criteria andNeedTimeBetween(Integer value1, Integer value2) {
            addCriterion("need_time between", value1, value2, "needTime");
            return (Criteria) this;
        }

        public Criteria andNeedTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("need_time not between", value1, value2, "needTime");
            return (Criteria) this;
        }

        public Criteria andPassedMarkIsNull() {
            addCriterion("passed_mark is null");
            return (Criteria) this;
        }

        public Criteria andPassedMarkIsNotNull() {
            addCriterion("passed_mark is not null");
            return (Criteria) this;
        }

        public Criteria andPassedMarkEqualTo(Float value) {
            addCriterion("passed_mark =", value, "passedMark");
            return (Criteria) this;
        }

        public Criteria andPassedMarkNotEqualTo(Float value) {
            addCriterion("passed_mark <>", value, "passedMark");
            return (Criteria) this;
        }

        public Criteria andPassedMarkGreaterThan(Float value) {
            addCriterion("passed_mark >", value, "passedMark");
            return (Criteria) this;
        }

        public Criteria andPassedMarkGreaterThanOrEqualTo(Float value) {
            addCriterion("passed_mark >=", value, "passedMark");
            return (Criteria) this;
        }

        public Criteria andPassedMarkLessThan(Float value) {
            addCriterion("passed_mark <", value, "passedMark");
            return (Criteria) this;
        }

        public Criteria andPassedMarkLessThanOrEqualTo(Float value) {
            addCriterion("passed_mark <=", value, "passedMark");
            return (Criteria) this;
        }

        public Criteria andPassedMarkIn(List<Float> values) {
            addCriterion("passed_mark in", values, "passedMark");
            return (Criteria) this;
        }

        public Criteria andPassedMarkNotIn(List<Float> values) {
            addCriterion("passed_mark not in", values, "passedMark");
            return (Criteria) this;
        }

        public Criteria andPassedMarkBetween(Float value1, Float value2) {
            addCriterion("passed_mark between", value1, value2, "passedMark");
            return (Criteria) this;
        }

        public Criteria andPassedMarkNotBetween(Float value1, Float value2) {
            addCriterion("passed_mark not between", value1, value2, "passedMark");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNull() {
            addCriterion("publish_time is null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNotNull() {
            addCriterion("publish_time is not null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeEqualTo(Date value) {
            addCriterion("publish_time =", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotEqualTo(Date value) {
            addCriterion("publish_time <>", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThan(Date value) {
            addCriterion("publish_time >", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("publish_time >=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThan(Date value) {
            addCriterion("publish_time <", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThanOrEqualTo(Date value) {
            addCriterion("publish_time <=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIn(List<Date> values) {
            addCriterion("publish_time in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotIn(List<Date> values) {
            addCriterion("publish_time not in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeBetween(Date value1, Date value2) {
            addCriterion("publish_time between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotBetween(Date value1, Date value2) {
            addCriterion("publish_time not between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andTestStatusIsNull() {
            addCriterion("test_status is null");
            return (Criteria) this;
        }

        public Criteria andTestStatusIsNotNull() {
            addCriterion("test_status is not null");
            return (Criteria) this;
        }

        public Criteria andTestStatusEqualTo(Integer value) {
            addCriterion("test_status =", value, "testStatus");
            return (Criteria) this;
        }

        public Criteria andTestStatusNotEqualTo(Integer value) {
            addCriterion("test_status <>", value, "testStatus");
            return (Criteria) this;
        }

        public Criteria andTestStatusGreaterThan(Integer value) {
            addCriterion("test_status >", value, "testStatus");
            return (Criteria) this;
        }

        public Criteria andTestStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("test_status >=", value, "testStatus");
            return (Criteria) this;
        }

        public Criteria andTestStatusLessThan(Integer value) {
            addCriterion("test_status <", value, "testStatus");
            return (Criteria) this;
        }

        public Criteria andTestStatusLessThanOrEqualTo(Integer value) {
            addCriterion("test_status <=", value, "testStatus");
            return (Criteria) this;
        }

        public Criteria andTestStatusIn(List<Integer> values) {
            addCriterion("test_status in", values, "testStatus");
            return (Criteria) this;
        }

        public Criteria andTestStatusNotIn(List<Integer> values) {
            addCriterion("test_status not in", values, "testStatus");
            return (Criteria) this;
        }

        public Criteria andTestStatusBetween(Integer value1, Integer value2) {
            addCriterion("test_status between", value1, value2, "testStatus");
            return (Criteria) this;
        }

        public Criteria andTestStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("test_status not between", value1, value2, "testStatus");
            return (Criteria) this;
        }

        public Criteria andNeedPointIsNull() {
            addCriterion("need_point is null");
            return (Criteria) this;
        }

        public Criteria andNeedPointIsNotNull() {
            addCriterion("need_point is not null");
            return (Criteria) this;
        }

        public Criteria andNeedPointEqualTo(Integer value) {
            addCriterion("need_point =", value, "needPoint");
            return (Criteria) this;
        }

        public Criteria andNeedPointNotEqualTo(Integer value) {
            addCriterion("need_point <>", value, "needPoint");
            return (Criteria) this;
        }

        public Criteria andNeedPointGreaterThan(Integer value) {
            addCriterion("need_point >", value, "needPoint");
            return (Criteria) this;
        }

        public Criteria andNeedPointGreaterThanOrEqualTo(Integer value) {
            addCriterion("need_point >=", value, "needPoint");
            return (Criteria) this;
        }

        public Criteria andNeedPointLessThan(Integer value) {
            addCriterion("need_point <", value, "needPoint");
            return (Criteria) this;
        }

        public Criteria andNeedPointLessThanOrEqualTo(Integer value) {
            addCriterion("need_point <=", value, "needPoint");
            return (Criteria) this;
        }

        public Criteria andNeedPointIn(List<Integer> values) {
            addCriterion("need_point in", values, "needPoint");
            return (Criteria) this;
        }

        public Criteria andNeedPointNotIn(List<Integer> values) {
            addCriterion("need_point not in", values, "needPoint");
            return (Criteria) this;
        }

        public Criteria andNeedPointBetween(Integer value1, Integer value2) {
            addCriterion("need_point between", value1, value2, "needPoint");
            return (Criteria) this;
        }

        public Criteria andNeedPointNotBetween(Integer value1, Integer value2) {
            addCriterion("need_point not between", value1, value2, "needPoint");
            return (Criteria) this;
        }

        public Criteria andGetPointIsNull() {
            addCriterion("get_point is null");
            return (Criteria) this;
        }

        public Criteria andGetPointIsNotNull() {
            addCriterion("get_point is not null");
            return (Criteria) this;
        }

        public Criteria andGetPointEqualTo(Integer value) {
            addCriterion("get_point =", value, "getPoint");
            return (Criteria) this;
        }

        public Criteria andGetPointNotEqualTo(Integer value) {
            addCriterion("get_point <>", value, "getPoint");
            return (Criteria) this;
        }

        public Criteria andGetPointGreaterThan(Integer value) {
            addCriterion("get_point >", value, "getPoint");
            return (Criteria) this;
        }

        public Criteria andGetPointGreaterThanOrEqualTo(Integer value) {
            addCriterion("get_point >=", value, "getPoint");
            return (Criteria) this;
        }

        public Criteria andGetPointLessThan(Integer value) {
            addCriterion("get_point <", value, "getPoint");
            return (Criteria) this;
        }

        public Criteria andGetPointLessThanOrEqualTo(Integer value) {
            addCriterion("get_point <=", value, "getPoint");
            return (Criteria) this;
        }

        public Criteria andGetPointIn(List<Integer> values) {
            addCriterion("get_point in", values, "getPoint");
            return (Criteria) this;
        }

        public Criteria andGetPointNotIn(List<Integer> values) {
            addCriterion("get_point not in", values, "getPoint");
            return (Criteria) this;
        }

        public Criteria andGetPointBetween(Integer value1, Integer value2) {
            addCriterion("get_point between", value1, value2, "getPoint");
            return (Criteria) this;
        }

        public Criteria andGetPointNotBetween(Integer value1, Integer value2) {
            addCriterion("get_point not between", value1, value2, "getPoint");
            return (Criteria) this;
        }

        public Criteria andCoverUrlIsNull() {
            addCriterion("cover_url is null");
            return (Criteria) this;
        }

        public Criteria andCoverUrlIsNotNull() {
            addCriterion("cover_url is not null");
            return (Criteria) this;
        }

        public Criteria andCoverUrlEqualTo(String value) {
            addCriterion("cover_url =", value, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlNotEqualTo(String value) {
            addCriterion("cover_url <>", value, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlGreaterThan(String value) {
            addCriterion("cover_url >", value, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlGreaterThanOrEqualTo(String value) {
            addCriterion("cover_url >=", value, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlLessThan(String value) {
            addCriterion("cover_url <", value, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlLessThanOrEqualTo(String value) {
            addCriterion("cover_url <=", value, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlLike(String value) {
            addCriterion("cover_url like", value, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlNotLike(String value) {
            addCriterion("cover_url not like", value, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlIn(List<String> values) {
            addCriterion("cover_url in", values, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlNotIn(List<String> values) {
            addCriterion("cover_url not in", values, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlBetween(String value1, String value2) {
            addCriterion("cover_url between", value1, value2, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlNotBetween(String value1, String value2) {
            addCriterion("cover_url not between", value1, value2, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlIsNull() {
            addCriterion("image_url is null");
            return (Criteria) this;
        }

        public Criteria andImageUrlIsNotNull() {
            addCriterion("image_url is not null");
            return (Criteria) this;
        }

        public Criteria andImageUrlEqualTo(String value) {
            addCriterion("image_url =", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotEqualTo(String value) {
            addCriterion("image_url <>", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlGreaterThan(String value) {
            addCriterion("image_url >", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("image_url >=", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlLessThan(String value) {
            addCriterion("image_url <", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlLessThanOrEqualTo(String value) {
            addCriterion("image_url <=", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlLike(String value) {
            addCriterion("image_url like", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotLike(String value) {
            addCriterion("image_url not like", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlIn(List<String> values) {
            addCriterion("image_url in", values, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotIn(List<String> values) {
            addCriterion("image_url not in", values, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlBetween(String value1, String value2) {
            addCriterion("image_url between", value1, value2, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotBetween(String value1, String value2) {
            addCriterion("image_url not between", value1, value2, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}