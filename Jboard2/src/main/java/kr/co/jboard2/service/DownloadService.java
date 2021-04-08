package kr.co.jboard2.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jboard2.dao.ArticleDao;
import kr.co.jboard2.vo.FileVo;

public class DownloadService implements CommonService {

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		
		String seq = req.getParameter("seq"); // 파일번호
		
		ArticleDao dao = ArticleDao.getInstance();
		
		// 파일 정보 SELECT
		FileVo vo = dao.selectFile(seq);
		
		// 파일 다운로드 횟수 1증감
		dao.updateFileDownload(seq);
		
		// Controller에서 참여하기 위해 공유
		req.setAttribute("fileVo", vo);
		
		return "file:"+vo.getOldName(); //파일다운로드이름바꿔주기?
	}

}
