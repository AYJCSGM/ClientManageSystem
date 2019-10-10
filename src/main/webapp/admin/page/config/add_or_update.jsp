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

<!--图片剪辑 js css-->
<script src="${pageContext.request.contextPath}/static/cropbox/cropbox.js"></script>
<link href="${pageContext.request.contextPath}/static/cropbox/style.css" rel="stylesheet"/>
<!--图片剪辑 js css-->
<!--自己定义扩展的 图片剪辑js 符合我的ui-->
<script src="${pageContext.request.contextPath}/static/common/base/cropbox.js"></script>
<!--自己定义扩展的 图片剪辑js 符合我的ui-->

<style>

.layui-form-pane .layui-form-label {
    width: 130px;
}
.layui-form-pane .layui-input-block {
    margin-left: 130px;
}


</style>

<script>
var save_url = '${save_url}';
function save() {
	//loading
	var index = layer.load(1, {
		shade : [ 0.1, '#fff' ]
	//0.1透明度的白色背景
	});
	
	$.post(save_url, {
		domain_name : app.domain_name,
		web_site : app.web_site,
		headStr : app.headStr,
		layuiStr:app.layuiStr
	}, function(result) {
		if (result.success) {
			//调用 父窗口的  关闭所有窗口 并且刷新 页面
			window.parent.closeDlg(result.msg);
		} else {
			layer.msg(result.msg);
		}
	}, 'json');
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
	<div style="padding: 10px; overflow: hidden;">
		<div class="layui-form layui-form-pane">
			 
		 
			
			
			<div class="layui-form-item">
				<label class="layui-form-label">网站名称</label>
				<div class="layui-input-block">
					<input type="text" autocomplete="off" v-model="domain_name"
						value="${config.domain_name }" placeholder="请输入  网站名称" class="layui-input">
				</div>
			</div>
			
			
			<div class="layui-form-item">
				<label class="layui-form-label">网站地址</label>
				<div class="layui-input-block">
					<input type="text" autocomplete="off" v-model="web_site"
						value="${config.web_site }" placeholder="请输入  网站地址" class="layui-input">
				</div>
			</div>
			
			<div class="layui-form-item layui-form-text">
			    <label class="layui-form-label">head  头文件 </label>
			    <div class="layui-input-block">
			      <textarea placeholder="请输入内容" v-model="headStr" class="layui-textarea">${config.headStr}</textarea>
			    </div>
			  </div>
  			
  			<div class="layui-form-item layui-form-text">
			    <label class="layui-form-label">layuiStr </label>
			    <div class="layui-input-block">
			      <textarea placeholder="请输入内容" v-model="layuiStr" class="layui-textarea">${config.layuiStr}</textarea>
			    </div>
		    </div>
			 
		</div>
		 
		<div class="site-demo-button" style="margin-top: 20px;">
			<button id="save" onclick="save()"
				class="layui-btn site-demo-layedit" data-type="content">${btn_text }</button>
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