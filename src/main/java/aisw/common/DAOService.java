package aisw.common;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import aisw.board.PostDAO;
import aisw.board.PostVO;

@Service
public class DAOService {

	private static DAOService service;
	
	public static DAOService getInstance() {
		         
		if(service == null) {
			service = new DAOService();
		}
		
		return service;
	}

//	protected UserDAO ud;
	protected PostDAO pd;
//	protected InfoDAO bd;
//	protected AccountDAO ad;
//	protected DepositDAO dd;
//	protected TransactionDAO td;
	
	@Autowired
	public DAOService(){
		super();
//		ud = new UserDAO();
		pd = new PostDAO();
//		bd = new InfoDAO();
//		ad = new AccountDAO();
//		dd = new DepositDAO();
//		td = new TransactionDAO();
	}
	/*
	 * PostDAO(게시글)
	 */
	
//	//회원별 QNA 리스트
//	public List<PostVO> getQnaListById(String id) {
//		return pd.getQnaListById(id);
//	}
//	//글쓰기
//	public int writePost(PostVO post) {
//		return pd.writePost(post); 
//	}
	//모든 qna 불러오기
	public List<PostVO> getAllQnas() {
		return pd.getAllQnas();
	}
//	//qna 수정 + 조회수 추가 포함
//	public void modifyPost(PostVO vo) {
//		pd.modifyPost(vo);
//	}
//	//qna 삭제
//	public void deletePost(int no) {
//		pd.deletePost(no);
//	}
//	
}
