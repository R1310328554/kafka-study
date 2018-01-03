package conf;

import kafka.admin.AdminUtils;
import kafka.server.ConfigType;
import kafka.utils.ZkUtils;
import org.apache.kafka.common.security.JaasUtils;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @Date Apr 28, 2015
 *
 * @Author dengjie
 *
 * @Note Set param path
 */
public class ConfigureAPI {

    public interface KafkaProperties {
//        public final static String ZK = "10.211.55.15:2181,10.211.55.17:2181,10.211.55.18:2181";
        public final static String ZK = "192.168.31.129:2181";
//        public final static String ZK = "10.20.10.157:9092,10.20.10.158:9092";
//        public final static String ZK = "10.20.10.157:9092,10.20.10.158:9092";
        public final static String GROUP_ID = "test"; // customer_collection_data
        public final static String TOPIC = "test";
//        public final static String BROKER_LIST = "10.211.55.15:9092,10.211.55.17:9092,10.211.55.18:9092";
        public final static String BROKER_LIST = "192.168.31.129:9092";
        public final static int BUFFER_SIZE = 64 * 1024;
        public final static int TIMEOUT = 20000;
        public final static int INTERVAL = 10000;
    }

    public static void main(String[] args) {

        ZkUtils zkUtils = ZkUtils.apply(KafkaProperties.ZK, 3000, 3000, JaasUtils.isZkSecurityEnabled());

        // create
//        AdminUtils.createTopic(zkUtils, "t1", 1, 1, new Properties(), RackAwareMode.Enforced$.MODULE$);

        // get
        Properties props = AdminUtils.fetchEntityConfig(zkUtils, ConfigType.Topic(), "test");

        Set<Map.Entry<Object, Object>> entries = props.entrySet();
        for (Iterator<Map.Entry<Object, Object>> iterator = entries.iterator(); iterator.hasNext(); ) {
            Map.Entry<Object, Object> next =  iterator.next();
            System.out.println("next = " + next.getKey());
            System.out.println("next = " + next.getValue());
        }

//        Enumeration<Object> keys = props.keys();
//        while (keys.hasMoreElements()) {
//            Object o =  keys.nextElement();
//            System.out.println("o = " + o);
//        }
//
//        for (Object o : props.keySet()) {
//
//            System.out.println("o2 = " + o);
//        }

        zkUtils.close();


    }



}