package controller;

import model.customer.Customer;
import model.employee.Employee;
import service.customer.CustomerService;
import service.customer.CustomerTypeService;
import service.customer.impl.CustomerServiceImpl;
import service.customer.impl.CustomerTypeServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CaseStudyServlet", value = "/CaseStudy")
public class CaseStudyServlet extends HttpServlet {
    CustomerService customerService = new CustomerServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreate(request, response);
                break;
            case "update":
                showUpdate(request, response);
                break;
            default:
                listCustomer(request, response);
                break;
        }
    }

    private void showUpdate(HttpServletRequest request, HttpServletResponse response) {
        int customer_id = Integer.parseInt(request.getParameter("customer_id"));
        Customer customer = customerService.selectCustomer(customer_id);
        request.setAttribute("customer" , customer);
        try {
            request.getRequestDispatcher("customer/update.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("customer/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = customerService.findAll();
        request.setAttribute("customerList", customerList);
        try {
            request.getRequestDispatcher("customer/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                create(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "update":
                update(request, response);
                break;
            case "search":
                search(request, response);
                break;
            default:
                listCustomer(request, response);
                break;
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String customer_name = request.getParameter("customer_name");
        List<Customer> customerList = customerService.search(customer_name);
        request.setAttribute("customerList", customerList);
        try {
            request.getRequestDispatcher("customer/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        int customer_id = Integer.parseInt(request.getParameter("customer_id"));
        String customer_name = request.getParameter("customer_name");
        String customer_birthday = request.getParameter("customer_birthday");
        boolean customer_gender = Boolean.parseBoolean(request.getParameter("customer_gender"));
        String customer_id_card = request.getParameter("customer_id_card");
        String customer_phone = request.getParameter("customer_phone");
        String customer_email = request.getParameter("customer_email");
        String customer_address = request.getParameter("customer_address");
        int customer_type_id = Integer.parseInt(request.getParameter("customer_type_id"));
        Customer customer = new Customer(customer_id, customer_name, customer_birthday, customer_gender, customer_id_card
        , customer_phone, customer_email, customer_address, customer_type_id);
        customerService.update(customer);
        try {
            response.sendRedirect("/CaseStudy");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        customerService.delete(id);
        try {
            response.sendRedirect("/CaseStudy");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        String customer_name = request.getParameter("customer_name");
        String customer_birthday = request.getParameter("customer_birthday");
        boolean customer_gender = Boolean.parseBoolean(request.getParameter("customer_gender"));
        String customer_id_card = request.getParameter("customer_id_card");
        String customer_phone = request.getParameter("customer_phone");
        String customer_email = request.getParameter("customer_email");
        String customer_address = request.getParameter("customer_address");
        int customer_type_id = Integer.parseInt(request.getParameter("customer_type_id"));
        Customer customer = new Customer(customer_name, customer_birthday, customer_gender, customer_id_card,
                customer_phone, customer_email, customer_address, customer_type_id);
        customerService.create(customer);
        try {
            response.sendRedirect("/CaseStudy");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
