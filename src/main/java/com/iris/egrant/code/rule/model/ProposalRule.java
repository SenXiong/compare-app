package com.iris.egrant.code.rule.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 申请规则实体类
 * 
 * @author 张杰
 * 
 */
@Entity
@Table(name = "PROPOSAL_RULE")
public class ProposalRule implements Serializable {

	public String getFaverMsg() {
		return faverMsg;
	}

	public void setFaverMsg(String faverMsg) {
		this.faverMsg = faverMsg;
	}

	private static final long serialVersionUID = 355595987983773757L;

	/**
	 * 自动编号，规则ID
	 */
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PROPOSAL_RULE")
	@SequenceGenerator(name = "SEQ_PROPOSAL_RULE", sequenceName = "SEQ_PROPOSAL_RULE", allocationSize = 1)
	private Long id;
	/**
	 * 校验时机 const_dictionary Category=””
	 */
	@Column(name = "VALIDATE_STAGE")
	private String validateStage = "5";
	/**
	 * 适用类别 grant_setting 空表示所有 即为通用规则 不空为个性化规则
	 */
	@Column(name = "GRANT_CODE")
	private Long grantCode;
	
	
	/**
	 * 排除类别 grant_setting表中的grant_code
	 */
/*	@Column(name = "GRANT_CODE_EXCEPT")
	private String grantCodeExcept;*/
	
	/**
	 * 规则模版外键
	 */
	@Column(name = "RULE_TMP_CODE")
	private Long ruleTmpCode;
	/**
	 * 规则名称
	 */
	@Column(name = "NAME")
	private String name;
	/**
	 * 规则类型（condition、validator、functions） (对比只有validator)
	 */
	@Column(name = "RULE_TYPE")
	private String ruleType;
	/**
	 * 校验方式：0系统计算,1人工识别
	 */
	@Column(name = "VALLIDATE_TYPE")
	private String validateType;
	/**
	 * 规则输入参数模式（0固定值，1可选大于表达式）(待定)
	 */
	@Column(name = "INPUT_PARAM_MODE")
	private Integer inputParamMode;
	/**
	 * 表达式类型：0:常量；1：springel表达式；2：sql；3：class；4：hql
	 */
	@Column(name = "EXPRESSION_TYPE")
	private Integer expressionType;

	public String getCmpType() {
		return cmpType;
	}

	public void setCmpType(String cmpType) {
		this.cmpType = cmpType;
	}

	/**
	 * 表达式详情(sql、springel、java函数)
	 */
	@Column(name = "EXPRESSION_DETAIL")
	private String expressionDetail;
	/**
	 * 界面规则展示详情 参数替换{}占位符
	 */
	@Column(name = "MESSAGE")
	private String message;
	/**
	 * 描述
	 */
	@Column(name = "RULE_DESC")
	private String ruleDesc;
	/**
	 * 描述
	 */
	@Column(name = "CMP_TYPE")
	private String cmpType;
	/**
	 * 更新人
	 */
	@Column(name = "UPDATE_PSN_CODE")
	private Long updatePsnCode;
	/**
	 * 更新日期
	 */
	@Column(name = "UPDATE_DATE")
	private Date updateDate;

	/**
	 * 启用禁用标志 0禁用 1启用
	 * 
	 * @return
	 */
	@Column(name = "STATUS")
	private String status = "1";
	/**
	 * 参数中文名称
	 */
	@Column(name = "XPATH")
	private String xpath;
	/**
	 * 参数中文名称
	 */
	@Column(name = "field_name")
	private String fieldName;
	/**
	 * 参数中文名称
	 */
/*	@Column(name = "year")
	private String year;*/


	/**
	 * 参数中文名称
	 */
	@Column(name = "field_zh_cn_name")
	private String fieldZhCnName;
	/**
	 * 参数中文名称
	 */
	@Column(name = "user_field_sccaption")
	private String userFieldSccaption;

	public String getOperatorTypeName() {
		return operatorTypeName;
	}

	public void setOperatorTypeName(String operatorTypeName) {
		this.operatorTypeName = operatorTypeName;
	}

	/**
	 * 参数中文名称
	 */
	@Column(name = "USER_FIELD_VALUE")
	private String userFieldValue;

	/**
	 * 参数中文名称
	 */
	@Column(name = "operator_type")
	private String operatorType;
	/**
	 * 参数中文名称
	 */
	@Column(name = "operator_type_name")
	private String operatorTypeName;
	/**
	 * 参数中文名称
	 */
	@Column(name = "rule_category")
	private String ruleCategory;

	/**
	 * 规则分类
	 */
/*	@Column(name = "rule_group")
	private String ruleGroup;*/

	/**
	 * 规则现实阶段
	 */
	@Column(name = "show_stage")
	private String showStage;
	
	@Column(name = "WARN_LEVEL")
	private String warnLevel;

	public String getWarnLevel() {
		return warnLevel;
	}

	public void setWarnLevel(String warnLevel) {
		this.warnLevel = warnLevel;
	}

	public String getRuleCategory() {
		return ruleCategory;
	}

	public void setRuleCategory(String ruleCategory) {
		this.ruleCategory = ruleCategory;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldZhCnName() {
		return fieldZhCnName;
	}

	public void setFieldZhCnName(String fieldZhCnName) {
		this.fieldZhCnName = fieldZhCnName;
	}

	public String getUserFieldSccaption() {
		return userFieldSccaption;
	}

	public void setUserFieldSccaption(String userFieldSccaption) {
		this.userFieldSccaption = userFieldSccaption;
	}

	public String getUserFieldValue() {
		return userFieldValue;
	}

	public void setUserFieldValue(String userFieldValue) {
		this.userFieldValue = userFieldValue;
	}

	public String getOperatorType() {
		return operatorType;
	}

	public void setOperatorType(String operatorType) {
		this.operatorType = operatorType;
	}

	public String getXpath() {
		return xpath;
	}

	public void setXpath(String xpath) {
		this.xpath = xpath;
	}

	/**
	 * 规则对比中文信息
	 */
	@Column(name = "MSG_ZH_CN_CMP")
	private String msgZhCnCmp;

	/**
	 * 规则对比中文信息
	 */
	@Column(name = "FAVER_MSG")
	private String faverMsg;
	/**
	 * 规则对比中文信息
	 */
	@Column(name = "reality_msg")
	private String realityMsg;

	// 立项级次
/*	@Column(name = "AMT_GRADE")
	private String amtGrade;*/
	// 地区编号，区级项目专用
/*	@Column(name = "AREA_NO")
	private String areaNo;*/
	// 申请类别
/*	@Column(name = "PRP_TYPE")
	private String prpType;*/

	public String getRealityMsg() {
		return realityMsg;
	}

	public void setRealityMsg(String realityMsg) {
		this.realityMsg = realityMsg;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValidateStage() {
		return validateStage;
	}

	public void setValidateStage(String validateStage) {
		this.validateStage = validateStage;
	}

	public Long getGrantCode() {
		return grantCode;
	}

	public void setGrantCode(Long grantCode) {
		this.grantCode = grantCode;
	}

	public Long getRuleTmpCode() {
		return ruleTmpCode;
	}

	public void setRuleTmpCode(Long ruleTmpCode) {
		this.ruleTmpCode = ruleTmpCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRuleType() {
		return ruleType;
	}

	public void setRuleType(String ruleType) {
		this.ruleType = ruleType;
	}

	public String getValidateType() {
		return validateType;
	}

	public void setValidateType(String validateType) {
		this.validateType = validateType;
	}

	public Integer getInputParamMode() {
		return inputParamMode;
	}

	public void setInputParamMode(Integer inputParamMode) {
		this.inputParamMode = inputParamMode;
	}

	public Integer getExpressionType() {
		return expressionType;
	}

	public void setExpressionType(Integer expressionType) {
		this.expressionType = expressionType;
	}

	public String getExpressionDetail() {
		return expressionDetail;
	}

	public void setExpressionDetail(String expressionDetail) {
		this.expressionDetail = expressionDetail;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRuleDesc() {
		return ruleDesc;
	}

	public void setRuleDesc(String ruleDesc) {
		this.ruleDesc = ruleDesc;
	}

	public Long getUpdatePsnCode() {
		return updatePsnCode;
	}

	public void setUpdatePsnCode(Long updatePsnCode) {
		this.updatePsnCode = updatePsnCode;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMsgZhCnCmp() {
		return msgZhCnCmp;
	}

	public void setMsgZhCnCmp(String msgZhCnCmp) {
		this.msgZhCnCmp = msgZhCnCmp;
	}


	public String getShowStage() {
		return showStage;
	}

	public void setShowStage(String showStage) {
		this.showStage = showStage;
	}

	public void ruleCopyFromTemplate(RuleTemplate ruleTemplate) {
		this.name = ruleTemplate.getName();
		this.ruleTmpCode = ruleTemplate.getId();
		this.ruleType = ruleTemplate.getRuleType();
		this.validateType = ruleTemplate.getVallidateType();
		this.inputParamMode = ruleTemplate.getInputParamMode();
		this.expressionType = ruleTemplate.getExpressionType();
		this.expressionDetail = ruleTemplate.getExpressionDetail();
		this.message = ruleTemplate.getMessage();
		this.ruleDesc = ruleTemplate.getRuleDesc();
		this.updatePsnCode = ruleTemplate.getUpdatePsnCode();
		this.updateDate = ruleTemplate.getUpdateDate();
		this.msgZhCnCmp = ruleTemplate.getMsgZhCnCmp();
		this.faverMsg = ruleTemplate.getFaverMsg();
		this.realityMsg = ruleTemplate.getRealityMsg();
	}


}
