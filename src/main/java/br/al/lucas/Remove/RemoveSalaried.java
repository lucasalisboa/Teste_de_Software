package br.al.lucas.Remove;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RemoveSalaried implements RemoveEmployers {
    @Override
    public boolean remove(Connection payroll, int id) {
        String sql = "ddelete from assalariado where id_empregado = ?";
        try {
            PreparedStatement stmt = payroll.prepareStatement(sql);
            stmt.setInt(1,id);
            stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
