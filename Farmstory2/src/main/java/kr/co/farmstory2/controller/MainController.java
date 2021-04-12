package kr.co.farmstory2.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
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

import kr.co.farmstory2.vo.FileVo;


public class MainController extends HttpServlet{

	private static final long serialVersionUID = 1L; // 식별??
	private Map<String, Object> instances = new HashMap<>(); // 서비스객체들을 미리 저장? 요청이오면 객체를 바로 실행...(요청오면 객체 만드는게 아니라)
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// 컨트롤러가 최초 실행될 때 실행되는 초기화 메서드
		
		// 프로퍼티 파일 (액션주소 맵핑 파일) 경로 구하기
		ServletContext ctx = config.getServletContext();
		String path = ctx.getRealPath("/WEB-INF") + "/urlMapping.properties";  /* getRealPath("/") 는 webappp을 의미 */
		
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
		
		//System.out.println("요청들어옴1");	
		
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
		String result = instance.requestProc(req, resp); //result는 문자열("redirect:/Jboard2/user/login.do")
		
		if(result.startsWith("redirect:")) { //result가 리다이렉트 명령이라면
			//리다이렉트
			String redirectUrl = result.substring(9); // "/Jboard2/user/login.do"
			resp.sendRedirect(redirectUrl);
			
		}else if(result.startsWith("json:")) {
			// Json 출력
			PrintWriter out = resp.getWriter();
			out.print(result.substring(5)); //json:json.toString() 중 json.toString()
			
		}else if(result.startsWith("file:")) {
			
			String fname = result.substring(5);
			
			FileVo vo = (FileVo) req.getAttribute("fileVo");
			
			// 파일 다운로드 response 헤더수정
			resp.setContentType("application/octet-stream");
			resp.setHeader("Content-Disposition", "attachment; filename="+URLEncoder.encode(fname, "utf-8"));
			resp.setHeader("Content-Transfer-Encoding", "binary");
			resp.setHeader("Pragma", "no-cache");
			resp.setHeader("Cache-Control", "private");
			
			// 파일 데이터 스트림 작업
			String filePath = req.getServletContext().getRealPath("/file");
			File file = new File(filePath+"/"+vo.getNewName());
			
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
			BufferedOutputStream bos = new BufferedOutputStream(resp.getOutputStream());
			
			while(true) {
				int data = bis.read();
				
				if(data == -1) {
					break;
				}
				bos.write(data);
			}
			
			bos.close();
			bis.close();
			
		}else {
			// View 포워드
			RequestDispatcher dispatcher = req.getRequestDispatcher(result);
			dispatcher.forward(req,resp);
		}
		
	}
	
	
}
