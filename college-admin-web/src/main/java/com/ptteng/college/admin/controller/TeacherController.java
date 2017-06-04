package com.ptteng.college.admin.controller;


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

import com.ptteng.college.home.model.Teacher;
import com.ptteng.college.home.service.TeacherService;
import util.DynamicUtil;

import static com.ptteng.college.home.constant.Constant.SHELEVE_DOWN;
import static com.ptteng.college.home.constant.Constant.SHELEVE_UP;
import static com.ptteng.college.home.constant.Constant.TEAM;

/**
 *
 */
@Controller
public class TeacherController {
    private static final Log log = LogFactory.getLog(TeacherController.class);

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private com.qding.common.util.http.cookie.CookieUtil cookieUtil;
    @Autowired
    private ManagerService managerService;


    @RequestMapping(value = "/a/u/teacher/{id}", method = RequestMethod.GET)
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

        return "/college-admin-service/teacher/json/teacherDetailJson";
    }


    @RequestMapping(value = "/a/u/teacher/search", method = RequestMethod.GET)
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

        return "/college-admin-service/teacher/json/teacherListJson";
    }


    @RequestMapping(value = "/a/u/teacher/status", method = RequestMethod.PUT)
    public String updateTeacherStatusJson(HttpServletRequest request,
                                          HttpServletResponse response, ModelMap model, Long id, Long status) throws Exception {

        log.info("get id is " + id);
        log.info("get status is " + status);
        if (status == null || status < 0 || status > 1) {
            model.addAttribute("code", -9013);
            return "/data/json";
        }
        try {
            Teacher teacher = teacherService.getObjectById(id);
            teacher.setStatus(status);
            log.info("update teacher data is " + teacher);
            teacherService.update(teacher);

            model.addAttribute("code", 0);


        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("update status error,teacherId is  " + id);
            model.addAttribute("code", -6003);

        }

        return "/data/json";
    }


    @RequestMapping(value = "/a/u/teacher/{id}", method = RequestMethod.PUT)
    public String updateTeacherJson(HttpServletRequest request,
                                    HttpServletResponse response, ModelMap model, @PathVariable Long id, @RequestBody Teacher teacher) throws Exception {

        log.info("update teacher : teacher= " + teacher);


        if (teacher.getTitle() == null) {
            model.addAttribute("code", -6500);
            return "/common/fail";
        }
        if (teacher.getContent() == null) {
            model.addAttribute("code", -6501);
            return "/common/fail";
        }
        if (teacher.getCategory() == null) {
            model.addAttribute("code", -6503);
            return "/common/fail";
        }
        Teacher teacherSource = teacherService.getObjectById(id);

        try {
            teacher.setId(teacherSource.getId());
            teacher.setRank(teacherSource.getRank());
            teacher.setStatus(teacherSource.getStatus());
            teacher.setCreateAt(teacherSource.getCreateAt());
            teacher.setUpdateAt(System.currentTimeMillis());
                  /* 从cookie中获取userid */
            Long uid = Long.valueOf(cookieUtil.getKeyIdentity(request, com.qding.common.util.http.cookie.CookieUtil.USER_ID));
            teacher.setAuthor(teacherSource.getAuthor());
            teacher.setCreateBy(teacherSource.getCreateBy());
            teacher.setUpdateBy(uid);
            teacherService.update(teacher);
            log.info("update success , id is " + id);
            model.addAttribute("code", 0);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("update teacher error ");
            model.addAttribute("code", -6504);
        }

        return "/data/json";
    }

    @RequestMapping(value = "/a/u/teacher", method = RequestMethod.POST)
    public String addTeacherJson(HttpServletRequest request,
                                 HttpServletResponse response, ModelMap model, @RequestBody Teacher teacher) throws Exception {

        log.info("inser teacher : teacher= " + teacher);

        if (teacher.getTitle() == null) {
            model.addAttribute("code", -6500);
            return "/common/fail";
        }
        if (teacher.getContent() == null) {
            model.addAttribute("code", -6501);
            return "/common/fail";
        }
        if (teacher.getStatus() == null) {
            model.addAttribute("code", -6502);
            return "/common/fail";
        }
        if (teacher.getStatus() != SHELEVE_UP && teacher.getStatus() != SHELEVE_DOWN) {
            model.addAttribute("code", -4020);
            return "common/success";
        }
        if (teacher.getCategory() == null) {
            model.addAttribute("code", -6503);
            return "/common/fail";
        }


        try {
            teacher.setId(null);
            teacher.setRank(0l);
            teacher.setCreateAt(System.currentTimeMillis());
            teacher.setUpdateAt(teacher.getCreateAt());
                  /* 从cookie中获取userid */
            Long uid = Long.valueOf(cookieUtil.getKeyIdentity(request, com.qding.common.util.http.cookie.CookieUtil.USER_ID));
            Manager manager = managerService.getObjectById(uid);
            teacher.setAuthor(manager.getName());
            teacher.setCreateBy(uid);
            teacher.setUpdateBy(teacher.getCreateBy());
            Long id = teacherService.insert(teacher);
            log.info("insert success , id is " + id);
            model.addAttribute("code", 0);
            model.addAttribute("id", id);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("add teacher error ");
            model.addAttribute("code", -6504);
        }

        return "/common/addsuccess";
    }


    @RequestMapping(value = "/a/u/teacher/rank", method = RequestMethod.POST)
    public String addTeacherRankJson(HttpServletRequest request,
                                     HttpServletResponse response, ModelMap model, @RequestBody Long[] rank
    ) throws Exception {

        log.info("get rank is  " + rank);
        try {
            List<Long> list = Arrays.asList(rank);
            List<Teacher> teacherList = teacherService.getObjectsByIds(list);
            for (Teacher teacher : teacherList) {
                Long id = teacher.getId();
                teacher.setRank(Long.valueOf(list.indexOf(id)));
            }
            teacherService.updateList(teacherList);
            model.addAttribute("code", 0);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("add teacher error ");
            model.addAttribute("code", -1);
        }

        return "/data/json";
    }


    @RequestMapping(value = "/a/u/teacher/{id}", method = RequestMethod.DELETE)
    public String deleteTeacherJson(HttpServletRequest request,
                                    HttpServletResponse response, ModelMap model, @PathVariable Long id)
            throws Exception {

        log.info("delete teacher : id= " + id);
        Teacher teacher = teacherService.getObjectById(id);
        Long status = teacher.getStatus();
        Long category = teacher.getCategory();
        log.info("get teacher status is " + status);
        if (status.equals(SHELEVE_UP)) {
            model.addAttribute("code", -6511);
            log.info("上架状态不可删除");
            return "/common/fail";
        }
        if (category.equals(TEAM)) {
            model.addAttribute("code", -6512);
            log.info("团队简介状态不可删除");
            return "/common/fail";
        }
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


}

