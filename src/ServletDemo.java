import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by Zv on 2017/04/24.
 */

public class ServletDemo extends HttpServlet {
    String name;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        name = config.getInitParameter("name");

        Enumeration<String> enumeration = config.getInitParameterNames();
        while (enumeration.hasMoreElements()) {
            String name = enumeration.nextElement();
            System.out.println(name + "" + config.getInitParameter(name));
        }


    }

    //服务方法
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletOutputStream servletOutputStream = resp.getOutputStream();
        byte[] bytes = "你好 中国".getBytes("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        servletOutputStream.write(bytes);

    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
