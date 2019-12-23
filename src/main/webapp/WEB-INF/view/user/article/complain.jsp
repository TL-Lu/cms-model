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
<title>投诉</title>
<script type="text/javascript" src="<%=path%>/webResources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="<%=path%>/webResources/My97DatePicker/WdatePicker.js"></script>
<%-- <link href="<%=path%>/webResources/css/index3.css"  rel="stylesheet"> --%>
<link href="<%=path%>/webResources/bootstrap-4.3.1-dist/css/bootstrap.css"  rel="stylesheet">
<script type="text/javascript" src="<%=path %>/webResources/bootstrap-4.3.1-dist/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=path %>/webResources/validate/jquery.validate.js"></script>
</head>
<body>
	<div class="container">
	<form:form  modelAttribute="complain"   action="/channel/addComplain.do" method="post"  enctype="multipart/form-data">
		<div class="form-group">
		   <label >文章标题</label>${article.title}
		  </div>
		<input type="hidden" name="articleId" value="${article.id}">
		
		<div class="form-group">
		   <label >地址</label>
		    <form:input path="srcUrl" />
		    <form:errors path="srcUrl" cssStyle="color:red"></form:errors>
		 </div>
		 
		 <div class="form-group">
		   <label >投诉类型</label>
		    <form:select path="complainType" >
		    	<option value="0">请选择</option>
		    	<option value="1">政治敏感</option>
		    	<option value="2">反社会</option>
		    	<option value="3">涉毒</option>
		    	<option value="4">涉黄 </option>
		    </form:select>
		     <form:errors path="complainType" cssStyle="color:red"></form:errors>
		 </div>
		  <div class="form-group">
		   <label >投诉类型</label>
		   		&nbsp;&nbsp;&nbsp;<input type="checkbox" name="compainOption" value="1"> 标题夸张
		   		  &nbsp;&nbsp;&nbsp;<input type="checkbox" name="compainOption" value="2">与事实不符 
		   		  &nbsp;&nbsp;&nbsp;<input type="checkbox" name="compainOption" value="3"> 疑似抄袭
		 	 <form:errors path="compainOption" cssStyle="color:red"></form:errors>
		  </div>
		  
		  <div class="form-group">
		   <label >图片</label>
		   	<input type="file" name="file">
		  </div>
		  <div class="form-group">
		   <label >内容</label>
		   	<form:textarea path="content" cols="100" rows="3" />
		   	 <form:errors path="content" cssStyle="color:red"></form:errors>
		  </div>
		  
		  <div class="form-group">
		   <label >邮箱</label>
		   <form:input path="email"/>
		   	 <form:errors path="email" cssStyle="color:red"></form:errors>
		  </div>
		  
		   <div class="form-group">
		   <label >电话</label>
		   <form:input path="mobile"/>
		   	 <form:errors path="mobile" cssStyle="color:red"></form:errors>
		 </div>		  
		<button>提交</button>
	</form:form>	
	
	</div>
</body>
</html>