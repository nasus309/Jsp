package kr.co.jboard2.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.jboard2.dao.ArticleDao;
import kr.co.jboard2.dao.UserDao;
import kr.co.jboard2.vo.ArticleVo;
import kr.co.jboard2.vo.UserVo;

public class ViewService implements CommonService {

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		
		
		String seq = req.getParameter("seq");
		
		ArticleVo ab = ArticleDao.getInstance().selectArticle(seq); 
		req.setAttribute("ab", ab);
			
		
		return "/view.jsp";
	}	
	
}
