package test.mq.mq1;



import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import test.UserVo;
import test.mq.ConnectionUtil;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
 
/**
 * 模式1：简单模式
 */
public class Sender {
	
	
	
	
	
    private final static String QUEUE_NAME = "simple_queue";
    private final static String TEST_SIMPLE_QUEUE = "test_simple_queue";
    
    
    
 
    public static void main(String[] args) throws IOException, TimeoutException {
    	
        //创建连接
        Connection connection = ConnectionUtil.getConnection();
        //创建通道
        Channel channel = connection.createChannel();
        //声明队列
        /**
         * 队列名
         * 是否持久化
         *  是否排外  即只允许该channel访问该队列   一般等于true的话用于一个队列只能有一个消费者来消费的场景
         *  是否自动删除  消费完删除
         *  其他属性
         *
         */
        channel.queueDeclare(TEST_SIMPLE_QUEUE, false, false, false, null);
 
        //消息内容
        /**
         * 交换机
         * 队列名
         * 其他属性  路由
         * 消息body
         */
        for(int i=0;i<5000;i++) {
        	
        	   UserVo userVo = new UserVo();
        	   userVo.setName("name-"+i);
        	   userVo.setAge(String.valueOf(i));
        	   userVo.setSex("男");
        	
	        	String message = JSON.toJSONString(userVo);
	        	channel.basicPublish("", TEST_SIMPLE_QUEUE,null,message.getBytes());
	        	
	        	System.out.println("【生产者】-"+i+":"+message );
        	
        }
        //最后关闭通关和连接
        channel.close();
        connection.close();
 
 
    }
}