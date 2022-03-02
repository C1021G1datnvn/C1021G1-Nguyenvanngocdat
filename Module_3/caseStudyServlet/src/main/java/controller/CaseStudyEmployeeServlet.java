package controller;

import model.employee.Employee;
import model.employee.Posision;
import service.employee.impl.EmployeeImpl;
import service.employee.impl.PosisionImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CaseStudyEmployeeServlet", value = "/Employee")
public class CaseStudyEmployeeServlet extends HttpServlet {
    EmployeeImpl employee = new EmployeeImpl();
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
                showUpdate(request ,response);
                break;
            default:
                showList(request, response);
                break;
        }
    }

    private void showUpdate(HttpServletRequest request, HttpServletResponse response) {
        int employee_id = Integer.parseInt(request.getParameter("employee_id"));
        Employee employee1 = employee.selectEmployee(employee_id);
        request.setAttribute("employee", employee1);
        try {
            request.getRequestDispatcher("employee/update.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("employee/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request,  HttpServletResponse response) {
        List<Employee> employeeList = employee.selectAll();
        request.setAttribute("employee", employeeList);
        try {
            request.getRequestDispatcher("employee/list.jsp").forward(request, response);
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
                create(request ,response);
                break;
            case "delete":
                delete(request ,response);
                break;
            case "update":
                update(request, response);
                break;
            case "search":
                search(request, response);
                break;
            default:
                showList(request, response);
                break;
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String employee_name = request.getParameter("employee_name");
        List<Employee> employeeList = employee.search(employee_name);
        request.setAttribute("employee", employeeList);
        try {
            request.getRequestDispatcher("employee/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        int employee_id = Integer.parseInt(request.getParameter("employee_id"));
        String employee_name = request.getParameter("employee_name");
        String employee_birthday = request.getParameter("employee_birthday");
        String employee_id_card = request.getParameter("employee_id_card");
        double employee_salary = Double.parseDouble(request.getParameter("employee_salary"));
        String employee_phone = request.getParameter("employee_phone");
        String employee_email = request.getParameter("employee_email");
        String employee_address = request.getParameter("employee_address");
        int position_id = Integer.parseInt(request.getParameter("position_id"));
        int education_degree_id = Integer.parseInt(request.getParameter("education_degree_id"));
        int division_id = Integer.parseInt(request.getParameter("division_id"));
        Employee employee2 = new Employee(employee_id,employee_name, employee_birthday,employee_id_card, employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id);
        employee.update(employee2);
        try {
            response.sendRedirect("/Employee");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        employee.delete(id);
        try {
            response.sendRedirect("/Employee");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        String employee_name = request.getParameter("employee_name");
        String employee_birthday = request.getParameter("employee_birthday");
        String employee_id_card = request.getParameter("employee_id_card");
        double employee_salary = Double.parseDouble((request.getParameter("employee_salary")));
        String employee_phone = request.getParameter("employee_phone");
        String employee_email = request.getParameter("employee_email");
        String employee_address = request.getParameter("employee_address");
        int position_id = Integer.parseInt(request.getParameter("position_id"));
        int education_degree_id = Integer.parseInt(request.getParameter("education_degree_id"));
        int division_id = Integer.parseInt(request.getParameter("division_id"));
        Employee employee1 = new Employee(employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id);
        employee.create(employee1);
        try {
            response.sendRedirect("/Employee");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
