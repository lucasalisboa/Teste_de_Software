package br.al.lucas.Update;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateSyndicate implements Update {
    @Override
    public boolean change(Connection payroll, int id, String new_info) {
        String sql = "update empregados set pertence_sindicato = ? where id_empregado = ?";

        try {
            PreparedStatement stmt = payroll.prepareStatement(sql);
            if(new_info == "Sim" || new_info == "Nao"){
                stmt.setString(1,new_info);
                stmt.setInt(2,id);
                stmt.execute();
                stmt.close();
                return true;
            }
            else{
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
