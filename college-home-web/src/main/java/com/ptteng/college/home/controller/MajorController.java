package com.ptteng.college.home.controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

import com.ptteng.college.home.model.Major;
import com.ptteng.college.home.service.MajorService;

/**
 * Major  crud
 * 
 * @author magenm
 * @Date 2014-4-16 13:43
 * 
 */
@Controller
public class MajorController {
	private static final Log log = LogFactory.getLog(MajorController.class);

	@Autowired
	private MajorService majorService;






    /**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */

	@RequestMapping(value = "/c/major", method = RequestMethod.GET)
	public String getmajorList(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {

		
		
		log.info("/major  to /major/view/majorList");

		return "/college-home-service/major/view/majorList";
	}
    
    

    
	
	@RequestMapping(value = "/c/major/{id}", method = RequestMethod.GET)
	public String getMajor(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("/major/" + id + "  to /major/view/majorDeail");
		if(null != id){
			model.addAttribute("id", id);
		}else{
			model.addAttribute("id", 0);
		}

		return "/college-home-service/major/view/majorDetail";
	}
	
	
	
	    
	

	@RequestMapping(value = "/a/major/{id}", method = RequestMethod.GET)
	public String getMajorJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("get data : id= " + id);
		try {
			Major major = majorService.getObjectById(id);
			log.info("get major data is " + major);

			model.addAttribute("code", 0);

			model.addAttribute("major", major);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get major error,id is  " + id);
			model.addAttribute("code", -100000);
		}

		return "/college-home-service/major/json/majorDetailJson";
	}

	@RequestMapping(value = "/a/major/{id}", method = RequestMethod.PUT)
	public String updateMajorJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Major major) throws Exception {
		
		log.info("update major : major= " + major);
		
		try {
			
			majorService.update(major);

			model.addAttribute("code", 0);

			model.addAttribute("major", major);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("update major error,id is  " + major.getId());
			model.addAttribute("code", -6003);

		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/major", method = RequestMethod.POST)
	public String addMajorJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Major major) throws Exception {
		
		log.info("update major : major= " + major);
		
		try { 
			major.setId(null);

			majorService.insert(major);

			model.addAttribute("code", 0);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("add major error ");
			model.addAttribute("code", -6002);
		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/major/{id}", method = RequestMethod.DELETE)
	public String deleteMajorJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("delete major : id= " + id);
		try {
			majorService.delete(id);

			log.info("add major success");
			model.addAttribute("code", 0);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete major error,id is  " + id);
			model.addAttribute("code", -6004);

		}

		return "/data/json";
	}
	
	
	@RequestMapping(value = "/a/multi/major", method = RequestMethod.GET)
	public String getMultiMajorJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Long[] ids)
			throws Exception {
			
		List<Long> idList = new ArrayList();	
	   if (ids == null) {

		} else {
			idList = Arrays.asList(ids);
		}
		try {

			

			List<Major> majorList = majorService.getObjectsByIds(idList);
			log.info("get  major data is " + majorList);

			model.addAttribute("code", 0);			
			model.addAttribute("total",majorList.size());

			model.addAttribute("majorList", majorList);

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get major error,id is  " + idList);
			model.addAttribute("code", -100000);
		}

		return "/college-home-service/major/json/majorListJson";
	}
	
	
	
	
	
}

