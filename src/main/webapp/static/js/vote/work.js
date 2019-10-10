	
	function toupiao(){
		layer.open({
		    type: 2
		    ,content: '正在投票中...'
		    ,shadeClose:false
		});
		
		$.post('/admin/activity/ticket/add', {activityWorkId:activityWorkId}, function(result) {
			    layer.closeAll();
				//询问框
				if(result.success){
					layer.open({
					    content: result.msg
					    ,btn: ['好', '我知道了']
					    ,yes: function(index){
					      layer.close(index);
					    }
					     ,no: function(index){
						      layer.close(index);
						}
					  });
				}else{
					if(result.code==500){
						show_mask();
					}else{
						layer.open({
						    content: result.msg
						    ,btn: ['好', '我知道了']
						    ,yes: function(index){
						      layer.close(index);
						    }
						     ,no: function(index){
							      layer.close(index);
							}
						  });
						
					}
				}
		}, 'json');
	}
	
	
function close_mask(){
	$("#mask").hide();
}
function show_mask(){
	$("#mask").show();
}

function close_gift_window(){
	$("#gift_window").hide();
}
function open_gift_window(){
	$("#gift_window").show();
}

var gift_select_current_index = -1;
var gift_select_id = -1;

$(function(){
	var list = $(".gift_item");
	 $(list).click(function(){
		 //去掉当前选中
		 $(list).eq(gift_select_current_index).find(".gift_item_wrap").removeClass("gift_item_wrap_select");
		 //console.log($(this).index());
		 gift_select_current_index = $(this).index();
		 $(this).find(".gift_item_wrap").addClass("gift_item_wrap_select");
		 gift_select_id =  $(this).attr("id");
		 console.log(gift_select_id);
	 });
});

function pay_gift(){
	//后台传  礼物id 作品id  
	if(gift_select_id==-1){
		  //提示
		  layer.open({
		    content: '请选择一个礼物'
		    ,skin: 'msg'
		    ,time: 2 //2秒后自动关闭
		  });
		return ;
	}
	
	$.post('/admin/activity/gift/pay', {activityWorkId:activityWorkId,activityGiftId:gift_select_id}, function(result) {
		
		if(!result.success){
			layer.open({ content: result.msg ,skin: 'msg',time: 2   });
			return ; 
		}
		
		
		WeixinJSBridge.invoke('getBrandWCPayRequest',{  
            "appId" : result.appId,                //公众号API 
            "timeStamp":result.timeStamp,          //时间戳，自 1970 年以来的秒数  
            "nonceStr" : result.nonceStr,          //随机串  
            "package" : result.package,  //商品包信息  prepay_id=u802345jgfjsdfgsdg888
            "signType" : result.signType,          //微信签名方式
            "paySign" : result.paySign             //微信签名  
        },function(res){
            //当成功支付点击完成之后 
            if(res.err_msg == "get_brand_wcpay_request:ok" ) {
            	layer.open({ content: '礼物已送出' ,skin: 'msg',time: 2   });
            	close_gift_window();
            	//刷新 当前页面
            	location.replace(location.href);
            }else if(res.err_msg == "get_brand_wcpay_request:cancel"){
            	layer.closeAll(); layer.open({ content: '取消支付' ,skin: 'msg' ,time: 2   });
            }else{
            	layer.closeAll(); layer.open({ content: '支付失败' ,skin: 'msg'  ,time: 2 });
            }
        });
		
		
		
		
		
	}, 'json');
}






	