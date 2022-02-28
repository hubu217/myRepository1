package com.example.hkt;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import sy.util.HttpRequestUtil;



public class MyQuartzTask implements Runnable{
	
	
	
	
	private static final Logger logger = Logger.getLogger(MyQuartzTask.class);
	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 
	 private static int POOL_NUM = 60;     //线程池数量
	
	 
	  
	
	
   
    
    
    //cron任务触发器运行的任务
	
	  public  void doCronTask(){
		  
			    String timeNow= sdf.format(new Date());
		        System.out.println(timeNow+" 【定时任务-cron任务触发器-异步方法】");  
	
			    ExecutorService executorService = Executors.newFixedThreadPool(60); 
			    
		        for(int i = 0; i<POOL_NUM; i++){
			        	MyQuartzTask thread = new MyQuartzTask();
			            executorService.execute(thread);  
		        }
		        //关闭线程池
		       executorService.shutdown(); 
		       
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


	@Override
	public void run() {
		
		    
		           //System.out.println("【通过线程池方式创建的线程】：" + Thread.currentThread().getName() + " ");  
				
				  long startTime = System.currentTimeMillis(); 
				  //第一步： 配置cookie 
				  String cookie  ="isolate-web-session-id=e0ac927d-09b6-4c33-9041-725efddd0a4e";
				  
				  
				  
				  
				  
				  String url2_post = "https://hk.sz.gov.cn:8118/districtHousenumLog/getList";
				  String url3 ="https://hk.sz.gov.cn:8118/passInfo/confirmOrder?";
				  
				  //第二步: 请求结果列表 
				  String data2 = HttpRequestUtil.doPost(url2_post, cookie, "");
				  System.out.println("【第2步结果data2】="+data2);
				  
				  Data lastDataVo = parseStringJson(data2); 
				  
				  String checkinDate= lastDataVo.getDate().trim();
				   String timespan =  String.valueOf(lastDataVo.getTimespan()).trim();
				  String sign = lastDataVo.getSign().trim();
				  
				  
				  String url3_get = url3+"checkinDate="+checkinDate+"&t="+timespan+"&s="+sign;
				  System.out.println("【url3_get】="+url3_get);
				  
				  //第三步: 提交请求 
				  String data3 = HttpRequestUtil.doGet(url3_get, cookie);
				  System.out.println("【第3步结果data3】="+data3); 
				  long endTime = System.currentTimeMillis();
				  
				  
				  System.out.println("【总耗时】=" +(endTime-startTime)); 
				  System.out.println();
				 
		
	}
		
    
    
    
    
    
}