package com.java1234.quartz;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.java1234.service.ConfigService;
import com.java1234.service.PublicService;
import com.java1234.util.DateUtil;



@Component
public class Task {
	
	/*
	 * 定时任务
	@Scheduled(cron="* * * * * ?") 每秒执行一次
	@Scheduled(cron="0 * * * * ?") 每分执行一次
	@Scheduled(cron="0 0 * * * ?") 每时执行一次
	@Scheduled(cron="0 0 0 * * ?") 每天执行一次
	@Scheduled(cron="0 0 10,11,14,16  *  *  ?") 每天上午10点，下午2点，4点
	*/
	
	@Resource
	private PublicService publicService;
	@Resource
	private ConfigService configService;
	
	
	
	
}
