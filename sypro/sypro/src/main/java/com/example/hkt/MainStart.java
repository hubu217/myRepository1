package com.example.hkt;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import sy.util.HttpRequestUtil;





public class MainStart {
	
	
	
	
	
	public static void main(String[] args) {
		
		
		
		  long startTime = System.currentTimeMillis();
		  //第一步： 配置cookie
		  String cookie ="isolate-web-session-id=24b6669c-f47a-4afe-a1ee-410ee7a46e13";
		  
		  String url2_post = "https://hk.sz.gov.cn:8118/districtHousenumLog/getList"; 
		  String url3 ="https://hk.sz.gov.cn:8118/passInfo/confirmOrder?"; 
		//String url3_get ="?checkinDate=2022-03-02&t=1645673178027&s=f3468a80d52d21b41fa415c69c471e48";
		  
		  //第二步: 请求结果列表
		  String data2 = HttpRequestUtil.doPost(url2_post, cookie, "");
		  System.out.println("【第2步结果data2】="+data2);
		 
		  Data lastDataVo = parseStringJson(data2);
		  //System.out.println("【最后一个对象 lastDataVo】="+JSON.toJSONString(lastDataVo));
		  
		  String checkinDate= lastDataVo.getDate().trim();
		  String timespan = String.valueOf(lastDataVo.getTimespan()).trim();
		  String sign = lastDataVo.getSign().trim();
		 // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 // String checkinDate= sdf.format(new Date());
		  
		  String url3_get = url3+"checkinDate="+checkinDate+"&t="+timespan+"&s="+sign;
		  System.out.println("【url3_get】="+url3_get);
		  
		  //第三步: 提交请求
		  String data3 = HttpRequestUtil.doGet(url3_get, cookie);
		  System.out.println("【第3步结果data3】="+data3);
		  long endTime = System.currentTimeMillis();
		  
		  System.out.println("【总耗时】=" +(endTime-startTime));
		
	}
	
	
	
	
	
	
	public static  Data parseStringJson(String jsonStr) {
		
		JSONObject jsonObj =  JSONObject.parseObject(jsonStr);
		//Integer status = (Integer) jsonObj.get("status");
		//String msg = (String)jsonObj.get("msg");
		
		JSONArray data_jsonArray = (JSONArray) jsonObj.get("data");
		//System.out.println("data_jsonArray="+data_jsonArray);
		
		Object[]  dataArr =  data_jsonArray.toArray();
		int len = dataArr.length;
		JSONObject lastJsonObj = (JSONObject) dataArr[len-1];
		Data lastDataVo = JSONObject.parseObject(JSON.toJSONString(lastJsonObj), Data.class);
		
		
		return lastDataVo;
	}
	
	

}
