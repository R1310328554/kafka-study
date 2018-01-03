//package com.aa;
//
//import com.lk.guanfang.Listener;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.kafka.core.KafkaTemplate;
//
//import java.util.concurrent.TimeUnit;
//
//import static org.junit.Assert.assertTrue;
//
///**
// * Created by luokai on 2017/10/26.
// */
//public class Kawww {
//
//    public static void main(String[] args) {
//
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("kafka-consumer.xml,spring-kafka-producer.xml");
//        Object aa = context.getBean("aa");
//        System.out.println("aa = " + aa);
//
//    }
//
//    @Autowired
//    private Listener listener;
//
//    @Autowired
//    private KafkaTemplate<Integer, String> template;
//
//    @Test
//    public void testSimple() throws Exception {
//        waitListening("foo");
//        template.send("annotated1", 0, "foo");
//        assertTrue(this.listener.latch1.await(10, TimeUnit.SECONDS));
//    }
//
//
//}
