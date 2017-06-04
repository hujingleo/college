package com.ptteng.college.home.controller;

import com.ptteng.college.home.model.*;
import com.ptteng.college.home.service.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import util.DynamicUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hujin on 2017/5/30.
 */
@Controller
public class SearchController {
    private static final Log log = LogFactory.getLog(SearchController.class);

    @Autowired
    private ActivityService activityService;
    @Autowired
    private ExchangeService exchangeService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private AdmissionEmploymentService admissionEmploymentService;
    @Autowired
    private GraduateService graduateService;
    @Autowired
    private InternshipService internshipService;
    @Autowired
    private MajorService majorService;


    @RequestMapping(value = "/a/global/search", method = RequestMethod.GET)
    public String getDataListJson(HttpServletRequest request,
                                  HttpServletResponse response, ModelMap model, String words, Integer page, Integer size)
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
        List<Long> exchangeIdsList = null;
        List<Long> teacherIdsList = null;
        List<Long> graduateIdsList = null;
        List<Long> internshipIdsList = null;
        List<Long> majorIdsList = null;
        List<Long> adminssionEmploymentIdsList = null;
        List<Long> activityIdsList = null;
        Integer total = 0;
        Integer total1 = null;
        Integer total2 = null;
        Integer total3 = null;
        Integer total4 = null;
        Integer total5 = null;
        Integer total6 = null;
        Integer total7 = null;
        List<HashMap<String, Object>> dataList = new ArrayList<HashMap<String, Object>>();
        try {
            Map<String, Object> param1 = DynamicUtil.searchExchangeList(words);
            exchangeIdsList = exchangeService.getIdsByDynamicCondition(Exchange.class, param1, start, Integer.MAX_VALUE);
            total1 = exchangeIdsList.size();
            if (null != total1){
                total =total + total1;
            }
            List<Exchange> exchangeList = exchangeService.getObjectsByIds(exchangeIdsList);
            log.info("get exchangeIdsList is " + exchangeIdsList);
            model.addAttribute("exchangeList", exchangeList);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get List error,id is  " + exchangeIdsList);
            model.addAttribute("code", -100000);
        }
        try {
            Map<String, Object> param2 = DynamicUtil.searchTeacherList(words);
            teacherIdsList = teacherService.getIdsByDynamicCondition(Teacher.class, param2, start, Integer.MAX_VALUE);
            total2 = teacherIdsList.size();
            if (null != total2){
                total = total +total2;
            }
            List<Teacher> teacherList = teacherService.getObjectsByIds(teacherIdsList);
            log.info("get teacherIdsList is " + teacherIdsList);
            model.addAttribute("teacherList", teacherList);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get List error,id is  " + teacherIdsList);
            model.addAttribute("code", -100000);
        }
        try {
            Map<String, Object> param3 = DynamicUtil.searchGraduateList(words);
            graduateIdsList = graduateService.getIdsByDynamicCondition(Graduate.class, param3, start, Integer.MAX_VALUE);
            total3 = graduateIdsList.size();
            if (null != total3){
                total = total +total3;
            }
            List<Graduate> graduateList = graduateService.getObjectsByIds(graduateIdsList);
            log.info("get graduateIdsList is " + graduateIdsList);
            model.addAttribute("graduateList", graduateList);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get List error,id is  " + graduateIdsList);
            model.addAttribute("code", -100000);
        }
        try {
            Map<String, Object> param4 = DynamicUtil.searchInternshipList(words);
            internshipIdsList = internshipService.getIdsByDynamicCondition(Internship.class, param4, start, Integer.MAX_VALUE);
            total4 = internshipIdsList.size();
            if (null != total4){
                total = total +total4;
            }
            List<Internship> internshipList = internshipService.getObjectsByIds(internshipIdsList);
            log.info("get internshipIdsList is " + internshipIdsList);
            model.addAttribute("internshipList", internshipList);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get List error,id is  " + internshipIdsList);
            model.addAttribute("code", -100000);
        }
        try {
            Map<String, Object> param5 = DynamicUtil.searchMajorList(words);
            majorIdsList = majorService.getIdsByDynamicCondition(Major.class, param5, start, Integer.MAX_VALUE);
            total5 = majorIdsList.size();
            if (null != total5){
                total = total +total5;
            }
            List<Major> majorList = majorService.getObjectsByIds(majorIdsList);
            log.info("get majorIdsList is " + majorIdsList);
            model.addAttribute("majorList", majorList);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get List error,id is  " + majorIdsList);
            model.addAttribute("code", -100000);
        }
        try {
            Map<String, Object> param6 = DynamicUtil.searchAdmissionEmploymentList(words);
            adminssionEmploymentIdsList = teacherService.getIdsByDynamicCondition(Teacher.class, param6, start, Integer.MAX_VALUE);
            total6 = adminssionEmploymentIdsList.size();
            if (null != total6){
                total = total +total6;
            }
            List<AdmissionEmployment> admissionEmploymentList = admissionEmploymentService.getObjectsByIds(adminssionEmploymentIdsList);
            log.info("get adminssionEmploymentIdsList is " + adminssionEmploymentIdsList);
            model.addAttribute("admissionEmploymentList", admissionEmploymentList);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get List error,id is  " + adminssionEmploymentIdsList);
            model.addAttribute("code", -100000);
        }
        try {
            Map<String, Object> param7 = DynamicUtil.searchActivityList(words);
            activityIdsList = activityService.getIdsByDynamicCondition(Activity.class, param7, start, Integer.MAX_VALUE);
            total7 = activityIdsList.size();
            if (null != total7){
                total = total +total7;
            }
            List<Activity> activityList = activityService.getObjectsByIds(activityIdsList);
            log.info("get activityIdsList is " + activityIdsList);
            model.addAttribute("activityList", activityList);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get List error,id is  " + activityIdsList);
            model.addAttribute("code", -100000);
        }

        model.addAttribute("code", 0);
        model.addAttribute("size", size);
        model.addAttribute("total", total);

        return "/college-home-service/search/json/searchListJson";


    }
}