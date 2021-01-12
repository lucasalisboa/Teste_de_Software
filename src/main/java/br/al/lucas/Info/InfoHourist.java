package br.al.lucas.Info;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InfoHourist implements Info {
    @Override
    public boolean info(Connection payroll, int id) {
        String sql = "select * from horista where id_empregado = ?";
        try {
            PreparedStatement stmt = payroll.prepareStatement(sql);
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            System.out.println(rs);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
