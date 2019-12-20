<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<style>
.ex {
		overflow: hidden;
		text-overflow:ellipsis;
		white-space: nowrap;
	}
</style>


	<ul class="list-group">
		<c:forEach items="${articles }" var="article">
			  			  <li class="list-group-item d-flex justify-content-between align-items-center ex" >
			  			  <div style="width: 80px;height: 80px; background: black;display: inline-block;" > <img alt="" src="/pic/${article.picture }" width="80px;"  height="80px;"  onerror="this.src='/webResources/images/1.jpg'"></div>
			  <div style="display: inline-block;width: 700px;height: 80px;" class="ex">
			 	
			 		  <a href="/channel/details.do?id=${article.id }"  target="_blank" style="margin-left: 10px;">${article.title }</a>
			 		 <br>
			 		   &nbsp;&nbsp;作者：${article.user.userName }
			 		    <br>
			 		   &nbsp;&nbsp;栏目：${article.channel.name }&nbsp;&nbsp;&nbsp;&nbsp;分类：${article.category.name }
			  </div>
			    <span class="badge badge-primary badge-pill">${article.hits }</span>
			  </li>
		</c:forEach>
				<li>
				
								<ul class="pagination justify-content-center">
								    <li class="page-item  ${page.isHasPreviousPage()==true?'':'disabled' }">
								     	 <a class="page-link" href="#" tabindex="-1"  onclick="page(${page.getPageNum()-1})">Previous</a>
								    </li>
							    <c:if test="${page.getPageNum()-1!=0}">
							 	   	<li class="page-item"><a class="page-link" href="#" onclick="page(${page.getPageNum()-1})">${page.getPageNum()-1}</a></li>
							    </c:if>
								    <li class="page-item active" aria-current="page">
								   	   <a class="page-link" href="#" onclick="page(${page.getPageNum()})">${page.getPageNum()} <span class="sr-only">(current)</span></a>
								    </li>
								     <c:if test="${page.getPageNum()+1<=page.getPages()}">
								        		 <li class="page-item"><a class="page-link" href="#" onclick="page(${page.getPageNum()+1})">${page.getPageNum()+1}</a></li>
							 		  </c:if>
								    <li class="page-item  ${page.isHasNextPage()==true?'':'disabled' }">
								      <a class="page-link" href="#" onclick="page(${page.getPageNum()+1})">Next</a>
								    </li>
							  </ul>
				
				
				
				
				
				
				
				
				
				</li>
	</ul>





