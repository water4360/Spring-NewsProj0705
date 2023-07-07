package aisw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aisw.board.PostDAO;
import aisw.board.PostVO;

@CrossOrigin(origins = "*") // 혹은 @CrossOrigin(origins = "*")를 사용하여 모든 도메인을 허용
@RestController
public class NewsAPIController {

	@Autowired
	private PostDAO dao;
	
	////////////////////API
	//GET /boardListTo
	// 뉴스목록API
	@GetMapping("/api/news")
	public List<PostVO> getNewsList() {
		List<PostVO> postList = dao.getAllQnas();
		
		if(postList.size()!=0) {
			System.out.println("목록 불러오기 완료");
		} else {
			System.out.println("목록이 없음");
		}
		return postList;
	}
	
	
	//GET /boardListTo/3
	// 뉴스상세API
	@GetMapping("/api/news/{p_no}")
	public PostVO getPost(@PathVariable("p_no") Integer p_no) {
		PostVO post = dao.getPost(p_no);
		
		dao.increaseHitCnt(p_no);
		
		if(post!=null) {
			System.out.printf("%d번 게시글 조회\n", p_no);
		} else {
			System.out.printf("%d번 게시글 없음\n", p_no);
		}
		
		return post;
	}
	
	//뉴스등록
	@PostMapping("/api/news")
	public void write(PostVO vo) {
		if(dao.write(vo)==1) {
			System.out.println("뉴스 등록 완료");
		} else {
			System.out.println("뉴스 등록 실패");
		}
	}
	
	
	
	
	
	//뉴스수정
	@PostMapping("/api/news/{p_no}")
	public void update(PostVO vo, @PathVariable("p_no") Integer p_no) {

		if(dao.update(vo)==1) {
			System.out.println("업데이트 완료");
		} else {
			System.out.println("업데이트 실패");
		}
	}
	
	
	
	//뉴스삭제
	@DeleteMapping("/api/news/{p_no}")
	public void delete(@PathVariable("p_no") Integer p_no) {
		if(dao.delete(p_no)==1) {
			System.out.println("삭제 완료");
		} else {
			System.out.println("삭제 실패");
		}
		
	}
	
	
	
}
