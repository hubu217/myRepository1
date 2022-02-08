package test.mq.mq3;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import test.mq.ConnectionUtil;


/**
 * 
 * @author asus
 * 模式3：发布、订阅模式(Publish/Subscribe)
 *
 */
public class Producter {
	
	
	

	private final static String EXCHANGE_NAME = "publishSubscrible_exchange";
	
	
	
	
	public static void main(String[] args) throws IOException, TimeoutException {
		
				Connection connection = ConnectionUtil.getConnection();
				Channel channel = connection.createChannel();
				//声明交换机Exchange类型为fanout
				channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
				
				for(int i=0;i<50;i++) {
						String message = "publish/subscrible; 消息:"+i;
						channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
						System.out.println("发布订阅 生产者 生产："+message);
					
				}
				channel.close();
				connection.close();
	}
}
