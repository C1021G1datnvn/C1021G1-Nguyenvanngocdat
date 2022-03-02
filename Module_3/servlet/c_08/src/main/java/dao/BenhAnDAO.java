package dao;

import model.BenhAn;
import model.BenhNhan;
import utilities.CreateConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BenhAnDAO implements IDAObenhan{
    private static final String SELECT_BENH_AN = "select * from benh_an;";
    private static final String REMOVE_BENH_AN = "delete from benh_an where id=?;";
    private static final String UPDATE_BENH_AN = "update benh_an set ngay_nhap_vien=?,ngay_ra_vien = ? where id=?;";

    @Override
    public List<BenhAn> listBenhAn() {
            CreateConnection createConnection = new CreateConnection();
            List<BenhAn> benhAnList = new ArrayList<>();
            Connection connection = createConnection.getConnection();
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BENH_AN);
                System.out.println(preparedStatement);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    String id = resultSet.getString("id");
                    String ngayNhapVien = resultSet.getString("ngay_nhap_vien");
                    String ngayRaVien = resultSet.getString("ngay_ra_vien");
                    BenhAn benhAn = new BenhAn(id,ngayNhapVien,ngayRaVien);
                    benhAnList.add(benhAn);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return benhAnList;
    }
    public BenhAn benhAn(String maBenhAn) {
        List<BenhAn> benhAnList = listBenhAn();
        for (BenhAn benhAn : benhAnList) {
            if (benhAn.getMaBenhAn().equals(maBenhAn)) {
                return benhAn;
            }
        }
        return null;
    }

    @Override
    public void removeBenhAn(String maBenhAn) {

    }

    @Override
    public void updateBenhAn(BenhAn maBenhAn) {
        CreateConnection createConnection = new CreateConnection();
        Connection connection = createConnection.getConnection();
        try {
            List<BenhAn> benhAnList = listBenhAn();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BENH_AN);
            preparedStatement.setString(1, maBenhAn.getNgayNhapVien());
            preparedStatement.setString(2, maBenhAn.getNgayRaVien());
            preparedStatement.setString(3, maBenhAn.getMaBenhAn());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
