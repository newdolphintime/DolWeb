package BookMart.servlet;

import BookMart.bean.Book;
import BookMart.util.BookUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zv on 2017/05/01.
 */
@WebServlet(name = "BuyServlet",urlPatterns = "/buyservlet")
public class BuyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8") ;
        response.setContentType("text/html;charset=UTF-8") ;
        PrintWriter out = response.getWriter() ;

        //获取页面传递的id
        String id = request.getParameter("id") ;

        //根据id找到书对象
        Book book = BookUtils.getBookById(id) ;

        //将书存入session对象中
        HttpSession session  = request.getSession() ;

        //将书放入session中的一个集合中
        List<Book> list = (List<Book>) session.getAttribute("carlist") ;

        if(list == null){
            //说明第一次购买书籍，此时session中是不存在list集合，需要手动创建
            list = new ArrayList<Book>() ;
            //将购买的书籍放入
            book.setCount(1) ;
            list.add(book) ;

            //将list存入session
            session.setAttribute("carlist", list) ;
        }else{
            //说明已经购买过书籍了
            //判断购物车中是否已经购买过此书
            int index = list.indexOf(book) ;
            if(index == -1){
                //说明没有买过此书
                book.setCount(1) ;
                list.add(book) ;
            }else{
                //说明买过了
                Book b = list.get(index) ;
                b.setCount(b.getCount() + 1) ;

            }


        }
        //提醒用户，此书已经放入购物车中
        out.write(book.getBookName() + " 已经放入购物车中,4秒后转向主页，低级<a href = '"+request.getContextPath()+"/showallbookservlet'>此处</a>直接转向主页") ;
        response.setHeader("Refresh", "4;url="+ request.getContextPath() + "/showallbookservlet") ;
    }
}
