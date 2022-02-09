package test.mq5;


import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import test.mq.ConnectionUtil;

/**
 * 模式5：通配符（或主题）模式（Topics ，按topic发送接收)
 * 符号“#”匹配一个或多个词，符号“*”仅匹配一个词。
 * @author asus
 *
 */
public class Producter {
	
	
	
	
	private static final String EXCHANGE_NAME = "topic_exchange";
	
	
	
	
	public static void main(String[] args) throws IOException, TimeoutException {
		
				Connection connection = ConnectionUtil.getConnection();
				Channel channel =connection.createChannel();
				//声明交换机类型为topic
				channel.exchangeDeclare(EXCHANGE_NAME, "topic");
				
				for(int i=0;i<10;i++) {
					
						String message = "";
						
						message = "发布了一条中国新闻 消息-"+i;
						channel.basicPublish(EXCHANGE_NAME, "china.news", null, message.getBytes());
						System.out.println(message);
						message = "发布了一条中国天气 消息-"+i;
						channel.basicPublish(EXCHANGE_NAME, "china.weather", null, message.getBytes());
						System.out.println(message);
						
						message = "发布了一条美国新闻 消息-"+i;
						channel.basicPublish(EXCHANGE_NAME, "usa.news", null, message.getBytes());
						System.out.println(message);
						message = "发布了一条美国天气 消息-"+i;
						channel.basicPublish(EXCHANGE_NAME, "usa.weather", null, message.getBytes());
						System.out.println(message);
						
						message = "发布了一条美国天气.天气1 消息-"+i;
						channel.basicPublish(EXCHANGE_NAME, "usa.weather.weather1", null, message.getBytes());
						System.out.println(message);
						message = "发布了一条美国天气.天气1.天气2.天气3 消息-"+i;
						channel.basicPublish(EXCHANGE_NAME, "usa.weather.weather1.weather2.weather3", null, message.getBytes());
						System.out.println(message);
				}
				
	}
	
}

