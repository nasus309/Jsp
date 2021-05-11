<%@ page contentType="text/xml;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@page import="org.jdom2.output.Format"%>
<%@page import="org.jdom2.output.XMLOutputter"%>
<%@page import="org.jdom2.Element"%>
<%@page import="org.jdom2.Document"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.List"%>
<%@page import="sub1.MemberBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%
	// 데이터베이스 처리 1~6단계
	String host = "jdbc:mysql://15.164.230.250:3306/knh";
	String user = "knh";
	String pass ="960222";
	
	// 1단계 - JDBC 드라이버 로드
	Class.forName("com.mysql.jdbc.Driver");
	// 2단계 - 데이터베이스 접속
	Connection conn = DriverManager.getConnection(host, user, pass);
	
	// 3단계 - SQL 실행 객체 생성
	Statement stmt = conn.createStatement(); 
	
	//4단계 - SQL 실행
	String sql = "SELECT * FROM `MEMBER`;";
	ResultSet rs = stmt.executeQuery(sql);
	
	// 5단계 - 결과셋 처리(Select일 경우)
	List<MemberBean> mbList = new ArrayList<>();
	
	while(rs.next()){
		MemberBean mb = new MemberBean();
		
		mb.setUid(rs.getString(1));
		mb.setName(rs.getString(2));
		mb.setHp(rs.getString(3));
		mb.setPos(rs.getString(4));
		mb.setDep(rs.getInt(5));
		mb.setRdate(rs.getString(6));
		
		mbList.add(mb);
	}
	
	// 6단계 - 데이터베이스 종료
	rs.close();
	stmt.close();
	conn.close();
	
	//XML 데이터 생성(JDOM 라이브러리 사용)
	Document doc = new Document(); //doc가 xml 문서
	Element members = new Element("members");
	
	//12번...?데이터 수만큼
	for(MemberBean mb : mbList){
		// 빈 태그 만들기
		Element member = new Element("member");
		Element uid = new Element("uid");
		Element name = new Element("name");
		Element hp = new Element("hp");
		Element pos = new Element("pos");
		Element dep = new Element("dep");
		Element rdate = new Element("rdate");
		
		// 태그 내용 넣어주기
		uid.setText(mb.getUid());
		name.setText(mb.getName());
		hp.setText(mb.getHp());
		pos.setText(mb.getPos());
		dep.setText(""+mb.getDep());
		rdate.setText(mb.getRdate());
		
		//개별 태그들을 <member></member> 안에 집어 넣기
		member.addContent(uid);
		member.addContent(name);
		member.addContent(hp);
		member.addContent(pos);
		member.addContent(dep);
		member.addContent(rdate);
		
		// member태그를 members에 넣기
		members.addContent(member);
	}
	
	doc.setRootElement(members);
	
	// XML 출력
	XMLOutputter outPutter = new XMLOutputter(Format.getPrettyFormat());
	String xml = outPutter.outputString(doc);
	
	out.print(xml);
	
%> 


