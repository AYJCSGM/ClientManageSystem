

function add_shop_cart(goodsId){
	
	layer.open({
		  type: 2
		  ,content: '添加中...'
		  ,shadeClose:false
	});
	
	
	$.post("/shopcart/add", {
		goodsId : goodsId
	}, function(result) {
		if (result.success) {
			layer.closeAll();
			
			  layer.open({
			    content: '添加成功'
			    ,skin: 'msg'
			    ,time: 2 //2秒后自动关闭
			  });
			  
		} else {
			layer.closeAll();
			layer.open({
			    content: result.msg
			    ,skin: 'msg'
			    ,time: 2 //2秒后自动关闭
			  });
		}
	}, 'json');
}



function buy(goodsId){
	
}


