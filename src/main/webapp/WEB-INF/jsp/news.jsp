<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HB하리은행 - e뉴스</title>
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<header>
		<%-- 상단고정 --%>
		<jsp:include page="/WEB-INF/jsp/main/topper.jsp"></jsp:include>
	</header>
	<section>
	

<div class="container mt-5" align="center">
			<div>
				<h2>지금 이시각 금융뉴스</h2>
			</div>
			<div class="btn-group">
			
			
				<form action="write-news" method="post">
					<button type="submit" class="btn btn-secondary">작성하기</button>
				</form>
			</div>
			<div class="row justify-content-center">
				<div class="col-md-11">
					<table class="table table-hover">
						<thead>
							<tr>
								<th class="col-md-1 narrow-column">번호</th>
								<th class="col-md-6">제목</th>
								<th class="col-md-1 narrow-column">글쓴이</th>
								<th class="col-md-1 narrow-column">작성일</th>
								<th class="col-md-1 narrow-column">조회</th>
							</tr>
						</thead>
						<%-- 테이블 내용 --%>
						<tbody>
							<c:choose>
								<c:when test="${ empty news }">
									<td colspan="5" align="center" style="padding: 50px 0;">등록된 포스트가
										없습니다.</td>
								</c:when>

								<c:otherwise>
									<c:forEach var="post" items="${news}">
										<tr>
											<td class="post-no">${post.p_no}</td>
											<td class="post-title"><a
												href="news-details?p_no=${post.p_no}">${post.p_title}</a></td>
											<td class="post-writer">${post.p_writer}</td>
											<td class="post-regdate">${post.p_reg_Date}</td>
											<td class="post-viewcnt">${post.p_hit}</td>
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</tbody>
					</table>
				</div>
			</div>
		</div>


	</section>

	<footer>
		<%-- 하단고정 --%>
		<jsp:include page="/WEB-INF/jsp/main/footer.jsp"></jsp:include>
	</footer>
</body>
</html>