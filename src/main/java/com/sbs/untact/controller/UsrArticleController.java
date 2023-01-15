package com.sbs.untact.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbs.untact.dto.Article;
import com.sbs.untact.dto.ResultData;
import com.sbs.untact.service.ArticleService;
import com.sbs.untact.util.Util;

@Controller
public class UsrArticleController {

	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/usr/article/detail")
	@ResponseBody
	public Article showDetail(int id) {
		Article article = articleService.getArticle(id);
		return article;
	}
	
	@RequestMapping("/usr/article/list")
	@ResponseBody
	public List<Article> showList() {
		return articleService.getArticles();
	}
	
	@RequestMapping("/usr/article/doAdd")
	@ResponseBody
	public ResultData doAdd(String title, String body) {
		if(title != null) {
			return new ResultData("F-1","title을 입력해주세요.");
		}
		
		if(body != null) {
			return new ResultData("F-1","body를 입력해주세요.");
		}
		
		return articleService.add(title, body);
	}

	@RequestMapping("/usr/article/doDelete")
	@ResponseBody
	public ResultData doDelete(int id) {
		Article article = articleService.getArticle(id);
		
		if(article == null) {
			return new ResultData("F-1","해당 게시물은 존재하지 않습니다.");
		}
		
		return articleService.deleteArticle(id);			
	}
	
	@RequestMapping("/usr/article/doModify")
	@ResponseBody
	public ResultData doModify(int id, String title, String body) {
		Article selArticle = null;
		
		for(Article article : articles) {
			if(article.getId() == id) {
				selArticle = article;
				break;
			}
		}
		
		if(selArticle == null) {
			return new ResultData("F-1", String.format("%d번 게시물은 존재하지 않습니다.", id));
		} 
		
		selArticle.setUpdateDate(Util.getNowDateStr());
		selArticle.setTitle(title);
		selArticle.setBody(body);
		
		return new ResultData( "S-1", String.format("%d번 게시물이 수정되었습니다.", id),"id", id);
		
	}
		
	
	
	
	
	
	
}
