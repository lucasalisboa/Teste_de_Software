package br.al.lucas.Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteTables {
    public Connection con;

    public DeleteTables(Connection connection){
        con = connection;
    }

    public boolean deleteEmployers(){
        String sql = "drop table empregados";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.execute(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteHourist(){
        String sql = "drop table horista";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.execute(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteSalaried(){
        String sql = "drop table assalariado";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.execute(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteCommissioned(){
        String sql = "drop table comissionado";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.execute(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
