<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${title}</title>

<!-- JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- JSTL -->

${config.headStr}

${config.layuiStr}

<!-- 加入移动布局 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=no"/>
<!-- 加入移动布局 -->

<!-- 引入manage 的基础css -->
<script	src="${pageContext.request.contextPath}/static/common/manage/manage_base.js"></script>
<link href="${pageContext.request.contextPath}/static/common/manage/manage_base.css" rel="stylesheet"/>
<!-- 引入manage 的基础css -->

</head>
<style>

/*修改table表格  左右内边框 为0*/
.layui-table-cell {
	padding-left: 0px;
	padding-right: 0px;
	text-align: center;
}
/*修改table表格 左右内边框 为0*/

</style>
<body>
<script>
var global_ids;
var global_ids_len;
var w ;//窗口的宽
var h ;//窗口的高

function add(){
	w = 700;
	h = 600;
	checkWindow();
	
	layer.open({
	  type: 2,
	  title: '添加',
	  shadeClose: true,
	  shade: 0.8,
	  area: [w+'px', h+'px'],
	  content: '/houtai/client/add'  //iframe的url
	});
}

//打开编辑窗口
function open_edit(id){
	w = 700;
	h = 600;
	checkWindow();
	
	layer.open({
	  type: 2,
	  title: '修改',
	  shadeClose: true,
	  shade: 0.8,
	  area: [w+'px', h+'px'],
	  content: '/houtai/client/edit?id='+id //iframe的url
	});
}

//增加充值 窗口
function deposit(id){
	
	w = 700;
	h = 600;
	checkWindow();
	
	layer.open({
	  type: 2,
	  title: '充值窗口',
	  shadeClose: true,
	  shade: 0.8,
	  area: [w+'px', h+'px'],
	  content: '/houtai/deposit/trade/add?clientId='+id //iframe的url
	});
}

//消费 窗口
function consumption(id){
	w = 700;
	h = 600;
	checkWindow();
	
	layer.open({
	  type: 2,
	  title: '消费窗口',
	  shadeClose: true,
	  shade: 0.8,
	  area: [w+'px', h+'px'],
	  content: '/houtai/consumption/add?clientId='+id //iframe的url
	});
}

//查看 客户对账单
function bill(clientId){
	
	w = 1200;
	h = 1200;
	checkWindow();
	
	layer.open({
	  type: 2,
	  title: '对账单 窗口',
	  shadeClose: true,
	  shade: 0.8,
	  area: [w+'px', h+'px'],
	  content: "/houtai/card/bill/manage?clientId="+clientId //iframe的url
	});
	
	//window.parent.addTab2("bill","客户对账单","/houtai/card/bill/manage?clientId="+clientId);
}

//子窗口调用 的  关闭窗口方法 
function closeDlg(msg){
	 layer.closeAll();
	 layer.msg(msg);
	 reload_data();
}

//相当前刷新  重新加载
function reload_data(){
	var q = $("#q").val();
	var date1 = $("#date1").val();
	var date2 = $("#date2").val();
	var clientTypeId = $("#clientTypeId").val();
	
	table.reload('table', {
		 where: {
			  q: q
			 ,date1:date1
			 ,date2:date2
			 ,clientTypeId:clientTypeId
	        }
    });
}

function table_edit_update(id,field,value){
	$.post('/admin/client/update?'+field+'='+value,{id:id},function(result){
		if(result.success){
			layer.msg('修改成功');
		}else{
			layer.closeAll();
			layer.msg(result.msg);
		}
	},'json');
}

</script>

<div class="layui-form" style="min-width:1000px;">

<div class="layui-table-toolbar" style="margin-bottom: 3px; ">
	<div class="layui-btn-group">
		<button onclick="add()" class="layui-btn  layui-btn-sm">增加客户</button>
	    <button onclick="reload_data()" class="layui-btn layui-btn-sm">刷新</button>
 	 </div>
</div>

<form class="layui-form layui-form-pane" style="margin-bottom: 3px; "  >
  <div class="layui-form-item" style="margin-bottom: 1px; min-width:1051px;">
  	 <label class="layui-form-label" style="width: 100px;">分类</label>
    <div class="layui-input-inline" style="  width: 160px; margin-right: -1px; ">
    	<select id="clientTypeId">
	     	<option value="" selected="">全部</option>
	     	<c:forEach var="clientType" items="${clientTypeList}" >
	     		<option value="${clientType.id}" >${clientType.name}</option>
	     	</c:forEach>
	      </select>
    </div>
    
    <label class="layui-form-label" style="width: 97px;">模糊查询</label>
    <div class="layui-input-inline" style="  width: 150px; margin-right: -1px;">
      <input class="layui-input" id="q" onkeydown="if(event.keyCode==13) reload_data()" placeholder="模糊查询" ">
    </div>

    <div class="layui-input-inline" style="  width: 113px;">
    	<a class="layui-btn" onclick="reload_data()">查询</a>
    </div>
</div>

<div class="layui-form-item" style="margin-bottom: 1px; min-width:1051px;">
    <label class="layui-form-label" style="width: 63px;">大于</label>
    <div class="layui-input-inline" style="  width: 113px; margin-right: -1px; ">
      <input class="layui-input" id="date1" placeholder="大于几号" >
    </div>
    
    <label class="layui-form-label" style="width: 63px;">小于</label>
    <div class="layui-input-inline" style="  width: 113px; margin-right: -1px; ">
      <input class="layui-input" id="date2" placeholder="小于几号" >
    </div>
</div>
</form>

<table class="layui-hide"   id="table" lay-filter="table"></table> 
<script type="text/html" id="table_bar">
<div class="layui-btn-group">
	<a class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
	<a class="layui-btn layui-btn-xs" lay-event="deposit">充值</a>
	<a class="layui-btn layui-btn-xs" lay-event="consumption">消费</a>
	<a class="layui-btn layui-btn-xs" lay-event="bill">查看对帐单</a>
</div>
</script>



<script type="text/html" id="format_sex">
  {{#  if(d.sex =='1'){ }}
	<eb>男</eb>
  {{#  } else if(d.sex =='2') { }}
     <er>女</er>
  {{#  } }}
</script>

<script type="text/html" id="format_clientType">
  {{#  if(d.clientType != null){ }}
	 <eg>{{d.clientType.name}}</eg>
  {{#  } else { }}
  {{#  } }}
</script>

<script type="text/html" id="format_createUser">
  {{#  if(d.createUserId!= null){ }}
	 {{d.createUser.trueName}} 
  {{#  } else { }}
  {{#  } }}
</script>

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
			
			
			  table.render({
			    elem: '#table'
			    ,url: '/admin/client/list',
			    height: 'full-150',
			   cols: [[
			      {checkbox: true, fixed: true}
			      ,{field:'id', title: 'ID', width:50,style:'font-size: 7px;' }
			      
			      ,{field:'name', title: '姓名', width:80,style:'font-size: 7px;'}
			      ,{field:'carno', title: '卡号', width:80,style:'font-size: 7px;'}
			      ,{field:'sex', title: '性别', width:50, templet: '#format_sex'}
			      ,{field:'phone', title: '电话', width:100,style:'font-size: 7px;'}
			      ,{field:'balance', title: '卡余额', width:100,style:'font-size: 7px;'}
			      
			      ,{field:'clientTypeId', title: '客户类型', width:80, templet: '#format_clientType'}
			      
			      ,{field:'address', title: '地址', width:100,style:'font-size: 7px;'}
			      
			      ,{field:'createDateTime', title: '创建时间', width:120,style:'font-size: 7px;'}
			      ,{field:'createUserId', title: '创建人', width:80,style:'font-size: 7px;', templet: '#format_createUser'}
			      ,{field:'remark', title: '备注', width:200,style:'font-size: 7px;'}
			      
			      ,{fixed:'right', width:180,title: '操作',  toolbar: '#table_bar'}
			    ]]
			    ,id: 'table'
			    ,page: true
			    ,limits:[100,200,500,1000,2000,5000],
			   limit:100
			  });
			
			//常规用法
			  laydate.render({
			    elem: '#date1'
			  });
			//常规用法
			  laydate.render({
			    elem: '#date2'
			  });
			    
			
			
			//监听工具条 table_bar
				table.on('tool(table)', function(obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
					var data = obj.data //获得当前行数据
					, layEvent = obj.event; //获得 lay-event 对应的值
					if (layEvent === 'bill') {
						if(data.id)
						bill(data.id)
					} else if (layEvent === 'see_hongbao') {
						see_hongbao(data.id);
					} else if (layEvent === 'edit') {
						if(data.id)
						open_edit(data.id);
						
					} else if(layEvent === 'deposit'){
						if(data.id)
						deposit(data.id);
					}else if(layEvent ==='consumption'){
						if(data.id)
						consumption(data.id);
					}
				});
			
				
				//监听单元格编辑
				  table.on('edit(table)', function(obj){
				    var value = obj.value //得到修改后的值
				    ,data = obj.data //得到所在行所有键值
				    ,field = obj.field; //得到字段
				    //layer.msg('[ID: '+ data.id +'] ' + field + ' 字段更改为：'+ value);
				    table_edit_update(data.id,field,value);
				  });
				
				
			
				
		});
</script>


</body>
</html>
