package com.ptteng.college.admin.controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ptteng.college.home.model.*;
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
import com.ptteng.college.home.service.GraduateService;
import util.DynamicUtil;
import static com.ptteng.college.home.constant.Constant.SHELEVE_DOWN;
import static com.ptteng.college.home.constant.Constant.SHELEVE_UP;


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
	@Autowired
	private com.qding.common.util.http.cookie.CookieUtil cookieUtil;
	@Autowired
	private ManagerService managerService;



	@RequestMapping(value = "/a/u/graduate/{id}", method = RequestMethod.GET)
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

		return "/college-admin-service/graduate/json/graduateDetailJson";
	}

	@RequestMapping(value = "/a/u/graduate/search", method = RequestMethod.GET)
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

		return "/college-admin-service/graduate/json/graduateListJson";
	}

	@RequestMapping(value = "/a/u/graduate/status", method = RequestMethod.PUT)
	public String updateGraduateStatusJson(HttpServletRequest request,
										  HttpServletResponse response, ModelMap model, Long id, Long status) throws Exception {

		log.info("get id is " + id);
		log.info("get status is " + status);
		if (status == null || status < 0 || status > 1) {
			model.addAttribute("code", -9013);
			return "/data/json";
		}
		try {
			Graduate graduate = graduateService.getObjectById(id);
			graduate.setStatus(status);
			log.info("update graduate data is " + graduate);
			graduateService.update(graduate);

			model.addAttribute("code", 0);


		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("update status error,graduateId is  " + id);
			model.addAttribute("code", -6003);

		}

		return "/data/json";
	}





	@RequestMapping(value = "/a/u/graduate/{id}", method = RequestMethod.PUT)
	public String updateGraduateJson(HttpServletRequest request,
									 HttpServletResponse response, ModelMap model, @PathVariable Long id, @RequestBody Graduate graduate) throws Exception {

		log.info("update graduate : graduate= " + graduate);


		if (graduate.getTitle() == null) {
			model.addAttribute("code", -6500);
			return "/common/fail";
		}
		if (graduate.getContent() == null) {
			model.addAttribute("code", -6501);
			return "/common/fail";
		}

		Graduate graduateSource = graduateService.getObjectById(id);

		try {
			graduate.setId(graduateSource.getId());
			graduate.setRank(graduateSource.getRank());
			graduate.setStatus(graduateSource.getStatus());
			graduate.setCreateAt(graduateSource.getCreateAt());
			graduate.setUpdateAt(System.currentTimeMillis());
                  /* 从cookie中获取userid */
			Long uid = Long.valueOf(cookieUtil.getKeyIdentity(request, com.qding.common.util.http.cookie.CookieUtil.USER_ID));
			graduate.setAuthor(graduateSource.getAuthor());
			graduate.setCreateBy(graduateSource.getCreateBy());
			graduate.setUpdateBy(uid);
			graduateService.update(graduate);
			log.info("update success , id is " + id);
			model.addAttribute("code", 0);
		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("update graduate error ");
			model.addAttribute("code", -6504);
		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/u/graduate", method = RequestMethod.POST)
	public String addgraduateJson(HttpServletRequest request,
								 HttpServletResponse response, ModelMap model, @RequestBody Graduate graduate) throws Exception {

		log.info("inser graduate : graduate= " + graduate);

		if (graduate.getTitle() == null) {
			model.addAttribute("code", -6500);
			return "/common/fail";
		}
		if (graduate.getContent() == null) {
			model.addAttribute("code", -6501);
			return "/common/fail";
		}
		if (graduate.getStatus() == null) {
			model.addAttribute("code", -6502);
			return "/common/fail";
		}
		if (graduate.getStatus() != SHELEVE_UP && graduate.getStatus() != SHELEVE_DOWN) {
			model.addAttribute("code", -4020);
			return "common/success";
		}



		try {
			graduate.setId(null);
			graduate.setRank(0l);
			graduate.setCreateAt(System.currentTimeMillis());
			graduate.setUpdateAt(graduate.getCreateAt());
                  /* 从cookie中获取userid */
			Long uid = Long.valueOf(cookieUtil.getKeyIdentity(request, com.qding.common.util.http.cookie.CookieUtil.USER_ID));
			Manager manager = managerService.getObjectById(uid);
			graduate.setAuthor(manager.getName());
			graduate.setCreateBy(uid);
			graduate.setUpdateBy(graduate.getCreateBy());
			Long id = graduateService.insert(graduate);
			log.info("insert success , id is " + id);
			model.addAttribute("code", 0);
			model.addAttribute("id", id);
		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("add graduate error ");
			model.addAttribute("code", -6504);
		}

		return "/common/addsuccess";
	}

	@RequestMapping(value = "/a/u/graduate/rank", method = RequestMethod.POST)
	public String addGraduateRankJson(HttpServletRequest request,
									 HttpServletResponse response, ModelMap model,@RequestBody Long[] rank
	) throws Exception {

		log.info("get rank is  " + rank);
		try {
			List<Long> list = Arrays.asList(rank);
			List<Graduate> graduateList = graduateService.getObjectsByIds(list);
			for (Graduate graduate:graduateList){
				Long id = graduate.getId();
				graduate.setRank(Long.valueOf(list.indexOf(id)));
			}
			graduateService.updateList(graduateList);
			model.addAttribute("code",0);
		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("add graduate error ");
			model.addAttribute("code", -1);
		}

		return "/data/json";
	}



	@RequestMapping(value = "/a/u/graduate/{id}", method = RequestMethod.DELETE)
	public String deleteGraduateJson(HttpServletRequest request,
									 HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("delete graduate : id= " + id);
		Graduate graduate = graduateService.getObjectById(id);
		Long status = graduate.getStatus();
		log.info("get graduate status is "+status);
		if (status.equals(SHELEVE_UP)){
			model.addAttribute("code",-6511);
			log.info("上架状态不可删除");
			return "/common/fail";
		}
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

