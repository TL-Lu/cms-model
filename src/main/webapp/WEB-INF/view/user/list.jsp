<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<form>
	<ul class="list-group">
		<c:forEach items="${articles }" var="article">
			  <li class="list-group-item d-flex justify-content-between align-items-center">
			    	${article.title }
			    <span class="badge badge-primary badge-pill">${article.hits }</span>
			  </li>
		</c:forEach>
	</ul>
</form>