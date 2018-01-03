import java.util.Properties;

 

import kafka.javaapi.producer.Producer;

import kafka.producer.KeyedMessage;

import kafka.producer.ProducerConfig;

 

public class ProducerDemo {

    public static void main(String[] args) throws Exception {

       Properties props = new Properties();

       props.put("zk.connect", "192.168.31.129:2181");

       props.put("metadata.broker.list","192.168.31.129:9092");

       props.put("serializer.class", "kafka.serializer.StringEncoder");

       ProducerConfig config = new ProducerConfig(props);

       Producer<String, String> producer = new Producer<String, String>(config);

 

       // 发送业务消息

       // 读取文件 读取内存数据库 读socket端口

       for (int i = 1; i <= 100; i++) {

           Thread.sleep(500);

           System.out.println("i = " + i);

           producer.send(new KeyedMessage<String, String>("t3",

                  "i said i love you baby for" + i + "times,will you have a nice day with me tomorrow"));

       }

 

    }

}