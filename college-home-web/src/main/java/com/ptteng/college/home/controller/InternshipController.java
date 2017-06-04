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

import com.ptteng.college.home.model.Internship;
import com.ptteng.college.home.service.InternshipService;

/**
 * Internship  crud
 * 
 * @author magenm
 * @Date 2014-4-16 13:43
 * 
 */
@Controller
public class InternshipController {
	private static final Log log = LogFactory.getLog(InternshipController.class);

	@Autowired
	private InternshipService internshipService;






    /**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */

	@RequestMapping(value = "/c/internship", method = RequestMethod.GET)
	public String getinternshipList(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {

		
		
		log.info("/internship  to /internship/view/internshipList");

		return "/college-home-service/internship/view/internshipList";
	}
    
    

    
	
	@RequestMapping(value = "/c/internship/{id}", method = RequestMethod.GET)
	public String getInternship(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("/internship/" + id + "  to /internship/view/internshipDeail");
		if(null != id){
			model.addAttribute("id", id);
		}else{
			model.addAttribute("id", 0);
		}

		return "/college-home-service/internship/view/internshipDetail";
	}
	
	
	
	    
	

	@RequestMapping(value = "/a/internship/{id}", method = RequestMethod.GET)
	public String getInternshipJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("get data : id= " + id);
		try {
			Internship internship = internshipService.getObjectById(id);
			log.info("get internship data is " + internship);

			model.addAttribute("code", 0);

			model.addAttribute("internship", internship);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get internship error,id is  " + id);
			model.addAttribute("code", -100000);
		}

		return "/college-home-service/internship/json/internshipDetailJson";
	}

	@RequestMapping(value = "/a/internship/{id}", method = RequestMethod.PUT)
	public String updateInternshipJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Internship internship) throws Exception {
		
		log.info("update internship : internship= " + internship);
		
		try {
			
			internshipService.update(internship);

			model.addAttribute("code", 0);

			model.addAttribute("internship", internship);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("update internship error,id is  " + internship.getId());
			model.addAttribute("code", -6003);

		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/internship", method = RequestMethod.POST)
	public String addInternshipJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Internship internship) throws Exception {
		
		log.info("update internship : internship= " + internship);
		
		try { 
			internship.setId(null);

			internshipService.insert(internship);

			model.addAttribute("code", 0);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("add internship error ");
			model.addAttribute("code", -6002);
		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/internship/{id}", method = RequestMethod.DELETE)
	public String deleteInternshipJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("delete internship : id= " + id);
		try {
			internshipService.delete(id);

			log.info("add internship success");
			model.addAttribute("code", 0);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete internship error,id is  " + id);
			model.addAttribute("code", -6004);

		}

		return "/data/json";
	}
	
	
	@RequestMapping(value = "/a/multi/internship", method = RequestMethod.GET)
	public String getMultiInternshipJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Long[] ids)
			throws Exception {
			
		List<Long> idList = new ArrayList();	
	   if (ids == null) {

		} else {
			idList = Arrays.asList(ids);
		}
		try {

			

			List<Internship> internshipList = internshipService.getObjectsByIds(idList);
			log.info("get  internship data is " + internshipList);

			model.addAttribute("code", 0);			
			model.addAttribute("total",internshipList.size());

			model.addAttribute("internshipList", internshipList);

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get internship error,id is  " + idList);
			model.addAttribute("code", -100000);
		}

		return "/college-home-service/internship/json/internshipListJson";
	}
	
	
	
	
	
}

