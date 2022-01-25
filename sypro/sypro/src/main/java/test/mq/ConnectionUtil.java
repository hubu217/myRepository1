package test.mq;


import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
 
/**
 * RabbitMQ连接（公共的连接方法，其他模式共用此方法）
 */
public class ConnectionUtil {
	
	
	
	
    public static Connection getConnection() throws IOException, TimeoutException {
    	
        //连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("66.112.223.21");
        //连接5672端口  注意15672为工具界面端口  25672为集群端口
        factory.setPort(5672);
        factory.setVirtualHost("/");
        factory.setUsername("admin");
        factory.setPassword("admin");
        //获取连接
        Connection connection = factory.newConnection();
 
        return connection;
 
    }
}