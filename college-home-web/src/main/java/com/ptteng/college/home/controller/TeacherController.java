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

import com.ptteng.college.home.model.Teacher;
import com.ptteng.college.home.service.TeacherService;
import util.DynamicUtil;

/**
 * Teacher  crud
 * 
 * @author magenm
 * @Date 2014-4-16 13:43
 * 
 */
@Controller
public class TeacherController {
	private static final Log log = LogFactory.getLog(TeacherController.class);

	@Autowired
	private TeacherService teacherService;






	@RequestMapping(value = "/a/teacher/search", method = RequestMethod.GET)
	public String getTeacherListJson(HttpServletRequest request,
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
			Map<String, Object> param = DynamicUtil.getTeacherList(title, category, startAt, endAt, status);
			log.info("get param data is  " + param);
			idsList = teacherService.getIdsByDynamicCondition(Teacher.class, param, start, size);
			List<Teacher> teacherList = teacherService.getObjectsByIds(idsList);
			Integer total = idsList.size();
			model.addAttribute("code", 0);
			model.addAttribute("teacherList", teacherList);
			model.addAttribute("total", total);
			model.addAttribute("size", size);
		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("get teacherList error,id is  " + idsList);
			model.addAttribute("code", -100000);
		}

		return "/college-home-service/teacher/json/teacherListJson";
	}

	
	    
	

	@RequestMapping(value = "/a/teacher/{id}", method = RequestMethod.GET)
	public String getTeacherJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("get data : id= " + id);
		try {
			Teacher teacher = teacherService.getObjectById(id);
			log.info("get teacher data is " + teacher);

			model.addAttribute("code", 0);

			model.addAttribute("teacher", teacher);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get teacher error,id is  " + id);
			model.addAttribute("code", -100000);
		}

		return "/college-home-service/teacher/json/teacherDetailJson";
	}

	@RequestMapping(value = "/a/teacher/{id}", method = RequestMethod.PUT)
	public String updateTeacherJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Teacher teacher) throws Exception {
		
		log.info("update teacher : teacher= " + teacher);
		
		try {
			
			teacherService.update(teacher);

			model.addAttribute("code", 0);

			model.addAttribute("teacher", teacher);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("update teacher error,id is  " + teacher.getId());
			model.addAttribute("code", -6003);

		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/teacher", method = RequestMethod.POST)
	public String addTeacherJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Teacher teacher) throws Exception {
		
		log.info("update teacher : teacher= " + teacher);
		
		try { 
			teacher.setId(null);

			teacherService.insert(teacher);

			model.addAttribute("code", 0);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("add teacher error ");
			model.addAttribute("code", -6002);
		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/teacher/{id}", method = RequestMethod.DELETE)
	public String deleteTeacherJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("delete teacher : id= " + id);
		try {
			teacherService.delete(id);

			log.info("add teacher success");
			model.addAttribute("code", 0);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete teacher error,id is  " + id);
			model.addAttribute("code", -6004);

		}

		return "/data/json";
	}
	
	
	@RequestMapping(value = "/a/multi/teacher", method = RequestMethod.GET)
	public String getMultiTeacherJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Long[] ids)
			throws Exception {
			
		List<Long> idList = new ArrayList();	
	   if (ids == null) {

		} else {
			idList = Arrays.asList(ids);
		}
		try {

			

			List<Teacher> teacherList = teacherService.getObjectsByIds(idList);
			log.info("get  teacher data is " + teacherList);

			model.addAttribute("code", 0);			
			model.addAttribute("total",teacherList.size());

			model.addAttribute("teacherList", teacherList);

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get teacher error,id is  " + idList);
			model.addAttribute("code", -100000);
		}

		return "/college-home-service/teacher/json/teacherListJson";
	}
	
	
	
	
	
}

