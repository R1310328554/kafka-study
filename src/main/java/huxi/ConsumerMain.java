package huxi;

public class ConsumerMain {

    public static void main(String[] args) {
        String brokerList = "192.168.31.129:9092";
        String groupId = "testGroup2";
        String topic = "test2";
        int consumerNum = 3;

        ConsumerGroup consumerGroup = new ConsumerGroup(consumerNum, groupId, topic, brokerList);
        consumerGroup.execute();
    }
}