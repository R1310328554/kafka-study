import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;

/**
 * Created by luokai on 2017/10/15.
 */
public class Lk2Servlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("I am a get req  ");
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        public Object method(HttpServletRequest request, HttpServletResponse response, @RequestParam(required = false) String rname) {
//		request.getContentType()
        System.out.println("start ================================================== ");

//        request.setCharacterEncoding("GBK");

        String contentType = request.getContentType();
        System.out.println("contentType = " + contentType);
        String characterEncoding = request.getCharacterEncoding();
        System.out.println("characterEncoding = " + characterEncoding);

//        System.out.println("aaaaaaaaaa contentType = " + contentType);
        String rname = request.getParameter("rname");
        String zw = request.getParameter("zw");
        String bb = request.getParameter("bb");
        System.out.println("rname : " + rname);
        System.out.println(bb + "   zw = " + zw);

        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String line = "";
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }

        System.out.println("stringBuilder = " + stringBuilder.toString());

        Collection<Part> parts = request.getParts();
        for (Iterator<Part> iterator = parts.iterator(); iterator.hasNext(); ) {
            Part next =  iterator.next();
            System.out.println("next = " + next.getName());
        }


        String authType = request.getAuthType();
        System.out.println("authType = " + authType);


//        System.out.println("response = " + response);

        switch (rname) {
                case "1": response.setContentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE);break;
                case "2": response.setContentType(MediaType.APPLICATION_JSON_VALUE);break;
                case "3": response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);break;
                case "4": response.setContentType(MediaType.APPLICATION_XML_VALUE);break;
                case "5": response.setContentType(MediaType.APPLICATION_XHTML_XML_VALUE);break;
                case "6": response.setContentType(MediaType.ALL_VALUE);break;
                case "7": response.setContentType(MediaType.IMAGE_JPEG_VALUE);break;
                case "8": response.setContentType(MediaType.MULTIPART_FORM_DATA_VALUE);break;
                case "9": response.setContentType(MediaType.TEXT_PLAIN_VALUE);break;
                case "10": response.setContentType(MediaType.TEXT_HTML_VALUE);break;
                case "11": response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);break;
                case "12": response.setContentType(MediaType.APPLICATION_PDF_VALUE);break;
                case "13": response.setContentType(MediaType.TEXT_EVENT_STREAM_VALUE);break;
                default:
                    System.out.println("contentType = " + rname);

            }
//            response.setContentLength(123);
            User user = new User();
            user.setName("lk");
            user.setAge(31);

//            response.setContentLength(123456);
//            response.setCharacterEncoding("GBK-221");
            response.setCharacterEncoding("UTF-8");
            response.setStatus(211);

        PrintWriter out = response.getWriter();
        Enumeration e = request.getHeaderNames();
        while (e.hasMoreElements()) {
            String name = (String)e.nextElement();
//            System.out.println("name = " + name);
            String value = request.getHeader(name);
//            out.println(name + " = " + value);
        }

        out.println("{\"aa\":123, \"bb\":\"你好啊\"}");
        out.close();
//            return user;

        System.out.println("end ================================================== ");

    }

    public String method(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Enumeration e = request.getHeaderNames();
        while (e.hasMoreElements()) {
            String name = (String)e.nextElement();
            String value = request.getHeader(name);
            out.println(name + " = " + value);
        }
        return "";
    }
}
