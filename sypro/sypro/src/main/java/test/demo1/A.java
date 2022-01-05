package test.demo1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class A {
	
	
	
	
	public static void main(String[] args) {
		
		String  str ="{\r\n"
				+ "	\"vaccineList\": [\r\n"
				+ "		{\r\n"
				+ "			\"vaccineCount\": \"3\",\r\n"
				+ "			\"inoculateDate\": \"2021-12-23 14:19:48\",\r\n"
				+ "			\"lastStationName\": \"怡园社区卫生服务中心狂犬病暴露处置门诊\"\r\n"
				+ "		},\r\n"
				+ "		{\r\n"
				+ "			\"vaccineCount\": \"1\",\r\n"
				+ "			\"inoculateDate\": \"2021-06-23 13:05:11\",\r\n"
				+ "			\"lastStationName\": \"怡园社区卫生服务中心狂犬病暴露处置门诊\"\r\n"
				+ "		},\r\n"
				+ "		{\r\n"
				+ "			\"vaccineCount\": \"2\",\r\n"
				+ "			\"inoculateDate\": \"2021-06-01 14:52:41\",\r\n"
				+ "			\"lastStationName\": \"怡园社区卫生服务中心狂犬病暴露处置门诊\"\r\n"
				+ "		}\r\n"
				+ "	],\r\n"
				+ "	\"flag\": 1\r\n"
				+ "}";
		
		
		JSONObject jsonObj = JSONObject.parseObject(str);
		
		System.out.println("jsonObj排序前="+JSON.toJSONString(jsonObj));
		Object vaccineList=  jsonObj.get("vaccineList");
		
	    List<VaccineVo> list = (List<VaccineVo>) JSONArray.parseArray(JSON.toJSONString(vaccineList), VaccineVo.class);

			//System.out.println("排序前 list="+JSON.toJSONString(list));
			
					
			Collections.sort(list,new Comparator<VaccineVo>() {

				@Override
				public int compare(VaccineVo o1, VaccineVo o2) {
					String c1=o1.getVaccineCount();
					String c2 = o2.getVaccineCount();
					System.out.println(c1+" "+c2);
					int count1 = Integer.parseInt(o1.getVaccineCount());
					int count2 = Integer.parseInt(o2.getVaccineCount());
					
					
					return count2-count1;
				}

				
				
			});
		
			//System.out.println("排序后 list="+JSON.toJSONString(list));
			
			
			jsonObj.put("vaccineList", list);
			
			System.out.println("jsonObj排序后="+JSON.toJSONString(jsonObj));
		
		
	}

}
