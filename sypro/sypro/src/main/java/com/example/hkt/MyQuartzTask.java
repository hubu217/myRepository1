package com.example.hkt;

import org.apache.log4j.Logger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import sy.util.HttpRequestUtil;



public class MyQuartzTask {
	
	
	
	
	private static final Logger logger = Logger.getLogger(MyQuartzTask.class);
	
	
    //简单触发器运行的任务
    public void doSimpleTask(){
    	
    	logger.info("【定时任务-简单触发器】doSimpleTask正在运行...................................................................");
        long startTime = System.currentTimeMillis();
		  //第一步： 配置cookie
		  String cookie ="isolate-web-session-id=f4c58c36-544d-41d3-966b-50c56e72edf8";
		  
		  
		  
		  
		  
		  String url2_post = "https://hk.sz.gov.cn:8118/districtHousenumLog/getList"; 
		  String url3 ="https://hk.sz.gov.cn:8118/passInfo/confirmOrder?"; 
		  
		  //第二步: 请求结果列表
		  String data2 = HttpRequestUtil.doPost(url2_post, cookie, "");
		  System.out.println("【第2步结果data2】="+data2);
		 
		  Data lastDataVo = parseStringJson(data2);
		  String checkinDate= lastDataVo.getDate().trim();
		  String timespan = String.valueOf(lastDataVo.getTimespan()).trim();
		  String sign = lastDataVo.getSign().trim();
		  
		  String url3_get = url3+"checkinDate="+checkinDate+"&t="+timespan+"&s="+sign;
		  System.out.println("【url3_get】="+url3_get);
		  
		  //第三步: 提交请求
		  String data3 = HttpRequestUtil.doGet(url3_get, cookie);
		  System.out.println("【第3步结果data3】="+data3);
		  long endTime = System.currentTimeMillis();
		  
		  System.out.println("【总耗时】=" +(endTime-startTime));
    }
    
    
    //cron任务触发器运行的任务
    public void doCronTask(){
        System.out.println("【定时任务-cron任务触发器】 doCronTask正在运行...");
    }
    
    
    
	public static  Data parseStringJson(String jsonStr) {
			
			JSONObject jsonObj =  JSONObject.parseObject(jsonStr);
			
			JSONArray data_jsonArray = (JSONArray) jsonObj.get("data");
			
			Object[]  dataArr =  data_jsonArray.toArray();
			int len = dataArr.length;
			JSONObject lastJsonObj = (JSONObject) dataArr[len-1];
			Data lastDataVo = JSONObject.parseObject(JSON.toJSONString(lastJsonObj), Data.class);
			
			
			return lastDataVo;
		}
		
    
    
    
    
    
}