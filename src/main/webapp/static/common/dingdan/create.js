//全局 数量和全局总金额  默认0
var global_num = 0 ; 
var global_jine = 0 ; 


//把商品信息打包成 json  [{"goodsId":"1","goodsNum":7},{"goodsId":"1","goodsNum":7}]
function getGoodsInfo(){
	var goodsItemList = $(".goods_item");
	var jsonText = '[';
	
	for(var i=0;i<$(goodsItemList).size();i++){
		var goodsItem = $(".goods_item").eq(i);
		//拿id
		var goodsId = goodsItem.find("#goodsId").val();
		//拿数量
		var goodsNum = goodsItem.find("#input_num").val();
		
		jsonText =jsonText+ '{"goodsId":'+goodsId+',"goodsNum":'+goodsNum+"},";
	}
	jsonText = jsonText.substring(0,jsonText.length-1);
	jsonText = jsonText+']';
	return jsonText;
}


//计算 一共几个商品  一共多少钱     计算合计
function calculation(){
	global_num = 0 ; 
	global_jine = 0 ; 
	
	var goodsItemList = $(".goods_item");
	//console.log($(goodsItemList).size());
	
	for(var i=0;i<$(goodsItemList).size();i++){
		var goodsItem = $(".goods_item").eq(i);
		//拿数量
		var input_num_val = goodsItem.find("#input_num").val();
		//同步数量
		goodsItem.find("#num").html(input_num_val);
		//设置全部数量
		global_num =  parseInt(global_num)+parseInt(input_num_val);
		//拿单价
		var price = goodsItem.find("#price").html();
		
		global_jine =  (parseFloat(global_jine)+(input_num_val*price)).toFixed(2);
		
		
	}
	
	
	$("#global_num").html(global_num);
	$("#global_jine").html(global_jine);
	
	console.log("global_num:"+global_num);
	console.log("global_jine:"+global_jine);
}

//点击减数量
function num_sub(index){
	console.log(index);
	var goodsItem = $(".goods_item").eq(index);
	var input_num_val = goodsItem.find("#input_num").val();
	if(input_num_val>1){
		input_num_val = parseInt(input_num_val) - 1 ;
		goodsItem.find("#input_num").val(input_num_val);
		goodsItem.find("#num").html(input_num_val);
	}
	calculation();
}

//点击加数量
function num_add(index){
	console.log(index);
	var goodsItem = $(".goods_item").eq(index);
	var input_num_val = goodsItem.find("#input_num").val();
	input_num_val = parseInt(input_num_val) + 1 ;
	goodsItem.find("#input_num").val(input_num_val);
	goodsItem.find("#num").html(input_num_val);
	calculation();
}

function create(){
	layer.open({
	    type: 2
	    ,content: '正在提交订单'
	    ,shadeClose:false
	});
	//验证用户信息是否齐全
	if(app.name.length<2){layer.closeAll();
		  layer.open({content: '请填写姓名',skin: 'msg',time: 2});
		return;
	}
	if(app.phone.length<6){layer.closeAll();
		  layer.open({content: '请填写电话',skin: 'msg',time: 2});
		return;
	}
	if(app.address.length<3){layer.closeAll();
		  layer.open({content: '请填写地址',skin: 'msg',time: 2});
		return;
	}
	
	//调用 取得商品信息函数
	var jsonInfo = getGoodsInfo();
	console.log(jsonInfo);
	
	//开始 创建订单 传   姓名   电话   地址   备注   商品id 
	$.post("/dingdan/add",{name:app.name,phone:app.phone,address:app.address,remark:app.remark,ids:'${ids}',jsonInfo:jsonInfo},function(result){
		if(result.success){
			layer.open({ content: '提交成功' ,skin: 'msg',time: 2   });
			//带上订单 跳转付款页面
			window.location.href="/wap/dingdan/pay/"+result.dingdanId;
		}else{
			layer.closeAll(); layer.open({ content: '提交失败' ,skin: 'msg',time: 2   });
		}
	},'json');
}
