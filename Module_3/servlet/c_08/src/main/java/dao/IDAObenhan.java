package dao;

import model.BenhAn;

import java.util.List;

public interface IDAObenhan {

    List<BenhAn> listBenhAn();

    void removeBenhAn(String maBenhAn);

    void updateBenhAn(BenhAn maBenhAn);
}
