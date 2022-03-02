package controller;

import dao.BenhAnDAO;
import dao.BenhNhanDAO;
import model.BenhAn;
import model.BenhNhan;
import model.HosoBenhAn;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CenterServlet", value = "/CenterServlet")
public class CenterServlet extends HttpServlet {

    BenhNhanDAO idaoBenhNhan = new BenhNhanDAO();
    BenhAnDAO idaoBenhAn = new BenhAnDAO();
    public List<HosoBenhAn> hosoBenhAnList = new ArrayList<>();
    public List<BenhNhan> benhNhanList = idaoBenhNhan.listBenhNhan();
    public List<BenhAn> benhAnList = idaoBenhAn.listBenhAn();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "delete":
                showDelete(request, response);
                break;
            case "update":
                showUpdate(request, response);
                break;
            default:
                listBenhAn(request, response);
                break;
        }

    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maBenhAn = request.getParameter("maBenhAn");

    }


    private void showUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maBenhAn = request.getParameter("maBenhAn");
        for (HosoBenhAn hosoBenhAn : hosoBenhAnList) {
            if (hosoBenhAn.getMaBenhAn().equals(maBenhAn)) {
                request.setAttribute("update", hosoBenhAn);
            }
        }
        request.getRequestDispatcher("Hospital/update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "delete":
                break;
            case "update":
                update(request, response);
                break;
            default:
                listBenhAn(request, response);
                break;
        }
    }

    private void listBenhAn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        hosoBenhAnList.clear();
        for (BenhNhan benhNhan : benhNhanList) {
            HosoBenhAn hosoBenhAn = new HosoBenhAn();
            hosoBenhAn.setMaBenhNhan(benhNhan.getMaBenhNhan());
            hosoBenhAn.setTenBenhNhan(benhNhan.getTenBenhNhan());
            hosoBenhAn.setLidoNhapVien(benhNhan.getLiDoNhapvien());
            hosoBenhAn.setMaBenhAn(benhNhan.getMaBenhAn());
            BenhAn benhAn = idaoBenhAn.benhAn(benhNhan.getMaBenhAn());
            hosoBenhAn.setNgayNhapVien(benhAn.getNgayNhapVien());
            hosoBenhAn.setNgayRaVien(benhAn.getNgayRaVien());
            hosoBenhAnList.add(hosoBenhAn);
        }
        request.setAttribute("hosoBenhAn", hosoBenhAnList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Hospital/list.jsp");
        dispatcher.forward(request, response);
    }
    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maBenhAn = request.getParameter("maBenhAn");
        String maBenhNhan = request.getParameter("maBenhNhan");
        String tenBenhNhan = request.getParameter("tenBenhNhan");
        String ngayNhapVien = request.getParameter("ngayNhapVien");
        String ngayRaVien = request.getParameter("ngayRaVien");
        String liDoNhapVien = request.getParameter("liDoNhapVien");
        for (HosoBenhAn hosoBenhAn1: hosoBenhAnList) {
            if (hosoBenhAn1.getMaBenhAn().equals(maBenhAn)) {
                hosoBenhAn1.setTenBenhNhan(tenBenhNhan);
                hosoBenhAn1.setNgayNhapVien(ngayNhapVien);
                hosoBenhAn1.setNgayRaVien(ngayRaVien);
                hosoBenhAn1.setLidoNhapVien(liDoNhapVien);
                BenhNhan benhNhan = new BenhNhan(maBenhNhan, tenBenhNhan, liDoNhapVien, maBenhAn);
                BenhAn benhAn = new BenhAn(maBenhAn, ngayNhapVien, ngayRaVien);
                idaoBenhNhan.updateBenhNhan(benhNhan);
                idaoBenhAn.updateBenhAn(benhAn);
            }
        }
        request.setAttribute("hosoBenhAn", hosoBenhAnList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Hospital/list.jsp");
        dispatcher.forward(request, response);
    }
}
