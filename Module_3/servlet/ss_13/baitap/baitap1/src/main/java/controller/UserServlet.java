package controller;

import model.User;
import service.UserImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/users")
public class UserServlet extends HttpServlet {
    UserImpl userIPML = new UserImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
            switch (action) {
                case "addUser":
                    showAddUser(request, response);
                    break;
                case "delete":
                    delete(request, response);
                    break;
                case "update":
                    showUpdate(request, response);
                    break;
                default:
                    listAllUser(request, response);
                    break;
            }
    }

    private void showUpdate(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userIPML.selectId(id);
        request.setAttribute("user", user);
        try {
            request.getRequestDispatcher("user/update.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listAllUser(HttpServletRequest request, HttpServletResponse response) {
        List<User> userList = this.userIPML.listUserAll();
        request.setAttribute("userList", userList);
        try {
            request.getRequestDispatcher("user/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "addUser":
                addUser(request, response);
                break;
            case "update":
                update(request, response);
                break;
            case "search":
                search(request, response);
                break;
            default:
                listAllUser(request, response);
                break;
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String country = request.getParameter("search");
        List<User> userList = userIPML.search(country);
        request.setAttribute("userList", userList);
        try {
            request.getRequestDispatcher("user/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(id, name, email, country);
        userIPML.update(user);
        try {
            response.sendRedirect("/users");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        userIPML.delete(id);
        List<User> lists = userIPML.listUserAll();
        request.setAttribute("userList", lists);
        try {
            request.getRequestDispatcher("user/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


        private void showAddUser(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("user/add.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addUser(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(name, email, country);
        userIPML.addUser(user);
        try {
            response.sendRedirect("/users");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
