import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Zv on 2017/05/01.
 */
@WebServlet(name = "ServletCookie1", urlPatterns = "/cookie1")
public class ServletCookie1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write("上次访问时间");
        //拿到客户端的记录上次访问的时间的COOKIE
        //拿到客户端携带的所有COOKIE
        Cookie[] cookies = request.getCookies();
        //循环拿到需要的COOKIE
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            Cookie cookie = cookies[i];
            if (cookie.getName().equals("lastlogintime")) {
                String time = cookie.getValue();
                //将time转成long类型
                long t = Long.parseLong(time);
                //格式化日期
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                //创建date对象
                Date d =new Date(t);
                out.write(simpleDateFormat.format(d)+" "+"<a href='cookie2'>清除Cookie</a>");
            }
        }

        Cookie cookie = new Cookie("lastlogintime",new Date().getTime()+"");
        cookie.setPath(request.getContextPath());
        //只要设置了存活时间就将存储到硬盘上
        cookie.setMaxAge(30*24*6000);
        response.addCookie(cookie);

    }

}
