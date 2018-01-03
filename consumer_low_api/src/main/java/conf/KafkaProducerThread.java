package conf;
import java.util.Properties;  
import java.util.concurrent.TimeUnit;  
  
import kafka.javaapi.producer.Producer;  
import kafka.producer.KeyedMessage;  
import kafka.producer.ProducerConfig;  
import kafka.serializer.StringEncoder;  
  
  
  
  
public class KafkaProducerThread extends Thread{
  
    private String topic;  
      
    public KafkaProducerThread(String topic){
        super();  
        this.topic = topic;  
    }  
      
      
    @Override  
    public void run() {  
        Producer producer = createProducer();  
        int i=0;  
        while(true){  
            producer.send(new KeyedMessage<Integer, String>(topic, "message: " + i++)); 
            System.out.println("message: " + i);
            try {  
                TimeUnit.SECONDS.sleep(1);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
  
    private Producer createProducer() {  
        Properties properties = new Properties();  
        properties.put("zookeeper.connect", "192.168.31.129:2181");//声明zk  
        properties.put("serializer.class", StringEncoder.class.getName());  
        properties.put("metadata.broker.list", "192.168.31.129:9092");// 声明kafka broker  
        return new Producer<Integer, String>(new ProducerConfig(properties));  
    }


    public static void main(String[] args) {  
        new KafkaProducerThread("test").start();// 使用kafka集群中创建好的主题 test
       // System.out.println("111");
          
    }  
       
}