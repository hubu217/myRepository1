package sy.test.t1;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import sy.pageModel.User;

/**
 * 
 * @author asus
 * @see 请求去重工具类 Java实现
 *
 */
public class UniqueRequest {
	
	
	
	
	
	public static void main(String[] args) {
			    //两个请求一样，但是请求时间差一秒
			   // show1();
		
		     //show2();
		
		String  str1="a";
		String  str2="b";
		String  str3="c";
		
		System.out.println(str1.hashCode()+" "+str2.hashCode()+" "+str3.hashCode());
		
		String str4 = "";
		System.out.println("str4="+str4);
			    
			   

	}
	
	
	
	private static void show2() {
		// TODO Auto-generated method stub
		
		
		List<User> list = new ArrayList<User>();
		for(long i = 0;i<Long.MAX_VALUE;i++) {
				 User u = new User();
				 u.setName("name");
				 u.setId(i+"");
				 list.add(u);
				 System.out.println("i="+i+"; listSize="+list.size());
		}
		
		
	}



	public static void show1() {
		
		
		 JSONObject  jsonObj1 = new JSONObject();
		    jsonObj1.put("name", "测试姓名");
		    jsonObj1.put("mobile", "13811112222");
		    jsonObj1.put("requestTime", "20220424111111988");
		    
		    JSONObject  jsonObj2 = new JSONObject();
		    jsonObj2.put("name", "测试姓名");
		    jsonObj2.put("mobile", "13811112222");
		    jsonObj2.put("requestTime", "20220424111111981");
		    
		    
		    String req1 = JSON.toJSONString(jsonObj1);
		    String req2 = JSON.toJSONString(jsonObj2);
		    
		    System.out.println("req1="+req1);
		    System.out.println("req2="+req2);
		    
		    
		    
	
		    
		    
		    //全参数比对，所以两个参数MD5不同
		    String dedupMD5 = new ReqDedupHelper().dedupParamMD5(req1);
		    String dedupMD52 = new ReqDedupHelper().dedupParamMD5(req2);
		    System.out.println("req1MD5 = "+ dedupMD5);
		    System.out.println("req2MD5="+dedupMD52);
	
		    //去除时间参数比对，MD5相同
		    String dedupMD53 = new ReqDedupHelper().dedupParamMD5(req1,"requestTime");
		    String dedupMD54 = new ReqDedupHelper().dedupParamMD5(req2,"requestTime");
		    System.out.println("dedupMD53 = "+ dedupMD53);
		    System.out.println("dedupMD54="+dedupMD54);
	}
	
	
	

}
