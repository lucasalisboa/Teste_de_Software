package br.al.lucas.Menu;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Remove extends Operation implements Command {
    public Remove() {
        super();
    }

    @Override
    public void execute(Connection payroll, MyCalendar calendar) {
        String sql_1 = "select * from empregados where id_empregado = ?";
        try {
            PreparedStatement stmt = payroll.prepareStatement(sql_1);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
