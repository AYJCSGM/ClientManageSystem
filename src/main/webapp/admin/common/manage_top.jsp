<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- JSTL -->

<!-- shiro标签 授权   -->
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!--  shiro标签 授权 -->

<style>
</style>
<script>

	//切换侧边导航
	function hide_left_menu() {
		$("#left_menu").toggle();
		//判断display  是啥  display: none;  display: block;
		var display_ = $("#left_menu").css("display");
		if (display_ == 'none') {
			$("#main_scroll").css("padding-left", "0px");
			left_width = 0 ;
		} else {
			$("#main_scroll").css("padding-left", "200px");
			left_width =200;
		}
		set_layui_tab_item_height();
		set_layui_tab_item_width();
	}
	
	//全屏和退出全屏
	function toggleFullScreen() {  
	    if (!document.fullscreenElement && // alternative standard method  
	        !document.mozFullScreenElement && !document.webkitFullscreenElement) {// current working methods  
	        if (document.documentElement.requestFullscreen) {  
	            document.documentElement.requestFullscreen();  
	        } else if (document.documentElement.mozRequestFullScreen) {  
	            document.documentElement.mozRequestFullScreen();  
	        } else if (document.documentElement.webkitRequestFullscreen) {  
	            document.documentElement.webkitRequestFullscreen(Element.ALLOW_KEYBOARD_INPUT);  
	        }  
	    } else {  
	        if (document.cancelFullScreen) {  
	            document.cancelFullScreen();  
	        } else if (document.mozCancelFullScreen) {  
	            document.mozCancelFullScreen();  
	        } else if (document.webkitCancelFullScreen) {  
	            document.webkitCancelFullScreen();  
	        }  
	    }  
	} 
	
</script>

<style>
/* 顶部 导航整块的间距取消   默认20 */
.layui-nav{
	padding: 0 0px;
}
/* 顶部 导航 菜单 之间 间距15  默认20 */
.layui-nav .layui-nav-item a {
    padding: 0 15px;
}
</style>

<div style="height: 60px; width: 100%; background-color: #23262E; display: flex; display: -webkit-flex;">
	<div style="width: 200px; text-align: center; vertical-align: middle;">
		<a  target="_blank" style="display: block;" href="javascript:void()"><img alt="图标" style="vertical-align: middle;  "
			src="/static/images/base/main_logo.png"></a>
	</div>
	
	
	
	<div style="flex: 1; -webkit-flex: 1; ">
		<ul class="layui-nav">

			<li class="layui-nav-item"><a href="javascript:;"
				onclick="hide_left_menu()">切换侧边导航</a></li>

			<li class="layui-nav-item"><a href="/admin/main">刷新页面</a></li>
 			 
			<li class="layui-nav-item"><a onclick="toggleFullScreen()">全屏/退出</a></li>
			
		</ul>
	</div>
	
	<div style="  border-left: 1px solid #befffe; color: #c2c2c2;  background-color: #393D49;">
		<ul class="layui-nav">
			<li class="layui-nav-item"><a href="javascript:;"
				class="admin-header-user"> <img
					src="/static/images/base/default_head_img.jpg"
					style="width: 40px; height: 40px; border-radius: 100%;"> <span>${currentUser.trueName }</span>
					<span class="layui-nav-more"></span></a>
				<dl class="layui-nav-child my_top_menu layui-anim layui-anim-upbit">
					<dd>
						<a href="/user/logout">注销</a>
					</dd>
				</dl></li>
		</ul>
	</div>

</div>