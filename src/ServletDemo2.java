import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Zv on 2017/04/27.
 */

public class ServletDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("你也来了");
        String path = getServletContext().getRealPath("\\WEB-INF\\classes\\美铝.jpg");
        InputStream inputStream = new FileInputStream(path);
        byte[] bytes = new byte[1024];
        int b = 0;
        ServletOutputStream servletOutputStream = response.getOutputStream();
        while ((b = inputStream.read(bytes)) != -1) {
            servletOutputStream.write(bytes, 0, b);
        }
    }
}
