import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * kafka读写测试类
 * @author miaohongbin
 * @version
 * Date: 2016年6月24日 下午6:22:38 <br/>
 * @since
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {  "classpath:spring-kafka-producer.xml"})
public class KafkaTest {

    @Autowired
    private KafkaTemplate kafkaTemplate;
    // org.springframework.integration.kafka.core.KafkaTemplate
    // org.springframework.kafka.core.KafkaTemplate

    /**
     * 向kafka里写数据.<br/>
     * @author miaohongbin
     * Date:2016年6月24日下午6:22:58
     */
    @Test
    public void testTemplateSend(){
        kafkaTemplate.send("t2", "hello");

//        kafkaTemplate.sendDefault("haha111");
    }

}