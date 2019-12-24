<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<form action="/channel/">
	<table class="table">
				  <thead>
			    <tr>
				      <th scope="col">
				      							<select class="custom-select mr-sm-2" id="sel" >
				      									<option value="-1"  ${status=='-1'?'selected':'' }>请选择</option>
				      									<option value="0"  ${status=='0'?'selected':'' }>待审核</option>
				      									<option value="1"  ${status==1?'selected':'' }>审核通过</option>
				      									<option value="2"  ${status==2?'selected':'' }>审核被拒</option>
				      							</select>
				      </th>
				      <th><button type="button" class="btn btn-outline-info" onclick="sele()">查询</button></th>
			    </tr>
		  </thead>
		  <thead>
			    <tr>
				      <th scope="col">文章编号</th>
				      <th scope="col">文章标题</th>
				      <th scope="col">栏目</th>
				      <th scope="col">分类</th>
				      
				      <th scope="col">创建时间</th>
				      <th scope="col">状态</th>
				      <th scope="col">用户</th>
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
				      <td>${article.user.userName }</td>
				       <td>${article.hot=='1'?'是':'否' }</td>
				      <td>
				      <button type="button" class="btn btn-danger" onclick="del(${article.id })">删除</button>
				      <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalLong" onclick="check('${article.id}')">审核</button>
						<button type="button" class="btn btn-primary btn-info"  data-toggle="modal" data-target="#exampleModal" onclick="getArticleOfHot('${article.id}')">热门</button>
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



<!-- 热门模态 -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">设置是否热门</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-success" onclick="setHot(1)">通过</button>
 		 <button type="button" class="btn btn-danger" onclick="setHot(0)">拒绝</button>
      </div>
    </div>
  </div>
</div>



<!-- 模态框 -->
<div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
  <div class="modal-dialog" role="document" >
    <div class="modal-content" style="width: 1200px;margin-left: -300px;">
      <div class="modal-header">
        <h6 class="modal-title" id="title" >Modal title</h6>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body" id="articleContent">
      	<div id="title2"></div>
      	<div id="contentBody" style="margin-top: 30px;"></div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		<button type="button" class="btn btn-success" onclick="setStatus(1)">通过</button>
 		 <button type="button" class="btn btn-danger" onclick="setStatus(2)">拒绝</button>
      </div>
    </div>
  </div>
</div>


<!--投诉模态框  -->
<div class="modal fade"   id="articleContent" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
  <div class="modal-dialog" role="document" style="margin-left:100px;">
    <div class="modal-content" style="width:1200px;" >
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">文章审核</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body ">
         	<div class="row" id="divTitle"></div>
         	<div class="row" id="divOptions" ></div>
         	<div class="row" id="divContent"></div>		
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary" onclick="setStatus(1)">审核通过</button>
        <button type="button" class="btn btn-primary" onclick="setStatus(2)">审核拒绝</button>
     	 <button type="button" class="btn btn-primary" onclick="setHot(1)">设置热门</button>
        <button type="button" class="btn btn-primary" onclick="setHot(0)">取消热门</button>
      </div>
    </div>
  </div>
</div>	

<script>

$('#exampleModalLong').on('hidden.bs.modal', function (e) {
	  // do something...
		$("#content").load("/channel/findAllArticle.do?currentPage=" + '${page.getPageNum()}');
	})
$('#exampleModal').on('hidden.bs.modal', function (e) {
	  // do something...
		$("#content").load("/channel/findAllArticle.do?currentPage=" + '${page.getPageNum()}');
	})

	var articleId="";
	function page(currentPage){
			var status=$("#sel").val()
			$("#content").load("/channel/findAllArticle.do?currentPage="+currentPage+"&status="+status)
	}
	function sele(){
		var status=$("#sel").val()
			$("#content").load("/channel/findAllArticle.do?status="+status);
		
	}
	
	function check(id){
			$.post("/channel/getArticle.do",{id:id},function(result){
				if(result.core==1){
					$("#title").html(result.article.title)
					$("#title2").html("栏目:"+result.article.category.name+"  分类:"+result.article.channel.name+"  作者:"+result.article.user.userName)
					$("#contentBody").html(result.article.content);
					articleId=result.article.id;
				}
			},"json")
	}
	function setStatus(status){
		$.post("/channel/setStatus.do",{status:status,id:articleId},function(result){
			if(result.core==1){
				alert("操作成功")
				$("#exampleModalLong").modal("hide")
				return;
			}
			alert(result.message)
		})
	}
	
	function getArticleOfHot(id){
		$.post("/channel/getArticle.do",{id:id},function(result){
			if(result.core==1){
				articleId=result.article.id;
			}	
		},"json")
	}
	
	function setHot(hot){
		$.post("/channel/setHot.do",{hot:hot,id:articleId},function(result){
			if(result.core==1){
				alert("操作成功")
				$("#exampleModalLong").modal("hide")
				return;
			}
			alert(result.message)
		})
	}
	
</script>