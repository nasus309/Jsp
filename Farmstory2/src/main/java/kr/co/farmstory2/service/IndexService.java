package kr.co.farmstory2.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.farmstory2.controller.CommonService;
import kr.co.farmstory2.dao.ArticleDao;
import kr.co.farmstory2.vo.ArticleVo;

public class IndexService implements CommonService {

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		
		Map<String, List<ArticleVo>> map = ArticleDao.getInstance().selectLatests();
		
		req.setAttribute("map", map);
		
		return "/index.jsp";
	}
	
	
}
