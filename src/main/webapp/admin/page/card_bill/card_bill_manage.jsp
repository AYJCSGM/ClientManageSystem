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


//子窗口调用 的  关闭窗口方法 
function closeDlg(msg){
	 layer.closeAll();
	 layer.msg(msg);
	 reload_data();
}

//相当前刷新  重新加载
function reload_data(){
	
	var date1  = $("#startDateTime").val();
	var date2 = $("#endDateTime").val();
	
	table.reload('table', {
		 where: {date1:date1,date2:date2
	        }
    });
}


</script>

<div class="layui-form" style="min-width:1000px;">
<blockquote class="layui-elem-quote">${title }</blockquote>

<div class="layui-table-toolbar" style="margin-bottom: 3px; ">
	<div class="layui-btn-group">
	    <button class="layui-btn layui-btn-sm" onclick="reload_data()"><i class="layui-icon">&#x1002;</i>刷新</button>
 	 </div>
</div>

<div class="layui-form layui-form-pane" style="margin-bottom: 3px; "  >
	<div class="layui-form-item" style="margin-bottom: 1px; min-width:1051px;">
		<label class="layui-form-label">开始时间</label>
		<div class="layui-input-inline">
			<input type="text" class="layui-input" v-model="startDateTime" value="<fmt:formatDate value="${activity.startDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"  id="startDateTime" placeholder="yyyy-MM-dd HH:mm:ss">
		</div>
		<label class="layui-form-label">截止时间</label>
		<div class="layui-input-inline">
			<input type="text" class="layui-input" v-model="endDateTime" value="<fmt:formatDate value="${activity.endDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"  id="endDateTime" placeholder="yyyy-MM-dd HH:mm:ss">
		</div>
	    <div class="layui-input-inline" style="  width: 113px;">
	    	<a class="layui-btn" onclick="reload_data()">查询</a>
	    </div>
    </div>
</div>


<table class="layui-hide"   id="table" lay-filter="table"></table> 


<script type="text/html" id="format_type">
  {{#  if(d.type == '1'){ }}
     	<er>充值</er>
  {{#  } else if(d.type == '2') { }}
		<eg>消费</eg>
  {{#  }  }}
</script>

<script type="text/html" id="format_money">
  {{#  if(d.type == '1'){ }}
     	<er>充值金额:</er> <ber>{{d.money}}</ber>
  {{#  } else if(d.type == '2') { }}
		<eg>消费金额:</eg> <beg>{{d.money}}</beg>
  {{#  }  }}
</script>

<script type="text/html" id="format_wx_msm">
  {{#  if(d.wx_msm != null){ }}
     	<er>{{d.wx_msm}}</er>
  {{#  }   }}
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
			    ,url: '${table_url}',
			    height: 'full-160',
			   cols: [[
			           
			       {checkbox: true, width:50, fixed: true},
			      {field:'clientName', title: '客户姓名', width:80 ,style:'font-size: 12px; '}
			       ,{field:'carno', title: '卡号', width:120,  style:'font-size: 12px;'}
			      ,{field:'type', title: '交易类型', width:80,  style:'font-size: 12px;',templet: '#format_type' }
			      ,{field:'money', title: '交易金额', width:120,  style:'font-size: 12px;',templet: '#format_money' }
			      ,{field:'balance', title: '卡余额', width:80,  style:'font-size: 12px;' }
			      
			      
			      ,{field:'actual', title: '实收金额', width:80,  style:'font-size: 12px;'}
			      ,{field:'discounts', title: '优惠金额', width:80,  style:'font-size: 12px;'}
			      
			      ,{field:'createDateTime', title: '创建时间', width:130,style:'font-size: 12px;'}
			      ,{field:'createUserId', title: '创建人', width:130,style:'font-size: 12px;',templet: '#format_createUser' }
			      ,{field:'remark', title: '备注', width:100,style:'font-size: 12px;'}
			    ]]
			    ,id: 'table'
			    ,page: true
			    ,limits:[10,50,100,200,500,1000],
			   limit:100
			  });
			
			/*
			//常规用法
			  laydate.render({
			    elem: '#date1'
			  });
			//常规用法
			  laydate.render({
			    elem: '#date2'
			  });
			*/
			
			//监听工具条 table_bar
				table.on('tool(table)', function(obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
					var data = obj.data //获得当前行数据
					, layEvent = obj.event; //获得 lay-event 对应的值
					if (layEvent === 'add_send_list') {
						//layer.msg('查看操作' + data.id);
						add_send_list(data.id)
					} else if (layEvent === 'see') {
						see(data.id);
					} else if (layEvent === 'edit') {
						//layer.msg('编辑操作' + data.id);
						edit(data.id);
					} else if(layEvent === 'refund'){
						refund_dlg(data.id);
					}else if(layEvent ==='see_wxuser_info'){
					}

				});
			
			
				//日期时间选择器
				  laydate.render({
				    elem: '#startDateTime'
				    ,type: 'datetime'
				  });
				  laydate.render({
				    elem: '#endDateTime'
				    ,type: 'datetime'
				  });
				
		});
</script>


</body>
</html>
