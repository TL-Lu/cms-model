<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<table class="table">
	  <thead>
		    <tr>
			      <th scope="col">文章编号</th>
			      <th scope="col">文章标题</th>
			      <th scope="col">创建时间</th>
			      <th scope="col">状态</th>
			      <th scope="col">操作</th>
		    </tr>
	  </thead>
	  <tbody>
	  <c:forEach items="${articles }" var="article">
		    <tr>
			      <th scope="row">${article.id }</th>
			      <td>${article.title }</td>
			      <td><fmt:formatDate value="${article.created }"/> </td>
			      <td>${article.status}</td>
			      <td>
			      <button type="button" class="btn btn-danger">删除</button>
			      	<button type="button" class="btn btn-info">修改</button>
			      </td>
		    </tr>
		   </c:forEach>
	  </tbody>
</table>