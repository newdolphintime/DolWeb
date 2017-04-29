import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Zv on 2017/04/29.
 */
public class ServletDemo3 extends HttpServlet {
    private int sum = 0;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    //线程安全测试 在两个浏览器测试

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        sum++;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        response.getWriter().write(sum+"");
        //第一种方式
        //response.setStatus(302);
        //response.setHeader("Location","/DolWeb/demo2");
        response.sendRedirect("/DolWeb/demo2");
    }
}
