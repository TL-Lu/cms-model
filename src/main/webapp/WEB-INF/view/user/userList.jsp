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
<title>首页</title>
<script type="text/javascript" src="<%=path%>/webResources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="<%=path%>/webResources/My97DatePicker/WdatePicker.js"></script>
<%-- <link href="<%=path%>/webResources/css/index3.css"  rel="stylesheet"> --%>
<link href="<%=path%>/webResources/bootstrap-4.3.1-dist/css/bootstrap.css"  rel="stylesheet">
<script type="text/javascript" src="<%=path %>/webResources/bootstrap-4.3.1-dist/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=path %>/webResources/validate/jquery.validate.js"></script>
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
					        	<a class="nav-link" href="#">test <span class="sr-only">(current)</span></a>
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
								    <h5 class="card-title">个人中心</h5>						<!-- 前往个人中心 -->
								    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
								    <a href="${user.userName==null?'javascript:alert(\'请登录\')':'/user/getAUser.do?userName=${user.userName }' }"  class="btn btn-primary">Let's Go</a>
								  </div>
						</div>
						<div class="card div-inline wh" style="width: 18rem;;">
						  <div class="card-body">
								    <h5 class="card-title">管理中心</h5>
								    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
								    <a  href="#"  class="btn btn-primary disable"  onclick="goRoot('${user.userName}','${user.passWord }')">Let's Go</a>
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
	<div class="row ">
		  <div class="col-1 " style="border-right: 20px;border-right-color: black;border-right-width: 2px;border-right-style:dotted;margin-top: 30px;height: 820px;margin-left: 25px;;">
			    <div class="nav flex-column nav-pills " id="v-pills-tab" role="tablist" aria-orientation="vertical" style="margin-top: 20px;">
			    		<a class="nav-link active"  style="text-align: center;" id="v-pills-hot-tab" data-toggle="pill" href="#v-pills-hot" role="tab" aria-controls="v-pills-hot" aria-selected="false" onclick="getHot()">推荐</a>
			    	<c:forEach items="${list }" var="channel">
									<a class="nav-link"  style="text-align: center;"  id="v-pills-${channel.name }-tab" data-toggle="pill" href="#v-pills-${channel.name }" role="tab" aria-controls="v-pills-${channel.name }" aria-selected="false" onclick="category(${channel.id})">${channel.name }</a>
			    	</c:forEach>
			    </div>
		  </div>
		  <div class="col-10">
			    <div class="tab-content" id="v-pills-tabContent">
			    		<div class="tab-pane fade show active" id="v-pills-hot" role="tabpanel" aria-labelledby="v-pills-hot-tab" style="margin-top:30px;width: 800px;height: 620px;">
				     				<!-- 内部导航栏 -->
				     				<nav>
									  <div class="nav nav-tabs uu uu2" id="nav-tab" role="tablist"  >
									    
									  </div>
									</nav>
				     					</div>
			    		<c:forEach items="${list }" var="channel">
				    					  <div class="tab-pane fade show " id="v-pills-${channel.name }" role="tabpanel" aria-labelledby="v-pills-${channel.name }-tab" style="margin-top:30px;width: 700px;height: 620px;">
							     				<!-- 内部导航栏 -->
							     						<nav>
															  <div class="nav nav-tabs uu" id="nav-tab" role="tablist">
															  </div>
														</nav>
					     				</div>
			     		</c:forEach>
			     		
			     		<div class="tab-content" id="content" style="width: 800px;;height: 580px;margin-top: -580px;'">

						</div>
						
						
			    </div>
			    <!-- 最新文章 -->
			    <div class="card" style="height:295px;  width: 42rem;margin-top: -615px;margin-left:1000px;">
						  <h5 class="card-header">最新消息</h5>
						<ul class="list-group">
							<c:forEach items="${newArticles }" var="article" varStatus="i">
								  <li class="list-group-item d-flex justify-content-between align-items-center ex">
												 		<a href="" target="_blank" style="margin-left: 10px;">${i.index+1 }. ${article.title }</a>
								  </li>
							</c:forEach>
						</ul>

					</div>
					
					
					
						<!-- 公告 -->					
					<div class="card" style="height:300px;  width: 42rem;margin-top: 115px;margin-left:1000px;">
						  <h5 class="card-header">公告</h5>
						<ul class="list-group">
									
						
						</ul>
					</div>
					
					
					
					
		  </div>
	</div>
	

	
			  			<div class="bg-dark" style="width: 300px auto;height: 100px;margin-top: 30px;">
	  					
	  				</div>
</body>
<script type="text/javascript">
 $.post("<%=path %>/channel/category.do",{id:1},function(arr){
	  $("#content").load("/channel/getHotArticle.do?");
})

var channelId="";
 var categoryId="";


function getHot(){
	 $(".uu2").empty()
	 $.post("<%=path %>/channel/category.do",function(arr){
		  $("#content").load("/channel/getHotArticle.do");
	})
 }

	function category(id){
		channelId=id;
		$(".uu").each(function(){
			$(this).empty();
		})
		$.post("<%=path %>/channel/category.do",{id:id},function(arr){
			
			$(".uu").each(function(){
				$(this).append("<a class=\"nav-item nav-link active\" id=\"nav-all-tab\" data-toggle=\"tab\" href=\"#nav-all\" role=\"tab\" aria-controls=\"nav-all\" aria-selected=\"false\" onclick=\"listForChannel("+id+")\">全部</a>");
			})
			  for(var i in arr){
				  if(i==0){
						$(".uu").each(function(){
							$(this).append("<a class=\"nav-item nav-link\" id=\"nav-"+arr[i].name+"-tab\" data-toggle=\"tab\" href=\"#nav-"+arr[i].name+"\" role=\"tab\" aria-controls=\"nav-"+arr[i].name+"\" aria-selected=\"false\" onclick=\"list("+arr[i].id+")\">"+arr[i].name+"</a>");
						})
				  }else{
					  $(".uu").each(function(){
							$(this).append("<a class=\"nav-item nav-link\" id=\"nav-"+arr[i].name+"-tab\" data-toggle=\"tab\" href=\"#nav-"+arr[i].name+"\" role=\"tab\" aria-controls=\"nav-"+arr[i].name+"\" aria-selected=\"false\" onclick=\"list("+arr[i].id+")\">"+arr[i].name+"</a>");
						})
				  }
			  }
		})
		$("#content").load("/channel/getArticleOfChannel.do?id="+id);
		
	}
 
	function listForChannel(id){
		 $("#content").load("/channel/getArticleOfChannel.do?id="+id);
	}
	
 
 	function list(id){
 		categoryId=id;
		 $("#content").load("/channel/getArticleOfCategory.do?id="+id);
 	}
 	
 	function page(page){
 		 $("#content").load("/channel/getArticleOfChannel.do?currentPage="+page+"&id="+channelId);
 	}
 	
 	function page1(page){
 		 $("#content").load("/channel/getArticleOfCategory.do?currentPage="+page+"&id="+categoryId);
 	}
 	function page2(page){
 		 $("#content").load("/channel/getHotArticle.do?currentPage="+page);
 	}
 	function goRoot(userName,passWord){
 		var role = '${user.role}'
 		if(role!=1){
 			alert("您不是管理员")
 		}else{
 			location = '/user/goRootHome.do?id='+'${user.id}';
 		}
 	}
</script>
</html>