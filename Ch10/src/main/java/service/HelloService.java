package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// ���� Ŭ������ ������ ������ �����ִ� ���� ����
public class HelloService implements CommonService {

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return "/hello.jsp"; //view�� ����. ��Ʈ�ѷ��� ���ϰ��� �޾Ƽ� forward
	}
	
	
	
}
