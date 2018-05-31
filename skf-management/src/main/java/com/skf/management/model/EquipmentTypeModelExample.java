package com.skf.management.model;

import java.util.ArrayList;
import java.util.List;

public class EquipmentTypeModelExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table skf_qpmt_type
	 * @mbg.generated  Tue May 22 14:56:15 CST 2018
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table skf_qpmt_type
	 * @mbg.generated  Tue May 22 14:56:15 CST 2018
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table skf_qpmt_type
	 * @mbg.generated  Tue May 22 14:56:15 CST 2018
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_qpmt_type
	 * @mbg.generated  Tue May 22 14:56:15 CST 2018
	 */
	public EquipmentTypeModelExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_qpmt_type
	 * @mbg.generated  Tue May 22 14:56:15 CST 2018
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_qpmt_type
	 * @mbg.generated  Tue May 22 14:56:15 CST 2018
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_qpmt_type
	 * @mbg.generated  Tue May 22 14:56:15 CST 2018
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_qpmt_type
	 * @mbg.generated  Tue May 22 14:56:15 CST 2018
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_qpmt_type
	 * @mbg.generated  Tue May 22 14:56:15 CST 2018
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_qpmt_type
	 * @mbg.generated  Tue May 22 14:56:15 CST 2018
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_qpmt_type
	 * @mbg.generated  Tue May 22 14:56:15 CST 2018
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_qpmt_type
	 * @mbg.generated  Tue May 22 14:56:15 CST 2018
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_qpmt_type
	 * @mbg.generated  Tue May 22 14:56:15 CST 2018
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_qpmt_type
	 * @mbg.generated  Tue May 22 14:56:15 CST 2018
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table skf_qpmt_type
	 * @mbg.generated  Tue May 22 14:56:15 CST 2018
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

		public Criteria andCodeIsNull() {
			addCriterion("QPTP_TYPE_CODE is null");
			return (Criteria) this;
		}

		public Criteria andCodeIsNotNull() {
			addCriterion("QPTP_TYPE_CODE is not null");
			return (Criteria) this;
		}

		public Criteria andCodeEqualTo(String value) {
			addCriterion("QPTP_TYPE_CODE =", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotEqualTo(String value) {
			addCriterion("QPTP_TYPE_CODE <>", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeGreaterThan(String value) {
			addCriterion("QPTP_TYPE_CODE >", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeGreaterThanOrEqualTo(String value) {
			addCriterion("QPTP_TYPE_CODE >=", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLessThan(String value) {
			addCriterion("QPTP_TYPE_CODE <", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLessThanOrEqualTo(String value) {
			addCriterion("QPTP_TYPE_CODE <=", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLike(String value) {
			addCriterion("QPTP_TYPE_CODE like", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotLike(String value) {
			addCriterion("QPTP_TYPE_CODE not like", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeIn(List<String> values) {
			addCriterion("QPTP_TYPE_CODE in", values, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotIn(List<String> values) {
			addCriterion("QPTP_TYPE_CODE not in", values, "code");
			return (Criteria) this;
		}

		public Criteria andCodeBetween(String value1, String value2) {
			addCriterion("QPTP_TYPE_CODE between", value1, value2, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotBetween(String value1, String value2) {
			addCriterion("QPTP_TYPE_CODE not between", value1, value2, "code");
			return (Criteria) this;
		}

		public Criteria andCustomerCodeIsNull() {
			addCriterion("QPTP_CSTM_CODE is null");
			return (Criteria) this;
		}

		public Criteria andCustomerCodeIsNotNull() {
			addCriterion("QPTP_CSTM_CODE is not null");
			return (Criteria) this;
		}

		public Criteria andCustomerCodeEqualTo(String value) {
			addCriterion("QPTP_CSTM_CODE =", value, "customerCode");
			return (Criteria) this;
		}

		public Criteria andCustomerCodeNotEqualTo(String value) {
			addCriterion("QPTP_CSTM_CODE <>", value, "customerCode");
			return (Criteria) this;
		}

		public Criteria andCustomerCodeGreaterThan(String value) {
			addCriterion("QPTP_CSTM_CODE >", value, "customerCode");
			return (Criteria) this;
		}

		public Criteria andCustomerCodeGreaterThanOrEqualTo(String value) {
			addCriterion("QPTP_CSTM_CODE >=", value, "customerCode");
			return (Criteria) this;
		}

		public Criteria andCustomerCodeLessThan(String value) {
			addCriterion("QPTP_CSTM_CODE <", value, "customerCode");
			return (Criteria) this;
		}

		public Criteria andCustomerCodeLessThanOrEqualTo(String value) {
			addCriterion("QPTP_CSTM_CODE <=", value, "customerCode");
			return (Criteria) this;
		}

		public Criteria andCustomerCodeLike(String value) {
			addCriterion("QPTP_CSTM_CODE like", value, "customerCode");
			return (Criteria) this;
		}

		public Criteria andCustomerCodeNotLike(String value) {
			addCriterion("QPTP_CSTM_CODE not like", value, "customerCode");
			return (Criteria) this;
		}

		public Criteria andCustomerCodeIn(List<String> values) {
			addCriterion("QPTP_CSTM_CODE in", values, "customerCode");
			return (Criteria) this;
		}

		public Criteria andCustomerCodeNotIn(List<String> values) {
			addCriterion("QPTP_CSTM_CODE not in", values, "customerCode");
			return (Criteria) this;
		}

		public Criteria andCustomerCodeBetween(String value1, String value2) {
			addCriterion("QPTP_CSTM_CODE between", value1, value2, "customerCode");
			return (Criteria) this;
		}

		public Criteria andCustomerCodeNotBetween(String value1, String value2) {
			addCriterion("QPTP_CSTM_CODE not between", value1, value2, "customerCode");
			return (Criteria) this;
		}

		public Criteria andNameIsNull() {
			addCriterion("QPTP_TYPE_NAME is null");
			return (Criteria) this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("QPTP_TYPE_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("QPTP_TYPE_NAME =", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("QPTP_TYPE_NAME <>", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("QPTP_TYPE_NAME >", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("QPTP_TYPE_NAME >=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("QPTP_TYPE_NAME <", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("QPTP_TYPE_NAME <=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("QPTP_TYPE_NAME like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("QPTP_TYPE_NAME not like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameIn(List<String> values) {
			addCriterion("QPTP_TYPE_NAME in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotIn(List<String> values) {
			addCriterion("QPTP_TYPE_NAME not in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("QPTP_TYPE_NAME between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("QPTP_TYPE_NAME not between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andDescriptionIsNull() {
			addCriterion("QPTP_TYPE_DESC is null");
			return (Criteria) this;
		}

		public Criteria andDescriptionIsNotNull() {
			addCriterion("QPTP_TYPE_DESC is not null");
			return (Criteria) this;
		}

		public Criteria andDescriptionEqualTo(String value) {
			addCriterion("QPTP_TYPE_DESC =", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotEqualTo(String value) {
			addCriterion("QPTP_TYPE_DESC <>", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionGreaterThan(String value) {
			addCriterion("QPTP_TYPE_DESC >", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
			addCriterion("QPTP_TYPE_DESC >=", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionLessThan(String value) {
			addCriterion("QPTP_TYPE_DESC <", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionLessThanOrEqualTo(String value) {
			addCriterion("QPTP_TYPE_DESC <=", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionLike(String value) {
			addCriterion("QPTP_TYPE_DESC like", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotLike(String value) {
			addCriterion("QPTP_TYPE_DESC not like", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionIn(List<String> values) {
			addCriterion("QPTP_TYPE_DESC in", values, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotIn(List<String> values) {
			addCriterion("QPTP_TYPE_DESC not in", values, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionBetween(String value1, String value2) {
			addCriterion("QPTP_TYPE_DESC between", value1, value2, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotBetween(String value1, String value2) {
			addCriterion("QPTP_TYPE_DESC not between", value1, value2, "description");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table skf_qpmt_type
	 * @mbg.generated  Tue May 22 14:56:15 CST 2018
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
     * This class corresponds to the database table skf_qpmt_type
     *
     * @mbg.generated do_not_delete_during_merge Fri May 11 17:49:13 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}