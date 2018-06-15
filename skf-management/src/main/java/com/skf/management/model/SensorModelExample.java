package com.skf.management.model;

import java.util.ArrayList;
import java.util.List;

public class SensorModelExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table SKF_SNSR
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table SKF_SNSR
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table SKF_SNSR
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_SNSR
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	public SensorModelExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_SNSR
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_SNSR
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_SNSR
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_SNSR
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_SNSR
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_SNSR
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_SNSR
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_SNSR
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_SNSR
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_SNSR
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table SKF_SNSR
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
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
			addCriterion("SNSR_CODE is null");
			return (Criteria) this;
		}

		public Criteria andCodeIsNotNull() {
			addCriterion("SNSR_CODE is not null");
			return (Criteria) this;
		}

		public Criteria andCodeEqualTo(String value) {
			addCriterion("SNSR_CODE =", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotEqualTo(String value) {
			addCriterion("SNSR_CODE <>", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeGreaterThan(String value) {
			addCriterion("SNSR_CODE >", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeGreaterThanOrEqualTo(String value) {
			addCriterion("SNSR_CODE >=", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLessThan(String value) {
			addCriterion("SNSR_CODE <", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLessThanOrEqualTo(String value) {
			addCriterion("SNSR_CODE <=", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLike(String value) {
			addCriterion("SNSR_CODE like", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotLike(String value) {
			addCriterion("SNSR_CODE not like", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeIn(List<String> values) {
			addCriterion("SNSR_CODE in", values, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotIn(List<String> values) {
			addCriterion("SNSR_CODE not in", values, "code");
			return (Criteria) this;
		}

		public Criteria andCodeBetween(String value1, String value2) {
			addCriterion("SNSR_CODE between", value1, value2, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotBetween(String value1, String value2) {
			addCriterion("SNSR_CODE not between", value1, value2, "code");
			return (Criteria) this;
		}

		public Criteria andEquipmentCodeIsNull() {
			addCriterion("SNSR_QPMT_CODE is null");
			return (Criteria) this;
		}

		public Criteria andEquipmentCodeIsNotNull() {
			addCriterion("SNSR_QPMT_CODE is not null");
			return (Criteria) this;
		}

		public Criteria andEquipmentCodeEqualTo(String value) {
			addCriterion("SNSR_QPMT_CODE =", value, "equipmentCode");
			return (Criteria) this;
		}

		public Criteria andEquipmentCodeNotEqualTo(String value) {
			addCriterion("SNSR_QPMT_CODE <>", value, "equipmentCode");
			return (Criteria) this;
		}

		public Criteria andEquipmentCodeGreaterThan(String value) {
			addCriterion("SNSR_QPMT_CODE >", value, "equipmentCode");
			return (Criteria) this;
		}

		public Criteria andEquipmentCodeGreaterThanOrEqualTo(String value) {
			addCriterion("SNSR_QPMT_CODE >=", value, "equipmentCode");
			return (Criteria) this;
		}

		public Criteria andEquipmentCodeLessThan(String value) {
			addCriterion("SNSR_QPMT_CODE <", value, "equipmentCode");
			return (Criteria) this;
		}

		public Criteria andEquipmentCodeLessThanOrEqualTo(String value) {
			addCriterion("SNSR_QPMT_CODE <=", value, "equipmentCode");
			return (Criteria) this;
		}

		public Criteria andEquipmentCodeLike(String value) {
			addCriterion("SNSR_QPMT_CODE like", value, "equipmentCode");
			return (Criteria) this;
		}

		public Criteria andEquipmentCodeNotLike(String value) {
			addCriterion("SNSR_QPMT_CODE not like", value, "equipmentCode");
			return (Criteria) this;
		}

		public Criteria andEquipmentCodeIn(List<String> values) {
			addCriterion("SNSR_QPMT_CODE in", values, "equipmentCode");
			return (Criteria) this;
		}

		public Criteria andEquipmentCodeNotIn(List<String> values) {
			addCriterion("SNSR_QPMT_CODE not in", values, "equipmentCode");
			return (Criteria) this;
		}

		public Criteria andEquipmentCodeBetween(String value1, String value2) {
			addCriterion("SNSR_QPMT_CODE between", value1, value2, "equipmentCode");
			return (Criteria) this;
		}

		public Criteria andEquipmentCodeNotBetween(String value1, String value2) {
			addCriterion("SNSR_QPMT_CODE not between", value1, value2, "equipmentCode");
			return (Criteria) this;
		}

		public Criteria andNameIsNull() {
			addCriterion("SNSR_NAME is null");
			return (Criteria) this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("SNSR_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("SNSR_NAME =", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("SNSR_NAME <>", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("SNSR_NAME >", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("SNSR_NAME >=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("SNSR_NAME <", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("SNSR_NAME <=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("SNSR_NAME like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("SNSR_NAME not like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameIn(List<String> values) {
			addCriterion("SNSR_NAME in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotIn(List<String> values) {
			addCriterion("SNSR_NAME not in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("SNSR_NAME between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("SNSR_NAME not between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andAngleIsNull() {
			addCriterion("SNSR_ANGLE is null");
			return (Criteria) this;
		}

		public Criteria andAngleIsNotNull() {
			addCriterion("SNSR_ANGLE is not null");
			return (Criteria) this;
		}

		public Criteria andAngleEqualTo(Float value) {
			addCriterion("SNSR_ANGLE =", value, "angle");
			return (Criteria) this;
		}

		public Criteria andAngleNotEqualTo(Float value) {
			addCriterion("SNSR_ANGLE <>", value, "angle");
			return (Criteria) this;
		}

		public Criteria andAngleGreaterThan(Float value) {
			addCriterion("SNSR_ANGLE >", value, "angle");
			return (Criteria) this;
		}

		public Criteria andAngleGreaterThanOrEqualTo(Float value) {
			addCriterion("SNSR_ANGLE >=", value, "angle");
			return (Criteria) this;
		}

		public Criteria andAngleLessThan(Float value) {
			addCriterion("SNSR_ANGLE <", value, "angle");
			return (Criteria) this;
		}

		public Criteria andAngleLessThanOrEqualTo(Float value) {
			addCriterion("SNSR_ANGLE <=", value, "angle");
			return (Criteria) this;
		}

		public Criteria andAngleIn(List<Float> values) {
			addCriterion("SNSR_ANGLE in", values, "angle");
			return (Criteria) this;
		}

		public Criteria andAngleNotIn(List<Float> values) {
			addCriterion("SNSR_ANGLE not in", values, "angle");
			return (Criteria) this;
		}

		public Criteria andAngleBetween(Float value1, Float value2) {
			addCriterion("SNSR_ANGLE between", value1, value2, "angle");
			return (Criteria) this;
		}

		public Criteria andAngleNotBetween(Float value1, Float value2) {
			addCriterion("SNSR_ANGLE not between", value1, value2, "angle");
			return (Criteria) this;
		}

		public Criteria andPosXIsNull() {
			addCriterion("SNSR_POS_X is null");
			return (Criteria) this;
		}

		public Criteria andPosXIsNotNull() {
			addCriterion("SNSR_POS_X is not null");
			return (Criteria) this;
		}

		public Criteria andPosXEqualTo(Float value) {
			addCriterion("SNSR_POS_X =", value, "posX");
			return (Criteria) this;
		}

		public Criteria andPosXNotEqualTo(Float value) {
			addCriterion("SNSR_POS_X <>", value, "posX");
			return (Criteria) this;
		}

		public Criteria andPosXGreaterThan(Float value) {
			addCriterion("SNSR_POS_X >", value, "posX");
			return (Criteria) this;
		}

		public Criteria andPosXGreaterThanOrEqualTo(Float value) {
			addCriterion("SNSR_POS_X >=", value, "posX");
			return (Criteria) this;
		}

		public Criteria andPosXLessThan(Float value) {
			addCriterion("SNSR_POS_X <", value, "posX");
			return (Criteria) this;
		}

		public Criteria andPosXLessThanOrEqualTo(Float value) {
			addCriterion("SNSR_POS_X <=", value, "posX");
			return (Criteria) this;
		}

		public Criteria andPosXIn(List<Float> values) {
			addCriterion("SNSR_POS_X in", values, "posX");
			return (Criteria) this;
		}

		public Criteria andPosXNotIn(List<Float> values) {
			addCriterion("SNSR_POS_X not in", values, "posX");
			return (Criteria) this;
		}

		public Criteria andPosXBetween(Float value1, Float value2) {
			addCriterion("SNSR_POS_X between", value1, value2, "posX");
			return (Criteria) this;
		}

		public Criteria andPosXNotBetween(Float value1, Float value2) {
			addCriterion("SNSR_POS_X not between", value1, value2, "posX");
			return (Criteria) this;
		}

		public Criteria andPosYIsNull() {
			addCriterion("SNSR_POS_Y is null");
			return (Criteria) this;
		}

		public Criteria andPosYIsNotNull() {
			addCriterion("SNSR_POS_Y is not null");
			return (Criteria) this;
		}

		public Criteria andPosYEqualTo(Float value) {
			addCriterion("SNSR_POS_Y =", value, "posY");
			return (Criteria) this;
		}

		public Criteria andPosYNotEqualTo(Float value) {
			addCriterion("SNSR_POS_Y <>", value, "posY");
			return (Criteria) this;
		}

		public Criteria andPosYGreaterThan(Float value) {
			addCriterion("SNSR_POS_Y >", value, "posY");
			return (Criteria) this;
		}

		public Criteria andPosYGreaterThanOrEqualTo(Float value) {
			addCriterion("SNSR_POS_Y >=", value, "posY");
			return (Criteria) this;
		}

		public Criteria andPosYLessThan(Float value) {
			addCriterion("SNSR_POS_Y <", value, "posY");
			return (Criteria) this;
		}

		public Criteria andPosYLessThanOrEqualTo(Float value) {
			addCriterion("SNSR_POS_Y <=", value, "posY");
			return (Criteria) this;
		}

		public Criteria andPosYIn(List<Float> values) {
			addCriterion("SNSR_POS_Y in", values, "posY");
			return (Criteria) this;
		}

		public Criteria andPosYNotIn(List<Float> values) {
			addCriterion("SNSR_POS_Y not in", values, "posY");
			return (Criteria) this;
		}

		public Criteria andPosYBetween(Float value1, Float value2) {
			addCriterion("SNSR_POS_Y between", value1, value2, "posY");
			return (Criteria) this;
		}

		public Criteria andPosYNotBetween(Float value1, Float value2) {
			addCriterion("SNSR_POS_Y not between", value1, value2, "posY");
			return (Criteria) this;
		}

		public Criteria andSchemaNameIsNull() {
			addCriterion("SNSR_SCHEMA_NAME is null");
			return (Criteria) this;
		}

		public Criteria andSchemaNameIsNotNull() {
			addCriterion("SNSR_SCHEMA_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andSchemaNameEqualTo(String value) {
			addCriterion("SNSR_SCHEMA_NAME =", value, "schemaName");
			return (Criteria) this;
		}

		public Criteria andSchemaNameNotEqualTo(String value) {
			addCriterion("SNSR_SCHEMA_NAME <>", value, "schemaName");
			return (Criteria) this;
		}

		public Criteria andSchemaNameGreaterThan(String value) {
			addCriterion("SNSR_SCHEMA_NAME >", value, "schemaName");
			return (Criteria) this;
		}

		public Criteria andSchemaNameGreaterThanOrEqualTo(String value) {
			addCriterion("SNSR_SCHEMA_NAME >=", value, "schemaName");
			return (Criteria) this;
		}

		public Criteria andSchemaNameLessThan(String value) {
			addCriterion("SNSR_SCHEMA_NAME <", value, "schemaName");
			return (Criteria) this;
		}

		public Criteria andSchemaNameLessThanOrEqualTo(String value) {
			addCriterion("SNSR_SCHEMA_NAME <=", value, "schemaName");
			return (Criteria) this;
		}

		public Criteria andSchemaNameLike(String value) {
			addCriterion("SNSR_SCHEMA_NAME like", value, "schemaName");
			return (Criteria) this;
		}

		public Criteria andSchemaNameNotLike(String value) {
			addCriterion("SNSR_SCHEMA_NAME not like", value, "schemaName");
			return (Criteria) this;
		}

		public Criteria andSchemaNameIn(List<String> values) {
			addCriterion("SNSR_SCHEMA_NAME in", values, "schemaName");
			return (Criteria) this;
		}

		public Criteria andSchemaNameNotIn(List<String> values) {
			addCriterion("SNSR_SCHEMA_NAME not in", values, "schemaName");
			return (Criteria) this;
		}

		public Criteria andSchemaNameBetween(String value1, String value2) {
			addCriterion("SNSR_SCHEMA_NAME between", value1, value2, "schemaName");
			return (Criteria) this;
		}

		public Criteria andSchemaNameNotBetween(String value1, String value2) {
			addCriterion("SNSR_SCHEMA_NAME not between", value1, value2, "schemaName");
			return (Criteria) this;
		}

		public Criteria andNodeIDIsNull() {
			addCriterion("SNSR_NODE_ID is null");
			return (Criteria) this;
		}

		public Criteria andNodeIDIsNotNull() {
			addCriterion("SNSR_NODE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andNodeIDEqualTo(Integer value) {
			addCriterion("SNSR_NODE_ID =", value, "nodeID");
			return (Criteria) this;
		}

		public Criteria andNodeIDNotEqualTo(Integer value) {
			addCriterion("SNSR_NODE_ID <>", value, "nodeID");
			return (Criteria) this;
		}

		public Criteria andNodeIDGreaterThan(Integer value) {
			addCriterion("SNSR_NODE_ID >", value, "nodeID");
			return (Criteria) this;
		}

		public Criteria andNodeIDGreaterThanOrEqualTo(Integer value) {
			addCriterion("SNSR_NODE_ID >=", value, "nodeID");
			return (Criteria) this;
		}

		public Criteria andNodeIDLessThan(Integer value) {
			addCriterion("SNSR_NODE_ID <", value, "nodeID");
			return (Criteria) this;
		}

		public Criteria andNodeIDLessThanOrEqualTo(Integer value) {
			addCriterion("SNSR_NODE_ID <=", value, "nodeID");
			return (Criteria) this;
		}

		public Criteria andNodeIDIn(List<Integer> values) {
			addCriterion("SNSR_NODE_ID in", values, "nodeID");
			return (Criteria) this;
		}

		public Criteria andNodeIDNotIn(List<Integer> values) {
			addCriterion("SNSR_NODE_ID not in", values, "nodeID");
			return (Criteria) this;
		}

		public Criteria andNodeIDBetween(Integer value1, Integer value2) {
			addCriterion("SNSR_NODE_ID between", value1, value2, "nodeID");
			return (Criteria) this;
		}

		public Criteria andNodeIDNotBetween(Integer value1, Integer value2) {
			addCriterion("SNSR_NODE_ID not between", value1, value2, "nodeID");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table SKF_SNSR
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
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
     * This class corresponds to the database table skf_snsr
     *
     * @mbg.generated do_not_delete_during_merge Thu May 31 17:23:14 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}