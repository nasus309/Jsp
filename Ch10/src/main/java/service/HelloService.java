package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 서비스 클래스들 끼리의 구조를 맞춰주는 것이 좋음
public class HelloService implements CommonService {

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return "/hello.jsp"; //view를 리턴. 컨트롤러가 리턴값을 받아서 forward
	}
	
	
	
}
