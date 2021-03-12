package sy.test;

import java.util.Arrays;

import com.alibaba.fastjson.JSON;

import sy.test.vo.Demo;
  
/**
 *   <B>说 明<B/>:SM2非对称加解密工具类测试
 */
public class Test2 {
  
    /** 元消息串 */
    private static String text = "哈哈哈，&*&…………&、、//\\!@#$%^&*()物品woyebuzhidaowozijiqiaodesha!@#$%^&*())))))ooooooooppppppppppppppppppplllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkffffffffffffffffffffffffffffffffffffff";
   
    
    
    
   
     
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
    	
		
		 
		 
        
        
        
        Demo demo = new Demo();
        demo.setCard_grade("1");
        demo.setCard_id("441424198803184918");
        demo.setCard_name("陈健权");
        demo.setCard_type("1");
        demo.setCode_channel("苏证通APP");
        demo.setPhone("15986653991");
        demo.setPhoto_begin("15");
        
        
       
        
        
        
        
        
        String text2 = JSON.toJSONString(demo);
        
        System.out.println("text2="+text2);
        
        
        
        
        SM2Util sm2 = new SM2Util(); 
		  SM2KeyPair keyPair = sm2.generateKeyPair();
		  byte[] data = sm2.encrypt(text2,keyPair.getPublicKey());
		  System.out.println("data is:"+Arrays.toString(data)); //
		 // 71017045908707391874054405929626258767106914144911649587813342322113806533034
		  sm2.decrypt(data, keyPair.getPrivateKey());
    }
     
}