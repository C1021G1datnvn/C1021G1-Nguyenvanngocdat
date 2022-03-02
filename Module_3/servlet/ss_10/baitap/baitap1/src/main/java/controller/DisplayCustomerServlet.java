package controller;

import modlue.Customer;

import  javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "controller.DisplayCustomerServlet", value = "/DisplayCustomerServlet")
public class DisplayCustomerServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("Mai Văn Hoàng", "1983-08-20", "Hà Nội", "https://vcdn-thethao.vnecdn.net/2021/12/13/2-jpeg-1639413745-3590-1639413816.jpg"));
        customerList.add(new Customer("Nguyễn Văn Nam", "1983-08-01", "Đà Nẵng", "https://www.sport.fr/wp-content/uploads/2021/12/Icon_012614_0023-1.jpg"));
        customerList.add(new Customer("Nguyễn Thái Hoà", "1983-08-22", "Quảng trị", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRaZWMzMMhE0_0fkHtkGucfuzKPmJ5UWNWUu13aZ7nBZ8mUj4Bm6w9eyJnqwq_ld-pDexE&usqp=CAU"));
        customerList.add(new Customer("Trần Đăng Khoa", "1983-08-17", "Hải Phòng", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRyZPRLyQdWt8WfJt-ihW-OyV3inAC__OWBwL0G0di96GXCyDQ_9ih37HlvaA6YIMHITkE&usqp=CAU"));
        customerList.add(new Customer("Nguyễn Đình Thi", "1983-08-19", "Hà Nội", "https://akm-img-a-in.tosshub.com/indiatoday/images/story/201806/2018-06-15T195245Z_1515619905_RC14D54DD3B0_RTRMADP_3_SOCCER-WORLDCUP-POR-ESP.png?cjmDY3v7yNxwfzrbC2TR2gVTAN1j7kyt&size=770:433"));
        request.setAttribute("customer",customerList);
        request.getRequestDispatcher("displayCustomer.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
