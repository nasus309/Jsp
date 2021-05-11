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
		List<ArticleVo> notices = ArticleDao.getInstance().selectNotice();
		List<ArticleVo> qnas = ArticleDao.getInstance().selectQna();
		List<ArticleVo> faqs = ArticleDao.getInstance().selectFaq();
		
		req.setAttribute("map", map);
		req.setAttribute("notices", notices);
		req.setAttribute("qnas", qnas);
		req.setAttribute("faqs", faqs);
		
		return "/index.jsp";
	}
	
	
}
