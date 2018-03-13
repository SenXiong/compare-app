package com.iris.egrant.code.compare.constant.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 项目比对常量
 * 
 * @author wk
 * 
 */
public class CompareConstants {
	
    private static String[] createRandomColor(int size) {
    	List<String> filterColors = Arrays.asList("FBFBFB", "F1F1F1", "FFFFFF"); //部分无法识别的颜色
    	List<String> colors = new ArrayList<String>();
		String r,g,b;
		for(int i=0; i<100; i++) {
		  Random random = new Random();  
		  r = Integer.toHexString(random.nextInt(128)+128).toUpperCase();
		  g = Integer.toHexString(random.nextInt(128)+128).toUpperCase();
		  b = Integer.toHexString(random.nextInt(128)+128).toUpperCase();
		    
		  r = r.length()==1 ? "0" + r : r ;  
		  g = g.length()==1 ? "0" + g : g ;  
		  b = b.length()==1 ? "0" + b : b ;  
		  
		  //过滤
		  if("33".equalsIgnoreCase(g) || filterColors.contains(r+g+b) || colors.contains(r+g+b)) {
			  i--;
			  continue;
		  }
		  
		  colors.add(r+g+b); 
		}
		return (String[])colors.toArray(new String[size]);
    }	

	/**
	 * 展示背景色，用于设备清单和核心团队
	 */
	public final static String[] backgroundColors = createRandomColor(100);
	
	/**
	 * 不进行比较的字符串
	 */
	public final static List<String> filterWord = Arrays.asList("", "无锡", "无", "暂无", "没有", "略", "待定", "定制","购置", "自制","\\", "/", "-", "0", 
			"[", "`", "~", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "+", "=", "|", "{", "}", "'", ":", ";", "'", 
			",", ".", "<", ">", "/", "?", "~", "！", "@", "#", "￥", "%", "……", "&", "*", "（", "）", "_", 
			"—", "——", "+", "|", "{", "}", "【", "】", "‘", "；", "：", "”", "“", "’", "。", "，", "、", "？", "]", 
			"《", "》", "<", ">");

	/**
	 * 分隔符，默认为[tear]
	 */
	public final static String separator = "[tear]";

	/**============================================项目内容======================================================*/
	/**
	 * 项目内容默认节点
	 */
	public final static String GOAL_EXTRACT_XPATH = "//data/proposal/goal";
	
	/**============================================可行性报告======================================================*/
	/**
	 * 可行性报告默认节点
	 */
	public final static String CONTENT_EXTRACT_XPATH_DEFAULT = "/data/content";
	/**
	 * 可行性报告备用节点
	 */
	public final static String CONTENT_EXTRACT_XPATH_OTHER = "/data/content/content[@seq_no=1210]";
	public final static String CONTENT_EXTRACT_XPATH_OTHER1 = "/data/content/content[@seq_no=1211]";
	public final static String CONTENT_EXTRACT_XPATH_OTHER2 = "/data/content/content[@seq_no=1212]";
	public final static String CONTENT_EXTRACT_XPATH_OTHER3 = "/data/content/content[@seq_no=1213]";

	/**============================================项目名称======================================================*/
	/**
	 * 项目名称默认节点
	 */
	public final static String PRPNAME_EXTRACT_XPATH = "//data/proposal/zh_title";
	
	/**============================================设备清单======================================================*/
	/**
	 * 生产设备/软件清单
	 */
	public final static String EQUIPMENT_EXTRACT_XPATH3 = "//data/org_no";
	/**
	 * 生产设备/软件清单
	 */
	public final static String EQUIPMENT_EXTRACT_XPATH1 = "//data/increaseds";
	/**
	 * 研发设备/软件清单
	 */
	public final static String EQUIPMENT_EXTRACT_XPATH2 = "//data/euipments";
	/**
	 * 智能设备/软件清单
	 */
	public final static String EQUIPMENT_EXTRACT_XPATH4 = "//data/intelligent";
	/**
	 * 比较关键字，设备表中的设备名称
	 */
	public final static String EQUIPMENT_COMPARE_NAME= "name";
	/**
	 * 比较关键字，设备表中的编号
	 */
	public final static String EQUIPMENT_COMPARE_MODEL = "model";
	/**
	 * 比较关键字，设备表中的发票号码
	 */
	public final static String EQUIPMENT_COMPARE_FAPIAO = "fapiao";
	public final static String EQUIPMENT_COMPARE_FAPIAO2 = "customs_no";
	/**
	 * 比较关键字，设备表中的编号
	 */
	public final static String EQUIPMENT_COMPARE_DATE = "start_date";
	/**
	 * 比较关键字，设备表中的编号
	 */
	public final static String EQUIPMENT_COMPARE_MONEY = "money";

	/**============================================核心团队======================================================*/
	/**
	 * 核心团队默认节点
	 */
	public final static String PSN_EXTRACT_XPATH = "//data/zh_persons";
	/**
	 * 保存在compare_list中的节点
	 */
	public final static String PSN_COMPARE_XPATH = "//zh_persons/zh_person";
	/**
	 * 比较关键字，人员表中的节点
	 */
	public final static String PSN_COMPARE_KEY1= "card_type_value";
	/**
	 * 比较关键字，人员表中的节点
	 */
	public final static String PSN_COMPARE_KEY2 = "card_code";
	
	public final static String PSN_COMPARE_KEY3 = "card_type_name";
	
	/**============================================核准制项目======================================================*/
	/**
	 * 核准制项目抽取节点：组织机构代码
	 * 组织机构代码[tear]部门[tear]文号[tear]日期[tear]编号[tear]内容
	 */
	public final static String HEZHUN_EXTRACT_XPATH_ORGNO = "//data/organizations/organization[@submit_org='1']/org_no";
	/**
	 * 核准制项目抽取节点：认定内容
	 */
	public final static String HEZHUN_EXTRACT_XPATH_TYPE = "//data/proposal/identified_type";
	/**
	 * 核准制项目抽取节点：认定内容
	 */
	public final static String HEZHUN_EXTRACT_XPATH_TYPE2 = "//data/proposal/identified_type_name";
	/**
	 * 核准制项目抽取节点：认定日期
	 */
	public final static String HEZHUN_EXTRACT_XPATH_DATE = "//data/proposal/identified_date";
	/**
	 * 核准制项目抽取节点：认定部门
	 */
	public final static String HEZHUN_EXTRACT_XPATH_DEPARTMENT = "//data/proposal/identified_department";
	/**
	 * 核准制项目抽取节点：认定部门
	 */
	public final static String HEZHUN_EXTRACT_XPATH_DEPARTMENT2 = "//data/proposal/identified_department_name";
	/**
	 * 核准制项目抽取节点：认定文号
	 */
	public final static String HEZHUN_EXTRACT_XPATH_NO = "//data/proposal/identified_no";
	/**
	 * 核准制项目抽取节点：认定编号
	 */
	public final static String HEZHUN_EXTRACT_XPATH_NUMBER = "//data/proposal/identified_number";
	
	/**============================================奖励类项目======================================================*/
	/**
	 * 专利号
	 */
	public final static String ZHUANLI_EXTRACT_XPATH = "//data/mainproperty";
	public final static String ZHUANLI_EXTRACT_XPATH_LIST = "//data/mainproperty/list";
	
	public final static String ZHUANLI_EXTRACT_XPATH_1 = "//data/mainproperty/list/property_name";
	public final static String ZHUANLI_EXTRACT_XPATH_2 = "//data/mainproperty/list/patent_number_part";
	public final static String ZHUANLI_EXTRACT_XPATH_3 = "//data/mainproperty/list/authorization_date";
	public final static String ZHUANLI_EXTRACT_XPATH_4 = "//data/mainproperty/list/obligee";
	public final static String ZHUANLI_EXTRACT_XPATH_5 = "//data/mainproperty/list/inventer";
	
	public final static String ZHUANLI_EXTRACT_XPATH_NUMBER = "//data/proposal/organizers";
	public final static String ZHUANLI_EXTRACT_XPATH_DATE = "//data/proposal/notice_date";
	public final static String ZHUANLI_EXTRACT_XPATH_QLR = "//data/content/zl_name";
	public final static String ZHUANLI_EXTRACT_XPATH_FMR = "//data/proposal/psn_invention";
	
	/**
	 * 项目简介
	 */
	public final static String PRPCONTENT_EXTRACT_XPATH = "//data/proposal/goal/summary";
	/**
	 * 主要科技创新
	 */
	public final static String ZHUANLI_EXTRACT_XPATH_CONTENT1 = "//data/proposal/goal/summary2";
	public final static String ZHUANLI_EXTRACT_XPATH_CONTENT2 = "//data/proposal/goal/summary3";
	public final static String ZHUANLI_EXTRACT_XPATH_CONTENT3 = "//data/proposal/goal/summary4";
	public final static String ZHUANLI_EXTRACT_XPATH_CONTENT4 = "//data/proposal/goal/summary5";
	/**
	 * 论文专著
	 */
	public final static String PAPER_EXTRACT_XPATH_LIST = "//data/paper/list";
	/**
	 * 人员
	 */
	public final static String PSN_EXTRACT_XPATH_FIRST_NAME = "//data/zh_persons/first_zh_person/basic_info/zh_name";
	public final static String PSN_EXTRACT_XPATH_FIRST_GENDER = "//data/zh_persons/first_zh_person/basic_info/gender_name";
	public final static String PSN_EXTRACT_XPATH_FIRST_POSI = "//data/zh_persons/first_zh_person/basic_info/position";
	public final static String PSN_EXTRACT_XPATH_FIRST_TITLE = "//data/zh_persons/first_zh_person/basic_info/prof_title1_name";
	public final static String PSN_EXTRACT_XPATH_FIRST_TYPE_VALUE = "//data/zh_persons/first_zh_person/basic_info/card_type_value";
	public final static String PSN_EXTRACT_XPATH_FIRST_TYPE = "//data/zh_persons/first_zh_person/basic_info/card_type_name";
	public final static String PSN_EXTRACT_XPATH_FIRST_CODE = "//data/zh_persons/first_zh_person/basic_info/card_code";
	public final static String PSN_EXTRACT_XPATH_LIST = "//data/zh_persons/other_zh_person";
}
