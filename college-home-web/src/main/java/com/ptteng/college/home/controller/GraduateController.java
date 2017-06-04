package com.ptteng.college.home.controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ptteng.college.home.model.Graduate;
import com.ptteng.college.home.service.GraduateService;
import util.DynamicUtil;

/**
 * Graduate  crud
 * 
 * @author magenm
 * @Date 2014-4-16 13:43
 * 
 */
@Controller
public class GraduateController {
	private static final Log log = LogFactory.getLog(GraduateController.class);

	@Autowired
	private GraduateService graduateService;



	@RequestMapping(value = "/a/graduate/search", method = RequestMethod.GET)
	public String getgraduateListJson(HttpServletRequest request,
									  HttpServletResponse response, ModelMap model, String title, Long startAt,
									  Long endAt, Long status, Integer page, Integer size)
			throws Exception {

		if (page == null) {
			page = 1;
		}
		if (size == null) {
			size = 10;
		}
		int start = (page - 1) * size;
		if (start < 0) {
			start = 0;
		}

		List<Long> idsList = null;
		try {
			Map<String, Object> param = DynamicUtil.getGraduateList(title, startAt, endAt, status);
			log.info("get param data is  " + param);
			idsList = graduateService.getIdsByDynamicCondition(Graduate.class, param, start, size);
			List<Graduate> graduateList = graduateService.getObjectsByIds(idsList);
			Integer total = idsList.size();
			model.addAttribute("code", 0);
			model.addAttribute("graduateList", graduateList);
			model.addAttribute("total", total);
			model.addAttribute("size", size);
		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("get graduateList error,id is  " + idsList);
			model.addAttribute("code", -100000);
		}

		return "/college-home-service/graduate/json/graduateListJson";
	}
	

	@RequestMapping(value = "/a/graduate/{id}", method = RequestMethod.GET)
	public String getGraduateJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("get data : id= " + id);
		try {
			Graduate graduate = graduateService.getObjectById(id);
			log.info("get graduate data is " + graduate);

			model.addAttribute("code", 0);

			model.addAttribute("graduate", graduate);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get graduate error,id is  " + id);
			model.addAttribute("code", -100000);
		}

		return "/college-home-service/graduate/json/graduateDetailJson";
	}

	@RequestMapping(value = "/a/graduate/{id}", method = RequestMethod.PUT)
	public String updateGraduateJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Graduate graduate) throws Exception {
		
		log.info("update graduate : graduate= " + graduate);
		
		try {
			
			graduateService.update(graduate);

			model.addAttribute("code", 0);

			model.addAttribute("graduate", graduate);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("update graduate error,id is  " + graduate.getId());
			model.addAttribute("code", -6003);

		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/graduate", method = RequestMethod.POST)
	public String addGraduateJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Graduate graduate) throws Exception {
		
		log.info("update graduate : graduate= " + graduate);
		
		try { 
			graduate.setId(null);

			graduateService.insert(graduate);

			model.addAttribute("code", 0);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("add graduate error ");
			model.addAttribute("code", -6002);
		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/graduate/{id}", method = RequestMethod.DELETE)
	public String deleteGraduateJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("delete graduate : id= " + id);
		try {
			graduateService.delete(id);

			log.info("add graduate success");
			model.addAttribute("code", 0);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete graduate error,id is  " + id);
			model.addAttribute("code", -6004);

		}

		return "/data/json";
	}
	
	
	@RequestMapping(value = "/a/multi/graduate", method = RequestMethod.GET)
	public String getMultiGraduateJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Long[] ids)
			throws Exception {
			
		List<Long> idList = new ArrayList();	
	   if (ids == null) {

		} else {
			idList = Arrays.asList(ids);
		}
		try {

			

			List<Graduate> graduateList = graduateService.getObjectsByIds(idList);
			log.info("get  graduate data is " + graduateList);

			model.addAttribute("code", 0);			
			model.addAttribute("total",graduateList.size());

			model.addAttribute("graduateList", graduateList);

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get graduate error,id is  " + idList);
			model.addAttribute("code", -100000);
		}

		return "/college-home-service/graduate/json/graduateListJson";
	}
	
	
	
	
	
}

