/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package egovframework.example.sample.web;

import egovframework.example.sample.service.EgovSampleService;
import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springmodules.validation.commons.DefaultBeanValidator;

import javax.annotation.Resource;

/**
 * @Class Name : EgovSampleController.java
 * @Description : EgovSample Controller Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2009.03.16           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2009. 03.16
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */

@Controller
public class EgovSampleController {

	/** EgovSampleService */
	@Resource(name = "sampleService")
	private EgovSampleService sampleService;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** Validator */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;

	@RequestMapping(value="/testList")
	public String testListDo(Model model)
	{
		model.addAttribute("list", sampleService.selectTest());
		return "sample/testList";
	}

	@RequestMapping(value="/testDetail/{id}")
	public String testListDo(@PathVariable int id, Model model)
	{
		model.addAttribute("vo", sampleService.selectDetailTest(id));
		return "sample/testDetail";
	}

//	/**
//	 * 글 목록을 조회한다. (pageing)
//	 * @param searchVO - 조회할 정보가 담긴 SampleDefaultVO
//	 * @param model
//	 * @return "egovSampleList"
//	 * @exception Exception
//	 */
//	@RequestMapping(value = "/egovSampleList.do")
//	public String selectSampleList(@ModelAttribute("searchVO") SampleDefaultVO searchVO, ModelMap model) throws Exception {
//
//		/** EgovPropertyService.sample */
//		searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
//		searchVO.setPageSize(propertiesService.getInt("pageSize"));
//
//		/** pageing setting */
//		PaginationInfo paginationInfo = new PaginationInfo();
//		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
//		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
//		paginationInfo.setPageSize(searchVO.getPageSize());
//
//		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
//		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
//		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
//
//		List<?> sampleList = sampleService.selectSampleList(searchVO);
//		model.addAttribute("resultList", sampleList);
//
//		int totCnt = sampleService.selectSampleListTotCnt(searchVO);
//		paginationInfo.setTotalRecordCount(totCnt);
//		model.addAttribute("paginationInfo", paginationInfo);
//
//		return "sample/egovSampleList";
//	}



}
