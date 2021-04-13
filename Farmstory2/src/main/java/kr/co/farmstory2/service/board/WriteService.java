package kr.co.farmstory2.service.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.farmstory2.controller.CommonService;
import kr.co.farmstory2.dao.ArticleDao;
import kr.co.farmstory2.vo.ArticleVo;

public class WriteService implements CommonService {

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		
		String group = req.getParameter("group");
		String cate = req.getParameter("cate");
		
		if(req.getMethod().equals("POST")) {
			
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String uid = req.getParameter("uid");
			String regip = req.getRemoteAddr();
			
			ArticleVo vo = new ArticleVo();
			vo.setCate(cate);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setUid(uid);
			vo.setRegip(regip);
			
			ArticleDao.getInstance().insertArticle(vo);
			
			return "redirect:/Farmstory2/board/list.do?group="+group+"&cate="+cate;
			
			
		}else {		
			req.setAttribute("group", group);
			req.setAttribute("cate", cate);
			
			return "/board/write.jsp";
			
		}
		

		
	}
}
