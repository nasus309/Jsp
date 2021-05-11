package kr.co.farmstory2.service.board;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.farmstory2.controller.CommonService;
import kr.co.farmstory2.dao.ArticleDao;
import kr.co.farmstory2.vo.ArticleVo;

public class WriteService implements CommonService {

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
	
		
		String group = req.getParameter("group");
		String cate = req.getParameter("cate");
		
		if(req.getMethod().equals("POST")) {
			
			
			String path= req.getServletContext().getRealPath("/file");
			int maxSize = 1024 * 1024 * 10; //1kb 1mb 10mb request,����������, ��������ũ��,���ڵ�,new DefaultFileRenamePolicy()
			
			MultipartRequest mRequest = null;
			
			try {
				mRequest = new MultipartRequest(req, path, maxSize, "UTF-8", new DefaultFileRenamePolicy());
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			group = mRequest.getParameter("group");
			cate = mRequest.getParameter("cate");
			String title = mRequest.getParameter("title");
			String content = mRequest.getParameter("content");
			String uid = mRequest.getParameter("uid");
			String file    = mRequest.getFilesystemName("file");
			String regip = req.getRemoteAddr();
			
			ArticleVo vo = new ArticleVo();
			vo.setCate(cate);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setFile(file != null ? 1 : 0);
			vo.setUid(uid);
			vo.setRegip(regip);
			
			int seq = ArticleDao.getInstance().insertArticle(vo);
			
			makeFileNameAndInsert(seq,file,path);
			
			req.setAttribute("group", group);
			req.setAttribute("cate", cate);
			
			return "redirect:/Farmstory2/board/list.do?group="+group+"&cate="+cate;
			
			
		}else {		
			req.setAttribute("group", group);
			req.setAttribute("cate", cate);
			
			return "/board/write.jsp";
			
		}
		
	}
	
	
	public void makeFileNameAndInsert(int seq, String file, String path) {
		
		// ����÷�� ���� Ȯ��
		if(file != null){ //���� ÷�θ� ���� ���
			// ������ ���ϸ� ����
			int i = file.lastIndexOf("."); //�ڿ������� "." �� ã�� index�� ��ȯ
			String ext = file.substring(i); //.���� ������ �ɰ� => Ȯ���ڸ� ����
			
			//universal unique id
			String uuid = UUID.randomUUID().toString();
			String newName = uuid + ext; //knh.Ȯ����
			
			// ����� ���ϸ� ����(��Ʈ��)
			File oldFile = new File(path+"/"+file);
			File newFile = new File(path+"/"+newName);
			oldFile.renameTo(newFile);  //oldFile�� newFile�� �̸��� �ٲ���
		
			// ���� ���̺� INSERT
			ArticleDao.getInstance().insertFile(seq, file, newName);
		}
	}
	
}
