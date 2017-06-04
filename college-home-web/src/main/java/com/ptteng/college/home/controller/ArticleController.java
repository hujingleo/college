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

import com.ptteng.college.home.model.Article;
import com.ptteng.college.home.service.ArticleService;
import util.DynamicUtil;

/**
 * Article  crud
 * 
 * @author magenm
 * @Date 2014-4-16 13:43
 * 
 */
@Controller
public class ArticleController {
	private static final Log log = LogFactory.getLog(ArticleController.class);

	@Autowired
	private ArticleService articleService;
	@RequestMapping(value = "/a/article/search", method = RequestMethod.GET)
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

		return "/college-home-service/article/json/articleListJson";
	}

	
	
	    
	

	@RequestMapping(value = "/a/article/{id}", method = RequestMethod.GET)
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

		return "/college-home-service/article/json/articleDetailJson";
	}

	@RequestMapping(value = "/a/article/{id}", method = RequestMethod.PUT)
	public String updateArticleJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Article article) throws Exception {
		
		log.info("update article : article= " + article);
		
		try {
			
			articleService.update(article);

			model.addAttribute("code", 0);

			model.addAttribute("article", article);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("update article error,id is  " + article.getId());
			model.addAttribute("code", -6003);

		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/article", method = RequestMethod.POST)
	public String addArticleJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Article article) throws Exception {
		
		log.info("update article : article= " + article);
		
		try { 
			article.setId(null);

			articleService.insert(article);

			model.addAttribute("code", 0);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("add article error ");
			model.addAttribute("code", -6002);
		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/article/{id}", method = RequestMethod.DELETE)
	public String deleteArticleJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("delete article : id= " + id);
		try {
			articleService.delete(id);

			log.info("add article success");
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

