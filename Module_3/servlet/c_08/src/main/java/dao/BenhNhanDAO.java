package dao;

import model.BenhNhan;
import model.HosoBenhAn;
import utilities.CreateConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BenhNhanDAO implements  IDAObenhnhan{
    private static final String SELECT_BENH_NHAN = "select * from benh_nhan;";
    private static final String REMOVE_BENH_NHAN = "delete from benh_nhan where id=?;";
    private static final String UPDATE_BENH_NHAN = "update benh_nhan set ten_benh_nhan=?,ly_do_nhap_vien = ? where id=?;";

    @Override
    public List<BenhNhan> listBenhNhan() {
        CreateConnection createConnection = new CreateConnection();
        List<BenhNhan> benhNhanList = new ArrayList<>();
        Connection connection = createConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BENH_NHAN);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String tenBenhNhan = resultSet.getString("ten_benh_nhan");
                String ly_do_nhap_vien = resultSet.getString("ly_do_nhap_vien");
                String maBenhAn = resultSet.getString("ma_benh_an");
                BenhNhan benhNhan = new BenhNhan(id, tenBenhNhan, ly_do_nhap_vien, maBenhAn);
                benhNhanList.add(benhNhan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return benhNhanList;
    }

    @Override
    public void removeBenhNhan(BenhNhan maBenhNhan) {
        CreateConnection createConnection = new CreateConnection();
        Connection connection = createConnection.getConnection();
        try {
            List<BenhNhan> benhNhanList = listBenhNhan();
            PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_BENH_NHAN);
            preparedStatement.setString(1, maBenhNhan.getMaBenhNhan());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateBenhNhan(BenhNhan maBenhNhan) {
        CreateConnection createConnection = new CreateConnection();
        Connection connection = createConnection.getConnection();
        try {
            List<BenhNhan> benhNhanList = listBenhNhan();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BENH_NHAN);
            preparedStatement.setString(1, maBenhNhan.getTenBenhNhan());
            preparedStatement.setString(2, maBenhNhan.getLiDoNhapvien());
            preparedStatement.setString(3, maBenhNhan.getMaBenhNhan());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
