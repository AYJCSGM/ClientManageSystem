<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 开启高速模式    -->
<meta name="renderer" content="webkit|ie-comp|ie-stand">
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

<!--添加  vue.js 支持加载-->
<script	src="${pageContext.request.contextPath}/static/vue/vue.min.js"></script>

<script>
function fun(){
	console.log(app.selected);
}

</script>
<style>
html, body {
}
</style>
</head>
<body id="app">

<div style="border-bottom: 1px solid black; margin-bottom: 10px;">
		<input type="checkbox" id="checkbox" v-model="checked">
		<label for="checkbox">{{ checked }}</label>
</div>

复选框 
<div style="border-bottom: 1px solid black; margin-bottom: 10px;">
	<input type="checkbox" id="jack" value="Jack" v-model="checkedNames">
	<label for="jack">Jack</label>
	<input type="checkbox" id="john" value="John" v-model="checkedNames">
	<label for="john">John</label>
	<input type="checkbox" id="mike" value="Mike" v-model="checkedNames">
	<label for="mike">Mike</label>
	<br>
	<span>Checked names: {{ checkedNames }}</span>
</div>

单选框 
<div style="border-bottom: 1px solid black; margin-bottom: 10px;">
	
	<input type="radio" id="one" value="One" v-model="picked">
	<label for="one">One</label>
	<br>
	
	<input type="radio" id="two" value="Two" v-model="picked">
	<label for="two">Two</label>
	<br>
	
	<input type="radio" id="thr" value="thr" v-model="picked1">
	<label for="two">thr</label>
	<br>
	
	<span>Picked: {{ picked }}</span>
	<br>
	
	<span>Picked: {{ picked1 }}</span>
	<br>
</div>

下拉选择
<div style="border-bottom: 1px solid black; margin-bottom: 10px;">
<select v-model="selected" onchange="fun()">
  <option selected>A</option>
  <option>B</option>
  <option>C</option>
</select>
<span>Selected: {{ selected }}</span>
</div>

<script>
var app = new Vue({
    el:'#app',
    data: {
    	checked:false,
    	checkedNames: [],
    	selected:''
}});
</script>

</body>
</html>