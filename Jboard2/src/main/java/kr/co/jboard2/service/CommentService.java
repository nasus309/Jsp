package kr.co.jboard2.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jboard2.dao.ArticleDao;
import kr.co.jboard2.vo.ArticleVo;

public class CommentService implements CommonService {

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		
		String parent = req.getParameter("parent");
		String comment = req.getParameter("comment");
		String uid = req.getParameter("uid");
		String regip = req.getRemoteAddr();
		
		ArticleDao dao = ArticleDao.getInstance();
		dao.insertComment(parent, comment, uid, regip);
		dao.updateArticleCommentInc(parent);
		
		/*
		 * ArticleVo ab = ArticleDao.getInstance().selectComments(parent);
		 * req.setAttribute("ab", ab);
		 */
		
		return "redirect:/Jboard2/view.do?seq="+parent;
			
	}

}
