<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- JSTL -->

${config.headStr}

${config.layuiStr}


<!-- 加入移动布局 -->
<meta name="viewport"	content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=no" />
<!-- 加入移动布局 -->

<!--添加  vue.js 支持加载-->
<script src="${pageContext.request.contextPath}/static/vue/vue.min.js"></script>
<!--添加  vue.js 支持加载-->

<script>
var save_url = '${save_url}';
function save(){
	var index = layer.load(1, {
		  shade: [0.1,'#fff'] //0.1透明度的白色背景
	});
	if(app.name.length<1){
		layer.closeAll();//关闭loading
		layer.msg('请输入用户名!!!!!!');
		return ; 
	}
	if(app.trueName.length<1){
		layer.closeAll();//关闭loading
		layer.msg('请输入真实姓名!!!!!!');
		return ; 
	}
	$.post(save_url,{
		name:app.name
		,trueName:app.trueName
		,password:app.password
		,remark:app.remark
		 
		},function(result){
		if(result.success){
			//调用 父窗口的  关闭所有窗口 并且刷新 页面
			window.parent.closeDlg(result.msg);
		}else{
			layer.closeAll();//关闭loading
			layer.msg(result.msg);
		}
	},'json');
	
}


</script>
<style>
html, body {
}
.layui-form-item {
    margin-bottom: 3px;
}
</style>
</head>
<body id="app">


<div style="padding: 10px;">
	<form class="layui-form layui-form-pane">
	
	  <div class="layui-form-item">
	    <label class="layui-form-label">帐号</label>
	    <div class="layui-input-block">
		      <input type="text" id="name" autocomplete="off" value="${user.name }" v-model="name" placeholder="请输入帐号" class="layui-input">
	    </div>
	  </div>
	  
	  <div class="layui-form-item">
	    <label class="layui-form-label">真实姓名</label>
	    <div class="layui-input-block">
		      <input type="text" id="trueName" autocomplete="off" value="${user.trueName }" v-model="trueName" placeholder="请输入真实姓名" class="layui-input">
	    </div>
	  </div>
	  
	  
	  
	  <c:choose>
			    <c:when test="${user!=null}">
			    	<input type="hidden" id="password" autocomplete="off" value=""  v-model="password"  placeholder="请输入密码" class="layui-input">
			    </c:when>
			     
			     
			     <c:when test="${user==null }">
			     	<div class="layui-form-item">
					    <label class="layui-form-label">密码</label>
					    <div class="layui-input-block">
						      <input type="text" id="password" autocomplete="off" value="${user.password}" v-model="password" placeholder="请输入密码" class="layui-input">
					    </div>
					  </div>
			     </c:when>
	</c:choose>
	  
	  <div class="layui-form-item">
	    <label class="layui-form-label">备注</label>
	    <div class="layui-input-block">
		      <input type="text" id="remark" autocomplete="off" v-model="remark" value="${user.remark}" placeholder="请输入备注" class="layui-input">
	    </div>
	  </div>
	  </form>
		<div class="site-demo-button" style="margin-top: 20px;">
		  <button id="save" onclick="save()" class="layui-btn site-demo-layedit" data-type="content">${btn_text }</button>
		</div>
</div>


<script>
layui.use([ 'laydate', 'laypage', 'layer', 'table', 'carousel',
		'upload', 'element' ], function() {
	var laydate = layui.laydate //日期
	, laypage = layui.laypage //分页
	layer = layui.layer //弹层
	, table = layui.table //表格
	, carousel = layui.carousel //轮播
	, upload = layui.upload //上传
	, element = layui.element; //元素操作
});
</script>
<script>
var app = new Vue({
	el : '#app',
	data : {
	}
});
 
</script>


</body>
</html>