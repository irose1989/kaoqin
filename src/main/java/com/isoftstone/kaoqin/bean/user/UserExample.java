package com.isoftstone.kaoqin.bean.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andJobStateIsNull() {
            addCriterion("job_state is null");
            return (Criteria) this;
        }

        public Criteria andJobStateIsNotNull() {
            addCriterion("job_state is not null");
            return (Criteria) this;
        }

        public Criteria andJobStateEqualTo(Integer value) {
            addCriterion("job_state =", value, "jobState");
            return (Criteria) this;
        }

        public Criteria andJobStateNotEqualTo(Integer value) {
            addCriterion("job_state <>", value, "jobState");
            return (Criteria) this;
        }

        public Criteria andJobStateGreaterThan(Integer value) {
            addCriterion("job_state >", value, "jobState");
            return (Criteria) this;
        }

        public Criteria andJobStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("job_state >=", value, "jobState");
            return (Criteria) this;
        }

        public Criteria andJobStateLessThan(Integer value) {
            addCriterion("job_state <", value, "jobState");
            return (Criteria) this;
        }

        public Criteria andJobStateLessThanOrEqualTo(Integer value) {
            addCriterion("job_state <=", value, "jobState");
            return (Criteria) this;
        }

        public Criteria andJobStateIn(List<Integer> values) {
            addCriterion("job_state in", values, "jobState");
            return (Criteria) this;
        }

        public Criteria andJobStateNotIn(List<Integer> values) {
            addCriterion("job_state not in", values, "jobState");
            return (Criteria) this;
        }

        public Criteria andJobStateBetween(Integer value1, Integer value2) {
            addCriterion("job_state between", value1, value2, "jobState");
            return (Criteria) this;
        }

        public Criteria andJobStateNotBetween(Integer value1, Integer value2) {
            addCriterion("job_state not between", value1, value2, "jobState");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNull() {
            addCriterion("real_name is null");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNotNull() {
            addCriterion("real_name is not null");
            return (Criteria) this;
        }

        public Criteria andRealNameEqualTo(String value) {
            addCriterion("real_name =", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotEqualTo(String value) {
            addCriterion("real_name <>", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThan(String value) {
            addCriterion("real_name >", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("real_name >=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThan(String value) {
            addCriterion("real_name <", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThanOrEqualTo(String value) {
            addCriterion("real_name <=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLike(String value) {
            addCriterion("real_name like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotLike(String value) {
            addCriterion("real_name not like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameIn(List<String> values) {
            addCriterion("real_name in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotIn(List<String> values) {
            addCriterion("real_name not in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameBetween(String value1, String value2) {
            addCriterion("real_name between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotBetween(String value1, String value2) {
            addCriterion("real_name not between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNull() {
            addCriterion("telephone is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            addCriterion("telephone is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            addCriterion("telephone =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            addCriterion("telephone <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            addCriterion("telephone >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("telephone >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(String value) {
            addCriterion("telephone <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("telephone <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLike(String value) {
            addCriterion("telephone like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotLike(String value) {
            addCriterion("telephone not like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(List<String> values) {
            addCriterion("telephone in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            addCriterion("telephone not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            addCriterion("telephone between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("telephone not between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andRoleidIsNull() {
            addCriterion("roleId is null");
            return (Criteria) this;
        }

        public Criteria andRoleidIsNotNull() {
            addCriterion("roleId is not null");
            return (Criteria) this;
        }

        public Criteria andRoleidEqualTo(Integer value) {
            addCriterion("roleId =", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotEqualTo(Integer value) {
            addCriterion("roleId <>", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidGreaterThan(Integer value) {
            addCriterion("roleId >", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidGreaterThanOrEqualTo(Integer value) {
            addCriterion("roleId >=", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidLessThan(Integer value) {
            addCriterion("roleId <", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidLessThanOrEqualTo(Integer value) {
            addCriterion("roleId <=", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidIn(List<Integer> values) {
            addCriterion("roleId in", values, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotIn(List<Integer> values) {
            addCriterion("roleId not in", values, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidBetween(Integer value1, Integer value2) {
            addCriterion("roleId between", value1, value2, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotBetween(Integer value1, Integer value2) {
            addCriterion("roleId not between", value1, value2, "roleid");
            return (Criteria) this;
        }

        public Criteria andJobIsNull() {
            addCriterion("job is null");
            return (Criteria) this;
        }

        public Criteria andJobIsNotNull() {
            addCriterion("job is not null");
            return (Criteria) this;
        }

        public Criteria andJobEqualTo(Integer value) {
            addCriterion("job =", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotEqualTo(Integer value) {
            addCriterion("job <>", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobGreaterThan(Integer value) {
            addCriterion("job >", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobGreaterThanOrEqualTo(Integer value) {
            addCriterion("job >=", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobLessThan(Integer value) {
            addCriterion("job <", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobLessThanOrEqualTo(Integer value) {
            addCriterion("job <=", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobIn(List<Integer> values) {
            addCriterion("job in", values, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotIn(List<Integer> values) {
            addCriterion("job not in", values, "job");
            return (Criteria) this;
        }

        public Criteria andJobBetween(Integer value1, Integer value2) {
            addCriterion("job between", value1, value2, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotBetween(Integer value1, Integer value2) {
            addCriterion("job not between", value1, value2, "job");
            return (Criteria) this;
        }

        public Criteria andProfessionalSkillIsNull() {
            addCriterion("professional_skill is null");
            return (Criteria) this;
        }

        public Criteria andProfessionalSkillIsNotNull() {
            addCriterion("professional_skill is not null");
            return (Criteria) this;
        }

        public Criteria andProfessionalSkillEqualTo(Integer value) {
            addCriterion("professional_skill =", value, "professionalSkill");
            return (Criteria) this;
        }

        public Criteria andProfessionalSkillNotEqualTo(Integer value) {
            addCriterion("professional_skill <>", value, "professionalSkill");
            return (Criteria) this;
        }

        public Criteria andProfessionalSkillGreaterThan(Integer value) {
            addCriterion("professional_skill >", value, "professionalSkill");
            return (Criteria) this;
        }

        public Criteria andProfessionalSkillGreaterThanOrEqualTo(Integer value) {
            addCriterion("professional_skill >=", value, "professionalSkill");
            return (Criteria) this;
        }

        public Criteria andProfessionalSkillLessThan(Integer value) {
            addCriterion("professional_skill <", value, "professionalSkill");
            return (Criteria) this;
        }

        public Criteria andProfessionalSkillLessThanOrEqualTo(Integer value) {
            addCriterion("professional_skill <=", value, "professionalSkill");
            return (Criteria) this;
        }

        public Criteria andProfessionalSkillIn(List<Integer> values) {
            addCriterion("professional_skill in", values, "professionalSkill");
            return (Criteria) this;
        }

        public Criteria andProfessionalSkillNotIn(List<Integer> values) {
            addCriterion("professional_skill not in", values, "professionalSkill");
            return (Criteria) this;
        }

        public Criteria andProfessionalSkillBetween(Integer value1, Integer value2) {
            addCriterion("professional_skill between", value1, value2, "professionalSkill");
            return (Criteria) this;
        }

        public Criteria andProfessionalSkillNotBetween(Integer value1, Integer value2) {
            addCriterion("professional_skill not between", value1, value2, "professionalSkill");
            return (Criteria) this;
        }

        public Criteria andSkillLeverIsNull() {
            addCriterion("skill_lever is null");
            return (Criteria) this;
        }

        public Criteria andSkillLeverIsNotNull() {
            addCriterion("skill_lever is not null");
            return (Criteria) this;
        }

        public Criteria andSkillLeverEqualTo(Integer value) {
            addCriterion("skill_lever =", value, "skillLever");
            return (Criteria) this;
        }

        public Criteria andSkillLeverNotEqualTo(Integer value) {
            addCriterion("skill_lever <>", value, "skillLever");
            return (Criteria) this;
        }

        public Criteria andSkillLeverGreaterThan(Integer value) {
            addCriterion("skill_lever >", value, "skillLever");
            return (Criteria) this;
        }

        public Criteria andSkillLeverGreaterThanOrEqualTo(Integer value) {
            addCriterion("skill_lever >=", value, "skillLever");
            return (Criteria) this;
        }

        public Criteria andSkillLeverLessThan(Integer value) {
            addCriterion("skill_lever <", value, "skillLever");
            return (Criteria) this;
        }

        public Criteria andSkillLeverLessThanOrEqualTo(Integer value) {
            addCriterion("skill_lever <=", value, "skillLever");
            return (Criteria) this;
        }

        public Criteria andSkillLeverIn(List<Integer> values) {
            addCriterion("skill_lever in", values, "skillLever");
            return (Criteria) this;
        }

        public Criteria andSkillLeverNotIn(List<Integer> values) {
            addCriterion("skill_lever not in", values, "skillLever");
            return (Criteria) this;
        }

        public Criteria andSkillLeverBetween(Integer value1, Integer value2) {
            addCriterion("skill_lever between", value1, value2, "skillLever");
            return (Criteria) this;
        }

        public Criteria andSkillLeverNotBetween(Integer value1, Integer value2) {
            addCriterion("skill_lever not between", value1, value2, "skillLever");
            return (Criteria) this;
        }

        public Criteria andLocationIsNull() {
            addCriterion("location is null");
            return (Criteria) this;
        }

        public Criteria andLocationIsNotNull() {
            addCriterion("location is not null");
            return (Criteria) this;
        }

        public Criteria andLocationEqualTo(String value) {
            addCriterion("location =", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotEqualTo(String value) {
            addCriterion("location <>", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThan(String value) {
            addCriterion("location >", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThanOrEqualTo(String value) {
            addCriterion("location >=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThan(String value) {
            addCriterion("location <", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThanOrEqualTo(String value) {
            addCriterion("location <=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLike(String value) {
            addCriterion("location like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotLike(String value) {
            addCriterion("location not like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationIn(List<String> values) {
            addCriterion("location in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotIn(List<String> values) {
            addCriterion("location not in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationBetween(String value1, String value2) {
            addCriterion("location between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotBetween(String value1, String value2) {
            addCriterion("location not between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andOnTheJobIsNull() {
            addCriterion("on_the_job is null");
            return (Criteria) this;
        }

        public Criteria andOnTheJobIsNotNull() {
            addCriterion("on_the_job is not null");
            return (Criteria) this;
        }

        public Criteria andOnTheJobEqualTo(String value) {
            addCriterion("on_the_job =", value, "onTheJob");
            return (Criteria) this;
        }

        public Criteria andOnTheJobNotEqualTo(String value) {
            addCriterion("on_the_job <>", value, "onTheJob");
            return (Criteria) this;
        }

        public Criteria andOnTheJobGreaterThan(String value) {
            addCriterion("on_the_job >", value, "onTheJob");
            return (Criteria) this;
        }

        public Criteria andOnTheJobGreaterThanOrEqualTo(String value) {
            addCriterion("on_the_job >=", value, "onTheJob");
            return (Criteria) this;
        }

        public Criteria andOnTheJobLessThan(String value) {
            addCriterion("on_the_job <", value, "onTheJob");
            return (Criteria) this;
        }

        public Criteria andOnTheJobLessThanOrEqualTo(String value) {
            addCriterion("on_the_job <=", value, "onTheJob");
            return (Criteria) this;
        }

        public Criteria andOnTheJobLike(String value) {
            addCriterion("on_the_job like", value, "onTheJob");
            return (Criteria) this;
        }

        public Criteria andOnTheJobNotLike(String value) {
            addCriterion("on_the_job not like", value, "onTheJob");
            return (Criteria) this;
        }

        public Criteria andOnTheJobIn(List<String> values) {
            addCriterion("on_the_job in", values, "onTheJob");
            return (Criteria) this;
        }

        public Criteria andOnTheJobNotIn(List<String> values) {
            addCriterion("on_the_job not in", values, "onTheJob");
            return (Criteria) this;
        }

        public Criteria andOnTheJobBetween(String value1, String value2) {
            addCriterion("on_the_job between", value1, value2, "onTheJob");
            return (Criteria) this;
        }

        public Criteria andOnTheJobNotBetween(String value1, String value2) {
            addCriterion("on_the_job not between", value1, value2, "onTheJob");
            return (Criteria) this;
        }

        public Criteria andHiredateIsNull() {
            addCriterion("hiredate is null");
            return (Criteria) this;
        }

        public Criteria andHiredateIsNotNull() {
            addCriterion("hiredate is not null");
            return (Criteria) this;
        }

        public Criteria andHiredateEqualTo(Date value) {
            addCriterionForJDBCDate("hiredate =", value, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateNotEqualTo(Date value) {
            addCriterionForJDBCDate("hiredate <>", value, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateGreaterThan(Date value) {
            addCriterionForJDBCDate("hiredate >", value, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("hiredate >=", value, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateLessThan(Date value) {
            addCriterionForJDBCDate("hiredate <", value, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("hiredate <=", value, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateIn(List<Date> values) {
            addCriterionForJDBCDate("hiredate in", values, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateNotIn(List<Date> values) {
            addCriterionForJDBCDate("hiredate not in", values, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("hiredate between", value1, value2, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("hiredate not between", value1, value2, "hiredate");
            return (Criteria) this;
        }

        public Criteria andDepartureDateIsNull() {
            addCriterion("departure_date is null");
            return (Criteria) this;
        }

        public Criteria andDepartureDateIsNotNull() {
            addCriterion("departure_date is not null");
            return (Criteria) this;
        }

        public Criteria andDepartureDateEqualTo(Date value) {
            addCriterionForJDBCDate("departure_date =", value, "departureDate");
            return (Criteria) this;
        }

        public Criteria andDepartureDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("departure_date <>", value, "departureDate");
            return (Criteria) this;
        }

        public Criteria andDepartureDateGreaterThan(Date value) {
            addCriterionForJDBCDate("departure_date >", value, "departureDate");
            return (Criteria) this;
        }

        public Criteria andDepartureDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("departure_date >=", value, "departureDate");
            return (Criteria) this;
        }

        public Criteria andDepartureDateLessThan(Date value) {
            addCriterionForJDBCDate("departure_date <", value, "departureDate");
            return (Criteria) this;
        }

        public Criteria andDepartureDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("departure_date <=", value, "departureDate");
            return (Criteria) this;
        }

        public Criteria andDepartureDateIn(List<Date> values) {
            addCriterionForJDBCDate("departure_date in", values, "departureDate");
            return (Criteria) this;
        }

        public Criteria andDepartureDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("departure_date not in", values, "departureDate");
            return (Criteria) this;
        }

        public Criteria andDepartureDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("departure_date between", value1, value2, "departureDate");
            return (Criteria) this;
        }

        public Criteria andDepartureDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("departure_date not between", value1, value2, "departureDate");
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

        public Criteria andWangwangNumIsNull() {
            addCriterion("wangwang_num is null");
            return (Criteria) this;
        }

        public Criteria andWangwangNumIsNotNull() {
            addCriterion("wangwang_num is not null");
            return (Criteria) this;
        }

        public Criteria andWangwangNumEqualTo(String value) {
            addCriterion("wangwang_num =", value, "wangwangNum");
            return (Criteria) this;
        }

        public Criteria andWangwangNumNotEqualTo(String value) {
            addCriterion("wangwang_num <>", value, "wangwangNum");
            return (Criteria) this;
        }

        public Criteria andWangwangNumGreaterThan(String value) {
            addCriterion("wangwang_num >", value, "wangwangNum");
            return (Criteria) this;
        }

        public Criteria andWangwangNumGreaterThanOrEqualTo(String value) {
            addCriterion("wangwang_num >=", value, "wangwangNum");
            return (Criteria) this;
        }

        public Criteria andWangwangNumLessThan(String value) {
            addCriterion("wangwang_num <", value, "wangwangNum");
            return (Criteria) this;
        }

        public Criteria andWangwangNumLessThanOrEqualTo(String value) {
            addCriterion("wangwang_num <=", value, "wangwangNum");
            return (Criteria) this;
        }

        public Criteria andWangwangNumLike(String value) {
            addCriterion("wangwang_num like", value, "wangwangNum");
            return (Criteria) this;
        }

        public Criteria andWangwangNumNotLike(String value) {
            addCriterion("wangwang_num not like", value, "wangwangNum");
            return (Criteria) this;
        }

        public Criteria andWangwangNumIn(List<String> values) {
            addCriterion("wangwang_num in", values, "wangwangNum");
            return (Criteria) this;
        }

        public Criteria andWangwangNumNotIn(List<String> values) {
            addCriterion("wangwang_num not in", values, "wangwangNum");
            return (Criteria) this;
        }

        public Criteria andWangwangNumBetween(String value1, String value2) {
            addCriterion("wangwang_num between", value1, value2, "wangwangNum");
            return (Criteria) this;
        }

        public Criteria andWangwangNumNotBetween(String value1, String value2) {
            addCriterion("wangwang_num not between", value1, value2, "wangwangNum");
            return (Criteria) this;
        }

        public Criteria andIsoftNoIsNull() {
            addCriterion("isoft_no is null");
            return (Criteria) this;
        }

        public Criteria andIsoftNoIsNotNull() {
            addCriterion("isoft_no is not null");
            return (Criteria) this;
        }

        public Criteria andIsoftNoEqualTo(String value) {
            addCriterion("isoft_no =", value, "isoftNo");
            return (Criteria) this;
        }

        public Criteria andIsoftNoNotEqualTo(String value) {
            addCriterion("isoft_no <>", value, "isoftNo");
            return (Criteria) this;
        }

        public Criteria andIsoftNoGreaterThan(String value) {
            addCriterion("isoft_no >", value, "isoftNo");
            return (Criteria) this;
        }

        public Criteria andIsoftNoGreaterThanOrEqualTo(String value) {
            addCriterion("isoft_no >=", value, "isoftNo");
            return (Criteria) this;
        }

        public Criteria andIsoftNoLessThan(String value) {
            addCriterion("isoft_no <", value, "isoftNo");
            return (Criteria) this;
        }

        public Criteria andIsoftNoLessThanOrEqualTo(String value) {
            addCriterion("isoft_no <=", value, "isoftNo");
            return (Criteria) this;
        }

        public Criteria andIsoftNoLike(String value) {
            addCriterion("isoft_no like", value, "isoftNo");
            return (Criteria) this;
        }

        public Criteria andIsoftNoNotLike(String value) {
            addCriterion("isoft_no not like", value, "isoftNo");
            return (Criteria) this;
        }

        public Criteria andIsoftNoIn(List<String> values) {
            addCriterion("isoft_no in", values, "isoftNo");
            return (Criteria) this;
        }

        public Criteria andIsoftNoNotIn(List<String> values) {
            addCriterion("isoft_no not in", values, "isoftNo");
            return (Criteria) this;
        }

        public Criteria andIsoftNoBetween(String value1, String value2) {
            addCriterion("isoft_no between", value1, value2, "isoftNo");
            return (Criteria) this;
        }

        public Criteria andIsoftNoNotBetween(String value1, String value2) {
            addCriterion("isoft_no not between", value1, value2, "isoftNo");
            return (Criteria) this;
        }

        public Criteria andWbNoIsNull() {
            addCriterion("wb_no is null");
            return (Criteria) this;
        }

        public Criteria andWbNoIsNotNull() {
            addCriterion("wb_no is not null");
            return (Criteria) this;
        }

        public Criteria andWbNoEqualTo(String value) {
            addCriterion("wb_no =", value, "wbNo");
            return (Criteria) this;
        }

        public Criteria andWbNoNotEqualTo(String value) {
            addCriterion("wb_no <>", value, "wbNo");
            return (Criteria) this;
        }

        public Criteria andWbNoGreaterThan(String value) {
            addCriterion("wb_no >", value, "wbNo");
            return (Criteria) this;
        }

        public Criteria andWbNoGreaterThanOrEqualTo(String value) {
            addCriterion("wb_no >=", value, "wbNo");
            return (Criteria) this;
        }

        public Criteria andWbNoLessThan(String value) {
            addCriterion("wb_no <", value, "wbNo");
            return (Criteria) this;
        }

        public Criteria andWbNoLessThanOrEqualTo(String value) {
            addCriterion("wb_no <=", value, "wbNo");
            return (Criteria) this;
        }

        public Criteria andWbNoLike(String value) {
            addCriterion("wb_no like", value, "wbNo");
            return (Criteria) this;
        }

        public Criteria andWbNoNotLike(String value) {
            addCriterion("wb_no not like", value, "wbNo");
            return (Criteria) this;
        }

        public Criteria andWbNoIn(List<String> values) {
            addCriterion("wb_no in", values, "wbNo");
            return (Criteria) this;
        }

        public Criteria andWbNoNotIn(List<String> values) {
            addCriterion("wb_no not in", values, "wbNo");
            return (Criteria) this;
        }

        public Criteria andWbNoBetween(String value1, String value2) {
            addCriterion("wb_no between", value1, value2, "wbNo");
            return (Criteria) this;
        }

        public Criteria andWbNoNotBetween(String value1, String value2) {
            addCriterion("wb_no not between", value1, value2, "wbNo");
            return (Criteria) this;
        }

        public Criteria andIsoftEmailIsNull() {
            addCriterion("isoft_email is null");
            return (Criteria) this;
        }

        public Criteria andIsoftEmailIsNotNull() {
            addCriterion("isoft_email is not null");
            return (Criteria) this;
        }

        public Criteria andIsoftEmailEqualTo(String value) {
            addCriterion("isoft_email =", value, "isoftEmail");
            return (Criteria) this;
        }

        public Criteria andIsoftEmailNotEqualTo(String value) {
            addCriterion("isoft_email <>", value, "isoftEmail");
            return (Criteria) this;
        }

        public Criteria andIsoftEmailGreaterThan(String value) {
            addCriterion("isoft_email >", value, "isoftEmail");
            return (Criteria) this;
        }

        public Criteria andIsoftEmailGreaterThanOrEqualTo(String value) {
            addCriterion("isoft_email >=", value, "isoftEmail");
            return (Criteria) this;
        }

        public Criteria andIsoftEmailLessThan(String value) {
            addCriterion("isoft_email <", value, "isoftEmail");
            return (Criteria) this;
        }

        public Criteria andIsoftEmailLessThanOrEqualTo(String value) {
            addCriterion("isoft_email <=", value, "isoftEmail");
            return (Criteria) this;
        }

        public Criteria andIsoftEmailLike(String value) {
            addCriterion("isoft_email like", value, "isoftEmail");
            return (Criteria) this;
        }

        public Criteria andIsoftEmailNotLike(String value) {
            addCriterion("isoft_email not like", value, "isoftEmail");
            return (Criteria) this;
        }

        public Criteria andIsoftEmailIn(List<String> values) {
            addCriterion("isoft_email in", values, "isoftEmail");
            return (Criteria) this;
        }

        public Criteria andIsoftEmailNotIn(List<String> values) {
            addCriterion("isoft_email not in", values, "isoftEmail");
            return (Criteria) this;
        }

        public Criteria andIsoftEmailBetween(String value1, String value2) {
            addCriterion("isoft_email between", value1, value2, "isoftEmail");
            return (Criteria) this;
        }

        public Criteria andIsoftEmailNotBetween(String value1, String value2) {
            addCriterion("isoft_email not between", value1, value2, "isoftEmail");
            return (Criteria) this;
        }

        public Criteria andWbEmailIsNull() {
            addCriterion("wb_email is null");
            return (Criteria) this;
        }

        public Criteria andWbEmailIsNotNull() {
            addCriterion("wb_email is not null");
            return (Criteria) this;
        }

        public Criteria andWbEmailEqualTo(String value) {
            addCriterion("wb_email =", value, "wbEmail");
            return (Criteria) this;
        }

        public Criteria andWbEmailNotEqualTo(String value) {
            addCriterion("wb_email <>", value, "wbEmail");
            return (Criteria) this;
        }

        public Criteria andWbEmailGreaterThan(String value) {
            addCriterion("wb_email >", value, "wbEmail");
            return (Criteria) this;
        }

        public Criteria andWbEmailGreaterThanOrEqualTo(String value) {
            addCriterion("wb_email >=", value, "wbEmail");
            return (Criteria) this;
        }

        public Criteria andWbEmailLessThan(String value) {
            addCriterion("wb_email <", value, "wbEmail");
            return (Criteria) this;
        }

        public Criteria andWbEmailLessThanOrEqualTo(String value) {
            addCriterion("wb_email <=", value, "wbEmail");
            return (Criteria) this;
        }

        public Criteria andWbEmailLike(String value) {
            addCriterion("wb_email like", value, "wbEmail");
            return (Criteria) this;
        }

        public Criteria andWbEmailNotLike(String value) {
            addCriterion("wb_email not like", value, "wbEmail");
            return (Criteria) this;
        }

        public Criteria andWbEmailIn(List<String> values) {
            addCriterion("wb_email in", values, "wbEmail");
            return (Criteria) this;
        }

        public Criteria andWbEmailNotIn(List<String> values) {
            addCriterion("wb_email not in", values, "wbEmail");
            return (Criteria) this;
        }

        public Criteria andWbEmailBetween(String value1, String value2) {
            addCriterion("wb_email between", value1, value2, "wbEmail");
            return (Criteria) this;
        }

        public Criteria andWbEmailNotBetween(String value1, String value2) {
            addCriterion("wb_email not between", value1, value2, "wbEmail");
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