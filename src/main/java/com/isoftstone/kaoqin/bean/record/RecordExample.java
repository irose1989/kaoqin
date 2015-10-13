package com.isoftstone.kaoqin.bean.record;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RecordExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNull() {
            addCriterion("project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(Integer value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(Integer value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(Integer value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(Integer value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(Integer value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<Integer> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<Integer> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(Integer value1, Integer value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("project_id not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andInJobIsNull() {
            addCriterion("in_job is null");
            return (Criteria) this;
        }

        public Criteria andInJobIsNotNull() {
            addCriterion("in_job is not null");
            return (Criteria) this;
        }

        public Criteria andInJobEqualTo(Date value) {
            addCriterionForJDBCDate("in_job =", value, "inJob");
            return (Criteria) this;
        }

        public Criteria andInJobNotEqualTo(Date value) {
            addCriterionForJDBCDate("in_job <>", value, "inJob");
            return (Criteria) this;
        }

        public Criteria andInJobGreaterThan(Date value) {
            addCriterionForJDBCDate("in_job >", value, "inJob");
            return (Criteria) this;
        }

        public Criteria andInJobGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("in_job >=", value, "inJob");
            return (Criteria) this;
        }

        public Criteria andInJobLessThan(Date value) {
            addCriterionForJDBCDate("in_job <", value, "inJob");
            return (Criteria) this;
        }

        public Criteria andInJobLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("in_job <=", value, "inJob");
            return (Criteria) this;
        }

        public Criteria andInJobIn(List<Date> values) {
            addCriterionForJDBCDate("in_job in", values, "inJob");
            return (Criteria) this;
        }

        public Criteria andInJobNotIn(List<Date> values) {
            addCriterionForJDBCDate("in_job not in", values, "inJob");
            return (Criteria) this;
        }

        public Criteria andInJobBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("in_job between", value1, value2, "inJob");
            return (Criteria) this;
        }

        public Criteria andInJobNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("in_job not between", value1, value2, "inJob");
            return (Criteria) this;
        }

        public Criteria andOutJobIsNull() {
            addCriterion("out_job is null");
            return (Criteria) this;
        }

        public Criteria andOutJobIsNotNull() {
            addCriterion("out_job is not null");
            return (Criteria) this;
        }

        public Criteria andOutJobEqualTo(Date value) {
            addCriterionForJDBCDate("out_job =", value, "outJob");
            return (Criteria) this;
        }

        public Criteria andOutJobNotEqualTo(Date value) {
            addCriterionForJDBCDate("out_job <>", value, "outJob");
            return (Criteria) this;
        }

        public Criteria andOutJobGreaterThan(Date value) {
            addCriterionForJDBCDate("out_job >", value, "outJob");
            return (Criteria) this;
        }

        public Criteria andOutJobGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("out_job >=", value, "outJob");
            return (Criteria) this;
        }

        public Criteria andOutJobLessThan(Date value) {
            addCriterionForJDBCDate("out_job <", value, "outJob");
            return (Criteria) this;
        }

        public Criteria andOutJobLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("out_job <=", value, "outJob");
            return (Criteria) this;
        }

        public Criteria andOutJobIn(List<Date> values) {
            addCriterionForJDBCDate("out_job in", values, "outJob");
            return (Criteria) this;
        }

        public Criteria andOutJobNotIn(List<Date> values) {
            addCriterionForJDBCDate("out_job not in", values, "outJob");
            return (Criteria) this;
        }

        public Criteria andOutJobBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("out_job between", value1, value2, "outJob");
            return (Criteria) this;
        }

        public Criteria andOutJobNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("out_job not between", value1, value2, "outJob");
            return (Criteria) this;
        }

        public Criteria andInProjectIsNull() {
            addCriterion("in_project is null");
            return (Criteria) this;
        }

        public Criteria andInProjectIsNotNull() {
            addCriterion("in_project is not null");
            return (Criteria) this;
        }

        public Criteria andInProjectEqualTo(Date value) {
            addCriterionForJDBCDate("in_project =", value, "inProject");
            return (Criteria) this;
        }

        public Criteria andInProjectNotEqualTo(Date value) {
            addCriterionForJDBCDate("in_project <>", value, "inProject");
            return (Criteria) this;
        }

        public Criteria andInProjectGreaterThan(Date value) {
            addCriterionForJDBCDate("in_project >", value, "inProject");
            return (Criteria) this;
        }

        public Criteria andInProjectGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("in_project >=", value, "inProject");
            return (Criteria) this;
        }

        public Criteria andInProjectLessThan(Date value) {
            addCriterionForJDBCDate("in_project <", value, "inProject");
            return (Criteria) this;
        }

        public Criteria andInProjectLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("in_project <=", value, "inProject");
            return (Criteria) this;
        }

        public Criteria andInProjectIn(List<Date> values) {
            addCriterionForJDBCDate("in_project in", values, "inProject");
            return (Criteria) this;
        }

        public Criteria andInProjectNotIn(List<Date> values) {
            addCriterionForJDBCDate("in_project not in", values, "inProject");
            return (Criteria) this;
        }

        public Criteria andInProjectBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("in_project between", value1, value2, "inProject");
            return (Criteria) this;
        }

        public Criteria andInProjectNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("in_project not between", value1, value2, "inProject");
            return (Criteria) this;
        }

        public Criteria andOutProjectIsNull() {
            addCriterion("out_project is null");
            return (Criteria) this;
        }

        public Criteria andOutProjectIsNotNull() {
            addCriterion("out_project is not null");
            return (Criteria) this;
        }

        public Criteria andOutProjectEqualTo(Date value) {
            addCriterionForJDBCDate("out_project =", value, "outProject");
            return (Criteria) this;
        }

        public Criteria andOutProjectNotEqualTo(Date value) {
            addCriterionForJDBCDate("out_project <>", value, "outProject");
            return (Criteria) this;
        }

        public Criteria andOutProjectGreaterThan(Date value) {
            addCriterionForJDBCDate("out_project >", value, "outProject");
            return (Criteria) this;
        }

        public Criteria andOutProjectGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("out_project >=", value, "outProject");
            return (Criteria) this;
        }

        public Criteria andOutProjectLessThan(Date value) {
            addCriterionForJDBCDate("out_project <", value, "outProject");
            return (Criteria) this;
        }

        public Criteria andOutProjectLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("out_project <=", value, "outProject");
            return (Criteria) this;
        }

        public Criteria andOutProjectIn(List<Date> values) {
            addCriterionForJDBCDate("out_project in", values, "outProject");
            return (Criteria) this;
        }

        public Criteria andOutProjectNotIn(List<Date> values) {
            addCriterionForJDBCDate("out_project not in", values, "outProject");
            return (Criteria) this;
        }

        public Criteria andOutProjectBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("out_project between", value1, value2, "outProject");
            return (Criteria) this;
        }

        public Criteria andOutProjectNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("out_project not between", value1, value2, "outProject");
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