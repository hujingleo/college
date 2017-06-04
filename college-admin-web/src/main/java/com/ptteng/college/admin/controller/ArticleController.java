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

import com.ptteng.college.home.model.Article;
import com.ptteng.college.home.service.ArticleService;
import util.DynamicUtil;

import static com.ptteng.college.home.constant.Constant.SHELEVE_DOWN;
import static com.ptteng.college.home.constant.Constant.SHELEVE_UP;

/**
 * Article  crud
 *
 * @author magenm
 * @Date 2014-4-16 13:43
 */
@Controller
public class ArticleController {
    private static final Log log = LogFactory.getLog(ArticleController.class);

    @Autowired
    private ArticleService articleService;
    @Autowired
    private com.qding.common.util.http.cookie.CookieUtil cookieUtil;
    @Autowired
    private ManagerService managerService;



    @RequestMapping(value = "/a/u/article/{id}", method = RequestMethod.GET)
    public String getArticleJson(HttpServletRequest request,
                                 HttpServletResponse response, ModelMap model, @PathVariable Long id)
            throws Exception {

        log.info("get data : id= " + id);
        try {
            Article article = articleService.getObjectById(id);
            log.info("get article data is " + article);

            model.addAttribute("code", 0);

            model.addAttribute("article", article);

        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get article error,id is  " + id);
            model.addAttribute("code", -100000);
        }

        return "/college-admin-service/article/json/articleDetailJson";
    }


    @RequestMapping(value = "/a/u/article/search", method = RequestMethod.GET)
    public String getarticleListJson(HttpServletRequest request,
                                     HttpServletResponse response, ModelMap model, String title, String author, Long startAt,
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
            Map<String, Object> param = DynamicUtil.getArticleList(title, author, startAt, endAt, status);
            log.info("get param data is  " + param);
            idsList = articleService.getIdsByDynamicCondition(Article.class, param, start, size);
            List<Article> articleList = articleService.getObjectsByIds(idsList);
            Integer total = idsList.size();
            model.addAttribute("code", 0);
            model.addAttribute("articleList", articleList);
            model.addAttribute("total", total);
            model.addAttribute("size", size);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get articleList error,id is  " + idsList);
            model.addAttribute("code", -100000);
        }

        return "/college-admin-service/article/json/articleListJson";
    }


    @RequestMapping(value = "/a/u/article/status", method = RequestMethod.PUT)
    public String updateArticleStatusJson(HttpServletRequest request,
                                          HttpServletResponse response, ModelMap model, Long id, Long status) throws Exception {

        log.info("get id is " + id);
        log.info("get status is " + status);
        if (status == null || status < 0 || status > 1) {
            model.addAttribute("code", -9013);
            return "/data/json";
        }
        try {
            Article article = articleService.getObjectById(id);
            article.setStatus(status);
            log.info("update article data is " + article);
            articleService.update(article);

            model.addAttribute("code", 0);


        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("update status error,articleId is  " + id);
            model.addAttribute("code", -6003);

        }

        return "/data/json";
    }


    @RequestMapping(value = "/a/u/article/{id}", method = RequestMethod.PUT)
    public String updateArticleJson(HttpServletRequest request,
                                     HttpServletResponse response, ModelMap model, @PathVariable Long id, @RequestBody Article article) throws Exception {

        log.info("update article : article= " + article);


        if (article.getTitle() == null) {
            model.addAttribute("code", -6500);
            return "/common/fail";
        }
        if (article.getContent() == null) {
            model.addAttribute("code", -6501);
            return "/common/fail";
        }

        Article articleSource = articleService.getObjectById(id);

        try {
            article.setId(articleSource.getId());
            article.setRank(articleSource.getRank());
            article.setStatus(articleSource.getStatus());
            article.setCreateAt(articleSource.getCreateAt());
            article.setUpdateAt(System.currentTimeMillis());
                  /* 从cookie中获取userid */
            Long uid = Long.valueOf(cookieUtil.getKeyIdentity(request, com.qding.common.util.http.cookie.CookieUtil.USER_ID));
            article.setAuthor(articleSource.getAuthor());
            article.setCreateBy(articleSource.getCreateBy());
            article.setUpdateBy(uid);
            articleService.update(article);
            log.info("update success , id is " + id);
            model.addAttribute("code", 0);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("update article error ");
            model.addAttribute("code", -6504);
        }

        return "/data/json";
    }

    @RequestMapping(value = "/a/u/article", method = RequestMethod.POST)
    public String addarticleJson(HttpServletRequest request,
                                 HttpServletResponse response, ModelMap model, @RequestBody Article article) throws Exception {

        log.info("inser article : article= " + article);
        Map<String, Object> param = DynamicUtil.countArticleNum();
        List<Long> list = articleService.getIdsByDynamicCondition(Article.class,param,0,Integer.MAX_VALUE);
        Long count = list.get(0);
        log.info("get count is "+ count);
        if (count >= 8){
            log.info("上架内容达到上限");
            model.addAttribute("code",-6505);
            return "/common/fail";
        }
        if (article.getTitle() == null) {
            model.addAttribute("code", -6500);
            return "/common/fail";
        }
        if (article.getContent() == null) {
            model.addAttribute("code", -6501);
            return "/common/fail";
        }
        if (article.getStatus() == null) {
            model.addAttribute("code", -6502);
            return "/common/fail";
        }
        if (article.getStatus() != SHELEVE_UP && article.getStatus() != SHELEVE_DOWN) {
            model.addAttribute("code", -4020);
            return "common/success";
        }


        try {
            article.setId(null);
            article.setRank(0l);
            article.setCreateAt(System.currentTimeMillis());
            article.setUpdateAt(article.getCreateAt());
                  /* 从cookie中获取userid */
            Long uid = Long.valueOf(cookieUtil.getKeyIdentity(request, com.qding.common.util.http.cookie.CookieUtil.USER_ID));
            Manager manager = managerService.getObjectById(uid);
            article.setAuthor(manager.getName());
            article.setCreateBy(uid);
            article.setUpdateBy(article.getCreateBy());
            Long id = articleService.insert(article);
            log.info("insert success , id is " + id);
            model.addAttribute("code", 0);
            model.addAttribute("id", id);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("add article error ");
            model.addAttribute("code", -6504);
        }

        return "/common/addsuccess";
    }


    @RequestMapping(value = "/a/u/article/rank", method = RequestMethod.PUT)
    public String addArticleRankJson(HttpServletRequest request,
                                     HttpServletResponse response, ModelMap model,@RequestBody Long[] rank
    ) throws Exception {

        log.info("get rank is  " + rank);
        try {
            List<Long> list = Arrays.asList(rank);
            List<Article> articleList = articleService.getObjectsByIds(list);
            for (Article article:articleList){
                Long id = article.getId();
                article.setRank(Long.valueOf(list.indexOf(id)));
            }
            articleService.updateList(articleList);
            model.addAttribute("code",0);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("add article error ");
            model.addAttribute("code", -1);
        }

        return "/data/json";
    }




    @RequestMapping(value = "/a/u/article/{id}", method = RequestMethod.DELETE)
    public String deleteArticleJson(HttpServletRequest request,
                                    HttpServletResponse response, ModelMap model, @PathVariable Long id)
            throws Exception {

        log.info("delete article : id= " + id);
        Article article = articleService.getObjectById(id);
        Long status = article.getStatus();
        log.info("get artcle status is + "+status);
        if (status.equals(SHELEVE_UP)) {
            model.addAttribute("code", -6511);
            log.info("上架状态不可删除");
            return "/common/fail";
        }
        try {
            articleService.delete(id);

            log.info("detele article success");
            model.addAttribute("code", 0);

        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("delete article error,id is  " + id);
            model.addAttribute("code", -6004);

        }

        return "/data/json";
    }




}

