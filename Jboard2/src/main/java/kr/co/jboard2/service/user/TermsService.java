package kr.co.jboard2.service.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jboard2.dao.UserDao;
import kr.co.jboard2.service.CommonService;
import kr.co.jboard2.vo.TermsVo;

public class TermsService implements CommonService {
	
	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		/* Controller�� Service���� �޾ƿ� view�� forward. */
		
		TermsVo vo;
		try {
			vo = UserDao.getInstance().selectTerms();
			
			//View���� vo ��ü�� �����ϱ� ���� Controller-Service-View���� �����Ǵ� requset ��ü�� �̿�
			req.setAttribute("vo", vo);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// 1,2�ܰ�
		// 3�ܰ�
		// 4�ܰ�
		// 5�ܰ�
		// 6�ܰ�
		
		return "/user/terms.jsp";
	}
	
}
