package kr.co.jboard2.service.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import kr.co.jboard2.dao.UserDao;
import kr.co.jboard2.service.CommonService;

public class CheckUidService implements CommonService {
	
	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		
		String uid = req.getParameter("uid");
		
		int count = 0;
		
		try {
			count = UserDao.getInstance().selectCountUser(uid);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		// Json 데이터 생성
		JsonObject json = new JsonObject();
		json.addProperty("result", count);
		
		return "json:"+json.toString(); // 제이슨 데이터를 문자열로
		
		// controller 로 json 데이터 형태의 result를 return
	}

		
}
