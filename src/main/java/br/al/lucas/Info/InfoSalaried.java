package br.al.lucas.Info;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InfoSalaried implements Info {
    @Override
    public boolean info(Connection payroll, int id) {
        String sql = "select * from assalariado where id_empregado = ?";
        try {
            PreparedStatement stmt = payroll.prepareStatement(sql);
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            System.out.println("ID-SALARIED:"+ rs.getString(1));
            System.out.println("SALARY:"+ rs.getString(2));
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
