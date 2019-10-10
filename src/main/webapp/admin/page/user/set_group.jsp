<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 开启高速模式    -->
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<!-- 开启高速模式 -->

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- JSTL -->

<!-- 加入移动布局 -->
<meta name="viewport"
	content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=no" />
<!-- 加入移动布局 -->

<!--添加  jq  支持加载-->
<script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<!--添加 jq 支持加载-->


<!--添加 layui  支持加载-->
<link href="${pageContext.request.contextPath}/static/layui_1.0.9/css/layui.css" rel="stylesheet"/>
<script src="${pageContext.request.contextPath}/static/layui_1.0.9/layui.js"></script>
<!--添加 layui  支持加载-->


<!--添加 layer 弹出 窗口  支持加载-->
<script src="${pageContext.request.contextPath}/static/layer-v3.0.3/layer/layer.js"></script>
<!--添加 layer 弹出 窗口  支持加载-->


<script>
layui.use(['form'], function(){
	  var form = layui.form()
	  ,layer = layui.layer;
});
	
	
$(function(){
		 
		var groups='${groupSelectedList}';
		var groupsArr=groups.split(",");
		for(var i=0;i<groupsArr.length;i++){
			$("[value="+groupsArr[i]+"]:checkbox").attr("checked",true);
			//$("#"+groupsArr[i]+"").attr("checked",true);
		}
	
});




var url = '${url}';

function save(){
	$("#save").addClass("layui-btn-disabled");
	
	var cb_obj = $("input:checkbox");
	var selectedGroupIds='';
	
	for(var i=0;i<cb_obj.length;i++){
		if(cb_obj[i].checked){
			selectedGroupIds+=cb_obj[i].value+',';
		}
	}
	
	console.log(selectedGroupIds);
	
	$.post(url,{userId:'${user.id_}',groupsIds:selectedGroupIds},function(result){
		if(result.success){
			//提交成功 设置按钮不可用 disabled="disabled"
			$("#save").attr("disabled",'disabled');
			//调用 父窗口的  关闭所有窗口
			window.parent.closeDlg(result.msg);
		}else{
			$("#save").removeAttr("disabled");
			layer.msg(result.msg);
		}
	},'json');
}


</script>
<style>
html, body {
	height: 100%;
	overflow: hidden;
}
</style>
</head>
<body>


	<div style="padding: 10px; overflow: hidden;">
		<form class="layui-form" action="" >
			  <div class="layui-form-item">
			    <div class="layui-input-block" style="margin-left: 0px; padding-bottom:20px; border-bottom: 1px solid black;">
			    	
			    	<c:forEach var="group" items="${groupList }">
			    		<input type="checkbox" id="${group.id_ }" value="${group.id_ }"   title="${group.name_ }" >
			    	</c:forEach>
			    	
			    </div>
			  </div>
		</form>
		
		<button id="save" onclick="save()" class="layui-btn layui-btn-normal">保存</button>
		
	</div>
	
	
	
	
</body>
</html>