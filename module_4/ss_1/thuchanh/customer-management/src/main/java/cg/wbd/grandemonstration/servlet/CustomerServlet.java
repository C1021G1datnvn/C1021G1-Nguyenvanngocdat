package cg.wbd.grandemonstration.servlet;

import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.service.CustomerService;
import cg.wbd.grandemonstration.service.CustomerServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CustomerServlet extends HttpServlet {
    private CustomerService customerService = CustomerServiceFactory.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
            if (action == null) {
                action = "";
            }
            switch (action) {
                case "create":
                    break;
                default:
                    showList(request, response);
                    break;
            }
    }
    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> list = customerService.findAll();
        request.setAttribute("customers", list
        );
        try {
            request.getRequestDispatcher("customers/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String action = req.getParameter("action");
            if (action == null) {
                action = "";
            }
            switch (action) {
                case "create":
                    break;
                default:
                    showList(req, resp);
                    break;
        }
    }
}
