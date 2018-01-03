package huxi;

import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ProducerMain implements Runnable {

    // 每个线程维护私有的KafkaConsumer实例
    private final KafkaProducer<String, String> producer;

    public static void main(String[] args) {
        String brokerList = "192.168.31.129:9092";
        String groupId = "";
        String topic = "test";
        ProducerMain producerMain = new ProducerMain(brokerList, groupId, topic);
        Thread t1 = new Thread(producerMain);
        Thread t2 = new Thread(producerMain);
        Thread t3 = new Thread(producerMain);

        t1.start();
        t2.start();
        t3.start();

    }

    public ProducerMain(String brokerList, String groupId, String topic) {
        Properties props = new Properties();

//        ProducerConfig.BOOTSTRAP_SERVERS_CONFIG
//        broker.list
        props.put("bootstrap.servers", brokerList);
        props.put("group.id", groupId);
        props.put("topic", topic);
        props.put("enable.auto.commit", "true");        //本例使用自动提交位移
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        this.producer = new KafkaProducer<>(props);
//        producer.subscribe(Arrays.asList(topic));   // 本例使用分区副本自动分配策略
    }

    @Override
    public void run() {

        int cnt = 0;
        while (cnt++ < 100) {
            ProducerRecord<String, String> record = new ProducerRecord<String, String>("test", " value");
            Future<RecordMetadata> send = producer.send(record);

//            producer.send(new ProducerRecord<String, String>(TOPIC, data)).get();


            try {
                RecordMetadata recordMetadata = send.get();
                int partition = recordMetadata.partition();
                System.out.println(Thread.currentThread().getName() + "     partition = " + partition);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
//


        }
    }
}
