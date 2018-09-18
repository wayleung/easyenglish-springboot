package com.easyenglish.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuestionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QuestionExample() {
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

        public Criteria andQIdIsNull() {
            addCriterion("q_id is null");
            return (Criteria) this;
        }

        public Criteria andQIdIsNotNull() {
            addCriterion("q_id is not null");
            return (Criteria) this;
        }

        public Criteria andQIdEqualTo(Integer value) {
            addCriterion("q_id =", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdNotEqualTo(Integer value) {
            addCriterion("q_id <>", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdGreaterThan(Integer value) {
            addCriterion("q_id >", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("q_id >=", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdLessThan(Integer value) {
            addCriterion("q_id <", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdLessThanOrEqualTo(Integer value) {
            addCriterion("q_id <=", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdIn(List<Integer> values) {
            addCriterion("q_id in", values, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdNotIn(List<Integer> values) {
            addCriterion("q_id not in", values, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdBetween(Integer value1, Integer value2) {
            addCriterion("q_id between", value1, value2, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdNotBetween(Integer value1, Integer value2) {
            addCriterion("q_id not between", value1, value2, "qId");
            return (Criteria) this;
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

        public Criteria andQuestionNumberIsNull() {
            addCriterion("question_number is null");
            return (Criteria) this;
        }

        public Criteria andQuestionNumberIsNotNull() {
            addCriterion("question_number is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionNumberEqualTo(Integer value) {
            addCriterion("question_number =", value, "questionNumber");
            return (Criteria) this;
        }

        public Criteria andQuestionNumberNotEqualTo(Integer value) {
            addCriterion("question_number <>", value, "questionNumber");
            return (Criteria) this;
        }

        public Criteria andQuestionNumberGreaterThan(Integer value) {
            addCriterion("question_number >", value, "questionNumber");
            return (Criteria) this;
        }

        public Criteria andQuestionNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("question_number >=", value, "questionNumber");
            return (Criteria) this;
        }

        public Criteria andQuestionNumberLessThan(Integer value) {
            addCriterion("question_number <", value, "questionNumber");
            return (Criteria) this;
        }

        public Criteria andQuestionNumberLessThanOrEqualTo(Integer value) {
            addCriterion("question_number <=", value, "questionNumber");
            return (Criteria) this;
        }

        public Criteria andQuestionNumberIn(List<Integer> values) {
            addCriterion("question_number in", values, "questionNumber");
            return (Criteria) this;
        }

        public Criteria andQuestionNumberNotIn(List<Integer> values) {
            addCriterion("question_number not in", values, "questionNumber");
            return (Criteria) this;
        }

        public Criteria andQuestionNumberBetween(Integer value1, Integer value2) {
            addCriterion("question_number between", value1, value2, "questionNumber");
            return (Criteria) this;
        }

        public Criteria andQuestionNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("question_number not between", value1, value2, "questionNumber");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeIsNull() {
            addCriterion("question_type is null");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeIsNotNull() {
            addCriterion("question_type is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeEqualTo(Integer value) {
            addCriterion("question_type =", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeNotEqualTo(Integer value) {
            addCriterion("question_type <>", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeGreaterThan(Integer value) {
            addCriterion("question_type >", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("question_type >=", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeLessThan(Integer value) {
            addCriterion("question_type <", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeLessThanOrEqualTo(Integer value) {
            addCriterion("question_type <=", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeIn(List<Integer> values) {
            addCriterion("question_type in", values, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeNotIn(List<Integer> values) {
            addCriterion("question_type not in", values, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeBetween(Integer value1, Integer value2) {
            addCriterion("question_type between", value1, value2, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("question_type not between", value1, value2, "questionType");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNull() {
            addCriterion("subject is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNotNull() {
            addCriterion("subject is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectEqualTo(String value) {
            addCriterion("subject =", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotEqualTo(String value) {
            addCriterion("subject <>", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThan(String value) {
            addCriterion("subject >", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThanOrEqualTo(String value) {
            addCriterion("subject >=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThan(String value) {
            addCriterion("subject <", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThanOrEqualTo(String value) {
            addCriterion("subject <=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLike(String value) {
            addCriterion("subject like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotLike(String value) {
            addCriterion("subject not like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectIn(List<String> values) {
            addCriterion("subject in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotIn(List<String> values) {
            addCriterion("subject not in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectBetween(String value1, String value2) {
            addCriterion("subject between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotBetween(String value1, String value2) {
            addCriterion("subject not between", value1, value2, "subject");
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

        public Criteria andFillInAnswerIsNull() {
            addCriterion("fill_in_answer is null");
            return (Criteria) this;
        }

        public Criteria andFillInAnswerIsNotNull() {
            addCriterion("fill_in_answer is not null");
            return (Criteria) this;
        }

        public Criteria andFillInAnswerEqualTo(String value) {
            addCriterion("fill_in_answer =", value, "fillInAnswer");
            return (Criteria) this;
        }

        public Criteria andFillInAnswerNotEqualTo(String value) {
            addCriterion("fill_in_answer <>", value, "fillInAnswer");
            return (Criteria) this;
        }

        public Criteria andFillInAnswerGreaterThan(String value) {
            addCriterion("fill_in_answer >", value, "fillInAnswer");
            return (Criteria) this;
        }

        public Criteria andFillInAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("fill_in_answer >=", value, "fillInAnswer");
            return (Criteria) this;
        }

        public Criteria andFillInAnswerLessThan(String value) {
            addCriterion("fill_in_answer <", value, "fillInAnswer");
            return (Criteria) this;
        }

        public Criteria andFillInAnswerLessThanOrEqualTo(String value) {
            addCriterion("fill_in_answer <=", value, "fillInAnswer");
            return (Criteria) this;
        }

        public Criteria andFillInAnswerLike(String value) {
            addCriterion("fill_in_answer like", value, "fillInAnswer");
            return (Criteria) this;
        }

        public Criteria andFillInAnswerNotLike(String value) {
            addCriterion("fill_in_answer not like", value, "fillInAnswer");
            return (Criteria) this;
        }

        public Criteria andFillInAnswerIn(List<String> values) {
            addCriterion("fill_in_answer in", values, "fillInAnswer");
            return (Criteria) this;
        }

        public Criteria andFillInAnswerNotIn(List<String> values) {
            addCriterion("fill_in_answer not in", values, "fillInAnswer");
            return (Criteria) this;
        }

        public Criteria andFillInAnswerBetween(String value1, String value2) {
            addCriterion("fill_in_answer between", value1, value2, "fillInAnswer");
            return (Criteria) this;
        }

        public Criteria andFillInAnswerNotBetween(String value1, String value2) {
            addCriterion("fill_in_answer not between", value1, value2, "fillInAnswer");
            return (Criteria) this;
        }

        public Criteria andOptionAnswerIsNull() {
            addCriterion("option_answer is null");
            return (Criteria) this;
        }

        public Criteria andOptionAnswerIsNotNull() {
            addCriterion("option_answer is not null");
            return (Criteria) this;
        }

        public Criteria andOptionAnswerEqualTo(String value) {
            addCriterion("option_answer =", value, "optionAnswer");
            return (Criteria) this;
        }

        public Criteria andOptionAnswerNotEqualTo(String value) {
            addCriterion("option_answer <>", value, "optionAnswer");
            return (Criteria) this;
        }

        public Criteria andOptionAnswerGreaterThan(String value) {
            addCriterion("option_answer >", value, "optionAnswer");
            return (Criteria) this;
        }

        public Criteria andOptionAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("option_answer >=", value, "optionAnswer");
            return (Criteria) this;
        }

        public Criteria andOptionAnswerLessThan(String value) {
            addCriterion("option_answer <", value, "optionAnswer");
            return (Criteria) this;
        }

        public Criteria andOptionAnswerLessThanOrEqualTo(String value) {
            addCriterion("option_answer <=", value, "optionAnswer");
            return (Criteria) this;
        }

        public Criteria andOptionAnswerLike(String value) {
            addCriterion("option_answer like", value, "optionAnswer");
            return (Criteria) this;
        }

        public Criteria andOptionAnswerNotLike(String value) {
            addCriterion("option_answer not like", value, "optionAnswer");
            return (Criteria) this;
        }

        public Criteria andOptionAnswerIn(List<String> values) {
            addCriterion("option_answer in", values, "optionAnswer");
            return (Criteria) this;
        }

        public Criteria andOptionAnswerNotIn(List<String> values) {
            addCriterion("option_answer not in", values, "optionAnswer");
            return (Criteria) this;
        }

        public Criteria andOptionAnswerBetween(String value1, String value2) {
            addCriterion("option_answer between", value1, value2, "optionAnswer");
            return (Criteria) this;
        }

        public Criteria andOptionAnswerNotBetween(String value1, String value2) {
            addCriterion("option_answer not between", value1, value2, "optionAnswer");
            return (Criteria) this;
        }

        public Criteria andTrueFalseAnswerIsNull() {
            addCriterion("true_false_answer is null");
            return (Criteria) this;
        }

        public Criteria andTrueFalseAnswerIsNotNull() {
            addCriterion("true_false_answer is not null");
            return (Criteria) this;
        }

        public Criteria andTrueFalseAnswerEqualTo(Integer value) {
            addCriterion("true_false_answer =", value, "trueFalseAnswer");
            return (Criteria) this;
        }

        public Criteria andTrueFalseAnswerNotEqualTo(Integer value) {
            addCriterion("true_false_answer <>", value, "trueFalseAnswer");
            return (Criteria) this;
        }

        public Criteria andTrueFalseAnswerGreaterThan(Integer value) {
            addCriterion("true_false_answer >", value, "trueFalseAnswer");
            return (Criteria) this;
        }

        public Criteria andTrueFalseAnswerGreaterThanOrEqualTo(Integer value) {
            addCriterion("true_false_answer >=", value, "trueFalseAnswer");
            return (Criteria) this;
        }

        public Criteria andTrueFalseAnswerLessThan(Integer value) {
            addCriterion("true_false_answer <", value, "trueFalseAnswer");
            return (Criteria) this;
        }

        public Criteria andTrueFalseAnswerLessThanOrEqualTo(Integer value) {
            addCriterion("true_false_answer <=", value, "trueFalseAnswer");
            return (Criteria) this;
        }

        public Criteria andTrueFalseAnswerIn(List<Integer> values) {
            addCriterion("true_false_answer in", values, "trueFalseAnswer");
            return (Criteria) this;
        }

        public Criteria andTrueFalseAnswerNotIn(List<Integer> values) {
            addCriterion("true_false_answer not in", values, "trueFalseAnswer");
            return (Criteria) this;
        }

        public Criteria andTrueFalseAnswerBetween(Integer value1, Integer value2) {
            addCriterion("true_false_answer between", value1, value2, "trueFalseAnswer");
            return (Criteria) this;
        }

        public Criteria andTrueFalseAnswerNotBetween(Integer value1, Integer value2) {
            addCriterion("true_false_answer not between", value1, value2, "trueFalseAnswer");
            return (Criteria) this;
        }

        public Criteria andImgUrlIsNull() {
            addCriterion("img_url is null");
            return (Criteria) this;
        }

        public Criteria andImgUrlIsNotNull() {
            addCriterion("img_url is not null");
            return (Criteria) this;
        }

        public Criteria andImgUrlEqualTo(String value) {
            addCriterion("img_url =", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotEqualTo(String value) {
            addCriterion("img_url <>", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlGreaterThan(String value) {
            addCriterion("img_url >", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("img_url >=", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLessThan(String value) {
            addCriterion("img_url <", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLessThanOrEqualTo(String value) {
            addCriterion("img_url <=", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLike(String value) {
            addCriterion("img_url like", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotLike(String value) {
            addCriterion("img_url not like", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlIn(List<String> values) {
            addCriterion("img_url in", values, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotIn(List<String> values) {
            addCriterion("img_url not in", values, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlBetween(String value1, String value2) {
            addCriterion("img_url between", value1, value2, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotBetween(String value1, String value2) {
            addCriterion("img_url not between", value1, value2, "imgUrl");
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

        public Criteria andCreateAdminIsNull() {
            addCriterion("create_admin is null");
            return (Criteria) this;
        }

        public Criteria andCreateAdminIsNotNull() {
            addCriterion("create_admin is not null");
            return (Criteria) this;
        }

        public Criteria andCreateAdminEqualTo(String value) {
            addCriterion("create_admin =", value, "createAdmin");
            return (Criteria) this;
        }

        public Criteria andCreateAdminNotEqualTo(String value) {
            addCriterion("create_admin <>", value, "createAdmin");
            return (Criteria) this;
        }

        public Criteria andCreateAdminGreaterThan(String value) {
            addCriterion("create_admin >", value, "createAdmin");
            return (Criteria) this;
        }

        public Criteria andCreateAdminGreaterThanOrEqualTo(String value) {
            addCriterion("create_admin >=", value, "createAdmin");
            return (Criteria) this;
        }

        public Criteria andCreateAdminLessThan(String value) {
            addCriterion("create_admin <", value, "createAdmin");
            return (Criteria) this;
        }

        public Criteria andCreateAdminLessThanOrEqualTo(String value) {
            addCriterion("create_admin <=", value, "createAdmin");
            return (Criteria) this;
        }

        public Criteria andCreateAdminLike(String value) {
            addCriterion("create_admin like", value, "createAdmin");
            return (Criteria) this;
        }

        public Criteria andCreateAdminNotLike(String value) {
            addCriterion("create_admin not like", value, "createAdmin");
            return (Criteria) this;
        }

        public Criteria andCreateAdminIn(List<String> values) {
            addCriterion("create_admin in", values, "createAdmin");
            return (Criteria) this;
        }

        public Criteria andCreateAdminNotIn(List<String> values) {
            addCriterion("create_admin not in", values, "createAdmin");
            return (Criteria) this;
        }

        public Criteria andCreateAdminBetween(String value1, String value2) {
            addCriterion("create_admin between", value1, value2, "createAdmin");
            return (Criteria) this;
        }

        public Criteria andCreateAdminNotBetween(String value1, String value2) {
            addCriterion("create_admin not between", value1, value2, "createAdmin");
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