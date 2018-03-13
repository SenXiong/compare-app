package com.iris.egrant.code.compare.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * 申报书.
 * 
 * 
 * 
 */
@Entity
@Table(name = "PROPOSAL")
public class Proposal implements Serializable {

	private static final long serialVersionUID = 7929905257306638114L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PRP_CODE")
	@GenericGenerator(name = "SEQ_PRP_CODE", strategy = "com.iris.egrant.core.dao.hibernate.AssignedSequenceGenerator", parameters = { @Parameter(name = "sequence", value = "SEQ_PRP_CODE") })
	@Column(name = "PRP_CODE")
	private Long prpCode;// 申请书code

	@Column(name = "POS_CODE")
	private Long posCode;// 申请书临时code

	@Column(name = "GRANT_CODE")
	private Long grantCode;// 业务类别code

	@Column(name = "SUB_GRANT_CODE")
	private Long subGrantCode;// 亚类说明code

	@Column(name = "SUB_GRANT_NAME")
	private String subGrantName;// 亚类说明Name

	@Column(name = "HELP_GRANT_CODE")
	private Long helpGrantCode;// 业务类别第三级code

	@Column(name = "HELP_GRANT_NAME")
	private String helpGrantName;// 业务类别第三级名称

	@Column(name = "PSN_CODE")
	private Long psnCode;// 申报人code

	@Column(name = "ORG_CODE")
	private Long orgCode;// 依托单位code

	@Column(name = "ZH_TITLE")
	private String zhTitle;// 申请书标题

	@Column(name = "EN_TITLE")
	private String enTitle;// 英文标题

	@Column(name = "STATUS")
	private String status;// 申请书状态

	@Column(name = "GRANT_NAME")
	private String grantName;// 业务类别名称

	@Column(name = "OLD_STATUS")
	private String oldStatus;// 前一个状态
	
	@Column(name="PRJ_NO")
	private String prj_no;//项目编码

	@Column(name = "START_DATE")
	private Date startDate;// 项目开始时间

	@Column(name = "END_DATE")
	private Date endDate;// 项目结束时间

	@Column(name = "SUBMIT_DATE")
	private Date submitDate;// 项目提交时间

	@Column(name = "SUBMIT_PSN_CODE")
	private Long submitPsnCode;// 项目提交人（可能是代填）

	@Column(name = "STAT_YEAR")
	private String statYear;// 申报年度

	@Column(name = "DEPT_CODE")
	private Long deptCode;// 二级部门Code

	@Column(name = "DEPT_NAME")
	private String deptName;// 二级部门Name

	@Column(name = "FORM_CODE")
	private Long formCode;// 申请书模板号，对应formbaselibrary

	@Column(name = "SUBJECT_NAME")
	private String subjectName;// 申请代码1名称

	@Column(name = "SUBJECT_CODE")
	private String subjectCode;// 申请代码1code

	@Column(name = "RECOMMEND_ORG_CODE")
	private Long recommendOrgCode;// 推荐单位ORG_CODE
/*	@Column(name = "FUND_AGENCY")
    private Long fundAgency;//合作银行
*/	// 受理编号
	@Column(name = "PRP_NO")
	private String prpNo;

	// 申请金额
	@Column(name = "REQUEST_AMT")
	private BigDecimal requestAmt;

	@Column(name = "PRJ_PSN_CODE")
	private Long prjPsnCode;

	// 建议金额
	@Column(name = "RECOMMENDED_AMT")
	BigDecimal recommendedAmt;

	// 学科综合评价
	@Column(name = "COMP_EVALUATION")
	String compEvaluation;

	// 是否上会项目，1是，0不是，空或其他表示未设置
	@Column(name = "MEETING_FLAG")
	String meetingFlag;

	// 是否非共识项目，1是0否，，注意是非共识项目
	@Column(name = "DIFF_FLAG")
	String diffFlag;

	// 编辑同行意见，学科综合意见(时间日期见日志记录)
	@Column(name = "XKEVCOMMENT")
	String xkevComment;

	// 编辑同行意见，学科综合评价等级(时间日期见日志记录)
	@Column(name = "XKEVLEVEL")
	String xkevLevel;

	// 编辑同行意见的时间
	@Column(name = "UPDATE_TIME")
	Date updateTime;

	// 反馈状态
	@Column(name = "FEEDBACK_STATUS")
	String feedbackStatus;

	// 批准状态
	@Column(name = "APPROVAL_STATUS")
	String approvalStatus;
	
/*	@Column(name = "PRJ_STAT_YEAR")
	private String prjStatYear;// 拟立项年度用来做比对
*/	/**
	 * 任务id.
	 */
	@Column(name = "TASK_ID")
	private String taskId;
	
	/**
	 * 流程id.
	 */
	@Column(name = "WORKFLOW_ID")
	private String workflowId;

	/**
	 * 单位确认时间
	 */
	@Column(name = "ORG_SUBMIT_DATE")
	private Date orgSubmitDate;
	/**
	 * 基金委确认时间
	 */
	@Column(name = "JJW_SUBMIT_DATE")
	private Date jjwSubmitDate;
	@Column(name = "LAST_MODIFY_DATE")
	private Date lastModifyDate;
	
	@Column(name = "FLAG_JZSL")
	private Integer flagJZSL;

	@Transient
	private String auditType;// 审核标记，对应常数

	@Column(name = "RESEARCHAREA_VALUE")
	private String researchareaValue;// 申请书研究方向Code

	@Column(name = "RESEARCHAREA_NAME")
	private String researchareaName;// 申请书研究方向Name

	@Column(name = "IS_ACCEPT")
	private Integer isAccept;// 是否受理

	@Column(name = "IS_OFFICIAL")
	private Integer isOfficial;// 是否入库

	@Column(name = "DIV_CODE")
	private String divCode;// 申请书的管理代码，参考isis系统添加
	
/*	@Column(name = "MANAGE_CATEGORY")
	private String manageCategory;*/

	@Transient
	private int isOldSys = 0;// 是否旧系统在操作 0-否，1-是 默认为0

	public Long getPrpCode() {
		return prpCode;
	}

	public void setPrpCode(Long prpCode) {
		this.prpCode = prpCode;
	}

	public Long getPosCode() {
		return posCode;
	}

	public void setPosCode(Long posCode) {
		this.posCode = posCode;
	}

	public Long getGrantCode() {
		return grantCode;
	}

	public void setGrantCode(Long grantCode) {
		this.grantCode = grantCode;
	}

	public Long getSubGrantCode() {
		return subGrantCode;
	}

	public void setSubGrantCode(Long subGrantCode) {
		this.subGrantCode = subGrantCode;
	}

	public String getSubGrantName() {
		return subGrantName;
	}

	public void setSubGrantName(String subGrantName) {
		this.subGrantName = subGrantName;
	}

	public Long getHelpGrantCode() {
		return helpGrantCode;
	}

	public void setHelpGrantCode(Long helpGrantCode) {
		this.helpGrantCode = helpGrantCode;
	}

	public String getHelpGrantName() {
		return helpGrantName;
	}

	public void setHelpGrantName(String helpGrantName) {
		this.helpGrantName = helpGrantName;
	}

	public Long getPsnCode() {
		return psnCode;
	}

	public void setPsnCode(Long psnCode) {
		this.psnCode = psnCode;
	}

	public Long getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(Long orgCode) {
		this.orgCode = orgCode;
	}

	public String getZhTitle() {
		return zhTitle;
	}

	public void setZhTitle(String zhTitle) {
		this.zhTitle = zhTitle;
	}

	public String getEnTitle() {
		return enTitle;
	}

	public void setEnTitle(String enTitle) {
		this.enTitle = enTitle;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getGrantName() {
		return grantName;
	}

	public void setGrantName(String grantName) {
		this.grantName = grantName;
	}

	public String getOldStatus() {
		return oldStatus;
	}

	public void setOldStatus(String oldStatus) {
		this.oldStatus = oldStatus;
	}

	
	
	public String getPrj_no() {
		return prj_no;
	}

	public void setPrj_no(String prj_no) {
		this.prj_no = prj_no;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}

	public Long getSubmitPsnCode() {
		return submitPsnCode;
	}

	public void setSubmitPsnCode(Long submitPsnCode) {
		this.submitPsnCode = submitPsnCode;
	}

	public String getStatYear() {
		return statYear;
	}

	public void setStatYear(String statYear) {
		this.statYear = statYear;
	}

	public Long getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(Long deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Long getFormCode() {
		return formCode;
	}

	public void setFormCode(Long formCode) {
		this.formCode = formCode;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getPrpNo() {
		return prpNo;
	}

	public void setPrpNo(String prpNo) {
		this.prpNo = prpNo;
	}

	public BigDecimal getRequestAmt() {
		return requestAmt;
	}

	public void setRequestAmt(BigDecimal requestAmt) {
		this.requestAmt = requestAmt;
	}

	public Long getPrjPsnCode() {
		return prjPsnCode;
	}

	public void setPrjPsnCode(Long prjPsnCode) {
		this.prjPsnCode = prjPsnCode;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getWorkflowId() {
		return workflowId;
	}

	public void setWorkflowId(String workflowId) {
		this.workflowId = workflowId;
	}

	public Date getOrgSubmitDate() {
		return orgSubmitDate;
	}

	public void setOrgSubmitDate(Date orgSubmitDate) {
		this.orgSubmitDate = orgSubmitDate;
	}

	public Date getJjwSubmitDate() {
		return jjwSubmitDate;
	}

	public void setJjwSubmitDate(Date jjwSubmitDate) {
		this.jjwSubmitDate = jjwSubmitDate;
	}

	public Integer getFlagJZSL() {
		return flagJZSL;
	}

	public void setFlagJZSL(Integer flagJZSL) {
		this.flagJZSL = flagJZSL;
	}

	public String getAuditType() {
		return auditType;
	}

	public void setAuditType(String auditType) {
		this.auditType = auditType;
	}

	public String getResearchareaValue() {
		return researchareaValue;
	}

	public void setResearchareaValue(String researchareaValue) {
		this.researchareaValue = researchareaValue;
	}

	public String getResearchareaName() {
		return researchareaName;
	}

	public void setResearchareaName(String researchareaName) {
		this.researchareaName = researchareaName;
	}

	public Integer getIsAccept() {
		return isAccept;
	}

	public void setIsAccept(Integer isAccept) {
		this.isAccept = isAccept;
	}

	public Integer getIsOfficial() {
		return isOfficial;
	}

	public void setIsOfficial(Integer isOfficial) {
		this.isOfficial = isOfficial;
	}

	public String getDivCode() {
		return divCode;
	}

	public void setDivCode(String divCode) {
		this.divCode = divCode;
	}

	public int getIsOldSys() {
		return isOldSys;
	}

	public void setIsOldSys(int isOldSys) {
		this.isOldSys = isOldSys;
	}

	public Long getRecommendOrgCode() {
		return recommendOrgCode;
	}

	public void setRecommendOrgCode(Long recommendOrgCode) {
		this.recommendOrgCode = recommendOrgCode;
	}
	public BigDecimal getRecommendedAmt() {
		return recommendedAmt;
	}

	public void setRecommendedAmt(BigDecimal recommendedAmt) {
		this.recommendedAmt = recommendedAmt;
	}

	public String getCompEvaluation() {
		return compEvaluation;
	}

	public void setCompEvaluation(String compEvaluation) {
		this.compEvaluation = compEvaluation;
	}

	public String getMeetingFlag() {
		return meetingFlag;
	}

	public void setMeetingFlag(String meetingFlag) {
		this.meetingFlag = meetingFlag;
	}

	public String getDiffFlag() {
		return diffFlag;
	}

	public void setDiffFlag(String diffFlag) {
		this.diffFlag = diffFlag;
	}

	public String getXkevComment() {
		return xkevComment;
	}

	public void setXkevComment(String xkevComment) {
		this.xkevComment = xkevComment;
	}

	public String getXkevLevel() {
		return xkevLevel;
	}

	public void setXkevLevel(String xkevLevel) {
		this.xkevLevel = xkevLevel;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getFeedbackStatus() {
		return feedbackStatus;
	}

	public void setFeedbackStatus(String feedbackStatus) {
		this.feedbackStatus = feedbackStatus;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

/*	public String getManageCategory() {
		return manageCategory;
	}

	public void setManageCategory(String manageCategory) {
		this.manageCategory = manageCategory;
	}

	public Long getFundAgency() {
		return fundAgency;
	}

	public void setFundAgency(Long fundAgency) {
		this.fundAgency = fundAgency;
	}

	public String getPrjStatYear() {
		return prjStatYear;
	}

	public void setPrjStatYear(String prjStatYear) {
		this.prjStatYear = prjStatYear;
	}*/

	public Date getLastModifyDate() {
		return lastModifyDate;
	}

	public void setLastModifyDate(Date lastModifyDate) {
		this.lastModifyDate = lastModifyDate;
	}

}
