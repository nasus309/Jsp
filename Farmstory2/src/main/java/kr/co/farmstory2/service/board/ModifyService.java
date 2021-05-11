package kr.co.farmstory2.service.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.farmstory2.controller.CommonService;
import kr.co.farmstory2.dao.ArticleDao;
import kr.co.farmstory2.vo.ArticleVo;

public class ModifyService implements CommonService {

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		
		String group = req.getParameter("group");
		String cate = req.getParameter("cate");
		String seq = req.getParameter("seq");
	
	
		req.setAttribute("group", group);
		req.setAttribute("cate", cate);
		req.setAttribute("seq", seq);
		
		ArticleVo vo = ArticleDao.getInstance().selectArticle(seq);
		req.setAttribute("vo", vo);
		
		if (req.getMethod().equals("POST")) {
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			req.setAttribute("title", title);
			req.setAttribute("content", content);
			ArticleDao.getInstance().updateArticle(title, content, seq);
			
			
			return "redirect:/Farmstory2/board/view.do?group="+group+"&cate="+cate+"&seq="+seq;
		}

		
		
		return "/board/modify.jsp";
	}

}
