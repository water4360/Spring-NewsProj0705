package aisw.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class PostDAO {

	@Autowired
	private DataSource dataSource;

	//////////////////////////////////
	// 모든 Q&A 리스트
	public List<PostVO> getAllQnas() {
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT * FROM NEWS_BOARD ORDER BY P_NO DESC ");
		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(dataSource);

		List<PostVO> postList = template.query(sql.toString(), new BeanPropertyRowMapper<>(PostVO.class));
		return postList;

	}

	// Q&A 상세보기?
	public PostVO getPost(Integer no) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM NEWS_BOARD WHERE P_NO = ? ");

		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(dataSource);

		PostVO post = template.queryForObject(sql.toString(), new BeanPropertyRowMapper<>(PostVO.class), no);

//		modifyPost(post);
		return post;
	}

	////// 조회수 올리기
	public int increaseHitCnt(Integer no) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE NEWS_BOARD SET P_HIT = P_HIT+1 WHERE P_NO = ? ");

		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(dataSource);

		int result = template.update(sql.toString(), no);
		return result;
	}

	////////// Q&A 업데이트
	public int update(PostVO post) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE NEWS_BOARD SET P_TITLE = ?, P_CONTENTS = ? WHERE P_NO = ? ");

		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(dataSource);

		int result = template.update(sql.toString(), post.getP_title(), post.getP_contents(), post.getP_no());
		return result;
	}

	///////// 뉴스 등록
	public int write(PostVO post) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO NEWS_BOARD(P_NO, P_WRITER, P_TITLE, P_CONTENTS) ");
		sql.append("	 VALUES(SEQ_NOTICE_NO.NEXTVAL, ?, ?, ?) ");

		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(dataSource);
		int result = template.update(sql.toString(), post.getP_writer(), post.getP_title(), post.getP_contents());
		return result;
	}

	// 뉴스 삭제
	public int delete(int no) {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE NEWS_BOARD WHERE P_NO = ? ");

		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(dataSource);
		int result = template.update(sql.toString(), no);

		return result;
	}


}
