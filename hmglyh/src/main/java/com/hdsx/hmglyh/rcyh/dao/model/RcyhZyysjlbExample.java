package com.hdsx.hmglyh.rcyh.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RcyhZyysjlbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RcyhZyysjlbExample() {
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

        public Criteria andYsidIsNull() {
            addCriterion("YSID is null");
            return (Criteria) this;
        }

        public Criteria andYsidIsNotNull() {
            addCriterion("YSID is not null");
            return (Criteria) this;
        }

        public Criteria andYsidEqualTo(String value) {
            addCriterion("YSID =", value, "ysid");
            return (Criteria) this;
        }

        public Criteria andYsidNotEqualTo(String value) {
            addCriterion("YSID <>", value, "ysid");
            return (Criteria) this;
        }

        public Criteria andYsidGreaterThan(String value) {
            addCriterion("YSID >", value, "ysid");
            return (Criteria) this;
        }

        public Criteria andYsidGreaterThanOrEqualTo(String value) {
            addCriterion("YSID >=", value, "ysid");
            return (Criteria) this;
        }

        public Criteria andYsidLessThan(String value) {
            addCriterion("YSID <", value, "ysid");
            return (Criteria) this;
        }

        public Criteria andYsidLessThanOrEqualTo(String value) {
            addCriterion("YSID <=", value, "ysid");
            return (Criteria) this;
        }

        public Criteria andYsidLike(String value) {
            addCriterion("YSID like", value, "ysid");
            return (Criteria) this;
        }

        public Criteria andYsidNotLike(String value) {
            addCriterion("YSID not like", value, "ysid");
            return (Criteria) this;
        }

        public Criteria andYsidIn(List<String> values) {
            addCriterion("YSID in", values, "ysid");
            return (Criteria) this;
        }

        public Criteria andYsidNotIn(List<String> values) {
            addCriterion("YSID not in", values, "ysid");
            return (Criteria) this;
        }

        public Criteria andYsidBetween(String value1, String value2) {
            addCriterion("YSID between", value1, value2, "ysid");
            return (Criteria) this;
        }

        public Criteria andYsidNotBetween(String value1, String value2) {
            addCriterion("YSID not between", value1, value2, "ysid");
            return (Criteria) this;
        }

        public Criteria andYstimeIsNull() {
            addCriterion("YSTIME is null");
            return (Criteria) this;
        }

        public Criteria andYstimeIsNotNull() {
            addCriterion("YSTIME is not null");
            return (Criteria) this;
        }

        public Criteria andYstimeEqualTo(Date value) {
            addCriterionForJDBCDate("YSTIME =", value, "ystime");
            return (Criteria) this;
        }

        public Criteria andYstimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("YSTIME <>", value, "ystime");
            return (Criteria) this;
        }

        public Criteria andYstimeGreaterThan(Date value) {
            addCriterionForJDBCDate("YSTIME >", value, "ystime");
            return (Criteria) this;
        }

        public Criteria andYstimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("YSTIME >=", value, "ystime");
            return (Criteria) this;
        }

        public Criteria andYstimeLessThan(Date value) {
            addCriterionForJDBCDate("YSTIME <", value, "ystime");
            return (Criteria) this;
        }

        public Criteria andYstimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("YSTIME <=", value, "ystime");
            return (Criteria) this;
        }

        public Criteria andYstimeIn(List<Date> values) {
            addCriterionForJDBCDate("YSTIME in", values, "ystime");
            return (Criteria) this;
        }

        public Criteria andYstimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("YSTIME not in", values, "ystime");
            return (Criteria) this;
        }

        public Criteria andYstimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("YSTIME between", value1, value2, "ystime");
            return (Criteria) this;
        }

        public Criteria andYstimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("YSTIME not between", value1, value2, "ystime");
            return (Criteria) this;
        }

        public Criteria andYsusernameIsNull() {
            addCriterion("YSUSERNAME is null");
            return (Criteria) this;
        }

        public Criteria andYsusernameIsNotNull() {
            addCriterion("YSUSERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andYsusernameEqualTo(String value) {
            addCriterion("YSUSERNAME =", value, "ysusername");
            return (Criteria) this;
        }

        public Criteria andYsusernameNotEqualTo(String value) {
            addCriterion("YSUSERNAME <>", value, "ysusername");
            return (Criteria) this;
        }

        public Criteria andYsusernameGreaterThan(String value) {
            addCriterion("YSUSERNAME >", value, "ysusername");
            return (Criteria) this;
        }

        public Criteria andYsusernameGreaterThanOrEqualTo(String value) {
            addCriterion("YSUSERNAME >=", value, "ysusername");
            return (Criteria) this;
        }

        public Criteria andYsusernameLessThan(String value) {
            addCriterion("YSUSERNAME <", value, "ysusername");
            return (Criteria) this;
        }

        public Criteria andYsusernameLessThanOrEqualTo(String value) {
            addCriterion("YSUSERNAME <=", value, "ysusername");
            return (Criteria) this;
        }

        public Criteria andYsusernameLike(String value) {
            addCriterion("YSUSERNAME like", value, "ysusername");
            return (Criteria) this;
        }

        public Criteria andYsusernameNotLike(String value) {
            addCriterion("YSUSERNAME not like", value, "ysusername");
            return (Criteria) this;
        }

        public Criteria andYsusernameIn(List<String> values) {
            addCriterion("YSUSERNAME in", values, "ysusername");
            return (Criteria) this;
        }

        public Criteria andYsusernameNotIn(List<String> values) {
            addCriterion("YSUSERNAME not in", values, "ysusername");
            return (Criteria) this;
        }

        public Criteria andYsusernameBetween(String value1, String value2) {
            addCriterion("YSUSERNAME between", value1, value2, "ysusername");
            return (Criteria) this;
        }

        public Criteria andYsusernameNotBetween(String value1, String value2) {
            addCriterion("YSUSERNAME not between", value1, value2, "ysusername");
            return (Criteria) this;
        }

        public Criteria andBmcodeIsNull() {
            addCriterion("BMCODE is null");
            return (Criteria) this;
        }

        public Criteria andBmcodeIsNotNull() {
            addCriterion("BMCODE is not null");
            return (Criteria) this;
        }

        public Criteria andBmcodeEqualTo(String value) {
            addCriterion("BMCODE =", value, "bmcode");
            return (Criteria) this;
        }

        public Criteria andBmcodeNotEqualTo(String value) {
            addCriterion("BMCODE <>", value, "bmcode");
            return (Criteria) this;
        }

        public Criteria andBmcodeGreaterThan(String value) {
            addCriterion("BMCODE >", value, "bmcode");
            return (Criteria) this;
        }

        public Criteria andBmcodeGreaterThanOrEqualTo(String value) {
            addCriterion("BMCODE >=", value, "bmcode");
            return (Criteria) this;
        }

        public Criteria andBmcodeLessThan(String value) {
            addCriterion("BMCODE <", value, "bmcode");
            return (Criteria) this;
        }

        public Criteria andBmcodeLessThanOrEqualTo(String value) {
            addCriterion("BMCODE <=", value, "bmcode");
            return (Criteria) this;
        }

        public Criteria andBmcodeLike(String value) {
            addCriterion("BMCODE like", value, "bmcode");
            return (Criteria) this;
        }

        public Criteria andBmcodeNotLike(String value) {
            addCriterion("BMCODE not like", value, "bmcode");
            return (Criteria) this;
        }

        public Criteria andBmcodeIn(List<String> values) {
            addCriterion("BMCODE in", values, "bmcode");
            return (Criteria) this;
        }

        public Criteria andBmcodeNotIn(List<String> values) {
            addCriterion("BMCODE not in", values, "bmcode");
            return (Criteria) this;
        }

        public Criteria andBmcodeBetween(String value1, String value2) {
            addCriterion("BMCODE between", value1, value2, "bmcode");
            return (Criteria) this;
        }

        public Criteria andBmcodeNotBetween(String value1, String value2) {
            addCriterion("BMCODE not between", value1, value2, "bmcode");
            return (Criteria) this;
        }

        public Criteria andLdcodeIsNull() {
            addCriterion("LDCODE is null");
            return (Criteria) this;
        }

        public Criteria andLdcodeIsNotNull() {
            addCriterion("LDCODE is not null");
            return (Criteria) this;
        }

        public Criteria andLdcodeEqualTo(String value) {
            addCriterion("LDCODE =", value, "ldcode");
            return (Criteria) this;
        }

        public Criteria andLdcodeNotEqualTo(String value) {
            addCriterion("LDCODE <>", value, "ldcode");
            return (Criteria) this;
        }

        public Criteria andLdcodeGreaterThan(String value) {
            addCriterion("LDCODE >", value, "ldcode");
            return (Criteria) this;
        }

        public Criteria andLdcodeGreaterThanOrEqualTo(String value) {
            addCriterion("LDCODE >=", value, "ldcode");
            return (Criteria) this;
        }

        public Criteria andLdcodeLessThan(String value) {
            addCriterion("LDCODE <", value, "ldcode");
            return (Criteria) this;
        }

        public Criteria andLdcodeLessThanOrEqualTo(String value) {
            addCriterion("LDCODE <=", value, "ldcode");
            return (Criteria) this;
        }

        public Criteria andLdcodeLike(String value) {
            addCriterion("LDCODE like", value, "ldcode");
            return (Criteria) this;
        }

        public Criteria andLdcodeNotLike(String value) {
            addCriterion("LDCODE not like", value, "ldcode");
            return (Criteria) this;
        }

        public Criteria andLdcodeIn(List<String> values) {
            addCriterion("LDCODE in", values, "ldcode");
            return (Criteria) this;
        }

        public Criteria andLdcodeNotIn(List<String> values) {
            addCriterion("LDCODE not in", values, "ldcode");
            return (Criteria) this;
        }

        public Criteria andLdcodeBetween(String value1, String value2) {
            addCriterion("LDCODE between", value1, value2, "ldcode");
            return (Criteria) this;
        }

        public Criteria andLdcodeNotBetween(String value1, String value2) {
            addCriterion("LDCODE not between", value1, value2, "ldcode");
            return (Criteria) this;
        }

        public Criteria andSsnyIsNull() {
            addCriterion("SSNY is null");
            return (Criteria) this;
        }

        public Criteria andSsnyIsNotNull() {
            addCriterion("SSNY is not null");
            return (Criteria) this;
        }

        public Criteria andSsnyEqualTo(String value) {
            addCriterion("SSNY =", value, "ssny");
            return (Criteria) this;
        }

        public Criteria andSsnyNotEqualTo(String value) {
            addCriterion("SSNY <>", value, "ssny");
            return (Criteria) this;
        }

        public Criteria andSsnyGreaterThan(String value) {
            addCriterion("SSNY >", value, "ssny");
            return (Criteria) this;
        }

        public Criteria andSsnyGreaterThanOrEqualTo(String value) {
            addCriterion("SSNY >=", value, "ssny");
            return (Criteria) this;
        }

        public Criteria andSsnyLessThan(String value) {
            addCriterion("SSNY <", value, "ssny");
            return (Criteria) this;
        }

        public Criteria andSsnyLessThanOrEqualTo(String value) {
            addCriterion("SSNY <=", value, "ssny");
            return (Criteria) this;
        }

        public Criteria andSsnyLike(String value) {
            addCriterion("SSNY like", value, "ssny");
            return (Criteria) this;
        }

        public Criteria andSsnyNotLike(String value) {
            addCriterion("SSNY not like", value, "ssny");
            return (Criteria) this;
        }

        public Criteria andSsnyIn(List<String> values) {
            addCriterion("SSNY in", values, "ssny");
            return (Criteria) this;
        }

        public Criteria andSsnyNotIn(List<String> values) {
            addCriterion("SSNY not in", values, "ssny");
            return (Criteria) this;
        }

        public Criteria andSsnyBetween(String value1, String value2) {
            addCriterion("SSNY between", value1, value2, "ssny");
            return (Criteria) this;
        }

        public Criteria andSsnyNotBetween(String value1, String value2) {
            addCriterion("SSNY not between", value1, value2, "ssny");
            return (Criteria) this;
        }

        public Criteria andYhidIsNull() {
            addCriterion("YHID is null");
            return (Criteria) this;
        }

        public Criteria andYhidIsNotNull() {
            addCriterion("YHID is not null");
            return (Criteria) this;
        }

        public Criteria andYhidEqualTo(String value) {
            addCriterion("YHID =", value, "yhid");
            return (Criteria) this;
        }

        public Criteria andYhidNotEqualTo(String value) {
            addCriterion("YHID <>", value, "yhid");
            return (Criteria) this;
        }

        public Criteria andYhidGreaterThan(String value) {
            addCriterion("YHID >", value, "yhid");
            return (Criteria) this;
        }

        public Criteria andYhidGreaterThanOrEqualTo(String value) {
            addCriterion("YHID >=", value, "yhid");
            return (Criteria) this;
        }

        public Criteria andYhidLessThan(String value) {
            addCriterion("YHID <", value, "yhid");
            return (Criteria) this;
        }

        public Criteria andYhidLessThanOrEqualTo(String value) {
            addCriterion("YHID <=", value, "yhid");
            return (Criteria) this;
        }

        public Criteria andYhidLike(String value) {
            addCriterion("YHID like", value, "yhid");
            return (Criteria) this;
        }

        public Criteria andYhidNotLike(String value) {
            addCriterion("YHID not like", value, "yhid");
            return (Criteria) this;
        }

        public Criteria andYhidIn(List<String> values) {
            addCriterion("YHID in", values, "yhid");
            return (Criteria) this;
        }

        public Criteria andYhidNotIn(List<String> values) {
            addCriterion("YHID not in", values, "yhid");
            return (Criteria) this;
        }

        public Criteria andYhidBetween(String value1, String value2) {
            addCriterion("YHID between", value1, value2, "yhid");
            return (Criteria) this;
        }

        public Criteria andYhidNotBetween(String value1, String value2) {
            addCriterion("YHID not between", value1, value2, "yhid");
            return (Criteria) this;
        }

        public Criteria andSbslIsNull() {
            addCriterion("SBSL is null");
            return (Criteria) this;
        }

        public Criteria andSbslIsNotNull() {
            addCriterion("SBSL is not null");
            return (Criteria) this;
        }

        public Criteria andSbslEqualTo(BigDecimal value) {
            addCriterion("SBSL =", value, "sbsl");
            return (Criteria) this;
        }

        public Criteria andSbslNotEqualTo(BigDecimal value) {
            addCriterion("SBSL <>", value, "sbsl");
            return (Criteria) this;
        }

        public Criteria andSbslGreaterThan(BigDecimal value) {
            addCriterion("SBSL >", value, "sbsl");
            return (Criteria) this;
        }

        public Criteria andSbslGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SBSL >=", value, "sbsl");
            return (Criteria) this;
        }

        public Criteria andSbslLessThan(BigDecimal value) {
            addCriterion("SBSL <", value, "sbsl");
            return (Criteria) this;
        }

        public Criteria andSbslLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SBSL <=", value, "sbsl");
            return (Criteria) this;
        }

        public Criteria andSbslIn(List<BigDecimal> values) {
            addCriterion("SBSL in", values, "sbsl");
            return (Criteria) this;
        }

        public Criteria andSbslNotIn(List<BigDecimal> values) {
            addCriterion("SBSL not in", values, "sbsl");
            return (Criteria) this;
        }

        public Criteria andSbslBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SBSL between", value1, value2, "sbsl");
            return (Criteria) this;
        }

        public Criteria andSbslNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SBSL not between", value1, value2, "sbsl");
            return (Criteria) this;
        }

        public Criteria andSbgrIsNull() {
            addCriterion("SBGR is null");
            return (Criteria) this;
        }

        public Criteria andSbgrIsNotNull() {
            addCriterion("SBGR is not null");
            return (Criteria) this;
        }

        public Criteria andSbgrEqualTo(BigDecimal value) {
            addCriterion("SBGR =", value, "sbgr");
            return (Criteria) this;
        }

        public Criteria andSbgrNotEqualTo(BigDecimal value) {
            addCriterion("SBGR <>", value, "sbgr");
            return (Criteria) this;
        }

        public Criteria andSbgrGreaterThan(BigDecimal value) {
            addCriterion("SBGR >", value, "sbgr");
            return (Criteria) this;
        }

        public Criteria andSbgrGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SBGR >=", value, "sbgr");
            return (Criteria) this;
        }

        public Criteria andSbgrLessThan(BigDecimal value) {
            addCriterion("SBGR <", value, "sbgr");
            return (Criteria) this;
        }

        public Criteria andSbgrLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SBGR <=", value, "sbgr");
            return (Criteria) this;
        }

        public Criteria andSbgrIn(List<BigDecimal> values) {
            addCriterion("SBGR in", values, "sbgr");
            return (Criteria) this;
        }

        public Criteria andSbgrNotIn(List<BigDecimal> values) {
            addCriterion("SBGR not in", values, "sbgr");
            return (Criteria) this;
        }

        public Criteria andSbgrBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SBGR between", value1, value2, "sbgr");
            return (Criteria) this;
        }

        public Criteria andSbgrNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SBGR not between", value1, value2, "sbgr");
            return (Criteria) this;
        }

        public Criteria andLdzhIsNull() {
            addCriterion("LDZH is null");
            return (Criteria) this;
        }

        public Criteria andLdzhIsNotNull() {
            addCriterion("LDZH is not null");
            return (Criteria) this;
        }

        public Criteria andLdzhEqualTo(String value) {
            addCriterion("LDZH =", value, "ldzh");
            return (Criteria) this;
        }

        public Criteria andLdzhNotEqualTo(String value) {
            addCriterion("LDZH <>", value, "ldzh");
            return (Criteria) this;
        }

        public Criteria andLdzhGreaterThan(String value) {
            addCriterion("LDZH >", value, "ldzh");
            return (Criteria) this;
        }

        public Criteria andLdzhGreaterThanOrEqualTo(String value) {
            addCriterion("LDZH >=", value, "ldzh");
            return (Criteria) this;
        }

        public Criteria andLdzhLessThan(String value) {
            addCriterion("LDZH <", value, "ldzh");
            return (Criteria) this;
        }

        public Criteria andLdzhLessThanOrEqualTo(String value) {
            addCriterion("LDZH <=", value, "ldzh");
            return (Criteria) this;
        }

        public Criteria andLdzhLike(String value) {
            addCriterion("LDZH like", value, "ldzh");
            return (Criteria) this;
        }

        public Criteria andLdzhNotLike(String value) {
            addCriterion("LDZH not like", value, "ldzh");
            return (Criteria) this;
        }

        public Criteria andLdzhIn(List<String> values) {
            addCriterion("LDZH in", values, "ldzh");
            return (Criteria) this;
        }

        public Criteria andLdzhNotIn(List<String> values) {
            addCriterion("LDZH not in", values, "ldzh");
            return (Criteria) this;
        }

        public Criteria andLdzhBetween(String value1, String value2) {
            addCriterion("LDZH between", value1, value2, "ldzh");
            return (Criteria) this;
        }

        public Criteria andLdzhNotBetween(String value1, String value2) {
            addCriterion("LDZH not between", value1, value2, "ldzh");
            return (Criteria) this;
        }

        public Criteria andCjslIsNull() {
            addCriterion("CJSL is null");
            return (Criteria) this;
        }

        public Criteria andCjslIsNotNull() {
            addCriterion("CJSL is not null");
            return (Criteria) this;
        }

        public Criteria andCjslEqualTo(BigDecimal value) {
            addCriterion("CJSL =", value, "cjsl");
            return (Criteria) this;
        }

        public Criteria andCjslNotEqualTo(BigDecimal value) {
            addCriterion("CJSL <>", value, "cjsl");
            return (Criteria) this;
        }

        public Criteria andCjslGreaterThan(BigDecimal value) {
            addCriterion("CJSL >", value, "cjsl");
            return (Criteria) this;
        }

        public Criteria andCjslGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CJSL >=", value, "cjsl");
            return (Criteria) this;
        }

        public Criteria andCjslLessThan(BigDecimal value) {
            addCriterion("CJSL <", value, "cjsl");
            return (Criteria) this;
        }

        public Criteria andCjslLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CJSL <=", value, "cjsl");
            return (Criteria) this;
        }

        public Criteria andCjslIn(List<BigDecimal> values) {
            addCriterion("CJSL in", values, "cjsl");
            return (Criteria) this;
        }

        public Criteria andCjslNotIn(List<BigDecimal> values) {
            addCriterion("CJSL not in", values, "cjsl");
            return (Criteria) this;
        }

        public Criteria andCjslBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CJSL between", value1, value2, "cjsl");
            return (Criteria) this;
        }

        public Criteria andCjslNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CJSL not between", value1, value2, "cjsl");
            return (Criteria) this;
        }

        public Criteria andYsslIsNull() {
            addCriterion("YSSL is null");
            return (Criteria) this;
        }

        public Criteria andYsslIsNotNull() {
            addCriterion("YSSL is not null");
            return (Criteria) this;
        }

        public Criteria andYsslEqualTo(BigDecimal value) {
            addCriterion("YSSL =", value, "yssl");
            return (Criteria) this;
        }

        public Criteria andYsslNotEqualTo(BigDecimal value) {
            addCriterion("YSSL <>", value, "yssl");
            return (Criteria) this;
        }

        public Criteria andYsslGreaterThan(BigDecimal value) {
            addCriterion("YSSL >", value, "yssl");
            return (Criteria) this;
        }

        public Criteria andYsslGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("YSSL >=", value, "yssl");
            return (Criteria) this;
        }

        public Criteria andYsslLessThan(BigDecimal value) {
            addCriterion("YSSL <", value, "yssl");
            return (Criteria) this;
        }

        public Criteria andYsslLessThanOrEqualTo(BigDecimal value) {
            addCriterion("YSSL <=", value, "yssl");
            return (Criteria) this;
        }

        public Criteria andYsslIn(List<BigDecimal> values) {
            addCriterion("YSSL in", values, "yssl");
            return (Criteria) this;
        }

        public Criteria andYsslNotIn(List<BigDecimal> values) {
            addCriterion("YSSL not in", values, "yssl");
            return (Criteria) this;
        }

        public Criteria andYsslBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("YSSL between", value1, value2, "yssl");
            return (Criteria) this;
        }

        public Criteria andYsslNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("YSSL not between", value1, value2, "yssl");
            return (Criteria) this;
        }

        public Criteria andHgslIsNull() {
            addCriterion("HGSL is null");
            return (Criteria) this;
        }

        public Criteria andHgslIsNotNull() {
            addCriterion("HGSL is not null");
            return (Criteria) this;
        }

        public Criteria andHgslEqualTo(BigDecimal value) {
            addCriterion("HGSL =", value, "hgsl");
            return (Criteria) this;
        }

        public Criteria andHgslNotEqualTo(BigDecimal value) {
            addCriterion("HGSL <>", value, "hgsl");
            return (Criteria) this;
        }

        public Criteria andHgslGreaterThan(BigDecimal value) {
            addCriterion("HGSL >", value, "hgsl");
            return (Criteria) this;
        }

        public Criteria andHgslGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("HGSL >=", value, "hgsl");
            return (Criteria) this;
        }

        public Criteria andHgslLessThan(BigDecimal value) {
            addCriterion("HGSL <", value, "hgsl");
            return (Criteria) this;
        }

        public Criteria andHgslLessThanOrEqualTo(BigDecimal value) {
            addCriterion("HGSL <=", value, "hgsl");
            return (Criteria) this;
        }

        public Criteria andHgslIn(List<BigDecimal> values) {
            addCriterion("HGSL in", values, "hgsl");
            return (Criteria) this;
        }

        public Criteria andHgslNotIn(List<BigDecimal> values) {
            addCriterion("HGSL not in", values, "hgsl");
            return (Criteria) this;
        }

        public Criteria andHgslBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HGSL between", value1, value2, "hgsl");
            return (Criteria) this;
        }

        public Criteria andHgslNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HGSL not between", value1, value2, "hgsl");
            return (Criteria) this;
        }

        public Criteria andSlfhlIsNull() {
            addCriterion("SLFHL is null");
            return (Criteria) this;
        }

        public Criteria andSlfhlIsNotNull() {
            addCriterion("SLFHL is not null");
            return (Criteria) this;
        }

        public Criteria andSlfhlEqualTo(BigDecimal value) {
            addCriterion("SLFHL =", value, "slfhl");
            return (Criteria) this;
        }

        public Criteria andSlfhlNotEqualTo(BigDecimal value) {
            addCriterion("SLFHL <>", value, "slfhl");
            return (Criteria) this;
        }

        public Criteria andSlfhlGreaterThan(BigDecimal value) {
            addCriterion("SLFHL >", value, "slfhl");
            return (Criteria) this;
        }

        public Criteria andSlfhlGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SLFHL >=", value, "slfhl");
            return (Criteria) this;
        }

        public Criteria andSlfhlLessThan(BigDecimal value) {
            addCriterion("SLFHL <", value, "slfhl");
            return (Criteria) this;
        }

        public Criteria andSlfhlLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SLFHL <=", value, "slfhl");
            return (Criteria) this;
        }

        public Criteria andSlfhlIn(List<BigDecimal> values) {
            addCriterion("SLFHL in", values, "slfhl");
            return (Criteria) this;
        }

        public Criteria andSlfhlNotIn(List<BigDecimal> values) {
            addCriterion("SLFHL not in", values, "slfhl");
            return (Criteria) this;
        }

        public Criteria andSlfhlBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SLFHL between", value1, value2, "slfhl");
            return (Criteria) this;
        }

        public Criteria andSlfhlNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SLFHL not between", value1, value2, "slfhl");
            return (Criteria) this;
        }

        public Criteria andZlhglIsNull() {
            addCriterion("ZLHGL is null");
            return (Criteria) this;
        }

        public Criteria andZlhglIsNotNull() {
            addCriterion("ZLHGL is not null");
            return (Criteria) this;
        }

        public Criteria andZlhglEqualTo(BigDecimal value) {
            addCriterion("ZLHGL =", value, "zlhgl");
            return (Criteria) this;
        }

        public Criteria andZlhglNotEqualTo(BigDecimal value) {
            addCriterion("ZLHGL <>", value, "zlhgl");
            return (Criteria) this;
        }

        public Criteria andZlhglGreaterThan(BigDecimal value) {
            addCriterion("ZLHGL >", value, "zlhgl");
            return (Criteria) this;
        }

        public Criteria andZlhglGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ZLHGL >=", value, "zlhgl");
            return (Criteria) this;
        }

        public Criteria andZlhglLessThan(BigDecimal value) {
            addCriterion("ZLHGL <", value, "zlhgl");
            return (Criteria) this;
        }

        public Criteria andZlhglLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ZLHGL <=", value, "zlhgl");
            return (Criteria) this;
        }

        public Criteria andZlhglIn(List<BigDecimal> values) {
            addCriterion("ZLHGL in", values, "zlhgl");
            return (Criteria) this;
        }

        public Criteria andZlhglNotIn(List<BigDecimal> values) {
            addCriterion("ZLHGL not in", values, "zlhgl");
            return (Criteria) this;
        }

        public Criteria andZlhglBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ZLHGL between", value1, value2, "zlhgl");
            return (Criteria) this;
        }

        public Criteria andZlhglNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ZLHGL not between", value1, value2, "zlhgl");
            return (Criteria) this;
        }

        public Criteria andYxslIsNull() {
            addCriterion("YXSL is null");
            return (Criteria) this;
        }

        public Criteria andYxslIsNotNull() {
            addCriterion("YXSL is not null");
            return (Criteria) this;
        }

        public Criteria andYxslEqualTo(BigDecimal value) {
            addCriterion("YXSL =", value, "yxsl");
            return (Criteria) this;
        }

        public Criteria andYxslNotEqualTo(BigDecimal value) {
            addCriterion("YXSL <>", value, "yxsl");
            return (Criteria) this;
        }

        public Criteria andYxslGreaterThan(BigDecimal value) {
            addCriterion("YXSL >", value, "yxsl");
            return (Criteria) this;
        }

        public Criteria andYxslGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("YXSL >=", value, "yxsl");
            return (Criteria) this;
        }

        public Criteria andYxslLessThan(BigDecimal value) {
            addCriterion("YXSL <", value, "yxsl");
            return (Criteria) this;
        }

        public Criteria andYxslLessThanOrEqualTo(BigDecimal value) {
            addCriterion("YXSL <=", value, "yxsl");
            return (Criteria) this;
        }

        public Criteria andYxslIn(List<BigDecimal> values) {
            addCriterion("YXSL in", values, "yxsl");
            return (Criteria) this;
        }

        public Criteria andYxslNotIn(List<BigDecimal> values) {
            addCriterion("YXSL not in", values, "yxsl");
            return (Criteria) this;
        }

        public Criteria andYxslBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("YXSL between", value1, value2, "yxsl");
            return (Criteria) this;
        }

        public Criteria andYxslNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("YXSL not between", value1, value2, "yxsl");
            return (Criteria) this;
        }

        public Criteria andYxgrIsNull() {
            addCriterion("YXGR is null");
            return (Criteria) this;
        }

        public Criteria andYxgrIsNotNull() {
            addCriterion("YXGR is not null");
            return (Criteria) this;
        }

        public Criteria andYxgrEqualTo(BigDecimal value) {
            addCriterion("YXGR =", value, "yxgr");
            return (Criteria) this;
        }

        public Criteria andYxgrNotEqualTo(BigDecimal value) {
            addCriterion("YXGR <>", value, "yxgr");
            return (Criteria) this;
        }

        public Criteria andYxgrGreaterThan(BigDecimal value) {
            addCriterion("YXGR >", value, "yxgr");
            return (Criteria) this;
        }

        public Criteria andYxgrGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("YXGR >=", value, "yxgr");
            return (Criteria) this;
        }

        public Criteria andYxgrLessThan(BigDecimal value) {
            addCriterion("YXGR <", value, "yxgr");
            return (Criteria) this;
        }

        public Criteria andYxgrLessThanOrEqualTo(BigDecimal value) {
            addCriterion("YXGR <=", value, "yxgr");
            return (Criteria) this;
        }

        public Criteria andYxgrIn(List<BigDecimal> values) {
            addCriterion("YXGR in", values, "yxgr");
            return (Criteria) this;
        }

        public Criteria andYxgrNotIn(List<BigDecimal> values) {
            addCriterion("YXGR not in", values, "yxgr");
            return (Criteria) this;
        }

        public Criteria andYxgrBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("YXGR between", value1, value2, "yxgr");
            return (Criteria) this;
        }

        public Criteria andYxgrNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("YXGR not between", value1, value2, "yxgr");
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