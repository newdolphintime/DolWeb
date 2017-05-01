import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Zv on 2017/05/01.
 */
@WebServlet(name = "ServletSession2", urlPatterns = "/session2")
public class ServletSession2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession httpSession = request.getSession();
        String name = (String) httpSession.getAttribute("name");
        System.out.println(name);
        response.getOutputStream().write(name.getBytes("UTF-8"));
    }
}
