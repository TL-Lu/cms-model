<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<form action="/channel/">
	<table class="table">
		  <thead>
			    <tr>
				      <th scope="col">文章编号</th>
				      <th scope="col">文章标题</th>
				      <th scope="col">栏目</th>
				      <th scope="col">分类</th>
				      <th scope="col">创建时间</th>
				      <th scope="col">状态</th>
				      <th scope="col">是否热门</th>
				      <th scope="col">操作</th>
			    </tr>
		  </thead>
		  <tbody>
		  <c:forEach items="${articles }" var="article">
			    <tr>
				      <th scope="row">${article.id }</th>
				      <td>${article.title }</td>
				      <td>${article.channel.name }</td>
				      <td>${article.category.name }</td>
				      <td><fmt:formatDate value="${article.created }"/> </td>
				      <td>
				      		<c:if test="${article.status==0}" >
				      				待审核
				      		</c:if>
				      		<c:if test="${article.status==1}" >
				      			<span style="color: green;">审核通过</span>
				      		</c:if>
				      		<c:if test="${article.status==2 }">
				      			<span style="color: red;">审核被拒</span>
				      		</c:if>
				      </td>
				      <td>${article.hot=='1'?'是':'否' }</td>
				      <td>
				      <button type="button" class="btn btn-danger" onclick="del(${article.id })">删除</button>
				      	<button type="button" class="btn btn-info" onclick="upd(${article.id})">修改</button>
				      </td>
			    </tr>
			   </c:forEach>
		  </tbody>
		  <tbody>
		  	<tr>
		  		<td colspan="12">
					<nav aria-label="...">
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
					</nav>
				 </td>
		  	</tr>
		  </tbody>
	</table>
</form>

<script>
	function page(currentPage){
			$("#content").load("/channel/getArticleOfUser.do?currentPage="+currentPage+"&id=${userId}")
	}
</script>