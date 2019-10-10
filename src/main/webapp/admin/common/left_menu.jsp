<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- JSTL -->
<style>
</style>

<div class="layui-side layui-bg-black" id="left_menu" style="top: 60px; ">
<div class="layui-side-scroll">
<ul class="layui-nav layui-nav-tree" lay-filter="left_menu">
 
  <c:forEach var="tree" items="${treeList }">
  <li class="layui-nav-item ">
    <a href="javascript:;">${tree.text}</a>
    <dl class="layui-nav-child">
    	<c:forEach var="child" items="${tree.children}">
    		<dd id="${child.dd_id}" url="${child.url}" text="${child.text}"><a style="cursor:pointer;"><i class="layui-icon">${child.iconCls }</i>&nbsp; ${child.text}</a></dd>
    	</c:forEach>
    </dl>
  </li>
  </c:forEach>
	
   
  <li class="layui-nav-item">
    <a href="javascript:;">菜单</a>
    <dl class="layui-nav-child">
      <dd id="user0" url="https://www.baidu.com" text="在线查找"><a href="#"><i class="layui-icon">&#xe63a;</i>&nbsp; 在线查找</a></dd>
    </dl>
  </li>
  <li class="layui-nav-item">
    <a href="javascript:;">娱乐</a>
    <dl class="layui-nav-child">
      <dd id="user1" url="common/tcs.jsp"  text="贪吃蛇"><a href="#"><i class="layui-icon">&#xe63a;</i>&nbsp; 贪吃蛇</a></dd>
      <dd id="user2" url="common/gridHtml.jsp" text="扫雷"><a href="#"><i class="layui-icon">&#xe63a;</i>&nbsp; 扫雷</a></dd>
    </dl>
  </li>


</div>

</div>
