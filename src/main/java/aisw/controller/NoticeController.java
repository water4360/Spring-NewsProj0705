package aisw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import aisw.board.PostDAO;
import aisw.board.PostVO;

@Controller
public class NoticeController {

	@Autowired
	private PostDAO dao;

	//뉴스목록
	@RequestMapping("/news")
	public String getAllQnas(Model model) throws Exception {

		List<PostVO> postList = dao.getAllQnas();
		model.addAttribute("news", postList);
		return "news";
	}
	
	//뉴스상세보기
	@RequestMapping("/news-details")
	public String getPost(@RequestParam("p_no") Integer no, Model model) throws Exception {
		PostVO post = dao.getPost(no);
		model.addAttribute("news", post);
		
		return "news-details";
	}

	//뉴스 작성페이지
	@RequestMapping("/write-news")
	public String write() throws Exception {
		return "write-news";
	}
	
	//뉴스 등록페이지
	@PostMapping("/add-news")
	public String add(@ModelAttribute PostVO vo, Model model) throws Exception {
		dao.write(vo);
		return "redirect:/news";
	}
	
	
	
}
