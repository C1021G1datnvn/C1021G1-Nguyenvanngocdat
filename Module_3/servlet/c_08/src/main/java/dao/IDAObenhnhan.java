package dao;

import model.BenhNhan;
import model.HosoBenhAn;

import java.util.List;

public interface IDAObenhnhan {
    List<BenhNhan> listBenhNhan();

    void removeBenhNhan(BenhNhan maBenhNhan);

    void updateBenhNhan(BenhNhan maBenhNhan);

}
