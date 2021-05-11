package kr.co.farmstory2.service.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.farmstory2.controller.CommonService;
import kr.co.farmstory2.dao.ArticleDao;
import kr.co.farmstory2.vo.UserVo;

public class CommentDeleteService implements CommonService {

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		
		String seq = req.getParameter("seq");
		String comment_seq = req.getParameter("comment_seq");
		
		ArticleDao.getInstance().deleteComment(comment_seq);
		ArticleDao.getInstance().updateArticleCommentDec(seq);
		
		
		return "/board/view.jsp";
	}

}
