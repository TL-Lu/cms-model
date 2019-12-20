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
<title>个人中心</title>
<script type="text/javascript" src="<%=path%>/webResources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="<%=path%>/webResources/My97DatePicker/WdatePicker.js"></script>
<%-- <link href="<%=path%>/webResources/css/index3.css"  rel="stylesheet"> --%>
<link href="<%=path%>/webResources/bootstrap-4.3.1-dist/css/bootstrap.css"  rel="stylesheet">
<script type="text/javascript" src="<%=path %>/webResources/bootstrap-4.3.1-dist/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=path %>/webResources/validate/jquery.validate.js"></script>

<link rel="stylesheet" href="<%=path %>/webResources/kindeditor/themes/default/default.css" />
	<link rel="stylesheet" href="<%=path %>/webResources/kindeditor/plugins/code/prettify.css" />
	<script charset="utf-8" src="<%=path %>/webResources/kindeditor/plugins/code/prettify.js"></script>
	<script charset="utf-8" src="<%=path %>/webResources/kindeditor/kindeditor-all.js"></script>
    <script charset="utf-8" src="<%=path %>/webResources/kindeditor/lang/zh-CN.js"></script>
</head>
<style>
    *{margin: 0;padding: 0;}
    .div-inline{ 
    position:relative;
    display:inline-block;
    margin-left: 25px;
    }
    .wh{
   		width: 286px;
   		height: 202px;
   		margin-top: 10px;
   	}
</style>
<body>
	<!-- 导航栏 -->
	
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
		 				
		 					<c:choose>
		 					<c:when test="${user.userName!=''&&user.userName!=null}">
		 						<li class="nav-link" style="height: 30px"><span style="color: white;">用户：${user.userName }</span></li>
		 						
		 					</c:when>
		 					<c:otherwise>
		 							<li class="nav-link" style="height: 30px"><span style="color: white;"><button onclick="script:location='/user/toLogin.do'" type="button" class="btn btn-info" style="margin-top: -5px;">登录</button></span></li>
		 					</c:otherwise>
		 					</c:choose>
		 				<li class="nav-link" style="height: 30px;">
										
								<div class="btn-group" style="margin-right: 30px;">
								  <button class="btn btn-secondary btn-sm dropdown-toggle" type="button"   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								   Setting
								  </button>
								  <div class="dropdown-menu">
								   		 <a class="dropdown-item" href="/user/logout.do">登出</a>
								  </div>
								</div>
						</li>
		 			</ul>
		 			
		</nav>
		
			<!-- 巨幕 -->
		<div class="jumbotron jumbotron-fluid">
			  <div class="container">
			    <h1 class="display-1">CMS</h1>
			    <p class="lead">This is a modified jumbotron that occupies the entire horizontal space of its parent.</p>
			  </div>
		</div>
					
					<!-- 卡片 -->
					<div >
					<div class="card div-inline wh" style="width: 18rem;;">
						  <div class="card-body">
								    <h5 class="card-title">进入主页</h5>
								    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
								    <a href="/channel/goHome.do?id=${user.id }" class="btn btn-primary">Let's Go</a>
								  </div>
						</div>
						<div class="card div-inline wh" style="width: 18rem;;">
						  <div class="card-body">
								    <h5 class="card-title">Card title</h5>
								    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
								    <a href="#" class="btn btn-primary">Go somewhere</a>
								  </div>
						</div>
						<div class="card div-inline wh" style="width: 18rem;;">
						  <div class="card-body">
								    <h5 class="card-title">Card title</h5>
								    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
								    <a href="#" class="btn btn-primary">Go somewhere</a>
								  </div>
						</div>
						<div class="card div-inline wh" style="width: 18rem;;">
						  <div class="card-body">
								    <h5 class="card-title">Card title</h5>
								    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
								    <a href="#" class="btn btn-primary">Go somewhere</a>
								  </div>
						</div>
						<div class="card div-inline wh " style="width: 18rem;">
						  <div class="card-body">
								    <h5 class="card-title">Card title</h5>
								    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
								    <a href="#" class="btn btn-primary">Go somewhere</a>
								  </div>
						</div>
						<div class="card div-inline " style="width: 18rem;;">
						  <div class="card-body">
								    <h5 class="card-title">Card title</h5>
								    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
								    <a href="#" class="btn btn-primary">Go somewhere</a>
								  </div>
						</div>
					</div>
					
					
					<!-- 左侧导航栏 -->
					<div class="row" style="margin: 30px 10px;width: 300px auto; ">
						  <div class="col-1" style="border-right: 20px;border-right-color: black;border-right-width: 2px;border-right-style:dotted;height: 620px;">
							    <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical" style="margin-top: 50px;">
							      <a class="nav-link active" id="v-pills-home-tab" data-toggle="pill" href="#v-pills-home" role="tab" aria-controls="v-pills-home" aria-selected="true" onclick="allArticle()">文章管理</a>
							      <a class="nav-link" id="v-pills-profile-tab" data-toggle="pill" href="#v-pills-profile" role="tab" aria-controls="v-pills-profile" aria-selected="false">评论管理</a>
							      <a class="nav-link" id="v-pills-messages-tab" data-toggle="pill" href="#v-pills-messages" role="tab" aria-controls="v-pills-messages" aria-selected="false" onclick="toAddArticle()">链接管理</a>
							      <a class="nav-link" id="v-pills-settings-tab" data-toggle="pill" href="#v-pills-settings" role="tab" aria-controls="v-pills-settings" aria-selected="false">用户管理</a>
						    </div>
						  </div>
						    <div class="col-10">
						      <div class="tab-content" id="content" style="margin-left: 30px;width: 1500px;">
						      		
						      </div>
						      </div>
						  
					</div>
					
					
					
					
					
					
					
					<div class="bg-dark" style="width: 300px auto;height: 100px;margin-top: 30px">
	  					
	  				</div>
</body>
<script type="text/javascript">

	 KindEditor.ready(function(K) {
			window.editor1 = K.create();
			prettyPrint();
		});

	$("#content").load("/channel/findAllArticle.do");
	
	function allArticle(){
		var id='${user.id}'
		$("#content").load("/channel/findAllArticle.do");
	}
	
	
	function del(id){
		if(!confirm("确定删除吗?")){
			return;
		}
		$.post('/channel/delArticle.do',{id:id},function(result){
				if(result){
					alert("删除成功")
					location.reload();
				}else{
					alert("删除失败")
				}
		})
	}
	function upd(id){
		$("#content").load("/channel/toUpdateArticle.do?id="+id);
	}
	
	function toAddArticle(){
		$("#content").load("/channel/toAddArticle.do");
	}

</script>
</html>