package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.hibernate.mapping.Array;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Controller                   
public class Demo {
	
	
	private static Boolean testFlag ;

	
	public static void main(String[] args) {
		
		//boolean flag =   showFlase() & showTrue();
		
		//System.out.println("testFlag="+testFlag);
		
		/*
		 * List<String> testList = new ArrayList<String>(); int i = 1; while(true) {
		 * String index = String.valueOf(i); testList.add(index);
		 * System.out.println("index="+index); i++;
		}*/
		
		
		
		String a ="11";
		String b ="22";
		String c ="22";
		
		System.out.println("a lenth="+a.hashCode());
		System.out.println("b lenth="+b.hashCode());
		System.out.println("c lenth="+c.hashCode());
		
	}
	
	
	
	
	public static boolean showTrue() {
		
			System.out.println("======showTrue执行");
			return 1<2;
	}
	
	
	public static boolean showFlase() {
		
		System.out.println("======showFlase执行");
		return 1>2;
    }
	
	public static void show1() {
		
		
		try {
			
			
			//PostMethod postMethod = new PostMethod("http://短信服务器IP地址:服务端口/SMSWebService/send_SMS");
			PostMethod postMethod = new PostMethod("http://zwfw.harbin.gov.cn/SMSWebService/send_SMS");
			postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8"); //设置编码
			String key = "046BC7E3-B42A-4CC1-BE57-17D7B01640B0";//签名(密钥)
			
			Map<String, Object> map = new HashMap<String, Object>();
			String  telphone ="18927465535";
			String  messages ="短信测试——平安智慧城市";
			String  enterprise ="平安智慧城市";
			String  sourceApp ="PASC";
			
			 AddressUtils addressUtils = new AddressUtils();
			//String sourceIp = addressUtils.getV4IP(); //外网IP
			// System.out.println("外网IP sourceIp="+sourceIp);
			 
			
			
			map.put("telphone", telphone);
			map.put("messages", messages);
			map.put("enterprise", enterprise);
			map.put("sourceApp",sourceApp );
			map.put("sourceIp", "无");
			System.out.println("EncodeUtils加密  map 请求入参:"+JSON.toJSONString(map));

			
			String content = EncodeUtils.getSortParams(map);
			String sign = EncodeUtils.encode(content + key);
			postMethod.setParameter("telphone", telphone);//手机号
			postMethod.setParameter("messages", messages);//短信信息
			postMethod.setParameter("sign", sign);//签名(密钥)
			postMethod.setParameter("enterprise", enterprise);//企业(中文)
			postMethod.setParameter("sourceApp", sourceApp);//企业(拼音简写)
			postMethod.setParameter("sourceIp", "无");//访问ip
			
			HttpClient authorize_client = new HttpClient();
			System.out.println("第三方短信通道 postMethod:"+JSON.toJSONString(postMethod.getParameters()));
			
			authorize_client.executeMethod(postMethod);
			String norsubmit = postMethod.getResponseBodyAsString();
			System.out.println("第三方短信通道返回Data:"+norsubmit);
			
			JSONObject jsonObj = JSONObject.parseObject(norsubmit);
			String code = (String) jsonObj.get("code");
			String msg = (String) jsonObj.get("msg");
			
			System.out.println("code="+code +"; msg="+msg);
				
				
	} catch (HttpException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	
	
	
	
	public void show2(String str) {
		
		JSONArray array = JSON.parseArray(str);
		
		
		
	}
	
}
