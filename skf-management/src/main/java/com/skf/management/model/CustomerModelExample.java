package com.skf.management.model;

import java.util.ArrayList;
import java.util.List;

public class CustomerModelExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table SKF_CSTM
	 * @mbg.generated  Tue Jun 05 16:50:42 CST 2018
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table SKF_CSTM
	 * @mbg.generated  Tue Jun 05 16:50:42 CST 2018
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table SKF_CSTM
	 * @mbg.generated  Tue Jun 05 16:50:42 CST 2018
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_CSTM
	 * @mbg.generated  Tue Jun 05 16:50:42 CST 2018
	 */
	public CustomerModelExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_CSTM
	 * @mbg.generated  Tue Jun 05 16:50:42 CST 2018
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_CSTM
	 * @mbg.generated  Tue Jun 05 16:50:42 CST 2018
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_CSTM
	 * @mbg.generated  Tue Jun 05 16:50:42 CST 2018
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_CSTM
	 * @mbg.generated  Tue Jun 05 16:50:42 CST 2018
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_CSTM
	 * @mbg.generated  Tue Jun 05 16:50:42 CST 2018
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_CSTM
	 * @mbg.generated  Tue Jun 05 16:50:42 CST 2018
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_CSTM
	 * @mbg.generated  Tue Jun 05 16:50:42 CST 2018
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_CSTM
	 * @mbg.generated  Tue Jun 05 16:50:42 CST 2018
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_CSTM
	 * @mbg.generated  Tue Jun 05 16:50:42 CST 2018
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_CSTM
	 * @mbg.generated  Tue Jun 05 16:50:42 CST 2018
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table SKF_CSTM
	 * @mbg.generated  Tue Jun 05 16:50:42 CST 2018
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
			addCriterion("CSTM_CODE is null");
			return (Criteria) this;
		}

		public Criteria andCodeIsNotNull() {
			addCriterion("CSTM_CODE is not null");
			return (Criteria) this;
		}

		public Criteria andCodeEqualTo(String value) {
			addCriterion("CSTM_CODE =", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotEqualTo(String value) {
			addCriterion("CSTM_CODE <>", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeGreaterThan(String value) {
			addCriterion("CSTM_CODE >", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeGreaterThanOrEqualTo(String value) {
			addCriterion("CSTM_CODE >=", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLessThan(String value) {
			addCriterion("CSTM_CODE <", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLessThanOrEqualTo(String value) {
			addCriterion("CSTM_CODE <=", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLike(String value) {
			addCriterion("CSTM_CODE like", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotLike(String value) {
			addCriterion("CSTM_CODE not like", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeIn(List<String> values) {
			addCriterion("CSTM_CODE in", values, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotIn(List<String> values) {
			addCriterion("CSTM_CODE not in", values, "code");
			return (Criteria) this;
		}

		public Criteria andCodeBetween(String value1, String value2) {
			addCriterion("CSTM_CODE between", value1, value2, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotBetween(String value1, String value2) {
			addCriterion("CSTM_CODE not between", value1, value2, "code");
			return (Criteria) this;
		}

		public Criteria andOemCodeIsNull() {
			addCriterion("CSTM_OEM_CODE is null");
			return (Criteria) this;
		}

		public Criteria andOemCodeIsNotNull() {
			addCriterion("CSTM_OEM_CODE is not null");
			return (Criteria) this;
		}

		public Criteria andOemCodeEqualTo(String value) {
			addCriterion("CSTM_OEM_CODE =", value, "oemCode");
			return (Criteria) this;
		}

		public Criteria andOemCodeNotEqualTo(String value) {
			addCriterion("CSTM_OEM_CODE <>", value, "oemCode");
			return (Criteria) this;
		}

		public Criteria andOemCodeGreaterThan(String value) {
			addCriterion("CSTM_OEM_CODE >", value, "oemCode");
			return (Criteria) this;
		}

		public Criteria andOemCodeGreaterThanOrEqualTo(String value) {
			addCriterion("CSTM_OEM_CODE >=", value, "oemCode");
			return (Criteria) this;
		}

		public Criteria andOemCodeLessThan(String value) {
			addCriterion("CSTM_OEM_CODE <", value, "oemCode");
			return (Criteria) this;
		}

		public Criteria andOemCodeLessThanOrEqualTo(String value) {
			addCriterion("CSTM_OEM_CODE <=", value, "oemCode");
			return (Criteria) this;
		}

		public Criteria andOemCodeLike(String value) {
			addCriterion("CSTM_OEM_CODE like", value, "oemCode");
			return (Criteria) this;
		}

		public Criteria andOemCodeNotLike(String value) {
			addCriterion("CSTM_OEM_CODE not like", value, "oemCode");
			return (Criteria) this;
		}

		public Criteria andOemCodeIn(List<String> values) {
			addCriterion("CSTM_OEM_CODE in", values, "oemCode");
			return (Criteria) this;
		}

		public Criteria andOemCodeNotIn(List<String> values) {
			addCriterion("CSTM_OEM_CODE not in", values, "oemCode");
			return (Criteria) this;
		}

		public Criteria andOemCodeBetween(String value1, String value2) {
			addCriterion("CSTM_OEM_CODE between", value1, value2, "oemCode");
			return (Criteria) this;
		}

		public Criteria andOemCodeNotBetween(String value1, String value2) {
			addCriterion("CSTM_OEM_CODE not between", value1, value2, "oemCode");
			return (Criteria) this;
		}

		public Criteria andNameIsNull() {
			addCriterion("CSTM_NAME is null");
			return (Criteria) this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("CSTM_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("CSTM_NAME =", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("CSTM_NAME <>", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("CSTM_NAME >", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("CSTM_NAME >=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("CSTM_NAME <", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("CSTM_NAME <=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("CSTM_NAME like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("CSTM_NAME not like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameIn(List<String> values) {
			addCriterion("CSTM_NAME in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotIn(List<String> values) {
			addCriterion("CSTM_NAME not in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("CSTM_NAME between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("CSTM_NAME not between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andCountryIsNull() {
			addCriterion("CSTM_COUNTRY is null");
			return (Criteria) this;
		}

		public Criteria andCountryIsNotNull() {
			addCriterion("CSTM_COUNTRY is not null");
			return (Criteria) this;
		}

		public Criteria andCountryEqualTo(String value) {
			addCriterion("CSTM_COUNTRY =", value, "country");
			return (Criteria) this;
		}

		public Criteria andCountryNotEqualTo(String value) {
			addCriterion("CSTM_COUNTRY <>", value, "country");
			return (Criteria) this;
		}

		public Criteria andCountryGreaterThan(String value) {
			addCriterion("CSTM_COUNTRY >", value, "country");
			return (Criteria) this;
		}

		public Criteria andCountryGreaterThanOrEqualTo(String value) {
			addCriterion("CSTM_COUNTRY >=", value, "country");
			return (Criteria) this;
		}

		public Criteria andCountryLessThan(String value) {
			addCriterion("CSTM_COUNTRY <", value, "country");
			return (Criteria) this;
		}

		public Criteria andCountryLessThanOrEqualTo(String value) {
			addCriterion("CSTM_COUNTRY <=", value, "country");
			return (Criteria) this;
		}

		public Criteria andCountryLike(String value) {
			addCriterion("CSTM_COUNTRY like", value, "country");
			return (Criteria) this;
		}

		public Criteria andCountryNotLike(String value) {
			addCriterion("CSTM_COUNTRY not like", value, "country");
			return (Criteria) this;
		}

		public Criteria andCountryIn(List<String> values) {
			addCriterion("CSTM_COUNTRY in", values, "country");
			return (Criteria) this;
		}

		public Criteria andCountryNotIn(List<String> values) {
			addCriterion("CSTM_COUNTRY not in", values, "country");
			return (Criteria) this;
		}

		public Criteria andCountryBetween(String value1, String value2) {
			addCriterion("CSTM_COUNTRY between", value1, value2, "country");
			return (Criteria) this;
		}

		public Criteria andCountryNotBetween(String value1, String value2) {
			addCriterion("CSTM_COUNTRY not between", value1, value2, "country");
			return (Criteria) this;
		}

		public Criteria andStateIsNull() {
			addCriterion("CSTM_STATE is null");
			return (Criteria) this;
		}

		public Criteria andStateIsNotNull() {
			addCriterion("CSTM_STATE is not null");
			return (Criteria) this;
		}

		public Criteria andStateEqualTo(String value) {
			addCriterion("CSTM_STATE =", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateNotEqualTo(String value) {
			addCriterion("CSTM_STATE <>", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateGreaterThan(String value) {
			addCriterion("CSTM_STATE >", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateGreaterThanOrEqualTo(String value) {
			addCriterion("CSTM_STATE >=", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateLessThan(String value) {
			addCriterion("CSTM_STATE <", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateLessThanOrEqualTo(String value) {
			addCriterion("CSTM_STATE <=", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateLike(String value) {
			addCriterion("CSTM_STATE like", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateNotLike(String value) {
			addCriterion("CSTM_STATE not like", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateIn(List<String> values) {
			addCriterion("CSTM_STATE in", values, "state");
			return (Criteria) this;
		}

		public Criteria andStateNotIn(List<String> values) {
			addCriterion("CSTM_STATE not in", values, "state");
			return (Criteria) this;
		}

		public Criteria andStateBetween(String value1, String value2) {
			addCriterion("CSTM_STATE between", value1, value2, "state");
			return (Criteria) this;
		}

		public Criteria andStateNotBetween(String value1, String value2) {
			addCriterion("CSTM_STATE not between", value1, value2, "state");
			return (Criteria) this;
		}

		public Criteria andCityIsNull() {
			addCriterion("CSTM_CITY is null");
			return (Criteria) this;
		}

		public Criteria andCityIsNotNull() {
			addCriterion("CSTM_CITY is not null");
			return (Criteria) this;
		}

		public Criteria andCityEqualTo(String value) {
			addCriterion("CSTM_CITY =", value, "city");
			return (Criteria) this;
		}

		public Criteria andCityNotEqualTo(String value) {
			addCriterion("CSTM_CITY <>", value, "city");
			return (Criteria) this;
		}

		public Criteria andCityGreaterThan(String value) {
			addCriterion("CSTM_CITY >", value, "city");
			return (Criteria) this;
		}

		public Criteria andCityGreaterThanOrEqualTo(String value) {
			addCriterion("CSTM_CITY >=", value, "city");
			return (Criteria) this;
		}

		public Criteria andCityLessThan(String value) {
			addCriterion("CSTM_CITY <", value, "city");
			return (Criteria) this;
		}

		public Criteria andCityLessThanOrEqualTo(String value) {
			addCriterion("CSTM_CITY <=", value, "city");
			return (Criteria) this;
		}

		public Criteria andCityLike(String value) {
			addCriterion("CSTM_CITY like", value, "city");
			return (Criteria) this;
		}

		public Criteria andCityNotLike(String value) {
			addCriterion("CSTM_CITY not like", value, "city");
			return (Criteria) this;
		}

		public Criteria andCityIn(List<String> values) {
			addCriterion("CSTM_CITY in", values, "city");
			return (Criteria) this;
		}

		public Criteria andCityNotIn(List<String> values) {
			addCriterion("CSTM_CITY not in", values, "city");
			return (Criteria) this;
		}

		public Criteria andCityBetween(String value1, String value2) {
			addCriterion("CSTM_CITY between", value1, value2, "city");
			return (Criteria) this;
		}

		public Criteria andCityNotBetween(String value1, String value2) {
			addCriterion("CSTM_CITY not between", value1, value2, "city");
			return (Criteria) this;
		}

		public Criteria andAddressIsNull() {
			addCriterion("CSTM_ADDRESS is null");
			return (Criteria) this;
		}

		public Criteria andAddressIsNotNull() {
			addCriterion("CSTM_ADDRESS is not null");
			return (Criteria) this;
		}

		public Criteria andAddressEqualTo(String value) {
			addCriterion("CSTM_ADDRESS =", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotEqualTo(String value) {
			addCriterion("CSTM_ADDRESS <>", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressGreaterThan(String value) {
			addCriterion("CSTM_ADDRESS >", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressGreaterThanOrEqualTo(String value) {
			addCriterion("CSTM_ADDRESS >=", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressLessThan(String value) {
			addCriterion("CSTM_ADDRESS <", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressLessThanOrEqualTo(String value) {
			addCriterion("CSTM_ADDRESS <=", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressLike(String value) {
			addCriterion("CSTM_ADDRESS like", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotLike(String value) {
			addCriterion("CSTM_ADDRESS not like", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressIn(List<String> values) {
			addCriterion("CSTM_ADDRESS in", values, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotIn(List<String> values) {
			addCriterion("CSTM_ADDRESS not in", values, "address");
			return (Criteria) this;
		}

		public Criteria andAddressBetween(String value1, String value2) {
			addCriterion("CSTM_ADDRESS between", value1, value2, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotBetween(String value1, String value2) {
			addCriterion("CSTM_ADDRESS not between", value1, value2, "address");
			return (Criteria) this;
		}

		public Criteria andUrlIsNull() {
			addCriterion("CSTM_URL is null");
			return (Criteria) this;
		}

		public Criteria andUrlIsNotNull() {
			addCriterion("CSTM_URL is not null");
			return (Criteria) this;
		}

		public Criteria andUrlEqualTo(String value) {
			addCriterion("CSTM_URL =", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlNotEqualTo(String value) {
			addCriterion("CSTM_URL <>", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlGreaterThan(String value) {
			addCriterion("CSTM_URL >", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlGreaterThanOrEqualTo(String value) {
			addCriterion("CSTM_URL >=", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlLessThan(String value) {
			addCriterion("CSTM_URL <", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlLessThanOrEqualTo(String value) {
			addCriterion("CSTM_URL <=", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlLike(String value) {
			addCriterion("CSTM_URL like", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlNotLike(String value) {
			addCriterion("CSTM_URL not like", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlIn(List<String> values) {
			addCriterion("CSTM_URL in", values, "url");
			return (Criteria) this;
		}

		public Criteria andUrlNotIn(List<String> values) {
			addCriterion("CSTM_URL not in", values, "url");
			return (Criteria) this;
		}

		public Criteria andUrlBetween(String value1, String value2) {
			addCriterion("CSTM_URL between", value1, value2, "url");
			return (Criteria) this;
		}

		public Criteria andUrlNotBetween(String value1, String value2) {
			addCriterion("CSTM_URL not between", value1, value2, "url");
			return (Criteria) this;
		}

		public Criteria andIntroductionIsNull() {
			addCriterion("CSTM_INTRODUCTION is null");
			return (Criteria) this;
		}

		public Criteria andIntroductionIsNotNull() {
			addCriterion("CSTM_INTRODUCTION is not null");
			return (Criteria) this;
		}

		public Criteria andIntroductionEqualTo(String value) {
			addCriterion("CSTM_INTRODUCTION =", value, "introduction");
			return (Criteria) this;
		}

		public Criteria andIntroductionNotEqualTo(String value) {
			addCriterion("CSTM_INTRODUCTION <>", value, "introduction");
			return (Criteria) this;
		}

		public Criteria andIntroductionGreaterThan(String value) {
			addCriterion("CSTM_INTRODUCTION >", value, "introduction");
			return (Criteria) this;
		}

		public Criteria andIntroductionGreaterThanOrEqualTo(String value) {
			addCriterion("CSTM_INTRODUCTION >=", value, "introduction");
			return (Criteria) this;
		}

		public Criteria andIntroductionLessThan(String value) {
			addCriterion("CSTM_INTRODUCTION <", value, "introduction");
			return (Criteria) this;
		}

		public Criteria andIntroductionLessThanOrEqualTo(String value) {
			addCriterion("CSTM_INTRODUCTION <=", value, "introduction");
			return (Criteria) this;
		}

		public Criteria andIntroductionLike(String value) {
			addCriterion("CSTM_INTRODUCTION like", value, "introduction");
			return (Criteria) this;
		}

		public Criteria andIntroductionNotLike(String value) {
			addCriterion("CSTM_INTRODUCTION not like", value, "introduction");
			return (Criteria) this;
		}

		public Criteria andIntroductionIn(List<String> values) {
			addCriterion("CSTM_INTRODUCTION in", values, "introduction");
			return (Criteria) this;
		}

		public Criteria andIntroductionNotIn(List<String> values) {
			addCriterion("CSTM_INTRODUCTION not in", values, "introduction");
			return (Criteria) this;
		}

		public Criteria andIntroductionBetween(String value1, String value2) {
			addCriterion("CSTM_INTRODUCTION between", value1, value2, "introduction");
			return (Criteria) this;
		}

		public Criteria andIntroductionNotBetween(String value1, String value2) {
			addCriterion("CSTM_INTRODUCTION not between", value1, value2, "introduction");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table SKF_CSTM
	 * @mbg.generated  Tue Jun 05 16:50:42 CST 2018
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
     * This class corresponds to the database table skf_cstm
     *
     * @mbg.generated do_not_delete_during_merge Thu May 31 17:23:14 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}