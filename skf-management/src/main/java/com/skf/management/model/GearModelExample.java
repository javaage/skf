package com.skf.management.model;

import java.util.ArrayList;
import java.util.List;

public class GearModelExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table SKF_GEAR
	 * @mbg.generated  Tue Jun 05 16:50:42 CST 2018
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table SKF_GEAR
	 * @mbg.generated  Tue Jun 05 16:50:42 CST 2018
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table SKF_GEAR
	 * @mbg.generated  Tue Jun 05 16:50:42 CST 2018
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_GEAR
	 * @mbg.generated  Tue Jun 05 16:50:42 CST 2018
	 */
	public GearModelExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_GEAR
	 * @mbg.generated  Tue Jun 05 16:50:42 CST 2018
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_GEAR
	 * @mbg.generated  Tue Jun 05 16:50:42 CST 2018
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_GEAR
	 * @mbg.generated  Tue Jun 05 16:50:42 CST 2018
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_GEAR
	 * @mbg.generated  Tue Jun 05 16:50:42 CST 2018
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_GEAR
	 * @mbg.generated  Tue Jun 05 16:50:42 CST 2018
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_GEAR
	 * @mbg.generated  Tue Jun 05 16:50:42 CST 2018
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_GEAR
	 * @mbg.generated  Tue Jun 05 16:50:42 CST 2018
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_GEAR
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_GEAR
	 * @mbg.generated  Tue Jun 05 16:50:42 CST 2018
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_GEAR
	 * @mbg.generated  Tue Jun 05 16:50:42 CST 2018
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table SKF_GEAR
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
			addCriterion("GEAR_CODE is null");
			return (Criteria) this;
		}

		public Criteria andCodeIsNotNull() {
			addCriterion("GEAR_CODE is not null");
			return (Criteria) this;
		}

		public Criteria andCodeEqualTo(String value) {
			addCriterion("GEAR_CODE =", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotEqualTo(String value) {
			addCriterion("GEAR_CODE <>", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeGreaterThan(String value) {
			addCriterion("GEAR_CODE >", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeGreaterThanOrEqualTo(String value) {
			addCriterion("GEAR_CODE >=", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLessThan(String value) {
			addCriterion("GEAR_CODE <", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLessThanOrEqualTo(String value) {
			addCriterion("GEAR_CODE <=", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLike(String value) {
			addCriterion("GEAR_CODE like", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotLike(String value) {
			addCriterion("GEAR_CODE not like", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeIn(List<String> values) {
			addCriterion("GEAR_CODE in", values, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotIn(List<String> values) {
			addCriterion("GEAR_CODE not in", values, "code");
			return (Criteria) this;
		}

		public Criteria andCodeBetween(String value1, String value2) {
			addCriterion("GEAR_CODE between", value1, value2, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotBetween(String value1, String value2) {
			addCriterion("GEAR_CODE not between", value1, value2, "code");
			return (Criteria) this;
		}

		public Criteria andModelNumberIsNull() {
			addCriterion("GEAR_MODEL_NUMBER is null");
			return (Criteria) this;
		}

		public Criteria andModelNumberIsNotNull() {
			addCriterion("GEAR_MODEL_NUMBER is not null");
			return (Criteria) this;
		}

		public Criteria andModelNumberEqualTo(Integer value) {
			addCriterion("GEAR_MODEL_NUMBER =", value, "modelNumber");
			return (Criteria) this;
		}

		public Criteria andModelNumberNotEqualTo(Integer value) {
			addCriterion("GEAR_MODEL_NUMBER <>", value, "modelNumber");
			return (Criteria) this;
		}

		public Criteria andModelNumberGreaterThan(Integer value) {
			addCriterion("GEAR_MODEL_NUMBER >", value, "modelNumber");
			return (Criteria) this;
		}

		public Criteria andModelNumberGreaterThanOrEqualTo(Integer value) {
			addCriterion("GEAR_MODEL_NUMBER >=", value, "modelNumber");
			return (Criteria) this;
		}

		public Criteria andModelNumberLessThan(Integer value) {
			addCriterion("GEAR_MODEL_NUMBER <", value, "modelNumber");
			return (Criteria) this;
		}

		public Criteria andModelNumberLessThanOrEqualTo(Integer value) {
			addCriterion("GEAR_MODEL_NUMBER <=", value, "modelNumber");
			return (Criteria) this;
		}

		public Criteria andModelNumberIn(List<Integer> values) {
			addCriterion("GEAR_MODEL_NUMBER in", values, "modelNumber");
			return (Criteria) this;
		}

		public Criteria andModelNumberNotIn(List<Integer> values) {
			addCriterion("GEAR_MODEL_NUMBER not in", values, "modelNumber");
			return (Criteria) this;
		}

		public Criteria andModelNumberBetween(Integer value1, Integer value2) {
			addCriterion("GEAR_MODEL_NUMBER between", value1, value2, "modelNumber");
			return (Criteria) this;
		}

		public Criteria andModelNumberNotBetween(Integer value1, Integer value2) {
			addCriterion("GEAR_MODEL_NUMBER not between", value1, value2, "modelNumber");
			return (Criteria) this;
		}

		public Criteria andManufactureIsNull() {
			addCriterion("GEAR_MANUFACTURE is null");
			return (Criteria) this;
		}

		public Criteria andManufactureIsNotNull() {
			addCriterion("GEAR_MANUFACTURE is not null");
			return (Criteria) this;
		}

		public Criteria andManufactureEqualTo(String value) {
			addCriterion("GEAR_MANUFACTURE =", value, "manufacture");
			return (Criteria) this;
		}

		public Criteria andManufactureNotEqualTo(String value) {
			addCriterion("GEAR_MANUFACTURE <>", value, "manufacture");
			return (Criteria) this;
		}

		public Criteria andManufactureGreaterThan(String value) {
			addCriterion("GEAR_MANUFACTURE >", value, "manufacture");
			return (Criteria) this;
		}

		public Criteria andManufactureGreaterThanOrEqualTo(String value) {
			addCriterion("GEAR_MANUFACTURE >=", value, "manufacture");
			return (Criteria) this;
		}

		public Criteria andManufactureLessThan(String value) {
			addCriterion("GEAR_MANUFACTURE <", value, "manufacture");
			return (Criteria) this;
		}

		public Criteria andManufactureLessThanOrEqualTo(String value) {
			addCriterion("GEAR_MANUFACTURE <=", value, "manufacture");
			return (Criteria) this;
		}

		public Criteria andManufactureLike(String value) {
			addCriterion("GEAR_MANUFACTURE like", value, "manufacture");
			return (Criteria) this;
		}

		public Criteria andManufactureNotLike(String value) {
			addCriterion("GEAR_MANUFACTURE not like", value, "manufacture");
			return (Criteria) this;
		}

		public Criteria andManufactureIn(List<String> values) {
			addCriterion("GEAR_MANUFACTURE in", values, "manufacture");
			return (Criteria) this;
		}

		public Criteria andManufactureNotIn(List<String> values) {
			addCriterion("GEAR_MANUFACTURE not in", values, "manufacture");
			return (Criteria) this;
		}

		public Criteria andManufactureBetween(String value1, String value2) {
			addCriterion("GEAR_MANUFACTURE between", value1, value2, "manufacture");
			return (Criteria) this;
		}

		public Criteria andManufactureNotBetween(String value1, String value2) {
			addCriterion("GEAR_MANUFACTURE not between", value1, value2, "manufacture");
			return (Criteria) this;
		}

		public Criteria andDescriptionIsNull() {
			addCriterion("GEAR_DESCRIPTION is null");
			return (Criteria) this;
		}

		public Criteria andDescriptionIsNotNull() {
			addCriterion("GEAR_DESCRIPTION is not null");
			return (Criteria) this;
		}

		public Criteria andDescriptionEqualTo(String value) {
			addCriterion("GEAR_DESCRIPTION =", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotEqualTo(String value) {
			addCriterion("GEAR_DESCRIPTION <>", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionGreaterThan(String value) {
			addCriterion("GEAR_DESCRIPTION >", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
			addCriterion("GEAR_DESCRIPTION >=", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionLessThan(String value) {
			addCriterion("GEAR_DESCRIPTION <", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionLessThanOrEqualTo(String value) {
			addCriterion("GEAR_DESCRIPTION <=", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionLike(String value) {
			addCriterion("GEAR_DESCRIPTION like", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotLike(String value) {
			addCriterion("GEAR_DESCRIPTION not like", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionIn(List<String> values) {
			addCriterion("GEAR_DESCRIPTION in", values, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotIn(List<String> values) {
			addCriterion("GEAR_DESCRIPTION not in", values, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionBetween(String value1, String value2) {
			addCriterion("GEAR_DESCRIPTION between", value1, value2, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotBetween(String value1, String value2) {
			addCriterion("GEAR_DESCRIPTION not between", value1, value2, "description");
			return (Criteria) this;
		}

		public Criteria andMeshingFrequencyIsNull() {
			addCriterion("GEAR_MESHING_FREQUENCY is null");
			return (Criteria) this;
		}

		public Criteria andMeshingFrequencyIsNotNull() {
			addCriterion("GEAR_MESHING_FREQUENCY is not null");
			return (Criteria) this;
		}

		public Criteria andMeshingFrequencyEqualTo(Float value) {
			addCriterion("GEAR_MESHING_FREQUENCY =", value, "meshingFrequency");
			return (Criteria) this;
		}

		public Criteria andMeshingFrequencyNotEqualTo(Float value) {
			addCriterion("GEAR_MESHING_FREQUENCY <>", value, "meshingFrequency");
			return (Criteria) this;
		}

		public Criteria andMeshingFrequencyGreaterThan(Float value) {
			addCriterion("GEAR_MESHING_FREQUENCY >", value, "meshingFrequency");
			return (Criteria) this;
		}

		public Criteria andMeshingFrequencyGreaterThanOrEqualTo(Float value) {
			addCriterion("GEAR_MESHING_FREQUENCY >=", value, "meshingFrequency");
			return (Criteria) this;
		}

		public Criteria andMeshingFrequencyLessThan(Float value) {
			addCriterion("GEAR_MESHING_FREQUENCY <", value, "meshingFrequency");
			return (Criteria) this;
		}

		public Criteria andMeshingFrequencyLessThanOrEqualTo(Float value) {
			addCriterion("GEAR_MESHING_FREQUENCY <=", value, "meshingFrequency");
			return (Criteria) this;
		}

		public Criteria andMeshingFrequencyIn(List<Float> values) {
			addCriterion("GEAR_MESHING_FREQUENCY in", values, "meshingFrequency");
			return (Criteria) this;
		}

		public Criteria andMeshingFrequencyNotIn(List<Float> values) {
			addCriterion("GEAR_MESHING_FREQUENCY not in", values, "meshingFrequency");
			return (Criteria) this;
		}

		public Criteria andMeshingFrequencyBetween(Float value1, Float value2) {
			addCriterion("GEAR_MESHING_FREQUENCY between", value1, value2, "meshingFrequency");
			return (Criteria) this;
		}

		public Criteria andMeshingFrequencyNotBetween(Float value1, Float value2) {
			addCriterion("GEAR_MESHING_FREQUENCY not between", value1, value2, "meshingFrequency");
			return (Criteria) this;
		}

		public Criteria andImageCodeIsNull() {
			addCriterion("GEAR_IMAGE_CODE is null");
			return (Criteria) this;
		}

		public Criteria andImageCodeIsNotNull() {
			addCriterion("GEAR_IMAGE_CODE is not null");
			return (Criteria) this;
		}

		public Criteria andImageCodeEqualTo(String value) {
			addCriterion("GEAR_IMAGE_CODE =", value, "imageCode");
			return (Criteria) this;
		}

		public Criteria andImageCodeNotEqualTo(String value) {
			addCriterion("GEAR_IMAGE_CODE <>", value, "imageCode");
			return (Criteria) this;
		}

		public Criteria andImageCodeGreaterThan(String value) {
			addCriterion("GEAR_IMAGE_CODE >", value, "imageCode");
			return (Criteria) this;
		}

		public Criteria andImageCodeGreaterThanOrEqualTo(String value) {
			addCriterion("GEAR_IMAGE_CODE >=", value, "imageCode");
			return (Criteria) this;
		}

		public Criteria andImageCodeLessThan(String value) {
			addCriterion("GEAR_IMAGE_CODE <", value, "imageCode");
			return (Criteria) this;
		}

		public Criteria andImageCodeLessThanOrEqualTo(String value) {
			addCriterion("GEAR_IMAGE_CODE <=", value, "imageCode");
			return (Criteria) this;
		}

		public Criteria andImageCodeLike(String value) {
			addCriterion("GEAR_IMAGE_CODE like", value, "imageCode");
			return (Criteria) this;
		}

		public Criteria andImageCodeNotLike(String value) {
			addCriterion("GEAR_IMAGE_CODE not like", value, "imageCode");
			return (Criteria) this;
		}

		public Criteria andImageCodeIn(List<String> values) {
			addCriterion("GEAR_IMAGE_CODE in", values, "imageCode");
			return (Criteria) this;
		}

		public Criteria andImageCodeNotIn(List<String> values) {
			addCriterion("GEAR_IMAGE_CODE not in", values, "imageCode");
			return (Criteria) this;
		}

		public Criteria andImageCodeBetween(String value1, String value2) {
			addCriterion("GEAR_IMAGE_CODE between", value1, value2, "imageCode");
			return (Criteria) this;
		}

		public Criteria andImageCodeNotBetween(String value1, String value2) {
			addCriterion("GEAR_IMAGE_CODE not between", value1, value2, "imageCode");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table SKF_GEAR
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
     * This class corresponds to the database table skf_gear
     *
     * @mbg.generated do_not_delete_during_merge Thu May 31 17:23:14 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}