package com.lqx.pojo;

import java.util.ArrayList;
import java.util.List;

public class ContainerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ContainerExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("_id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("_id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("_id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("_id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("_id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("_id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("_id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("_id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("_id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("_id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("_id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("_id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("_type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("_type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("_type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("_type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("_type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("_type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("_type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("_type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("_type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("_type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("_type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("_type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("_type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("_type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andCapacityIsNull() {
            addCriterion("_capacity is null");
            return (Criteria) this;
        }

        public Criteria andCapacityIsNotNull() {
            addCriterion("_capacity is not null");
            return (Criteria) this;
        }

        public Criteria andCapacityEqualTo(Integer value) {
            addCriterion("_capacity =", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityNotEqualTo(Integer value) {
            addCriterion("_capacity <>", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityGreaterThan(Integer value) {
            addCriterion("_capacity >", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityGreaterThanOrEqualTo(Integer value) {
            addCriterion("_capacity >=", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityLessThan(Integer value) {
            addCriterion("_capacity <", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityLessThanOrEqualTo(Integer value) {
            addCriterion("_capacity <=", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityIn(List<Integer> values) {
            addCriterion("_capacity in", values, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityNotIn(List<Integer> values) {
            addCriterion("_capacity not in", values, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityBetween(Integer value1, Integer value2) {
            addCriterion("_capacity between", value1, value2, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityNotBetween(Integer value1, Integer value2) {
            addCriterion("_capacity not between", value1, value2, "capacity");
            return (Criteria) this;
        }

        public Criteria andShipTypeIsNull() {
            addCriterion("ship_type is null");
            return (Criteria) this;
        }

        public Criteria andShipTypeIsNotNull() {
            addCriterion("ship_type is not null");
            return (Criteria) this;
        }

        public Criteria andShipTypeEqualTo(String value) {
            addCriterion("ship_type =", value, "shipType");
            return (Criteria) this;
        }

        public Criteria andShipTypeNotEqualTo(String value) {
            addCriterion("ship_type <>", value, "shipType");
            return (Criteria) this;
        }

        public Criteria andShipTypeGreaterThan(String value) {
            addCriterion("ship_type >", value, "shipType");
            return (Criteria) this;
        }

        public Criteria andShipTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ship_type >=", value, "shipType");
            return (Criteria) this;
        }

        public Criteria andShipTypeLessThan(String value) {
            addCriterion("ship_type <", value, "shipType");
            return (Criteria) this;
        }

        public Criteria andShipTypeLessThanOrEqualTo(String value) {
            addCriterion("ship_type <=", value, "shipType");
            return (Criteria) this;
        }

        public Criteria andShipTypeLike(String value) {
            addCriterion("ship_type like", value, "shipType");
            return (Criteria) this;
        }

        public Criteria andShipTypeNotLike(String value) {
            addCriterion("ship_type not like", value, "shipType");
            return (Criteria) this;
        }

        public Criteria andShipTypeIn(List<String> values) {
            addCriterion("ship_type in", values, "shipType");
            return (Criteria) this;
        }

        public Criteria andShipTypeNotIn(List<String> values) {
            addCriterion("ship_type not in", values, "shipType");
            return (Criteria) this;
        }

        public Criteria andShipTypeBetween(String value1, String value2) {
            addCriterion("ship_type between", value1, value2, "shipType");
            return (Criteria) this;
        }

        public Criteria andShipTypeNotBetween(String value1, String value2) {
            addCriterion("ship_type not between", value1, value2, "shipType");
            return (Criteria) this;
        }

        public Criteria andRepositoryIsNull() {
            addCriterion("_repository is null");
            return (Criteria) this;
        }

        public Criteria andRepositoryIsNotNull() {
            addCriterion("_repository is not null");
            return (Criteria) this;
        }

        public Criteria andRepositoryEqualTo(Integer value) {
            addCriterion("_repository =", value, "repository");
            return (Criteria) this;
        }

        public Criteria andRepositoryNotEqualTo(Integer value) {
            addCriterion("_repository <>", value, "repository");
            return (Criteria) this;
        }

        public Criteria andRepositoryGreaterThan(Integer value) {
            addCriterion("_repository >", value, "repository");
            return (Criteria) this;
        }

        public Criteria andRepositoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("_repository >=", value, "repository");
            return (Criteria) this;
        }

        public Criteria andRepositoryLessThan(Integer value) {
            addCriterion("_repository <", value, "repository");
            return (Criteria) this;
        }

        public Criteria andRepositoryLessThanOrEqualTo(Integer value) {
            addCriterion("_repository <=", value, "repository");
            return (Criteria) this;
        }

        public Criteria andRepositoryIn(List<Integer> values) {
            addCriterion("_repository in", values, "repository");
            return (Criteria) this;
        }

        public Criteria andRepositoryNotIn(List<Integer> values) {
            addCriterion("_repository not in", values, "repository");
            return (Criteria) this;
        }

        public Criteria andRepositoryBetween(Integer value1, Integer value2) {
            addCriterion("_repository between", value1, value2, "repository");
            return (Criteria) this;
        }

        public Criteria andRepositoryNotBetween(Integer value1, Integer value2) {
            addCriterion("_repository not between", value1, value2, "repository");
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