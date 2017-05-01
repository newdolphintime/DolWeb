package BookMart.servlet;

import BookMart.bean.Book;
import BookMart.util.BookUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import static BookMart.util.BookUtils.getAllBook;

/**
 * Created by Zv on 2017/05/01.
 */
@WebServlet(name = "ShowAllBookServlet", urlPatterns = "/showallbookservlet")
public class ShowAllBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.write("本站有以下好书：<br>");

        Map<String, Book> map = BookUtils.getAllBook();
        for (Map.Entry<String, Book> entry : map.entrySet()) {
            //拿到每一本的id
            String id = entry.getKey();
            //拿到每一本书
            Book book = entry.getValue();
            //输出书的名字
            out.write(book.getBookName() + "&nbsp;&nbsp;<a href = '" +
                    request.getContextPath() + "/showbookdetailservlet?id=" + id + "'>显示详细信息</a><br>");
        }
        out.write("<br><br><br><br>") ;

        //提供查看购物车的连接
        out.write("<a href = '"+ request.getContextPath()+"/carservlet'>查看购物车</a>") ;

    }
}
