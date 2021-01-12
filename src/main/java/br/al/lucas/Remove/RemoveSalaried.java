package br.al.lucas.Remove;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RemoveSalaried implements RemoveEmployers {
    @Override
    public boolean remove(Connection payroll, int id) {
        String sql = "delete from assalariado where id_empregado = ?";
        try {
            PreparedStatement stmt = payroll.prepareStatement(sql);
            stmt.setInt(1,id);
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException e) {
//            e.printStackTrace();
            return false;
        }
    }
}
