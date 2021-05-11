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
		String hit = req.getParameter("hit");
		String comment = req.getParameter("comment");
		
		String pg = req.getParameter("pg");
		
		int currentPage = getCurrentPage(pg);
		int start = getLimitStart(currentPage);
		
		ArticleDao dao = ArticleDao.getInstance();
		
		int total = dao.selectCountArticle(cate);
		int listStartNum = getPageStartNum(total, start);
		
		int lastPageNum = getLastPageNum(total);
		int groups[] = getPageGroup(currentPage, lastPageNum);
		
		
		List<ArticleVo> articles = dao.selectArticles(cate, start);
		
		req.setAttribute("articles", articles);
		req.setAttribute("listStartNum", ++listStartNum);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("groups", groups);
		
		
		req.setAttribute("group", group); 
		req.setAttribute("cate", cate); 

		
		return "/board/list.jsp";
	}
	
		// 게시판 리스트 페이지 번호 처리관련 메서드
			public int getPageStartNum(int total, int start) {
				return total - start;
			}
			
			public int[] getPageGroup(int currentPage, int lastPageNum) {
				
				int groupCurrent = (int) Math.ceil(currentPage / 10.0);
				int groupStart   = (groupCurrent - 1) * 10 + 1;
				int groupEnd     = groupCurrent * 10;
				
				if(groupEnd > lastPageNum) {
					groupEnd = lastPageNum;
				}
				
				int[] groups = {groupStart, groupEnd};
				
				return groups;
			}
			
			public int getCurrentPage(String pg) {
				int currentPage = 1;
				
				if(pg != null) {
					currentPage = Integer.parseInt(pg);
				}
				return currentPage;
			}
			
			public int getLimitStart(int currentPage) {
				return (currentPage - 1) * 10;
			}
			
			public int getLastPageNum(int total) {
				
				int lastPageNum = 0;
				
				if(total % 10 == 0) {
					lastPageNum = total / 10;
				}else {
					lastPageNum = total / 10 + 1;
				}
				
				return lastPageNum;
			}
}
