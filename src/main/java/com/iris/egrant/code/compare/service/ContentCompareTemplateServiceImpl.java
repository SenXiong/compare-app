package com.iris.egrant.code.compare.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.iris.egrant.code.compare.constant.app.CompareConstants;
import com.iris.egrant.code.compare.model.ArchiveFile;
import com.iris.egrant.core.exception.ServiceException;
import com.iris.egrant.core.utils.ReadFileUtils;
import com.iris.egrant.core.utils.SimilarityUtils;
 
/**
 *   可行性报告
 * @author iris
 *
 */
@Service("contentCompareTemplateServiceImpl")
public class ContentCompareTemplateServiceImpl  extends DataFilterSolrSupport implements  CompareTemplateService {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private CompareSourceService compareSourceService;
	
	@Autowired
	private FileService fileService;
	
	@Value("${uploadFileRootDir}")
	private String uploadFileRootDir;

	@SuppressWarnings("finally")
	@Override
	public String extractCompareSource(long prpCode) {
		String content = "";
		// System.out.println(DateUtils.now(DateFormator.YEAR_MONTH_DAY_HH_MM_SS)+"=========start:抽取可行性报告==========");
		
		String tempContent = "";
		try {
			// 获取可行性报告filecode的相对路径，默认可行性报告为第一个
			String path = CompareConstants.CONTENT_EXTRACT_XPATH_DEFAULT;
			tempContent = compareSourceService.getDBContent(prpCode, 1, 2, path, path);
			if("-1".equalsIgnoreCase(tempContent)) {
				path = CompareConstants.CONTENT_EXTRACT_XPATH_OTHER;
				tempContent = compareSourceService.getDBContent(prpCode, 1, 2, path, path);
			}
			if("-1".equalsIgnoreCase(tempContent)) {
				path = CompareConstants.CONTENT_EXTRACT_XPATH_OTHER1;
				tempContent = compareSourceService.getDBContent(prpCode, 1, 2, path, path);
			}
			if("-1".equalsIgnoreCase(tempContent)) {
				path = CompareConstants.CONTENT_EXTRACT_XPATH_OTHER2;
				tempContent = compareSourceService.getDBContent(prpCode, 1, 2, path, path);
			}
			if("-1".equalsIgnoreCase(tempContent)) {
				path = CompareConstants.CONTENT_EXTRACT_XPATH_OTHER3;
				tempContent = compareSourceService.getDBContent(prpCode, 1, 2, path, path);
			}
		
			if(!"-1".equalsIgnoreCase(tempContent) && !"".equalsIgnoreCase(tempContent)) {	//有可行性报告
				String[] fileCodeAry = tempContent.split(",");
				for (String fileCode : fileCodeAry) {
					if (StringUtils.isNotBlank(fileCode)) {
						content += getFileContent(fileCode) + "\r\n";
					}
				}
			}
		} catch (Exception e) {
			logger.error("抽取可行性报告出错,keyCode=" + prpCode + ",type=" + 1 + ",errMsg="+ e.getMessage());
			throw new ServiceException("抽取可行性报告出错,keyCode=" + prpCode + ",type=" + 1 + ",errMsg="+ e.getMessage());
		} finally {
			// System.out.println(content);
			// System.out.println(DateUtils.now(DateFormator.YEAR_MONTH_DAY_HH_MM_SS)+"=========end:抽取可行性报告==========");
			return content;
		}

	}

	@Override
	public Double compareContent(String sourceContent, String targetContent) {
		Double similarity = 0.0;
		if(!StringUtils.isNotBlank(sourceContent) || !StringUtils.isNotBlank(targetContent)) {
			return similarity;
		}
		
		// System.out.println(DateUtils.now(DateFormator.YEAR_MONTH_DAY_HH_MM_SS)+"=========start:可行性报告相似度比对==========");
		similarity = SimilarityUtils.calculateSimilaryByClause(sourceContent, targetContent, 4, CompareConstants.filterWord);
		// System.out.println("可行性报告相似度：" + similarity);
		// System.out.println(DateUtils.now(DateFormator.YEAR_MONTH_DAY_HH_MM_SS)+"=========end:可行性报告相似度比对==========");
		return similarity;
	}

	@Override
	public Map<String, String> renderDiffer(String sourceContent, String targetContent) {
		Map<String, String> map = new HashMap<String, String>();
		if(!StringUtils.isNotBlank(sourceContent) || !StringUtils.isNotBlank(targetContent)) {
			map.put("sourceContent", sourceContent);
			map.put("targetContent", targetContent);
			return map;
		}
		
		List<String> same = SimilarityUtils.getSameList(sourceContent, targetContent, 4, null);
		String fontColor = "#FF0000";
		String backgroundColor = "#FFFFFF";
		sourceContent = SimilarityUtils.replaceSameContent(sourceContent, same, fontColor, backgroundColor, true);
		targetContent = SimilarityUtils.replaceSameContent(targetContent, same, fontColor, backgroundColor, false);
		
		map.put("sourceContent", sourceContent);
		map.put("targetContent", targetContent);
		return map;
	}
	
	/**
	 * 获取文件内容
	 * 
	 * @param fileCode
	 * @return
	 * @throws ServiceException
	 */
	private String getFileContent(String fileCode) throws ServiceException {
		String content = "";
		if (StringUtils.isBlank(fileCode)) {
			return content;
		}

		try {
			ArchiveFile af = fileService.getArchiveFile(fileCode);
			if (af != null) {
				String filePath = af.getFilePath();
				// 获取文件的绝对路径
				filePath = buildAbsoluteFilePath(filePath);
				if (filePath.endsWith(".doc")) {
					content = ReadFileUtils.readWord2003(filePath);
				} else if (filePath.endsWith(".docx")) {
					content = ReadFileUtils.readWord2007(filePath);
				} else if (filePath.endsWith(".pdf")) {
					content = ReadFileUtils.readPdf(filePath);
				}
			}
		} catch (Exception e) {
			logger.error("相似度对比中获取附件内容出错,fileCode=" + fileCode + ",errMsg=" + e.getMessage());
			throw new ServiceException("相似度对比中获取附件内容出错,fileCode=" + fileCode + ",errMsg=" + e.getMessage());
		}
		return content;
	}


	// 拼装文件的绝对路径
	private String buildAbsoluteFilePath(String path) {
		String apath = uploadFileRootDir;
		if (!apath.endsWith(File.separator)) {
			apath += File.separator;
		}
		apath += path;
		return apath;
	}

}
