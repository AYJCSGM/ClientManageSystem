<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">

<link href="/static/css/vote/NewFile.css" rel="stylesheet" type="text/css" />
<title>
  扫雷
</title>
</head>
<!-- ondragstart:防拖拽生成新页面 oncontextmenu:屏蔽右键菜单-->
<body ondragstart='return false' oncontextmenu='self.event.returnValue=false'>
  <div id='bar'>
    <span class='bar'>
      剩余雷数：
      <label id='count'>
        0
      </label>
    </span>
    <span class='bar'>
      计时：
      <label id='time'>
        0
      </label>
      s
    </span>
  </div>
  <table id='grid'>
  </table>
  <script type="text/javascript" src="/static/js/vote/sao.js"></script>
</body>
</html>