package kr.co.farmstory2.service.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import kr.co.farmstory2.controller.CommonService;
import kr.co.farmstory2.dao.ArticleDao;
import kr.co.farmstory2.vo.ArticleVo;
import kr.co.farmstory2.vo.UserVo;

public class ViewService implements CommonService {
	
	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		
		String seq = req.getParameter("seq");
		HttpSession sess = req.getSession();
		UserVo user = (UserVo)sess.getAttribute("suser");
		String uid = user.getUid();
		String comment = req.getParameter("comment");
		String regip = req.getRemoteAddr();
		
		
		
		if (req.getMethod().equals("POST") && comment!=null) {
			
			ArticleDao.getInstance().insertComment(seq, comment, uid, regip);
			ArticleDao.getInstance().updateArticleCommentInc(seq);

		}
	
		
		String group = req.getParameter("group");
		String cate = req.getParameter("cate");
		

		
		ArticleVo vo = ArticleDao.getInstance().selectArticle(seq);
		List<ArticleVo> comments = ArticleDao.getInstance().selectComments(seq);
		
		ArticleDao.getInstance().updateArticelHit(seq);
		
		
		
		req.setAttribute("group", group);
		req.setAttribute("cate", cate);
		req.setAttribute("vo", vo);
		req.setAttribute("comments", comments);
		
		return "/board/view.jsp";
	}
}
