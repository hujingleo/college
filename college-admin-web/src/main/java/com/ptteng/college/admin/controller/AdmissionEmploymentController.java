package com.ptteng.college.admin.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.ptteng.college.home.model.Manager;

import com.ptteng.college.home.service.ManagerService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ptteng.college.home.model.AdmissionEmployment;
import com.ptteng.college.home.service.AdmissionEmploymentService;
import util.DynamicUtil;

import static com.ptteng.college.home.constant.Constant.SHELEVE_DOWN;
import static com.ptteng.college.home.constant.Constant.SHELEVE_UP;

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
	@Autowired
	private com.qding.common.util.http.cookie.CookieUtil cookieUtil;
	@Autowired
	private ManagerService managerService;







	@RequestMapping(value = "/a/u/admissionEmployment/{id}", method = RequestMethod.GET)
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

		return "/college-admin-service/admissionEmployment/json/admissionEmploymentDetailJson";
	}

	@RequestMapping(value = "/a/u/admissionEmployment/search", method = RequestMethod.GET)
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

		return "/college-admin-service/admissionEmployment/json/admissionEmploymentListJson";
	}


	@RequestMapping(value = "/a/u/admissionEmployment/{id}", method = RequestMethod.PUT)
	public String updateAdmissionEmploymentJson(HttpServletRequest request,
									HttpServletResponse response, ModelMap model, @PathVariable Long id, @RequestBody AdmissionEmployment admissionEmployment) throws Exception {

		log.info("update admissionEmployment : admissionEmployment= " + admissionEmployment);


		if (admissionEmployment.getTitle() == null) {
			model.addAttribute("code", -6500);
			return "/common/fail";
		}
		if (admissionEmployment.getContent() == null) {
			model.addAttribute("code", -6501);
			return "/common/fail";
		}

		AdmissionEmployment admissionEmploymentSource = admissionEmploymentService.getObjectById(id);

		try {
			admissionEmployment.setId(admissionEmploymentSource.getId());
			admissionEmployment.setStatus(admissionEmploymentSource.getStatus());
			admissionEmployment.setCreateAt(admissionEmploymentSource.getCreateAt());
			admissionEmployment.setUpdateAt(System.currentTimeMillis());
                  /* 从cookie中获取userid */
			Long uid = Long.valueOf(cookieUtil.getKeyIdentity(request, com.qding.common.util.http.cookie.CookieUtil.USER_ID));
			admissionEmployment.setAuthor(admissionEmploymentSource.getAuthor());
			admissionEmployment.setCreateBy(admissionEmploymentSource.getCreateBy());
			admissionEmployment.setUpdateBy(uid);
			admissionEmploymentService.update(admissionEmployment);
			log.info("update success , id is " + id);
			model.addAttribute("code", 0);
		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("update admissionEmployment error ");
			model.addAttribute("code", -6504);
		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/u/admissionEmployment", method = RequestMethod.POST)
	public String addadmissionEmploymentJson(HttpServletRequest request,
								  HttpServletResponse response, ModelMap model, @RequestBody AdmissionEmployment admissionEmployment) throws Exception {

		log.info("insert admissionEmployment : admissionEmployment= " + admissionEmployment);

		if (admissionEmployment.getTitle() == null) {
			model.addAttribute("code", -6500);
			return "/common/fail";
		}
		if (admissionEmployment.getContent() == null) {
			model.addAttribute("code", -6501);
			return "/common/fail";
		}
		if (admissionEmployment.getStatus() == null) {
			model.addAttribute("code", -6502);
			return "/common/fail";
		}
		if (admissionEmployment.getStatus() != SHELEVE_UP && admissionEmployment.getStatus() != SHELEVE_DOWN) {
			model.addAttribute("code", -4020);
			return "common/success";
		}
		if (admissionEmployment.getCategory() == null) {
			model.addAttribute("code", -6503);
			return "/common/fail";
		}
		try {
			admissionEmployment.setId(null);
			admissionEmployment.setCreateAt(System.currentTimeMillis());
			admissionEmployment.setUpdateAt(admissionEmployment.getCreateAt());
                              /* 从cookie中获取userid */
			Long uid = Long.valueOf(cookieUtil.getKeyIdentity(request, com.qding.common.util.http.cookie.CookieUtil.USER_ID));
			Manager manager = managerService.getObjectById(uid);
			admissionEmployment.setAuthor(manager.getName());
			admissionEmployment.setCreateBy(uid);
			admissionEmployment.setUpdateBy(admissionEmployment.getCreateBy());
			Long id = admissionEmploymentService.insert(admissionEmployment);
			log.info("insert success , id is " + id);
			model.addAttribute("code", 0);
			model.addAttribute("id", id);
		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("add admissionEmployment error ");
			model.addAttribute("code", -6504);
		}

		return "/common/addsuccess";
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

