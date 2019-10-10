<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- JSTL -->
<style>
</style>

<!-- left 导航  -->
<div class="layui-side layui-bg-black" id="left_menu" style="top: 60px; ">
<div class="layui-side-scroll">
<ul class="layui-nav layui-nav-tree" lay-filter="left_menu">
 
  <c:forEach var="tree" items="${treeList }">
  <li class="layui-nav-item layui-nav-itemed">
    <a href="javascript:;">${tree.text}</a>
    <dl class="layui-nav-child">
    	<c:forEach var="child" items="${tree.children}">
    		<dd id="${child.dd_id}" url="${child.url}" text="${child.text}"><a style="cursor:pointer;"><i class="layui-icon">${child.iconCls }</i>&nbsp; ${child.text}</a></dd>
    	</c:forEach>
    </dl>
  </li>
  </c:forEach>
	
  <!--  
  <li class="layui-nav-item layui-nav-itemed">
    <a href="javascript:;">菜单1</a>
    <dl class="layui-nav-child">
      <dd id="wxuser" url="http://www.baidu.com" text="111"><a href="#"><i class="layui-icon">&#xe63a;</i>&nbsp; 11111111</a></dd>
      <dd id="wxuser"><a href="#"><i class="layui-icon">&#xe63a;</i>&nbsp; 222222222</a></dd>
    </dl>
  </li>
  
  
   <li class="layui-nav-item layui-nav-itemed">
    <a href="javascript:;">菜单2</a>
    <dl class="layui-nav-child">
      <dd id="deployment"><a href="#"><i class="layui-icon">&#xe609;</i>&nbsp; 菜单2-111111</a></dd>
      <dd id="processDefinition"><a href="#"><i class="layui-icon">&#xe63c;</i>&nbsp; 菜单2-222222</a></dd>
    </dl>
  </li>
 -->
 
 
</ul>


</div>

</div>
<!-- left 导航 结束 div -->

