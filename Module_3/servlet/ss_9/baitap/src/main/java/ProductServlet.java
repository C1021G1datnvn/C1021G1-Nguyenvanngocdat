import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProductServlet", value = "/calculator")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameProduct = request.getParameter("nameProduct");
        float price = Float.parseFloat(request.getParameter("price"));
        int discountPercent = Integer.parseInt(request.getParameter("discountPercent"));
        float discountAmount = (float) (price*discountPercent*0.01);
        float discountPrice = price-discountAmount;

        request.setAttribute("calculator", discountPrice);
        request.getRequestDispatcher("result.jsp").forward(request, response);
//        PrintWriter printWriter = response.getWriter();
//        printWriter.write("<html>");
//        printWriter.write("<body>");
//        printWriter.write("<h1> Name Product: " + nameProduct + "</h1>" );
//        printWriter.write("<h1> List Price: " + price + "</h1>" );
//        printWriter.write("<h1> Discount Percent: " + discountPercent + "</h1>" );
//        printWriter.write("<h1> Discount Amount: " + discountAmount + "</h1>" );
//        printWriter.write("<h1> Discount Price: " + discountPrice + "</h1>" );
//        printWriter.write("</body>");
//        printWriter.write("</html>");

    }
}
