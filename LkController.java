package com.lk;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by luokai on 2017/10/26.
 */
@Controller
public class LkController {

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
//        binder.registerCustomEditor(int.class, new CustomNumberEditor(int.class, true));
        binder.registerCustomEditor(int.class, new IntegerEditor());
        binder.registerCustomEditor(long.class, new CustomNumberEditor(Long.class, true));
        binder.registerCustomEditor(long.class, new LongEditor());
        binder.registerCustomEditor(double.class, new DoubleEditor());
        binder.registerCustomEditor(float.class, new FloatEditor());
        binder.registerCustomEditor(Date.class, new DateEditor());

        // ConversionServiceFactoryBean  的区别？
    }

    @RequestMapping("ee")
    public String aaas(double dd, Date date, Long longa) throws IOException {
        System.out.println("dd = [" + dd + "], date = [" + date + "], longa = [" + longa + "]");

        return "asdf";
    }

    @RequestMapping("aa")
    public String method(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("22 = " + true);


//        response.sendError(HttpServletResponse.SC_FORBIDDEN, "AdditionalInformationIfAvailable");


//        throw new org.springframework.security.access.AccessDeniedException("403 returned");
//        response.setStatus(403);

//        response.set
//        int aa = 3/0;

        String aa = null;

        System.out.println("aa = " + aa.length());

        return "vv";
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String bb() {
        System.out.println("bbbbbb = " + true);

        return "aa";
    }

    @ExceptionHandler({NullPointerException.class,IndexOutOfBoundsException.class})
    public String ddd() {
        System.out.println("cccc");
        return "";
    }

    public String ccc() {
        System.out.println("cccc");
        return "";
    }
}
