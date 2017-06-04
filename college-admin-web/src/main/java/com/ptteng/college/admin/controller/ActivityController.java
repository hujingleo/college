package com.ptteng.college.admin.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ptteng.college.home.model.Manager;
import com.ptteng.college.home.model.Activity;
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
import com.ptteng.college.home.service.ActivityService;
import util.DynamicUtil;

import static com.ptteng.college.home.constant.Constant.SHELEVE_DOWN;
import static com.ptteng.college.home.constant.Constant.SHELEVE_UP;

/**
 * Activity  crud
 *
 * @author magenm
 * @Date 2014-4-16 13:43
 */
@Controller
public class ActivityController {
    private static final Log log = LogFactory.getLog(ActivityController.class);

    @Autowired
    private ActivityService activityService;
    @Autowired
    private com.qding.common.util.http.cookie.CookieUtil cookieUtil;
    @Autowired
    private ManagerService managerService;


    @RequestMapping(value = "/a/u/activity/{id}", method = RequestMethod.GET)
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

        return "/college-admin-service/activity/json/activityDetailJson";
    }

    @RequestMapping(value = "/a/u/activity/search", method = RequestMethod.GET)
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

        return "/college-admin-service/activity/json/activityListJson";
    }

    @RequestMapping(value = "/a/u/activity/{id}", method = RequestMethod.PUT)
    public String updateActivityJson(HttpServletRequest request,
                                    HttpServletResponse response, ModelMap model, @PathVariable Long id, @RequestBody Activity activity) throws Exception {

        log.info("update activity : activity= " + activity);


        if (activity.getTitle() == null) {
            model.addAttribute("code", -6500);
            return "/common/fail";
        }
        if (activity.getContent() == null) {
            model.addAttribute("code", -6501);
            return "/common/fail";
        }

        Activity activitySource = activityService.getObjectById(id);

        try {
            activity.setId(activitySource.getId());
            activity.setStatus(activitySource.getStatus());
            activity.setCreateAt(activitySource.getCreateAt());
            activity.setUpdateAt(System.currentTimeMillis());
                  /* 从cookie中获取userid */
            Long uid = Long.valueOf(cookieUtil.getKeyIdentity(request, com.qding.common.util.http.cookie.CookieUtil.USER_ID));
            activity.setAuthor(activitySource.getAuthor());
            activity.setCreateBy(activitySource.getCreateBy());
            activity.setUpdateBy(uid);
            activityService.update(activity);
            log.info("update success , id is " + id);
            model.addAttribute("code", 0);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("update activity error ");
            model.addAttribute("code", -6504);
        }

        return "/data/json";
    }




    @RequestMapping(value = "/a/u/activity/status", method = RequestMethod.PUT)
    public String updateActivityStatusJson(HttpServletRequest request,
                                          HttpServletResponse response, ModelMap model, Long id, Long status) throws Exception {

        log.info("get id is " + id);
        log.info("get status is " + status);
        if (status == null || status < 0 || status > 1) {
            model.addAttribute("code", -9013);
            return "/data/json";
        }
        try {
            Activity activity = activityService.getObjectById(id);
            activity.setStatus(status);
            log.info("update activity data is " + activity);
            activityService.update(activity);

            model.addAttribute("code", 0);


        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("update status error,activityId is  " + id);
            model.addAttribute("code", -6003);

        }

        return "/data/json";
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

    @RequestMapping(value = "/a/u/activity", method = RequestMethod.POST)
    public String addActivityJson(HttpServletRequest request,
                                  HttpServletResponse response, ModelMap model, @RequestBody Activity activity) throws Exception {

        log.info("insert activity : activity= " + activity);

        if (activity.getTitle() == null) {
            model.addAttribute("code", -6500);
            return "/common/fail";
        }
        if (activity.getContent() == null) {
            model.addAttribute("code", -6501);
            return "/common/fail";
        }
        if (activity.getStatus() == null) {
            model.addAttribute("code", -6502);
            return "/common/fail";
        }
        if (activity.getStatus() != SHELEVE_UP && activity.getStatus() != SHELEVE_DOWN) {
            model.addAttribute("code", -4020);
            return "common/success";
        }
        try {
            activity.setId(null);
            activity.setCreateAt(System.currentTimeMillis());
            activity.setUpdateAt(activity.getCreateAt());
                              /* 从cookie中获取userid */
            Long uid = Long.valueOf(cookieUtil.getKeyIdentity(request, com.qding.common.util.http.cookie.CookieUtil.USER_ID));
            Manager manager = managerService.getObjectById(uid);
            activity.setAuthor(manager.getName());
            activity.setCreateBy(uid);
            activity.setUpdateBy(activity.getCreateBy());
            Long id = activityService.insert(activity);
            log.info("insert success , id is " + id);
            model.addAttribute("code", 0);
            model.addAttribute("id", id);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("add activity error ");
            model.addAttribute("code", -6504);
        }

        return "/common/addsuccess";
    }

    @RequestMapping(value = "/a/u/activity/{id}", method = RequestMethod.DELETE)
    public String deleteActivityJson(HttpServletRequest request,
                                     HttpServletResponse response, ModelMap model, @PathVariable Long id)
            throws Exception {

        log.info("delete activity : id= " + id);
Activity activity = activityService.getObjectById(id);
Long status = activity.getStatus();
log.info("get activity status is "+status);
if (status.equals(SHELEVE_UP)){
    model.addAttribute("code",-6511);
    log.info("上架状态不可删除");
    return "/common/fail";
}
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


    @RequestMapping(value = "/a/multi/activity", method = RequestMethod.GET)
    public String getMultiActivityJson(HttpServletRequest request,
                                       HttpServletResponse response, ModelMap model, Long[] ids)
            throws Exception {

        List<Long> idList = new ArrayList();
        if (ids == null) {

        } else {
            idList = Arrays.asList(ids);
        }
        try {


            List<Activity> activityList = activityService.getObjectsByIds(idList);
            log.info("get  activity data is " + activityList);

            model.addAttribute("code", 0);
            model.addAttribute("total", activityList.size());

            model.addAttribute("activityList", activityList);

        } catch (Throwable t) {
            log.error(t.getMessage());
            log.error("get activity error,id is  " + idList);
            model.addAttribute("code", -100000);
        }

        return "/college-home-service/activity/json/activityListJson";
    }


}

