package aisw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import aisw.board.PostDAO;
import aisw.board.PostVO;

@Controller
public class NewsController {

	@Autowired
	private PostDAO dao;
	
	//////////////////////기본 컨트롤러
	// 뉴스목록
	@RequestMapping("/news-list")
	public String getAllQnas(Model model) throws Exception {
		List<PostVO> postList = dao.getAllQnas();
		model.addAttribute("news", postList);
		return "news";
	}

	// 뉴스상세보기
	@GetMapping("/news-details")
	public String news(Integer p_no, Model model) throws Exception {
		PostVO post = dao.getPost(p_no);
		model.addAttribute("news", post);
		return "news-details";
	}

	// 뉴스 작성
	@RequestMapping("/write-news")
	public String write() throws Exception {
		return "write-news";
	}

	// 뉴스 등록
	@PostMapping("/add-news")
	public String add(@ModelAttribute PostVO vo, Model model) throws Exception {
		System.out.println(vo);
		dao.write(vo);
		return "redirect:/news";
	}

	// 뉴스 삭제
	@RequestMapping("/delete-news")
	public String delete(Integer p_no, Model model){
		dao.delete(p_no);
		return "redirect:/news";
	}
}
