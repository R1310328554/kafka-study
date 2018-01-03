import kafka.admin.TopicCommand;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by luokai on 2017/10/16.
 */
public class TestKfk {

    public static void main(String[] args) {
        String[] options = new String[]{
                "--list",
                "--zookeeper",
//                "10.20.10.157:2181"};
                "192.168.31.129:2181"};

                ByteArrayOutputStream byteStream = new ByteArrayOutputStream(1024*3);
// cache stream
        PrintStream cacheStream = new PrintStream(byteStream);
// old stream
        PrintStream oldStream = System.out;



        System.setOut(cacheStream);

        TopicCommand.main(options);

        String message = byteStream.toString();
        List<String> ls = new ArrayList<String>();

        String[]ss = message.split("\n");
        ls = Arrays.asList(ss);

// Restore old stream
        System.setOut(oldStream);

        for(int i=0;i<ss.length;i++){//循环遍历转换后的list中的topic

            System.out.println(ls.get(i));
        }

}
}
