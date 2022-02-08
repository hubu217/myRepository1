package test.mq.mq2;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import test.UserVo;
import test.mq.ConnectionUtil;



/**
 * 
 * @author asus
 * 模式2：工作模式（Work单发送 多接收）
 *
 */
public class Producter {
	
	
	
	
			private final static String QUEUE_NAME = "work_queue";
			
			
		
			public static void main(String[] args) throws IOException, TimeoutException {
				
					//获取连接
					Connection connection = ConnectionUtil.getConnection();
					//声明信道
					Channel channel = connection.createChannel();
					//队列申明,durable：true消息持久化
					channel.queueDeclare(QUEUE_NAME, true, false, false, null);
					
					for(int i = 0; i < 5000; i++) {
							//消息内容
							UserVo user = new UserVo();
							user.setName("name-"+i);
							user.setAge(String.valueOf(i));
							user.setSex("男");
							String message =JSON.toJSONString(user);
							
							//发布消息
							//basicPublish(String exchange, String routingKey, BasicProperties props, byte[] body)
							channel.basicPublish("", QUEUE_NAME, null, message.getBytes("utf-8"));
							System.out.println("【生产者】-"+i+":"+message);
					}
					//关闭通道
					channel.close();
					//连接关闭
					connection.close();
			}
			
			
}
