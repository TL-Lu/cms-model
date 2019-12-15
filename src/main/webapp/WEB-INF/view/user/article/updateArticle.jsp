<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %><%
    String path = request.getContextPath();
%>
<link rel="stylesheet" href="<%=path %>/webResources/kindeditor/themes/default/default.css" />
	<link rel="stylesheet" href="<%=path %>/webResources/kindeditor/plugins/code/prettify.css" />
	<script charset="utf-8" src="<%=path %>/webResources/kindeditor/plugins/code/prettify.js"></script>
	<script charset="utf-8" src="<%=path %>/webResources/kindeditor/kindeditor-all.js"></script>
    <script charset="utf-8" src="<%=path %>/webResources/kindeditor/lang/zh-CN.js"></script>
    
		<form class="form-group" name="articleform"  id="articleform">
			<input type="hidden" name="id" value="${article.id }">
				  <div class="form-group">
						<label class="my-1 mr-2" for="inlineFormCustomSelectPref">请输入标题：</label>
      					<input type="text" class="form-control" placeholder="请输入标题"  name="title" value="${article.title }">
				  </div>
				 <div class="form-group">
				 	  <label class="my-1 mr-2" for="inlineFormCustomSelectPref">请选择：</label>
									  <select class="custom-select my-1 mr-sm-2" id="channel" name="channel.id">
									 		 <option value="0">请选择栏目</option>
											<c:forEach items="${list }" var="channel">
												<option value="${channel.id}"  ${channel.id==article.channel.id?"selected":""}>${channel.name }</option>
											</c:forEach>
									  </select>
			   </div>
			   
			     <div class="form-group">
				    <label for="category">分类：</label>
				    
				    <select class="form-control" id="category" name="category.id" >
				    	
				    </select>
			  </div>
			  
			<div class="form-group">
			    <label for="exampleFormControlFile1">文章图片：</label>
			    <img alt="" src="${picture }" width="100px" height="100px">
			    <input type="file" class="form-control-file" id="file" name="file">
  			</div>
  
		  <div class="form-group">
		    <label for="content1">文章内容：</label>
		    <textarea name="content" id="contentId" cols="200" rows="200" style="width:700px;height:200px;visibility:hidden;">${article.content }</textarea> 
		  </div>
  
		  <div class="form-group">
		  	<input type="button" class="btn btn-primary mb-2" value="提交" onclick="updateTxt()">
		  </div> 
						
					</form>
					
<script>
	$("#channel").change(function(){
			$.post("/channel/category.do",{id:$("#channel").val()},function(data){
				$("#category").empty();
				for ( var i in data) {
					$("#category").append("<option value='"+ data[i].id+"'>"+data[i].name+"</option>")	
				}
			})
	})
	
	 $(document).ready( function(){
		 
		 $.post("/channel/category.do",{id:$("#channel").val()},function(data){
				$("#category").empty();
				var categoryId='${article.category.id}'
				for ( var i in data) {
					$("#category").append("<option value='"+ data[i].id+"' "+(data[i].id==categoryId?'selected':'')+" >"+data[i].name+"</option>")	
				}
			})
		 
		KindEditor.ready(function(K) {
			//    textarea[name="content1"]
			editor = K.create('#contentId', {
			cssPath : '<%=path %>/webResources/kindeditor/plugins/code/prettify.css',
			<%-- uploadJson : '<%=path %>/webResources/kindeditor/jsp/upload_json.jsp',--%>			
			uploadJson:'/file/upload.do', 
			fileManagerJson:'/file/manager.do',
			
			<%--fileManagerJson : '<%=path %>/webResources/kindeditor/jsp/file_manager_json.jsp', --%>
			allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
      
	 }); 
		
	
	  
	  function updateTxt(){
		//  var formdata = new FormData($("#articleform"))
		// 生成formData  异步提交的数据包含附件  
		  var formData = new FormData($( "#articleform" )[0]);
		  
		
		   // 把文章内容存放到formData 中
		  formData.set("content",editor.html());
		 
		  $.ajax({url:"/user/updateArticle.do",
			  dataType:"json",
			  data:formData,
			  // 让jQuery 不要再提交数据之前进行处理
			  processData : false,
			  // 提交的数据不能加消息头
			  contentType : false,
			  // 提交的方式 
			  type:"post",
			  // 成功后的回调函数
			  success:function(data){
					 location.reload();
			  }
			  })
		  
	  }
</script>
