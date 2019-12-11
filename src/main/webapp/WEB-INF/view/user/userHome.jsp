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
<title>Insert title here</title>
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
	<nav class="navbar navbar-expand-lg navbar-light bg-light navbar navbar-dark bg-dark" style=" position:sticky; position:-webkit-sticky;top:0px;z-index: 999;hight: 70px">		
		  	<a class="navbar-brand" href="#">首页</a>
		  	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
		   			 <span class="navbar-toggler-icon"></span>
		 	 </button>
			  <div class="collapse navbar-collapse" id="navbarNavDropdown">
				    <ul class="navbar-nav">
					      <li class="nav-item active">
					        	<a class="nav-link" href="/user/toLogin.do">登录 <span class="sr-only">(current)</span></a>
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
					
					<div >
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
					
					
	<div class="row" >
		  <div class="col-1 " style="border-right: 20px;border-right-color: black;border-right-width: 2px;border-right-style:dotted;margin-top: 30px;height: 620px;margin-left: 25px;">
			    <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
			      	<a class="nav-link active" id="v-pills-home-tab" data-toggle="pill" href="#v-pills-home" role="tab" aria-controls="v-pills-home" aria-selected="true">Home</a>
			      	<a class="nav-link" id="v-pills-profile-tab" data-toggle="pill" href="#v-pills-profile" role="tab" aria-controls="v-pills-profile" aria-selected="false">Profile</a>
			      	<a class="nav-link" id="v-pills-messages-tab" data-toggle="pill" href="#v-pills-messages" role="tab" aria-controls="v-pills-messages" aria-selected="false">Messages</a>
			     	 <a class="nav-link" id="v-pills-settings-tab" data-toggle="pill" href="#v-pills-settings" role="tab" aria-controls="v-pills-settings" aria-selected="false">Settings</a>
			    </div>
		  </div>
		  <div class="col-10">
			    <div class="tab-content" id="v-pills-tabContent">
			     		 <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab" style="margin-top:30px; background: black;width: 200px auto;height: 620px;">
			     		 
			     		 </div>
			      		<div class="tab-pane fade" id="v-pills-profile" role="tabpanel" aria-labelledby="v-pills-profile-tab" style="margin-top:30px; background: red;width: 200px auto;height: 620px;" >...</div>
			      		<div class="tab-pane fade" id="v-pills-messages" role="tabpanel" aria-labelledby="v-pills-messages-tab" style="margin-top:30px; background: green;width: 200px auto;height: 620px;" >...</div>
			      		<div class="tab-pane fade" id="v-pills-settings" role="tabpanel" aria-labelledby="v-pills-settings-tab" style="margin-top:30px; background: yellow;width: 200px auto;height: 620px;" >...</div>
			    </div>
		  </div>
	</div>
						
			    
			  			<div class="bg-dark" style="width: 300px auto;height: 100px;margin-top: 30px">
	  					
	  				</div>
</body>
</html>