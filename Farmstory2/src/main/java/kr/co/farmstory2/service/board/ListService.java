package kr.co.farmstory2.service.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.farmstory2.controller.CommonService;
import kr.co.farmstory2.dao.ArticleDao;
import kr.co.farmstory2.vo.ArticleVo;

public class ListService implements CommonService{

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		
		String group = req.getParameter("group");
		String cate = req.getParameter("cate");
		
		List<ArticleVo> articles = ArticleDao.getInstance().selectArticles(cate);
		
		req.setAttribute("group", group); //view에서 참조하기 위해
		req.setAttribute("cate", cate); 
		req.setAttribute("articles", articles);
		
		return "/board/list.jsp";
	}
}
