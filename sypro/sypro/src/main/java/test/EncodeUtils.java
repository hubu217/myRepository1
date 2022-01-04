package test;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
/**
 *
 *
 * @author YuanZL
 */
public class EncodeUtils {

    /**
     *
     *   加密-(SHA-256)(BASE64)
     * @author YuanZL
     */
    public static String encode(String content){
        String sign = "";
        try {
            MessageDigest md5 = MessageDigest.getInstance("SHA-256");//MD5
            BASE64Encoder BASE64Encoder = new BASE64Encoder();
            sign = BASE64Encoder.encode(md5.digest(content.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return sign;
    }


    /**
     *
     *   这个方法的作用是：http请求的参数出去sign的所有内容进行参数名排序
     * @author YuanZL
     */
    public static String getSortParams(Map<String, Object> params) {
//        params.remove("sign");
//        params.remove("method");
        String contnt = "";
        Set<String> keySet = params.keySet();
        List<String> keyList = new ArrayList<String>();
        for (String key : keySet) {
            String value = params.get(key)+"";
            // 将值为空的参数排除
			/*if (!StringUtil.isNull(value)) {
				keyList.add(key);
			}*/
            keyList.add(key);
        }
        Collections.sort(keyList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int length = Math.min(o1.length(), o2.length());
                for (int i = 0; i < length; i++) {
                    char c1 = o1.charAt(i);
                    char c2 = o2.charAt(i);
                    int r = c1 - c2;
                    if (r != 0) {
                        // char值小的排前边
                        return r;
                    }
                }
                // 2个字符串关系是str1.startsWith(str2)==true
                // 取str2排前边
                return o1.length() - o2.length();
            }
        });
        //将参数和参数值按照排序顺序拼装成字符串
        for (int i = 0; i < keyList.size(); i++) {
            String key = keyList.get(i);
            contnt += key + params.get(key);
        }
        return contnt;
    }

}
