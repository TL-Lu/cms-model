<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

		<c:if test="${commentPage.getList().size()=='0' }">
						<li class="list-group-item d-flex justify-content-between align-items-center ex">
						  <div style="width: 500px;height: 40px;" class="ex" >
								
								 <p style="color: gray;">暂时没有评论哦~~~~</p>
						  </div>
						  </li>
		</c:if>
	<ul class="list-group">
		<c:forEach items="${commentPage.list }" var="comment">

			  <li class="list-group-item d-flex justify-content-between align-items-center ex">
			  <div style="width: 1500px;height: 70px;">
			  
			  <img alt="" src="/pic/${comment.user.url}" width="30px;" height="30px;">
			  ${comment.user.userName}：${comment.content }
			  <p style="color: gray;margin-top: 3px;margin-left: 32px;font-size: medium;"><fmt:formatDate value="${comment.created }" pattern="yyyy-MM-dd hh:mm:ss"/></p>
			  </div>
			  </li>
		</c:forEach>
					  <li>
			  		<ul class="pagination justify-content-center">
								    <li class="page-item  ${commentPage.isHasPreviousPage()==true?'':'disabled' }">
								     	 <a class="page-link" href="#" tabindex="-1"  onclick="gopage(${commentPage.getPageNum()-1})">Previous</a>
								    </li>
							    <c:if test="${commentPage.getPageNum()-1!=0}">
							 	   	<li class="page-item"><a class="page-link" href="#" onclick="gopage(${commentPage.getPageNum()-1})">${commentPage.getPageNum()-1}</a></li>
							    </c:if>
								    <li class="page-item active" aria-current="page">
								   	   <a class="page-link" href="#" onclick="gopage(${commentPage.getPageNum()})">${commentPage.getPageNum()} <span class="sr-only">(current)</span></a>
								    </li>
								     <c:if test="${commentPage.getPageNum()+1<=commentPage.getPages()}">
								        		 <li class="page-item"><a class="page-link" href="#" onclick="gopage(${commentPage.getPageNum()+1})">${commentPage.getPageNum()+1}</a></li>
							 		  </c:if>
								    <li class="page-item  ${commentPage.isHasNextPage()==true?'':'disabled' }">
								      <a class="page-link" href="#" onclick="gopage(${commentPage.getPageNum()+1})">Next</a>
								    </li>
							  </ul>
			  
			  </li>
</ul>
