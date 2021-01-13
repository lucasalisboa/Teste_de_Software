package br.al.lucas.Update;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateAdress implements Update {
    @Override
    public int change(Connection payroll, int id, String new_info) {
        String sql = "update empregados set endereco = ? where id_empregado = ?";
        try{
            PreparedStatement stmt = payroll.prepareStatement(sql);
            stmt.setString(1,new_info);
            stmt.setInt(2,id);
            int result = stmt.executeUpdate();
            stmt.close();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
