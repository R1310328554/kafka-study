package lk;

//import org.springframework.integration.kafka.core.KafkaMessage;
//import org.springframework.integration.kafka.listener.MessageListener;

import org.springframework.kafka.listener.MessageListener;

public class DemoKafkaConsumer implements MessageListener {
 
//    @Override
//    public void onMessage(ConsumerRecord<String, String> data) {
//        System.out.println("收到消息=====>" + data.value());
//    }

//    @Override
//    public void onMessage(KafkaMessage kafkaMessage) {
//        System.out.println("kafkaMessage = " + kafkaMessage);
//    }

    @Override
    public void onMessage(Object o) {
        System.out.println("o = " + o);

    }
}