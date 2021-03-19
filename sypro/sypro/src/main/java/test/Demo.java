package test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@Controller                   
public class Demo {

	
	public static void main(String[] args) {
		try {
			
			
					//PostMethod postMethod = new PostMethod("http://短信服务器IP地址:服务端口/SMSWebService/send_SMS");
					PostMethod postMethod = new PostMethod("http://zwfw.harbin.gov.cn/SMSWebService/send_SMS");
					postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8"); //设置编码
					String key = "046BC7E3-B42A-4CC1-BE57-17D7B01640B0";//签名(密钥)
					
					Map<String, Object> map = new HashMap<String, Object>();
					String  telphone ="18927465535";
					String  messages ="短信信息-通道测试-验证码123456";
					String  enterprise ="平安智慧城市";
					String  sourceApp ="PASC";
					
					 AddressUtils addressUtils = new AddressUtils();
					String sourceIp = addressUtils.getV4IP(); //外网IP
					 System.out.println("外网IP sourceIp="+sourceIp);
					 
					
					
					map.put("telphone", telphone);
					map.put("messages", messages);
					map.put("enterprise", enterprise);
					map.put("sourceApp",sourceApp );
					map.put("sourceIp", sourceIp);
					System.out.println("EncodeUtils加密  map 请求入参:"+JSON.toJSONString(map));

					
					String content = EncodeUtils.getSortParams(map);
					String sign = EncodeUtils.encode(content + key);
					postMethod.setParameter("telphone", telphone);//手机号
					postMethod.setParameter("messages", messages);//短信信息
					postMethod.setParameter("sign", sign);//签名(密钥)
					postMethod.setParameter("enterprise", enterprise);//企业(中文)
					postMethod.setParameter("sourceApp", sourceApp);//企业(拼音简写)
					postMethod.setParameter("sourceIp", sourceIp);//访问ip
					
					HttpClient authorize_client = new HttpClient();
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
	
	
}
