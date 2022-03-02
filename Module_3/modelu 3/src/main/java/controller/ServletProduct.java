package controller;
import model.Category;
import model.Product;
import service.CategoryServiceImpl;
import service.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controller.Servlet", value = "/product")
public class ServletProduct extends HttpServlet {
    ProductServiceImpl productService = new ProductServiceImpl();
    CategoryServiceImpl categoryService = new CategoryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreate(request, response);
                break;
            case "update":
                showUpdate(request,response);
            default:
                listProduct(request, response);
                break;


        }

    }

    private void showUpdate(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product customer = productService.finById(id);
        request.setAttribute("list",customer);
        List<Category> categoryList = categoryService.selectAll();
        request.setAttribute("categoryList",categoryList);
        try {
            request.getRequestDispatcher("update.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = productService.finAll();
        request.setAttribute("productList",productList);
        try {
            request.getRequestDispatcher("list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        List<Category> categoryList = categoryService.selectAll();
        request.setAttribute("categoryList", categoryList);
        try {
            request.getRequestDispatcher("create.jsp").forward(request,response);
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
        if (action == null){
            action ="";
        }
        switch (action){
            case "create":
                createProduct(request,response);
                break;
            case "delete":
                deleteProduct(request,response);
                break;
            case "update":
                updateProduct(request,response);
                break;
            case "search":
                search(request,response);
                break;
            case "searchColor":
                searchColor(request,response);
                break;

        }
    }

    private void searchColor(HttpServletRequest request, HttpServletResponse response) {
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        List<Product> productList = productService.searchName(name);
        request.setAttribute("productList",productList);
        try {
            request.getRequestDispatcher("list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String nameProduct = request.getParameter("nameproduct");
        Double price = Double.valueOf(request.getParameter("price"));
        int quantily = Integer.parseInt(request.getParameter("quantily"));
        String color = request.getParameter("color");
        int idcategory = Integer.parseInt(request.getParameter("idcategory"));
        Product product = new Product(id,nameProduct,price,quantily,color,idcategory);
        productService.update(product);

        try {
            response.sendRedirect("/product");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        String nameProduct = request.getParameter("name");
        Double price = Double.valueOf(request.getParameter("price"));
        int quantily = Integer.parseInt(request.getParameter("quantily"));
        String color = request.getParameter("color");
        int idCategory = Integer.parseInt(request.getParameter("idCategory"));
        Product product = new Product(nameProduct,price,quantily,color,idCategory);
        productService.create(product);
        try {
            response.sendRedirect("/product");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.remove(id);
        try {
            response.sendRedirect("/product");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

