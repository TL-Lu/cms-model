<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>文章详情</title>
<script type="text/javascript" src="<%=path%>/webResources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="<%=path%>/webResources/My97DatePicker/WdatePicker.js"></script>
<%-- <link href="<%=path%>/webResources/css/index3.css"  rel="stylesheet"> --%>
<link href="<%=path%>/webResources/bootstrap-4.3.1-dist/css/bootstrap.css"  rel="stylesheet">
<script type="text/javascript" src="<%=path %>/webResources/bootstrap-4.3.1-dist/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=path %>/webResources/validate/jquery.validate.js"></script>
</head>
<body>
	
	<nav class="navbar navbar-expand-lg navbar-light bg-light navbar navbar-dark bg-dark" style=" position:sticky; position:-webkit-sticky;top:0px;z-index: 999;hight: 70px">		
		  	<a class="navbar-brand" href="#">首页</a>
		  	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
		   			 <span class="navbar-toggler-icon"></span>
		 	 </button>
			  <div class="collapse navbar-collapse" id="navbarNavDropdown">
				    <ul class="navbar-nav">
					      <li class="nav-item active">
					        	<a class="nav-link" href="#">test<span class="sr-only">(current)</span></a>
					      </li>
					      <li class="nav-item">
					       	 	<a class="nav-link" href="#">Features</a>
					      </li>
					      <li class="nav-item">
					       		 <a class="nav-link" href="#">Pricing</a>
					      </li>
					      <li class="nav-item dropdown">
						        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						          Dropdown link
						        </a>
						        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
						          <a class="dropdown-item" href="#">Action</a>
						          <a class="dropdown-item" href="#">Another action</a>
						          <a class="dropdown-item" href="#">Something else here</a>
						        </div>
					      </li>
				    </ul>
			  </div>
		 			<ul class="row" style="margin-right: 30px;">
		 				<li class="nav-link" style="height: 30px"><img alt="" src="/webResources/img/1.jpg" width="30px;" height="30ps;"></li>
		 				<li class="nav-link" style="height: 30px"><span style="color: white;">用户：${user.userName }</span></li>
		 				<li class="nav-link" style="height: 30px;">
										
								<div class="btn-group">
								  <button class="btn btn-secondary btn-sm dropdown-toggle" type="button"   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								    Small button
								  </button>
								  <div class="dropdown-menu">
								    ...
								  </div>
								</div>
						</li>
		 			</ul>
		</nav>

	
	
	
	<div class="container">
		<div class="row justify-content-center" >
			<h3>${article.title}</h3>
		</div>
		<div class="row justify-content-center">
			<h5>
			作者：${article.user.userName} &nbsp;&nbsp;&nbsp;
			栏目：${article.channel.name}  &nbsp;&nbsp;&nbsp;
			分类：${article.category.name}&nbsp;&nbsp;&nbsp;
			发表时间：<fmt:formatDate value="${article.created}" pattern="yyyy-MM-dd"/> 
			</h5>
			<a href="/channel/complain.do?id=${article.id }" style="margin-left: 20px;">投诉</a>
		</div>
		<div style="margin-top:30px">
			${article.content}
		</div>
		<div>
			<nav aria-label="...">
					  <ul class="pagination">
					    <li class="page-item ">
					      <a class="page-link" href="/home/detail?id=${artile.id-1<0?'1':'artile.id-1' }" tabindex="-1" >上一篇</a>
					    </li>	
					    <li class="page-item">
					      <a class="page-link" href="/home/detail?id=${artile.id+1}">下一篇</a>
					    </li>
					  </ul>
			</nav>
		</div>
	</div>
		
	<!-- 发布评论 -->
	<div style="margin-left:400px;margin-top: 10px;">
		<div >
			<textarea rows="5" cols="160" id="commentText">
				
			</textarea>
			<input type="button" style="margin-top: -30px;" class="btn btn-outline-dark" onclick="addComment()" value="发表评论">
		</div>
		<div id="comment" style="width: 1145px;">
			
		</div>
	</div>
	
				<div class="" style="width: 300px auto;height: 100px;margin-top: 30px">
	  					
	  				</div>
	
	<script type="text/javascript">
	
		function gopage(page){
			showComment(page)
		}
		function showComment(page){
			$("#comment").load("/channel/comments.do?id=${article.id }&currentPage="+page);
		}
		
		$(document).ready(function(){
			// 显示第一页的评论
			showComment(1)
		})
		
		function addComment(){
			
			 $.post("/channel/addComment.do",{articleId:'${article.id}',content:$("#commentText").val()},function(msg){
					if(msg.core==1){
						alert("评论成功")
						$("#commentText").empty()
						location.reload();
					}else{
						alert(msg.message)
					}
				},"json") 
		}
	</script>
</body>
</html>