package com.ptteng.college.admin.controller;
import java.util.ArrayList;
import java.util.Arrays;
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

import com.ptteng.college.home.model.Exchange;
import com.ptteng.college.home.service.ExchangeService;
import util.DynamicUtil;

import static com.ptteng.college.home.constant.Constant.SHELEVE_DOWN;
import static com.ptteng.college.home.constant.Constant.SHELEVE_UP;

/**
 * Exchange  crud
 * 
 * @author magenm
 * @Date 2014-4-16 13:43
 * 
 */
@Controller
public class ExchangeController {
	private static final Log log = LogFactory.getLog(ExchangeController.class);

	@Autowired
	private ExchangeService exchangeService;
	@Autowired
	private com.qding.common.util.http.cookie.CookieUtil cookieUtil;
	@Autowired
	private ManagerService managerService;






	
	
	
	    
	

	@RequestMapping(value = "/a/u/exchange/{id}", method = RequestMethod.GET)
	public String getExchangeJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("get data : id= " + id);
		try {
			Exchange exchange = exchangeService.getObjectById(id);
			log.info("get exchange data is " + exchange);

			model.addAttribute("code", 0);

			model.addAttribute("exchange", exchange);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get exchange error,id is  " + id);
			model.addAttribute("code", -100000);
		}

		return "/college-admin-service/exchange/json/exchangeDetailJson";
	}


	@RequestMapping(value = "/a/u/exchange/search", method = RequestMethod.GET)
	public String getExchangeListJson(HttpServletRequest request,
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
			Map<String, Object> param = DynamicUtil.getExchangeList(title, startAt, endAt, status);
			log.info("get param data is  " + param);
			idsList = exchangeService.getIdsByDynamicCondition(Exchange.class, param, start, size);
			List<Exchange> exchangeList = exchangeService.getObjectsByIds(idsList);
			Integer total = idsList.size();
			model.addAttribute("code", 0);
			model.addAttribute("exchangeList", exchangeList);
			model.addAttribute("total", total);
			model.addAttribute("size", size);
		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("get exchangeList error,id is  " + idsList);
			model.addAttribute("code", -100000);
		}

		return "/college-admin-service/exchange/json/exchangeListJson";
	}


	@RequestMapping(value = "/a/u/exchange/{id}", method = RequestMethod.PUT)
	public String updateExchangeJson(HttpServletRequest request,
									 HttpServletResponse response, ModelMap model, @PathVariable Long id, @RequestBody Exchange exchange) throws Exception {

		log.info("update exchange : exchange= " + exchange);


		if (exchange.getTitle() == null) {
			model.addAttribute("code", -6500);
			return "/common/fail";
		}
		if (exchange.getContent() == null) {
			model.addAttribute("code", -6501);
			return "/common/fail";
		}

		Exchange exchangeSource = exchangeService.getObjectById(id);

		try {
			exchange.setId(exchangeSource.getId());
			exchange.setStatus(exchangeSource.getStatus());
			exchange.setCreateAt(exchangeSource.getCreateAt());
			exchange.setUpdateAt(System.currentTimeMillis());
                  /* 从cookie中获取userid */
			Long uid = Long.valueOf(cookieUtil.getKeyIdentity(request, com.qding.common.util.http.cookie.CookieUtil.USER_ID));
			exchange.setAuthor(exchangeSource.getAuthor());
			exchange.setCreateBy(exchangeSource.getCreateBy());
			exchange.setUpdateBy(uid);
			exchangeService.update(exchange);
			log.info("update success , id is " + id);
			model.addAttribute("code", 0);
		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("update exchange error ");
			model.addAttribute("code", -6504);
		}

		return "/data/json";
	}



	@RequestMapping(value = "/a/u/exchange/status", method = RequestMethod.PUT)
	public String updateExchangeStatusJson(HttpServletRequest request,
										  HttpServletResponse response, ModelMap model, Long id, Long status) throws Exception {

		log.info("get id is " + id);
		log.info("get status is " + status);
		if (status == null || status < 0 || status > 1) {
			model.addAttribute("code", -9013);
			return "/data/json";
		}
		try {
			Exchange exchange = exchangeService.getObjectById(id);
			exchange.setStatus(status);
			log.info("update exchange data is " + exchange);
			exchangeService.update(exchange);

			model.addAttribute("code", 0);


		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("update status error,exchangeId is  " + id);
			model.addAttribute("code", -6003);

		}

		return "/data/json";
	}



	@RequestMapping(value = "/a/exchange/{id}", method = RequestMethod.PUT)
	public String updateExchangeJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Exchange exchange) throws Exception {
		
		log.info("update exchange : exchange= " + exchange);
		
		try {
			
			exchangeService.update(exchange);

			model.addAttribute("code", 0);

			model.addAttribute("exchange", exchange);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("update exchange error,id is  " + exchange.getId());
			model.addAttribute("code", -6003);

		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/u/exchange", method = RequestMethod.POST)
	public String addExchangeJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model,@RequestBody Exchange exchange) throws Exception {
		
		log.info("insert exchange : exchange= " + exchange);

		if (exchange.getTitle() == null) {
			model.addAttribute("code", -6500);
			return "/common/fail";
		}
		if (exchange.getContent() == null) {
			model.addAttribute("code", -6501);
			return "/common/fail";
		}
		if (exchange.getStatus() == null) {
			model.addAttribute("code", -6502);
			return "/common/fail";
		}
		if (exchange.getStatus() != SHELEVE_UP && exchange.getStatus() != SHELEVE_DOWN) {
			model.addAttribute("code", -4020);
			return "common/success";
		}
		try { 
			exchange.setId(null);
			exchange.setCreateAt(System.currentTimeMillis());
			exchange.setUpdateAt(exchange.getCreateAt());
                              /* 从cookie中获取userid */
			Long uid = Long.valueOf(cookieUtil.getKeyIdentity(request, com.qding.common.util.http.cookie.CookieUtil.USER_ID));
			Manager manager = managerService.getObjectById(uid);
			exchange.setAuthor(manager.getName());
			exchange.setCreateBy(uid);
			exchange.setUpdateBy(exchange.getCreateBy());
			Long id = exchangeService.insert(exchange);
			log.info("insert success , id is " + id);
			model.addAttribute("code", 0);
			model.addAttribute("id", id);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("add exchange error ");
			model.addAttribute("code", -6504);
		}


		return "/common/addsuccess";
	}

	@RequestMapping(value = "/a/u/exchange/{id}", method = RequestMethod.DELETE)
	public String deleteExchangeJson(HttpServletRequest request,
									 HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("delete exchange : id= " + id);
		Exchange exchange = exchangeService.getObjectById(id);
		Long status = exchange.getStatus();
		log.info("get exchange status is "+status);
		if (status.equals(SHELEVE_UP)){
			model.addAttribute("code",-6511);
			log.info("上架状态不可删除");
			return "/common/fail";
		}
		try {
			exchangeService.delete(id);

			log.info("add exchange success");
			model.addAttribute("code", 0);

		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete exchange error,id is  " + id);
			model.addAttribute("code", -6004);

		}

		return "/data/json";
	}
	
	
	@RequestMapping(value = "/a/multi/exchange", method = RequestMethod.GET)
	public String getMultiExchangeJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Long[] ids)
			throws Exception {
			
		List<Long> idList = new ArrayList();	
	   if (ids == null) {

		} else {
			idList = Arrays.asList(ids);
		}
		try {

			

			List<Exchange> exchangeList = exchangeService.getObjectsByIds(idList);
			log.info("get  exchange data is " + exchangeList);

			model.addAttribute("code", 0);			
			model.addAttribute("total",exchangeList.size());

			model.addAttribute("exchangeList", exchangeList);

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get exchange error,id is  " + idList);
			model.addAttribute("code", -100000);
		}

		return "/college-home-service/exchange/json/exchangeListJson";
	}
	
	
	
	
	
}

