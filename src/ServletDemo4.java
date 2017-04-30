import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by Zv on 2017/04/30.
 */
@WebServlet(name = "ServletDemo4", urlPatterns = "/demo4")
public class ServletDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getOutputStream().write("nimabi".getBytes());
        Enumeration<String> enumeration = request.getHeaderNames();
        while(enumeration.hasMoreElements()){
            String key = enumeration.nextElement();
            String requestHeader = key + ":" +request.getHeader(key);
            response.getOutputStream().write(requestHeader.getBytes());
            System.out.println(requestHeader);
        }
        String name = request.getParameter("name");
        System.out.println(name);
    }
}
