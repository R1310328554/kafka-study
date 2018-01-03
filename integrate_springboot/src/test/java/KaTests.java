import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.logging.Logger;

/**
 * Created by luokai on 2017/10/26.
 */
public class KaTests {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("kafka-consumer.xml,spring-kafka-producer.xml");
        Object aa = context.getBean("aa");
        System.out.println("aa = " + aa);

    }

}
