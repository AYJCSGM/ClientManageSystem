<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- JSTL -->

${config.headStr}

${config.layuiStr}

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<style type="text/css">
/*css reset */
body,p,div,ol,ul,li,dl,dt,dd,h1,h2,h3,h4,h5,h6,form,input,iframe,nav {
    margin: 0;
    padding: 0;
}
html,body {
    width: 100%;
    height: 100%;
}
body {
    font: 14px Microsoft YaHei;
    -webkit-text-size-adjust:100%;
    -moz-user-select: none;
    -webkit-user-select: none;
    user-select: none;
    position: relative;
    background: #000;
}

#canvas {
    width: 100%;
    height: 100%;
    display: block;
    opacity: .8;
}
</style>
<style>
body {
	background: #ebebeb;
}

.content {
 	box-shadow: 0px 0px 66px 2px rgba(0,0,0,0.4);
	margin-bottom:50px;
	background: rgb(255, 255, 255);
	margin: -500px auto auto;
	border: 0px solid rgb(231, 231, 231);
	border-image: none;
	width: 350px;
	height: 0px;
	padding-top: 0px;
	padding-right: 20px;
	border-radius: 3px;
}
.layui-form-item {
	margin-bottom: 2px;
	clear: both;
}

.layui-form-label {
	width: 38px;
}

.layui-input-block {
	margin-left: 70px;
}
</style>




</head>
<body>
	<canvas id="canvas" width="120" height="40"></canvas>
	<div class="top_div"></div>
	<div class="content">
		<form id="fm" class="layui-form" style="margin-bottom: 26px;" action="/admin/main">
			<div class="layui-form-item"> 
				<label class="layui-form-label">帐号</label>
				<div class="layui-input-block">
					<input type="text" style= "background-color:transparent;border:0;" id="name" lay-verify="title" autocomplete="off" placeholder="请输入帐号" onkeydown="if(event.keyCode==13) go_login()" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">  
				<label class="layui-form-label">密码</label>
				<div class="layui-input-block">
					<input type="password" style= "background-color:transparent;border:0;" id="password" lay-verify="title" autocomplete="off" placeholder="请输入密码" onkeydown="if(event.keyCode==13) go_login()"  class="layui-input">
				</div>
			</div>
		</form>

		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" onclick="go_login()" lay-submit="" lay-filter="demo1">登陆</button>
			</div>
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
<script type="text/javascript">
	$(function() {
		$("#name").focus();
	});
	
	function go_login() {
		var index = layer.load(1, {
			shade : [ 0.1, '#fff' ]
		//0.1透明度的白色背景
		});
		
		var name = $("#name").val();
		var password = $("#password").val();
		
		if (name == null || name == "") {
			layer.closeAll();
			layer.alert('请输入帐号!');
			return;
		}
		
		if (password == null || password == "") {
			layer.closeAll();
			layer.alert('请输入密码!');
			return;
		}
		
		$.post('/user/login', {
			name : name,
			password : password
		}, function(result) {
			if (result.success) {
				layer.closeAll();
				//document.location.href = "/admin/main";
				//window.open("/admin/main");
				//window.location.href = "/admin/main";
				$("#name").val("");
				$("#password").val("");
				window.location.href = "/admin/main";
			} else {
				layer.closeAll();
				layer.alert(result.msg);
				$("#error").html(result.msg);
			}
		}, 'json');

	}
</script>

<script type="text/javascript">

	//宇宙特效
	var canvas = document.getElementById('canvas'),
	ctx = canvas.getContext('2d'),
	w = canvas.width = window.innerWidth,
	h = canvas.height = window.innerHeight,

	hue = 217,
	stars = [],
	count = 0,
	maxStars = 1100;                //星星数量,默认1300
	var canvas2 = document.createElement('canvas'),
	ctx2 = canvas2.getContext('2d');
	canvas2.width = 100;
	canvas2.height = 100;
	var half = canvas2.width / 2,
	gradient2 = ctx2.createRadialGradient(half, half, 0, half, half, half);
	gradient2.addColorStop(0.025, '#CCC');
	gradient2.addColorStop(0.1, 'hsl(' + hue + ', 61%, 33%)');
	gradient2.addColorStop(0.25, 'hsl(' + hue + ', 64%, 6%)');
	gradient2.addColorStop(1, 'transparent');
	
	ctx2.fillStyle = gradient2;
	ctx2.beginPath();
	ctx2.arc(half, half, half, 0, Math.PI * 2);
	ctx2.fill();
	
	//End cache
	function random(min, max) {
	  if (arguments.length < 2) {
	      max = min;
	      min = 0;
	  }
	
	  if (min > max) {
	      var hold = max;
	      max = min;
	      min = hold;
	  }
	
	  return Math.floor(Math.random() * (max - min + 1)) + min;
	}
	
	function maxOrbit(x, y) {
	  var max = Math.max(x, y),
	  diameter = Math.round(Math.sqrt(max * max + max * max));
	  return diameter / 2;
	  //星星移动范围，值越大范围越小，
	}
	
	var Star = function() {
	
	  this.orbitRadius = random(maxOrbit(w, h));
	  this.radius = random(60, this.orbitRadius) / 10;       //星星大小,值越大星星越小,默认8
	  
	  this.orbitX = w / 2;
	  this.orbitY = h / 2;
	  this.timePassed = random(0, maxStars);
	  this.speed = random(this.orbitRadius) / 80000;        //星星移动速度,值越大越慢,默认5W
	  
	  this.alpha = random(2, 10) / 10;
	
	  count++;
	  stars[count] = this;
	}
	
	Star.prototype.draw = function() {
	  var x = Math.sin(this.timePassed) * this.orbitRadius + this.orbitX,
	  y = Math.cos(this.timePassed) * this.orbitRadius + this.orbitY,
	  twinkle = random(10);
	
	  if (twinkle === 1 && this.alpha > 0) {
	      this.alpha -= 0.05;
	  } else if (twinkle === 2 && this.alpha < 1) {
	      this.alpha += 0.05;
	  }
	
	  ctx.globalAlpha = this.alpha;
	  ctx.drawImage(canvas2, x-this.radius/2, y-this.radius/2, this.radius, this.radius);
	  this.timePassed += this.speed;
	}
	
	for (var i = 0; i < maxStars; i++) {
	  new Star();
	}
	
	function animation() {
	  ctx.globalCompositeOperation = 'source-over';
	  ctx.globalAlpha = 0.5;                                 //尾巴
	  ctx.fillStyle = 'hsla(' + hue + ', 64%, 6%, 2)';
	  ctx.fillRect(0, 0, w, h)
	
	  ctx.globalCompositeOperation = 'lighter';
	  for (var i = 1,
	  l = stars.length; i < l; i++) {
	      stars[i].draw();
	  };

 	 window.requestAnimationFrame(animation);
}

animation();
</script>
</body>

</html>