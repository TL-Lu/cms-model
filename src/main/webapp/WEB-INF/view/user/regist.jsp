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
<title>注册</title>
<script type="text/javascript" src="<%=path%>/webResources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="<%=path%>/webResources/My97DatePicker/WdatePicker.js"></script>
<%-- <link href="<%=path%>/webResources/css/index3.css"  rel="stylesheet"> --%>
<link href="<%=path%>/webResources/bootstrap-4.3.1-dist/css/bootstrap.css"  rel="stylesheet">
<script type="text/javascript" src="<%=path %>/webResources/bootstrap-4.3.1-dist/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=path %>/webResources/validate/jquery.validate.js"></script>
</head>
<style>
    *{margin: 0;padding: 0;}
    .content{
    	position:relative;
        width: 200px;
        height: 190px;
      	margin: 45px auto;
    }
    .div-inline{ 
    position:relative;
    display:inline-block;
    margin-left: 25px;
    }
</style>
<body>
<!--导航条  -->
	<nav class="navbar navbar-expand-lg navbar-light bg-light navbar navbar-dark bg-dark" style=" position:sticky; position:-webkit-sticky;top:0px;z-index: 999;">		
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
		  	  <form class="form-inline">
				    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
				    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			  </form>
		</nav>
		
		<!-- 巨幕 -->
		<div class="jumbotron jumbotron-fluid">
			  <div class="container">
			    <h1 class="display-1">CMS</h1>
			    <p class="lead">This is a modified jumbotron that occupies the entire horizontal space of its parent.</p>
			  </div>
		</div>
					
				
						<!-- 表单 -->
			    	<div class="content">
			    		 <form:form action="/user/regist.do" class="form-inline"  method="post"  modelAttribute="user"  id="form" >
			    			<h4>Please Regist：</h4>
								  <div class="input-group" style="margin-top: 10px;">
								  		<form:input path="userName"   minlength="2"  maxlength="9" cssClass="form-control" style="width:200px"  placeholder="Username" aria-label="Username" aria-describedby="basic-addon1"  remote="/user/checkName.do" />
							    		<form:errors path="userName"   cssStyle="color: red;font-family: 微软雅黑;font-weight:400;"></form:errors>
							    </div>
								  <div class="input-group">
							    		<form:password path="passWord" cssClass="form-control"  style="width:200px"  placeholder="Password" aria-label="passWord" aria-describedby="basic-addon1"/>
							   				<form:errors path="passWord"   cssStyle="color: red;font-family: 微软雅黑;font-weight:400;"></form:errors>
							    </div>
							    	<form:button class="btn btn-dark "  style="margin-left: 63px;margin-top: 30px">Regist</form:button>
	  						</form:form>
	  				</div>
	  				
	  						<div class="bg-dark" style="width: 300px auto;height: 304px;">
	  					
	  				</div>
</body>
<script type="text/javascript">
	$("#form").validate();

</script>
</html>