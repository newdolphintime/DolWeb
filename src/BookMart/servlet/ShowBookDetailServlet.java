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

/**
 * Created by Zv on 2017/05/01.
 */
@WebServlet(name = "ShowBookDetailServlet", urlPatterns = "/showbookdetailservlet")
public class ShowBookDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //1.显示书的详细信息
        //拿到页面传递的id
        String id = request.getParameter("id");
        //根据id获取书
        Book book = BookUtils.getBookById(id);
        //显示信息
        out.write(book + "&nbsp;&nbsp;<a href = '" + request.getContextPath() + "/showallbookservlet'>返回主页继续浏览</a><a href = '" +
                request.getContextPath() + "/buyservlet?id=" + id + "'>放入购物车</a><br>");
    }
}
