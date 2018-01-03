package lk;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;

/**
 * @author liuzh
 * @since 2017/6/17.
 */
@Controller
public class SampleController2 {

    public static Logger logger = LoggerFactory.getLogger(SampleController2.class);

    @Autowired
    private KafkaTemplate<String, String> template;


    @KafkaListener(id = "t1", topics = "t1")
    public void listenT1(ConsumerRecord<?, ?> cr) throws Exception {
        logger.info("{} - {} : {}", cr.topic(), cr.key(), cr.value());
    }

    @KafkaListener(id = "t2", topics = "t2" , containerGroup = "kafka-group5")
    public void listenT2(ConsumerRecord<?, ?> cr) throws Exception {
        System.out.println("cr = " + cr);
        logger.info("AA {} - {} : {}", cr.topic(), cr.key(), cr.value());
    }
    @KafkaListener(id = "t3", topics = "t2", containerGroup = "kafka-group0")
    public void listenT3(ConsumerRecord<?, ?> cr) throws Exception {
        System.out.println("cr = " + cr);
        logger.info("BB {} - {} : {}", cr.topic(), cr.key(), cr.value());
    }

    @KafkaListener(id = "t4", topics = "t2", containerGroup = "kafka-group1")
    public void listenT53(ConsumerRecord<?, ?> cr) throws Exception {
        System.out.println("cr = " + cr);
        logger.info("CC {} - {} : {}", cr.topic(), cr.key(), cr.value());
    }

    @KafkaListener(id = "t8", topics = "t2", containerGroup = "kafka-group2")
    public void listenT454(ConsumerRecord<?, ?> cr) throws Exception {
        System.out.println("cr = " + cr);
        logger.info("{} - {} : {}", cr.topic(), cr.key(), cr.value());
    }

}