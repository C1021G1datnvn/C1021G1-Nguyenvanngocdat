package controller;

import service.CalculatorService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", value = "/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       Double firstNumber = Double.valueOf(request.getParameter("firstOperand"));
       Double lastNumber = Double.valueOf(request.getParameter("lastOperand"));
       String operator = request.getParameter("operator");
       Double result = CalculatorService.result(firstNumber, operator, lastNumber);
       request.setAttribute("result", result);
       request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}
