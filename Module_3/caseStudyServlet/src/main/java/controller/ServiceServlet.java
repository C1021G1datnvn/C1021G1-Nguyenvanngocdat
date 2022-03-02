package controller;

import com.sun.corba.se.impl.orb.PrefixParserAction;
import model.service.Service;
import service.service.impl.ServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServiceServlet", value = "/Service")
public class ServiceServlet extends HttpServlet {
    ServiceImpl service = new ServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null ) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreate(request, response);
                break;
            default:
                listService(request, response);
                break;
        }
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("service/create.jsp").forward(request ,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listService(HttpServletRequest request, HttpServletResponse response) {
        List<Service> list = service.selectAllService();
        request.setAttribute("serviceList", list);
        try {
            request.getRequestDispatcher("service/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null ) {
            action = "";
        }
        switch (action) {
            case "create":
                create(request, response);
                break;
            default:
                listService(request, response);
                break;
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        String service_name = request.getParameter("service_name");
        int service_area = Integer.parseInt(request.getParameter("service_area"));
        double service_cost = Double.parseDouble(request.getParameter("service_cost"));
        int service_max_people = Integer.parseInt(request.getParameter("service_max_people"));
        String standard_room = request.getParameter("standard_room");
        String description_other_convenience = request.getParameter("description_other_convenience");
        double pool_area = Double.parseDouble(request.getParameter("pool_area"));
        int number_of_floors = Integer.parseInt(request.getParameter("number_of_floors"));
        int rent_type_id = Integer.parseInt(request.getParameter("rent_type_id"));
        int service_type_id = Integer.parseInt(request.getParameter("service_type_id"));
        Service service1 = new Service(service_name, service_area, service_cost, service_max_people, standard_room, description_other_convenience, pool_area, number_of_floors, rent_type_id, service_type_id);
        service.create(service1);
        try {
            response.sendRedirect("/Service");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
