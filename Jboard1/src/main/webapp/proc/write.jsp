<%@page import="java.io.File"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="kr.co.jboard1.dao.ArticleDao"%>
<%@page import="kr.co.jboard1.bean.ArticleBean"%>
<%@page import="kr.co.jboard1.bean.UserBean"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="kr.co.jboard1.config.DBConfig"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 전송 데이터 인코딩
	request.setCharacterEncoding("UTF-8");

	// 전송 데이터 수신
	String path= request.getServletContext().getRealPath("/file");
	int maxSize = 1024 * 1024 * 10; //1kb 1mb 10mb request,파일저장경로, 파일저장크기,인코딩,new DefaultFileRenamePolicy()
	MultipartRequest mRequest = new MultipartRequest(request,
													path, 
													maxSize,
													"UTF-8", 
													new DefaultFileRenamePolicy());
	
	String title = mRequest.getParameter("title");	
	String content = mRequest.getParameter("content");
	String file = mRequest.getFilesystemName("file");
	String regip = request.getRemoteAddr();
	
	/* String title = request.getParameter("title");	
	String content = request.getParameter("content");
	String regip = request.getRemoteAddr(); */
	
	// 세션 사용자 정보객체 가져오기
	UserBean user = (UserBean)session.getAttribute("suser");
	String uid = user.getUid();
	
	// 데이터베이스 처리
	ArticleBean article = new ArticleBean();
	article.setTitle(title);
	article.setContent(content);
	//article.setUid(user.getUid()); 왜 두줄로 바꼈지 ~~~~?
	article.setFile(file != null ? 1 : 0);
	article.setUid(uid);
	article.setRegip(regip);
	
	int seq = ArticleDao.getInstance().insertArticle(article);
	
	// 파일첨부 여부 확인
	if(file != null){ //파일 첨부를 했을 경우
		// 고유한 파일명 생성
		int i = file.lastIndexOf("."); //뒤에서부터 "." 를 찾아 index를 반환
		String ext = file.substring(i); //.부터 끝까지 쪼갬 => 확장자를 구함
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss_");
		String now = sdf.format(new Date()); // 현재 시간 ex)210401154123_
		
		String newName = now+uid+ext; //210401154123_knh.확장자
		
		// 저장된 파일명 수정(스트림)
		File oldFile = new File(path+"/"+file);
		File newFile = new File(path+"/"+newName);
		oldFile.renameTo(newFile);  //oldFile을 newFile로 이름을 바꿔줌
	
		// 파일 테이블 INSERT
		ArticleDao.getInstance().insertFile(seq, file, newName);
	}
	
	
	// 데이터베이스 처리 1~6단계
	/*
	// 1,2단계
	Connection conn = DBConfig.getInstance().getConnection();
	
	// 3단계
	String sql  = "INSERT INTO `JBOARD_ARTICLE` SET ";
		   sql += "`title`=?,";
		   sql += "`content`=?,";
		   sql += "`uid`=?,";
		   sql += "`regip`=?,";
		   sql += "`rdate`=NOW();";
	
	PreparedStatement psmt = conn.prepareStatement(sql);
	
	psmt.setString(1, title);
	psmt.setString(2, content);
	psmt.setString(3, user.getUid());
	psmt.setString(4, regip);
	
	// 4단계
	psmt.executeUpdate();
	
	// 5단계
	// 6단계
	psmt.close();
	conn.close();
	
	articledao로 ~
	*/
	
	/* ArticleBean article = new ArticleBean();
	article.setTitle(title);
	article.setContent(content);
	article.setUid(user.getUid());
	article.setRegip(regip);
	
	ArticleDao.getInstance().insertArticle(article); */
	
	
	// 게시판 목록 리다이렉트
	response.sendRedirect("/Jboard1/list.jsp");
%>