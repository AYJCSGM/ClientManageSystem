
/*
 * 
 * html代码这样写就行了
 * 
 * <div class="lunbo">
        <ul>
        </ul>
	    <div class="tab">
	    </div>
</div>

 * 
 * 
 * */
//当前显示图片
var this_lunbo_current_i =0;
//总共多少个图片
var this_lunbo_len = 0;

var lunbo_data ; //存轮播数据

$(function(){
	initLunbo();//初始化轮播数据
});

function initLunbo(){
	//手动设置data
	lunbo_data = '[{"id":1,"title":"跨年购心动1111111111111价1","href":"http://www.baidu.com1","img_url":"/static/images/lunbo/1.jpeg"},{"id":2,"title":"跨年购心动价2","href":"http://www.baidu.com2","img_url":"/static/images/lunbo/2.jpeg"},{"id":3,"title":"跨年购心动价444","href":"http://www.baidu.com3","img_url":"/static/images/lunbo/3.jpeg"},{"id":4,"title":"跨年购心动价3","href":"http://www.baidu.com3","img_url":"/static/images/lunbo/4.jpeg"},{"id":5,"title":"跨年购心动价3","href":"http://www.baidu.com3","img_url":"/static/images/lunbo/5.jpeg"},{"id":6,"title":"6666666666心动价3","href":"http://www.baidu.com3","img_url":"/static/images/lunbo/6.jpeg"}]';
	lunbo_data = eval(lunbo_data);
	//使得post取data
	/*
	$.post("/lunbo/list.do",{isUse:1},function(result){
		data = result;
	},'json');
	*/
	showData();
	$(window).resize(function(){
		   //process here
		set_lunbo_tab_center();
	});
	
	//绑定事件
	set_lunbo_tab_a_bind_event();
}

//把取到的数据 显示到页面
function showData(){
	this_lunbo_len = lunbo_data.length;
	for(var i=0;i<lunbo_data.length;i++){
		if(i==0){
			$(".lunbo ul").append('<li style="background:url('+lunbo_data[i].img_url+') no-repeat center center;opacity: 100;filter: alpha(opacity=1);"></li>');
			$(".lunbo .tab").append('<a class="lunbo_tab_a_this" href="javascript:;">'+lunbo_data[i].title+'</a>');
		}else{
			$(".lunbo ul").append('<li style="background:url('+lunbo_data[i].img_url+') no-repeat center center;"></li>');
			$(".lunbo .tab").append('<a href="javascript:;">'+lunbo_data[i].title+'</a>');
		}
	}
	set_lunbo_tab_center();
	
	lunbo_move(0);//在ie第一张不显示，所以强执弄成第1张li
}

//调整位置居中
function set_lunbo_tab_center(){
	var screen_width= document.documentElement.clientWidth;
	//判断 screen_width < 1164 的话 则直接 等 于1164
	if(screen_width<1164){
		screen_width = 1164;
	}
	var tab_width = $(".lunbo .tab").width();
	$(".lunbo .tab").css("left",(screen_width-tab_width)/2+"px");
}

function lunbo_move(i){
	$(".lunbo li").eq(i).siblings().stop().animate({
		opacity:0
	  },800);
	  $(".lunbo li").eq(i).stop().animate({
		opacity:1
	  },800);
	 $(".lunbo .tab a").eq(i).addClass('lunbo_tab_a_this').siblings().removeClass('lunbo_tab_a_this');
}


//绑定事件
function set_lunbo_tab_a_bind_event(){
	//给a绑定click事件
	$(".lunbo .tab a").bind("click",function(){
		var index = $(this).index();
		this_lunbo_current_i = index ; 
		lunbo_move(index);
		resetTimer();
	});
	
	//给a绑定mouseover事件
	$(".lunbo .tab a").bind("mouseover",function(){
		var index = $(this).index();
		this_lunbo_current_i = index ; 
		lunbo_move(index);
		resetTimer();
	});
	
	//给li绑定click事件
	$(".lunbo li").bind("click",function(){
		// alert($(this).index);//这里取到的$(this).index永远是5 所以只能用这种方法了
		if(lunbo_data[this_lunbo_current_i].href.length>5){
			//alert(data[this_lunbo_current_i].href);
			//window.open(data[this_lunbo_current_i].href);//在新窗口打开
		}
	});
}


//切换图片
function lunbo_run(){
	this_lunbo_current_i++; //6
    if(this_lunbo_current_i>=this_lunbo_len){
    	this_lunbo_current_i=0;
    }
    lunbo_move(this_lunbo_current_i);  
}

//启动定时器
timer = setInterval(lunbo_run,4000);


//清除并且重启一次定时器    
function resetTimer(){
	clearInterval(timer);
	timer = setInterval(lunbo_run,4000);
}


