<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"  %>

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta property="og:title" content="${ LikeInfo.title}" />
	<meta property="og:site_name" content="${LikeInfo.sitename}" />
	<meta property="og:app_id" content="${LikeInfo.appid}" />
	<meta property="og:url" content="${LikeInfo.url}" />
	<meta property="og:type" content="${LikeInfo.type}" />
	<meta property="og:description" content="${LikeInfo.description}" />
	<meta property="og:image" content="${LikeInfo.image}" />	
	<link href="css/style.css" rel="stylesheet">
	<link href="css/bootstrap.min.css" rel="stylesheet">			
	<script src="js/bootstrap.min.js"></script>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	
	<title>My Facebook Infomation </title>
</head>
<body>
	<div id="fb-root"></div>
	<script>(function(d, s, id) {
	  var js, fjs = d.getElementsByTagName(s)[0];
	  if (d.getElementById(id)) return;
	  js = d.createElement(s); js.id = id;
	  js.src = "//connect.facebook.net/ko_KR/all.js#xfbml=1&appId=${LikeInfo.appid}";
	  fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));</script>
	<jsp:include page="share/header.jsp"></jsp:include>
	<div class="container">
		<h1> Facebook Information </h1>
		<div class="well well-large">
			<h5>Like Button</h5>
			<div class="fb-like" data-href="${LikeInfo.url}" data-send="false" 
			data-width="450" data-show-faces="true" data-font="tahoma"></div>
		</div>
		<hr></hr>
		
		<div class="alert alert-info"> My Facebook Information </div>
		
		<table class="table table-striped table-bordered">
			<tr>
				<td rowspan="8" class="row-align">
					<img src="https://graph.facebook.com/${me.id}/picture?type=large" 
					 class="img-polaroid" />
				</td>
				<td>Name :</td><td>${me.name}</td>
			</tr>			
			<tr>
				<td>User name :</td><td>${me.username}</td>
			</tr>
			<tr>
				<td>Facebook Link :</td><td>${me.link}</td>
			</tr>
			<tr>
				<td>ID :</td><td>${me.id}</td>
			</tr>
			<tr>
				<td>First Name :</td><td>${me.firstname}</td>
			</tr>
			<tr>
				<td>Last Name :</td><td>${me.lastname}</td>
			</tr>
			<tr>
				<td>Gender : </td><td>${me.gender}</td>
			</tr>
			<tr>
				<td>Birth Day :</td><td>${me.birthday}</td>
			</tr>
		</table>
		
	</div>
		
		
	<div class="container">	
			
		<hr></hr>
		<div class="alert alert-info"> My Facebook Friend List </div>
		
		<c:forEach var="listElement" items="${friends}" >
				<table class="table table-striped table-bordered">
					<tr>
						<td rowspan="8" class="row-align">
							<img src="https://graph.facebook.com/${listElement.id}/picture?type=large"  
							class="img-polaroid" />
						</td>
						<td>Name :</td><td>${listElement.name}</td>
					</tr>			
					<tr>
						<td>User name :</td><td>${listElement.username}</td>
					</tr>
					<tr>
						<td>Facebook Link :</td><td>${listElement.link}</td>
					</tr>
					<tr>
						<td>ID :</td><td>${listElement.id}</td>
					</tr>
					<tr>
						<td>First Name :</td><td>${listElement.firstname}</td>
					</tr>
					<tr>
						<td>Last Name :</td><td>${listElement.lastname}</td>
					</tr>
					<tr>
						<td>Gender : </td><td>${listElement.gender}</td>
					</tr>
					<tr>
						<td>Birth Day :</td><td>${listElement.birthday}</td>
					</tr>
				</table>
		</c:forEach>
		
	</div>
	<jsp:include page="share/footer.jsp"></jsp:include>
</body>
</html>
