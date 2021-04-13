package kr.co.farmstory2.service.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import kr.co.farmstory2.controller.CommonService;
import kr.co.farmstory2.dao.UserDao;

public class CheckUidService implements CommonService{

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		
		String uid = req.getParameter("uid");
		
		int count = UserDao.getInstance().selectUserCount(uid);
		
		JsonObject json = new JsonObject();
		json.addProperty("result", count);
		
		return "json:"+json.toString();
	}

}
