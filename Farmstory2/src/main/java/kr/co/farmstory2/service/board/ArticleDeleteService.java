package kr.co.farmstory2.service.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import kr.co.farmstory2.controller.CommonService;
import kr.co.farmstory2.dao.ArticleDao;
import kr.co.farmstory2.vo.ArticleVo;
import kr.co.farmstory2.vo.UserVo;

public class ArticleDeleteService implements CommonService {
	
	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		
		String seq = req.getParameter("seq");
		String group = req.getParameter("group");
		String cate = req.getParameter("cate");
		
		int result = ArticleDao.getInstance().deleteArticle(seq);
		//ArticleDao.getInstance().selectCountArticle(cate);
		
		JsonObject json = new JsonObject();
		json.addProperty("result", result);

		
		return "json:"+new Gson().toJson(json);
	}
}
