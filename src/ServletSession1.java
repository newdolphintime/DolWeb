import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Zv on 2017/05/01.
 */
@WebServlet(name = "ServletSession1", urlPatterns = "/session1")
public class ServletSession1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession httpSession = request.getSession();
        String id = httpSession.getId();
        System.out.println(id);
        httpSession.setAttribute("name","张威");

        PrintWriter out = response.getWriter();
        out.write("<a href = '" + request.getContextPath() + "/session2'>返回主页继续浏览</a>");

    }
}
