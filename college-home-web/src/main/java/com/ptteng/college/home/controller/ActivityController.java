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

import com.ptteng.college.home.model.Activity;
import com.ptteng.college.home.service.ActivityService;
import util.DynamicUtil;

/**
 * Activity  crud
 * 
 * @author magenm
 * @Date 2014-4-16 13:43
 * 
 */
@Controller
public class ActivityController {
	private static final Log log = LogFactory.getLog(ActivityController.class);

	@Autowired
	private ActivityService activityService;






	@RequestMapping(value = "/a/activity/search", method = RequestMethod.GET)
	public String getActivityListJson(HttpServletRequest request,
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
			Map<String, Object> param = DynamicUtil.getActivityList(title, startAt, endAt, status);
			log.info("get param data is  " + param);
			idsList = activityService.getIdsByDynamicCondition(Activity.class, param, start, size);
			List<Activity> activityList = activityService.getObjectsByIds(idsList);
			Integer total = idsList.size();
			model.addAttribute("code", 0);
			model.addAttribute("activityList", activityList);
			model.addAttribute("total", total);
			model.addAttribute("size", size);
		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("get activityList error,id is  " + idsList);
			model.addAttribute("code", -100000);
		}

		return "/college-home-service/activity/json/activityListJson";
	}
	
	    
	

	@RequestMapping(value = "/a/activity/{id}", method = RequestMethod.GET)
	public String getActivityJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("get data : id= " + id);
		try {
			Activity activity = activityService.getObjectById(id);
			log.info("get activity data is " + activity);

			model.addAttribute("code", 0);

			model.addAttribute("activity", activity);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get activity error,id is  " + id);
			model.addAttribute("code", -100000);
		}

		return "/college-home-service/activity/json/activityDetailJson";
	}

	@RequestMapping(value = "/a/activity/{id}", method = RequestMethod.PUT)
	public String updateActivityJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Activity activity) throws Exception {
		
		log.info("update activity : activity= " + activity);
		
		try {
			
			activityService.update(activity);

			model.addAttribute("code", 0);

			model.addAttribute("activity", activity);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("update activity error,id is  " + activity.getId());
			model.addAttribute("code", -6003);

		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/activity", method = RequestMethod.POST)
	public String addActivityJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Activity activity) throws Exception {
		
		log.info("update activity : activity= " + activity);
		
		try { 
			activity.setId(null);

			activityService.insert(activity);

			model.addAttribute("code", 0);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("add activity error ");
			model.addAttribute("code", -6002);
		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/activity/{id}", method = RequestMethod.DELETE)
	public String deleteActivityJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("delete activity : id= " + id);
		try {
			activityService.delete(id);

			log.info("add activity success");
			model.addAttribute("code", 0);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete activity error,id is  " + id);
			model.addAttribute("code", -6004);

		}

		return "/data/json";
	}
	

	
	
	
	
	
}

