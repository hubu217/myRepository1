package sy.util;



import java.util.Arrays;

import java.util.Collections;

import java.util.List;



/**

 * 类名称：CodeUtil

 * 类描述：  生成码工具

 * @author ex-hubo

 */

public class CodesUtil {



  

	

	/**

	 * @see 生成八位数的随机验证码(数字+英文)

	 * @param len 验证码的位数

	 * @return

	 */

	public static String generateRamdomVerifyCode(int len) {

		

		 String generateCode = "";

		 String[] codeArr = new String[] {"0","1","2","3","4","5","6","7","8","9", "a","b","c","d","e","f","g","h","i","j","k","m","n","l","o","p","q","r","s","t","u","v","w","x","y","z"}; 

		 List<String> codeList = Arrays.asList(codeArr);

		 //打乱codeList内容

		 Collections.shuffle(codeList);  

		 StringBuilder sbCode = new StringBuilder();

		 for(String smsCode :codeList) {

			 sbCode.append(smsCode);

		 }

		 String smsCodeStr = sbCode.toString();

		 generateCode = smsCodeStr.substring(0, len);

		

		return generateCode;

	}

	

	

	

}



