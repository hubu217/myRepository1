package test.mq.mq1;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import test.mq.ConnectionUtil;


public class Receiver {
	
	
	
	
	private final static String QUEUE_NAME = "simple_queue";
	
	
	
	public static void main(String[] args) throws IOException, TimeoutException{
		
		//获取连接
		Connection connection = ConnectionUtil.getConnection();
		//声明信道
		Channel channel = connection.createChannel();
		//声明队列
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		//声明消费者
		Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body) throws IOException {
						
					String message = new String(body,"UTF-8");
					System.out.println("customer 消费消息："+message);
					
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		};
		channel.basicConsume(QUEUE_NAME, true,consumer);
	}
}


