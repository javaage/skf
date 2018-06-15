package com.skf.management.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class EquipmentModelExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table SKF_QPMT
	 * @mbg.generated  Fri Jun 15 18:04:35 CST 2018
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table SKF_QPMT
	 * @mbg.generated  Fri Jun 15 18:04:35 CST 2018
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table SKF_QPMT
	 * @mbg.generated  Fri Jun 15 18:04:35 CST 2018
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_QPMT
	 * @mbg.generated  Fri Jun 15 18:04:35 CST 2018
	 */
	public EquipmentModelExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_QPMT
	 * @mbg.generated  Fri Jun 15 18:04:35 CST 2018
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_QPMT
	 * @mbg.generated  Fri Jun 15 18:04:35 CST 2018
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_QPMT
	 * @mbg.generated  Fri Jun 15 18:04:35 CST 2018
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_QPMT
	 * @mbg.generated  Fri Jun 15 18:04:35 CST 2018
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_QPMT
	 * @mbg.generated  Fri Jun 15 18:04:35 CST 2018
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_QPMT
	 * @mbg.generated  Fri Jun 15 18:04:35 CST 2018
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_QPMT
	 * @mbg.generated  Fri Jun 15 18:04:35 CST 2018
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_QPMT
	 * @mbg.generated  Fri Jun 15 18:04:35 CST 2018
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_QPMT
	 * @mbg.generated  Fri Jun 15 18:04:35 CST 2018
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_QPMT
	 * @mbg.generated  Fri Jun 15 18:04:35 CST 2018
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table SKF_QPMT
	 * @mbg.generated  Fri Jun 15 18:04:35 CST 2018
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

		public Criteria andCodeIsNull() {
			addCriterion("QPMT_CODE is null");
			return (Criteria) this;
		}

		public Criteria andCodeIsNotNull() {
			addCriterion("QPMT_CODE is not null");
			return (Criteria) this;
		}

		public Criteria andCodeEqualTo(String value) {
			addCriterion("QPMT_CODE =", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotEqualTo(String value) {
			addCriterion("QPMT_CODE <>", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeGreaterThan(String value) {
			addCriterion("QPMT_CODE >", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeGreaterThanOrEqualTo(String value) {
			addCriterion("QPMT_CODE >=", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLessThan(String value) {
			addCriterion("QPMT_CODE <", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLessThanOrEqualTo(String value) {
			addCriterion("QPMT_CODE <=", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLike(String value) {
			addCriterion("QPMT_CODE like", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotLike(String value) {
			addCriterion("QPMT_CODE not like", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeIn(List<String> values) {
			addCriterion("QPMT_CODE in", values, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotIn(List<String> values) {
			addCriterion("QPMT_CODE not in", values, "code");
			return (Criteria) this;
		}

		public Criteria andCodeBetween(String value1, String value2) {
			addCriterion("QPMT_CODE between", value1, value2, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotBetween(String value1, String value2) {
			addCriterion("QPMT_CODE not between", value1, value2, "code");
			return (Criteria) this;
		}

		public Criteria andEquipmentTypeCodeIsNull() {
			addCriterion("QPMT_TYPE_CODE is null");
			return (Criteria) this;
		}

		public Criteria andEquipmentTypeCodeIsNotNull() {
			addCriterion("QPMT_TYPE_CODE is not null");
			return (Criteria) this;
		}

		public Criteria andEquipmentTypeCodeEqualTo(String value) {
			addCriterion("QPMT_TYPE_CODE =", value, "equipmentTypeCode");
			return (Criteria) this;
		}

		public Criteria andEquipmentTypeCodeNotEqualTo(String value) {
			addCriterion("QPMT_TYPE_CODE <>", value, "equipmentTypeCode");
			return (Criteria) this;
		}

		public Criteria andEquipmentTypeCodeGreaterThan(String value) {
			addCriterion("QPMT_TYPE_CODE >", value, "equipmentTypeCode");
			return (Criteria) this;
		}

		public Criteria andEquipmentTypeCodeGreaterThanOrEqualTo(String value) {
			addCriterion("QPMT_TYPE_CODE >=", value, "equipmentTypeCode");
			return (Criteria) this;
		}

		public Criteria andEquipmentTypeCodeLessThan(String value) {
			addCriterion("QPMT_TYPE_CODE <", value, "equipmentTypeCode");
			return (Criteria) this;
		}

		public Criteria andEquipmentTypeCodeLessThanOrEqualTo(String value) {
			addCriterion("QPMT_TYPE_CODE <=", value, "equipmentTypeCode");
			return (Criteria) this;
		}

		public Criteria andEquipmentTypeCodeLike(String value) {
			addCriterion("QPMT_TYPE_CODE like", value, "equipmentTypeCode");
			return (Criteria) this;
		}

		public Criteria andEquipmentTypeCodeNotLike(String value) {
			addCriterion("QPMT_TYPE_CODE not like", value, "equipmentTypeCode");
			return (Criteria) this;
		}

		public Criteria andEquipmentTypeCodeIn(List<String> values) {
			addCriterion("QPMT_TYPE_CODE in", values, "equipmentTypeCode");
			return (Criteria) this;
		}

		public Criteria andEquipmentTypeCodeNotIn(List<String> values) {
			addCriterion("QPMT_TYPE_CODE not in", values, "equipmentTypeCode");
			return (Criteria) this;
		}

		public Criteria andEquipmentTypeCodeBetween(String value1, String value2) {
			addCriterion("QPMT_TYPE_CODE between", value1, value2, "equipmentTypeCode");
			return (Criteria) this;
		}

		public Criteria andEquipmentTypeCodeNotBetween(String value1, String value2) {
			addCriterion("QPMT_TYPE_CODE not between", value1, value2, "equipmentTypeCode");
			return (Criteria) this;
		}

		public Criteria andNameIsNull() {
			addCriterion("QPMT_NAME is null");
			return (Criteria) this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("QPMT_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("QPMT_NAME =", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("QPMT_NAME <>", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("QPMT_NAME >", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("QPMT_NAME >=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("QPMT_NAME <", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("QPMT_NAME <=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("QPMT_NAME like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("QPMT_NAME not like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameIn(List<String> values) {
			addCriterion("QPMT_NAME in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotIn(List<String> values) {
			addCriterion("QPMT_NAME not in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("QPMT_NAME between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("QPMT_NAME not between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andSetupDateIsNull() {
			addCriterion("QPMT_SETUP_DATE is null");
			return (Criteria) this;
		}

		public Criteria andSetupDateIsNotNull() {
			addCriterion("QPMT_SETUP_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andSetupDateEqualTo(Date value) {
			addCriterionForJDBCDate("QPMT_SETUP_DATE =", value, "setupDate");
			return (Criteria) this;
		}

		public Criteria andSetupDateNotEqualTo(Date value) {
			addCriterionForJDBCDate("QPMT_SETUP_DATE <>", value, "setupDate");
			return (Criteria) this;
		}

		public Criteria andSetupDateGreaterThan(Date value) {
			addCriterionForJDBCDate("QPMT_SETUP_DATE >", value, "setupDate");
			return (Criteria) this;
		}

		public Criteria andSetupDateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("QPMT_SETUP_DATE >=", value, "setupDate");
			return (Criteria) this;
		}

		public Criteria andSetupDateLessThan(Date value) {
			addCriterionForJDBCDate("QPMT_SETUP_DATE <", value, "setupDate");
			return (Criteria) this;
		}

		public Criteria andSetupDateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("QPMT_SETUP_DATE <=", value, "setupDate");
			return (Criteria) this;
		}

		public Criteria andSetupDateIn(List<Date> values) {
			addCriterionForJDBCDate("QPMT_SETUP_DATE in", values, "setupDate");
			return (Criteria) this;
		}

		public Criteria andSetupDateNotIn(List<Date> values) {
			addCriterionForJDBCDate("QPMT_SETUP_DATE not in", values, "setupDate");
			return (Criteria) this;
		}

		public Criteria andSetupDateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("QPMT_SETUP_DATE between", value1, value2, "setupDate");
			return (Criteria) this;
		}

		public Criteria andSetupDateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("QPMT_SETUP_DATE not between", value1, value2, "setupDate");
			return (Criteria) this;
		}

		public Criteria andCustomerCodeIsNull() {
			addCriterion("QPMT_CSTM_CODE is null");
			return (Criteria) this;
		}

		public Criteria andCustomerCodeIsNotNull() {
			addCriterion("QPMT_CSTM_CODE is not null");
			return (Criteria) this;
		}

		public Criteria andCustomerCodeEqualTo(String value) {
			addCriterion("QPMT_CSTM_CODE =", value, "customerCode");
			return (Criteria) this;
		}

		public Criteria andCustomerCodeNotEqualTo(String value) {
			addCriterion("QPMT_CSTM_CODE <>", value, "customerCode");
			return (Criteria) this;
		}

		public Criteria andCustomerCodeGreaterThan(String value) {
			addCriterion("QPMT_CSTM_CODE >", value, "customerCode");
			return (Criteria) this;
		}

		public Criteria andCustomerCodeGreaterThanOrEqualTo(String value) {
			addCriterion("QPMT_CSTM_CODE >=", value, "customerCode");
			return (Criteria) this;
		}

		public Criteria andCustomerCodeLessThan(String value) {
			addCriterion("QPMT_CSTM_CODE <", value, "customerCode");
			return (Criteria) this;
		}

		public Criteria andCustomerCodeLessThanOrEqualTo(String value) {
			addCriterion("QPMT_CSTM_CODE <=", value, "customerCode");
			return (Criteria) this;
		}

		public Criteria andCustomerCodeLike(String value) {
			addCriterion("QPMT_CSTM_CODE like", value, "customerCode");
			return (Criteria) this;
		}

		public Criteria andCustomerCodeNotLike(String value) {
			addCriterion("QPMT_CSTM_CODE not like", value, "customerCode");
			return (Criteria) this;
		}

		public Criteria andCustomerCodeIn(List<String> values) {
			addCriterion("QPMT_CSTM_CODE in", values, "customerCode");
			return (Criteria) this;
		}

		public Criteria andCustomerCodeNotIn(List<String> values) {
			addCriterion("QPMT_CSTM_CODE not in", values, "customerCode");
			return (Criteria) this;
		}

		public Criteria andCustomerCodeBetween(String value1, String value2) {
			addCriterion("QPMT_CSTM_CODE between", value1, value2, "customerCode");
			return (Criteria) this;
		}

		public Criteria andCustomerCodeNotBetween(String value1, String value2) {
			addCriterion("QPMT_CSTM_CODE not between", value1, value2, "customerCode");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table SKF_QPMT
	 * @mbg.generated  Fri Jun 15 18:04:35 CST 2018
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
     * This class corresponds to the database table skf_qpmt
     *
     * @mbg.generated do_not_delete_during_merge Thu May 31 17:23:14 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}