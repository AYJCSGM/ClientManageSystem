
var page = 1;
var rows = 100;

//定义 是否  继续查询 
var bFound = true;

mui.init();

$(function() {
	$("#shop").addClass("active");
	//监测用户滚动
	listenScroll();
	//加载数据
	loadDataBeFore();
});

function loadDataBeFore(){
	layer.open({
	    type: 2
	    ,content: '加载中'
	    ,shadeClose:false
    });
	$.post("/shopcart/list",{page:page,rows:rows},function(result){
		if(result.code==200){
			layer.closeAll();
			console.log(result.data.length);
			if(result.data.length>0){
				page++;
				loadData(result);
			}else{
				bFound = false;
				console.log("没有数据了");
				layer.closeAll();
				 //提示
				 if(page==1){
				 }else{
					 layer.open({
					    content: '没有商品可以加载了'
					    ,skin: 'msg'
					    ,time: 2 //2秒后自动关闭
					});
				 }
			}
		}
		if(result.code==404){
			layer.closeAll();
			//提示
			  layer.open({
			    content: result.msg
			    ,skin: 'msg'
			    ,time: 2 //2秒后自动关闭
			  });
		}
	},'json');
}



function loadData(result){
	for(var i=0;i<result.data.length;i++){
		 $(".shop_list").append(
				'<div class="shop_item">'+
					'<div style="width: 40px;padding-top: 40px; text-align: center;">'+
						'<input type="checkbox" value="'+result.data[i].goods.id+'"  id="'+result.data[i].goods.id+'"  style="zoom:150%"  />'+
					'</div>'+
					'<div style="width: 100px;" onclick="window.location.href=\'/wap/goods/'+result.data[i].goods.id+'.html\'">'+
						'<img style="width: 100%;" src="'+result.data[i].goods.showImg+'" />'+
					'</div>'+
					'<div style="flex:1;-webkit-flex:1; padding-left: 10px;">'+
						'<div class="shop_item_title">'+result.data[i].goods.title+'</div>'+
						'<div>'+
							'<span style="font-size: 13px; color: #ef4706;  font-weight: bold;">¥</span>'+
							'<span style="letter-spacing: 1px; color: #ef4706;  font-weight: bold;">'+result.data[i].goods.price+'</span>'+
						'</div>'+
					'</div>'+
					'<div style="width: 40px; text-align: center; padding-top: 35px;">'+
						'<span class="shop_item_btn_del" onclick="shop_del('+result.data[i].id+')">删除</span>'+
					'</div>'+
				'</div>'
				 );
	}
	
	//添加checkbox监听
	//listen_checkbox();
	
}


function listenScroll(){
	$(window).scroll(function () {
    	//这个方法是当前滚动条滚动的距离
        var scrollTop =  $(window).scrollTop();
    	console.log("距离屏幕顶部位置:"+scrollTop);
    	
    	var doc_height = $(document).height();
    	console.log("获取当前文档的高度:"+doc_height);
    	
    	var window_height = $(window).height();
    	console.log("获取当前窗体的高度:"+window_height);
    	
    	
    	// 距离屏幕的位置 加上   当前窗体的高度  >= 文档的高度-100【-100提早加载】    那么就表示  文档到底部了
    	if((window_height+scrollTop)>(doc_height-150)){
    		if(bFound){
    			console.log("要翻页了");
        		loadDataBeFore();
    		}
    	}
    	/*
        //$(window).height()获取当前窗体的高度
        //$(document).height()获取当前文档的高度
        var bot = 50; //bot是底部距离的高度
        if ((bot + $(window).scrollTop()) >= ($(document).height() - $(window).height())) {
           //当底部基本距离+滚动的高度〉=文档的高度-窗体的高度时；
            //我们需要去异步加载数据了
            $.getJSON("url", { page: "2" }, function (str) { alert(str); });
        }
        */
    });
}


function shop_del(goodsId){
	layer.open({
		  type: 2
		  ,content: '删除中...'
		  ,shadeClose:false
	});
	$.post("/shopcart/del", {goodsId : goodsId}, function(result) {
		if (result.success) {
			layer.closeAll();
			  layer.open({
			    content: '删除成功'
			    ,skin: 'msg'
			    ,time: 2 //2秒后自动关闭
			  });
			  location.replace(location.href);
		} else {
			layer.closeAll();
			layer.open({
			    content: result.msg
			    ,skin: 'msg'
			    ,time: 2 //2秒后自动关闭
			  });
			location.replace(location.href);
		}
	}, 'json');
}
