package kr.co.jboard2.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jboard2.dao.ArticleDao;

public class CommentService implements CommonService {

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		
		if(req.getMethod().equals("POST")) {
			// 댓글 입력
			
			String parent = req.getParameter("parent");
			String comment = req.getParameter("comment");
			String uid = req.getParameter("uid");
			String regip = req.getRemoteAddr();
			
			ArticleDao dao = ArticleDao.getInstance();
			dao.insertComment(parent, comment, uid, regip);
			dao.updateArticleCommentInc(parent);
			
			return "redirect:/Jboard2/view.do?seq="+parent;
			
		}else {
			// 댓글 조회
			return null;
		}
	}

}
