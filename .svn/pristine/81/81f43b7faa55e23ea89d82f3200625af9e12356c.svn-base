
function pay(){
	
	//发送金额和商品id到后台  验证一下
	layer.open({
	    type: 2
	    ,content: '正在发起支付'
	    ,shadeClose:false
	});
	
	$.post("/weixin/pay",{dingdanId:dingdanId},function(result){
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
            	layer.closeAll();
            	layer.open({ content: '支付成功:' ,skin: 'msg',time: 2   });
            	//跳转哪里
            	//  /wap/dingdan/detail/dingdanId
            	//window.location.href="home.jsp"
            	
            }else if(res.err_msg == "get_brand_wcpay_request:cancel"){
            	layer.closeAll(); layer.open({ content: '取消支付' ,skin: 'msg' ,time: 2   });
            }else{
            	layer.closeAll(); layer.open({ content: '支付失败' ,skin: 'msg'  ,time: 2 });
            }
        });
		
	},'json');
	
}

