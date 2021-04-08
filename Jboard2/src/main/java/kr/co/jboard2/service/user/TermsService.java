package kr.co.jboard2.service.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jboard2.dao.UserDao;
import kr.co.jboard2.service.CommonService;
import kr.co.jboard2.vo.TermsVo;

public class TermsService implements CommonService {
	
	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		/* Controller가 Service에서 받아온 view를 forward. */
		
		TermsVo vo;
		try {
			vo = UserDao.getInstance().selectTerms();
			
			//View에서 vo 객체를 참조하기 위해 Controller-Service-View에서 공유되는 requset 객체를 이용
			req.setAttribute("vo", vo);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// 1,2단계
		// 3단계
		// 4단계
		// 5단계
		// 6단계
		
		return "/user/terms.jsp";
	}
	
}
