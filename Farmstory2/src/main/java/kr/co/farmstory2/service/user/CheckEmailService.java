package kr.co.farmstory2.service.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import kr.co.farmstory2.controller.CommonService;
import kr.co.farmstory2.dao.UserDao;

public class CheckEmailService implements CommonService{

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		
		String email = req.getParameter("email");
		
		int count = UserDao.getInstance().selectEmailCount(email);
		
		JsonObject json = new JsonObject();
		json.addProperty("result", count);
		
		return "json:"+json.toString();
	}

}
