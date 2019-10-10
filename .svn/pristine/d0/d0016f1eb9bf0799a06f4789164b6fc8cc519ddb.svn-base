	$(function(){

		$.post('/weixin/share', {url : share_url}, function(result) {
			appId = result.appId;
	        nonceStr = result.noncestr;
	        signature = result.signature;
	        timestamp = result.timestamp;
	        
	        wx.config({
	            debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
	            appId: appId, // 必填，公众号的唯一标识
	            timestamp:timestamp , // 必填，生成签名的时间戳
	            nonceStr: nonceStr, // 必填，生成签名的随机串
	            signature: signature,// 必填，签名
	            jsApiList: ['onMenuShareAppMessage','scanQRCode','onMenuShareTimeline'] // 必填，需要使用的JS接口列表
	        });
	        
	        wx.ready(function(){
	        	
	        	wx.onMenuShareTimeline({
	                title: share_title,
	                link: share_url,
	                imgUrl: share_img_url, 
	                success: function () { 
	                    // 用户确认分享后执行的回调函数
	                    // alert('分享到朋友圈成功');
	                },
	                cancel: function () { 
	                    // 用户取消分享后执行的回调函数
	                    //alert('你没有分享到朋友圈');
	                }
	            });
	        	
	        	
	            wx.onMenuShareAppMessage({
	                title: share_title,// 分享标题
	                desc: share_desc, // 分享描述
	                link: share_url,  // 分享链接
	                imgUrl: share_img_url, // 分享图标
	                type: 'link', // 分享类型,music、video或link，不填默认为link
	                dataUrl: '', // 如果type是music或video，则要提供数据链接，默认为空
	                success: function () {
	                    //alert("分享好友 成功！");
	                },
	                cancel: function () {
	                	//alert("你取消了分享好友！");
	                }
	            });
	            wx.error(function(res){
	            });
	        });
			
		}, 'json');
	});
	