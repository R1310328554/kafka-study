package lk;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by luokai on 2017/10/26.
 */

@Controller
public class KafkaController {

    @RequestMapping("aa")
    public String method() {
        System.out.println("true = " + true);
        return "hello";

    }
}
