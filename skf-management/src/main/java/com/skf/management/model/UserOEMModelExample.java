package com.skf.management.model;

import java.util.ArrayList;
import java.util.List;

public class UserOEMModelExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table skf_usr_oem
	 * @mbg.generated  Mon Jun 11 18:01:21 CST 2018
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table skf_usr_oem
	 * @mbg.generated  Mon Jun 11 18:01:21 CST 2018
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table skf_usr_oem
	 * @mbg.generated  Mon Jun 11 18:01:21 CST 2018
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_usr_oem
	 * @mbg.generated  Mon Jun 11 18:01:21 CST 2018
	 */
	public UserOEMModelExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_usr_oem
	 * @mbg.generated  Mon Jun 11 18:01:21 CST 2018
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_usr_oem
	 * @mbg.generated  Mon Jun 11 18:01:21 CST 2018
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_usr_oem
	 * @mbg.generated  Mon Jun 11 18:01:21 CST 2018
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_usr_oem
	 * @mbg.generated  Mon Jun 11 18:01:21 CST 2018
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_usr_oem
	 * @mbg.generated  Mon Jun 11 18:01:21 CST 2018
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_usr_oem
	 * @mbg.generated  Mon Jun 11 18:01:21 CST 2018
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_usr_oem
	 * @mbg.generated  Mon Jun 11 18:01:21 CST 2018
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_usr_oem
	 * @mbg.generated  Mon Jun 11 18:01:21 CST 2018
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_usr_oem
	 * @mbg.generated  Mon Jun 11 18:01:21 CST 2018
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_usr_oem
	 * @mbg.generated  Mon Jun 11 18:01:21 CST 2018
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table skf_usr_oem
	 * @mbg.generated  Mon Jun 11 18:01:21 CST 2018
	 */
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

		public Criteria andUserCodeIsNull() {
			addCriterion("USR_CODE is null");
			return (Criteria) this;
		}

		public Criteria andUserCodeIsNotNull() {
			addCriterion("USR_CODE is not null");
			return (Criteria) this;
		}

		public Criteria andUserCodeEqualTo(String value) {
			addCriterion("USR_CODE =", value, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeNotEqualTo(String value) {
			addCriterion("USR_CODE <>", value, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeGreaterThan(String value) {
			addCriterion("USR_CODE >", value, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeGreaterThanOrEqualTo(String value) {
			addCriterion("USR_CODE >=", value, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeLessThan(String value) {
			addCriterion("USR_CODE <", value, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeLessThanOrEqualTo(String value) {
			addCriterion("USR_CODE <=", value, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeLike(String value) {
			addCriterion("USR_CODE like", value, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeNotLike(String value) {
			addCriterion("USR_CODE not like", value, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeIn(List<String> values) {
			addCriterion("USR_CODE in", values, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeNotIn(List<String> values) {
			addCriterion("USR_CODE not in", values, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeBetween(String value1, String value2) {
			addCriterion("USR_CODE between", value1, value2, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeNotBetween(String value1, String value2) {
			addCriterion("USR_CODE not between", value1, value2, "userCode");
			return (Criteria) this;
		}

		public Criteria andOemCodeIsNull() {
			addCriterion("OEM_CODE is null");
			return (Criteria) this;
		}

		public Criteria andOemCodeIsNotNull() {
			addCriterion("OEM_CODE is not null");
			return (Criteria) this;
		}

		public Criteria andOemCodeEqualTo(String value) {
			addCriterion("OEM_CODE =", value, "oemCode");
			return (Criteria) this;
		}

		public Criteria andOemCodeNotEqualTo(String value) {
			addCriterion("OEM_CODE <>", value, "oemCode");
			return (Criteria) this;
		}

		public Criteria andOemCodeGreaterThan(String value) {
			addCriterion("OEM_CODE >", value, "oemCode");
			return (Criteria) this;
		}

		public Criteria andOemCodeGreaterThanOrEqualTo(String value) {
			addCriterion("OEM_CODE >=", value, "oemCode");
			return (Criteria) this;
		}

		public Criteria andOemCodeLessThan(String value) {
			addCriterion("OEM_CODE <", value, "oemCode");
			return (Criteria) this;
		}

		public Criteria andOemCodeLessThanOrEqualTo(String value) {
			addCriterion("OEM_CODE <=", value, "oemCode");
			return (Criteria) this;
		}

		public Criteria andOemCodeLike(String value) {
			addCriterion("OEM_CODE like", value, "oemCode");
			return (Criteria) this;
		}

		public Criteria andOemCodeNotLike(String value) {
			addCriterion("OEM_CODE not like", value, "oemCode");
			return (Criteria) this;
		}

		public Criteria andOemCodeIn(List<String> values) {
			addCriterion("OEM_CODE in", values, "oemCode");
			return (Criteria) this;
		}

		public Criteria andOemCodeNotIn(List<String> values) {
			addCriterion("OEM_CODE not in", values, "oemCode");
			return (Criteria) this;
		}

		public Criteria andOemCodeBetween(String value1, String value2) {
			addCriterion("OEM_CODE between", value1, value2, "oemCode");
			return (Criteria) this;
		}

		public Criteria andOemCodeNotBetween(String value1, String value2) {
			addCriterion("OEM_CODE not between", value1, value2, "oemCode");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table skf_usr_oem
	 * @mbg.generated  Mon Jun 11 18:01:21 CST 2018
	 */
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

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table skf_usr_oem
     *
     * @mbg.generated do_not_delete_during_merge Thu May 31 17:23:14 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}