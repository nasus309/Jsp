package kr.co.farmstory2.service.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.farmstory2.controller.CommonService;
import kr.co.farmstory2.dao.UserDao;
import kr.co.farmstory2.vo.UserVo;

public class LoginService implements CommonService {

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		
		if(req.getMethod().equals("POST")) {
			String uid = req.getParameter("uid");
			String pass = req.getParameter("pass");
			
			UserVo vo = UserDao.getInstance().selectUser(uid, pass);
			
			if(vo != null) {
				HttpSession sess = req.getSession();
				sess.setAttribute("suser", vo);
				
				return "redirect:/Farmstory2/";
				
			}else{
				return "redirect:/Farmstory2/user/login.do?result=0";
			}
			
		}else {
		
			return "/user/login.jsp";
		}
	}

}
