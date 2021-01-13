package br.al.lucas.Update;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateMethod implements Update {
    @Override
    public boolean change(Connection payroll, int id, String new_info) {
        String sql = "update empregados set metodo_pagamento = ? where id_empregado = ?";
        try {
            PreparedStatement stmt = payroll.prepareStatement(sql);
            stmt.setString(1,new_info);
            stmt.setInt(2,id);
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
