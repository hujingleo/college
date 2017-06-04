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

import com.ptteng.college.home.model.AdmissionEmployment;
import com.ptteng.college.home.service.AdmissionEmploymentService;
import util.DynamicUtil;

/**
 * AdmissionEmployment  crud
 * 
 * @author magenm
 * @Date 2014-4-16 13:43
 * 
 */
@Controller
public class AdmissionEmploymentController {
	private static final Log log = LogFactory.getLog(AdmissionEmploymentController.class);

	@Autowired
	private AdmissionEmploymentService admissionEmploymentService;






	@RequestMapping(value = "/a/admissionEmployment/search", method = RequestMethod.GET)
	public String getadmissionEmploymentListJson(HttpServletRequest request,
												 HttpServletResponse response, ModelMap model, String title, Long category, Long startAt,
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
			Map<String, Object> param = DynamicUtil.getAdmissionEmploymentList(title, category, startAt, endAt, status);
			log.info("get param data is  " + param);
			idsList = admissionEmploymentService.getIdsByDynamicCondition(AdmissionEmployment.class, param, start, size);
			List<AdmissionEmployment> admissionEmploymentList = admissionEmploymentService.getObjectsByIds(idsList);
			Integer total = idsList.size();
			model.addAttribute("code", 0);
			model.addAttribute("admissionEmploymentList", admissionEmploymentList);
			model.addAttribute("total", total);
			model.addAttribute("size", size);
		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("get admissionEmploymentList error,id is  " + idsList);
			model.addAttribute("code", -100000);
		}

		return "/college-home-service/admissionEmployment/json/admissionEmploymentListJson";
	}

	
	
	    
	

	@RequestMapping(value = "/a/admissionEmployment/{id}", method = RequestMethod.GET)
	public String getAdmissionEmploymentJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("get data : id= " + id);
		try {
			AdmissionEmployment admissionEmployment = admissionEmploymentService.getObjectById(id);
			log.info("get admissionEmployment data is " + admissionEmployment);

			model.addAttribute("code", 0);

			model.addAttribute("admissionEmployment", admissionEmployment);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get admissionEmployment error,id is  " + id);
			model.addAttribute("code", -100000);
		}

		return "/college-home-service/admissionEmployment/json/admissionEmploymentDetailJson";
	}

	@RequestMapping(value = "/a/admissionEmployment/{id}", method = RequestMethod.PUT)
	public String updateAdmissionEmploymentJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, AdmissionEmployment admissionEmployment) throws Exception {
		
		log.info("update admissionEmployment : admissionEmployment= " + admissionEmployment);
		
		try {
			
			admissionEmploymentService.update(admissionEmployment);

			model.addAttribute("code", 0);

			model.addAttribute("admissionEmployment", admissionEmployment);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("update admissionEmployment error,id is  " + admissionEmployment.getId());
			model.addAttribute("code", -6003);

		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/admissionEmployment", method = RequestMethod.POST)
	public String addAdmissionEmploymentJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, AdmissionEmployment admissionEmployment) throws Exception {
		
		log.info("update admissionEmployment : admissionEmployment= " + admissionEmployment);
		
		try { 
			admissionEmployment.setId(null);

			admissionEmploymentService.insert(admissionEmployment);

			model.addAttribute("code", 0);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("add admissionEmployment error ");
			model.addAttribute("code", -6002);
		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/admissionEmployment/{id}", method = RequestMethod.DELETE)
	public String deleteAdmissionEmploymentJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("delete admissionEmployment : id= " + id);
		try {
			admissionEmploymentService.delete(id);

			log.info("add admissionEmployment success");
			model.addAttribute("code", 0);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete admissionEmployment error,id is  " + id);
			model.addAttribute("code", -6004);

		}

		return "/data/json";
	}
	
	

	
	
	
	
}

