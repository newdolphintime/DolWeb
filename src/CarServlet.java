import BookMart.bean.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Zv on 2017/05/01.
 */
@WebServlet(name = "CarServlet",urlPatterns = "/carservlet")
public class CarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8") ;
        response.setContentType("text/html;charset=UTF-8") ;
        PrintWriter out = response.getWriter() ;

        HttpSession session = request.getSession() ;
        //如果用户直接在地址栏中输入地址访问此servlet,那此时session是一个新创建的对象
        if(session.isNew()){
            //直接返回主页面
            response.sendRedirect(request.getContextPath() + "/showallbookservlet") ;
            return ;
        }

        //先从session拿到购物车
        List<Book> list = (List<Book>)session.getAttribute("carlist") ;
        //如果用户直接从主页面上点击查看购物车过来,此时还没有购买任何书籍呢，所以提示用户会主页
        if(list == null){
            //用户首次访问购物车
            out.write("你还没有购买任何书籍呢，看个鸟啊,2秒后转向主页") ;
            response.setHeader("Refresh", "2;url="+ request.getContextPath() + "/showallbookservlet") ;
            return ;
        }

        //说明购买了书籍
        out.write("你购买的书籍如下：<br> ") ;
        out.write("书名\t数量\t总价格<br>") ;
        for (int i = 0; i < list.size(); i++) {
            Book b = list.get(i) ;
            out.write(b.getBookName() + "\t" + b.getCount() + "\t" + b.getPrice() * b.getCount() + "<br>") ;
        }


        out.write("<br><br><a href = '" +request.getContextPath()+ "/showallbookservlet'>返回主页面</a>") ;
    }
}
