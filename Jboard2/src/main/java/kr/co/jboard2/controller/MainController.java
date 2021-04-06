package kr.co.jboard2.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jboard2.service.CommonService;

public class MainController extends HttpServlet{

	private static final long serialVersionUID = 1L; // 식별??
	private Map<String, Object> instances = new HashMap<>(); // 서비스객체들을 미리 저장? 요청이오면 객체를 바로 실행...(요청오면 객체 만드는게 아니라)
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// 컨트롤러가 최초 실행될 때 실행되는 초기화 메서드
		
		// 프로퍼티 파일 (액션주소 맵핑 파일) 경로 구하기
		ServletContext ctx = config.getServletContext();
		String path = ctx.getRealPath("/WEB-INF")+"/urlMapping.properties";
		
		// 프로퍼티 파일 입력 스트림 연결
		Properties prop = new Properties(); //hash map과 동일한 객체???
		
		try {
			FileInputStream fis = new FileInputStream(path);
			prop.load(fis);
			fis.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		// 포로퍼티 객체 생성 및 Service 객체 생성 후 보관
		
		Iterator iter = prop.keySet().iterator();
		
		while(iter.hasNext()) {
			String k = iter.next().toString();
			String v = prop.getProperty(k);
			
			try {
				Class obj = Class.forName(v);
				Object instance = obj.newInstance();
				
				instances.put(k, instance);
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
			
		super.init();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestProc(req, resp); // req : 클라이언트에서 요청하는 요청객체, resp :
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestProc(req, resp);
	}
	
	public void requestProc(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {
		
		// 요청 주소에서 service 객체 key 구하기
		String path = req.getContextPath();
		String uri = req.getRequestURI();
		String key = uri.substring(path.length());
		
		// service 객체 map에서 꺼내기
		CommonService instance = (CommonService)instances.get(key); // 다형성 : interface(CommonService)로 형변환
		
		// service 객체 실행후 view 리턴 받기
		String view = instance.requestProc(req, resp);
		
		// View 포워드
		RequestDispatcher dispatcher = req.getRequestDispatcher(view);
		dispatcher.forward(req,resp);
		
		
	}
	
	
}
