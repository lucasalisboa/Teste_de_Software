package br.al.lucas.Menu;


import br.al.lucas.Add.AddEmployer;
import br.al.lucas.Remove.RemoveCommissioned;
import br.al.lucas.Remove.RemoveEmployers;
import br.al.lucas.Remove.RemoveHourist;
import br.al.lucas.Remove.RemoveSalaried;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Remove implements Command {

    public List<RemoveEmployers> removeEmployers;
    Scanner sc;
    public Remove() {
        removeEmployers = new ArrayList<>();
        removeEmployers.add(0,new RemoveHourist());
        removeEmployers.add(1,new RemoveSalaried());
        removeEmployers.add(2, new RemoveCommissioned());
        sc = new Scanner(System.in);
    }

    @Override
    public void execute(Connection payroll, MyCalendar calendar) {
        System.out.println("WHAT'S IS EMPLOYER ID?");
        int id = scanner_int();
        remove(payroll,id);
        }


    public boolean remove(Connection payroll,int id) {
        String sql_1 = "select tipo_funcionario from empregados where id_empregado = ?";
        String sql_2 = "delete from empregados where id_empregado = ?";
        try {
            PreparedStatement stmt_1 = payroll.prepareStatement(sql_1);
            PreparedStatement stmt_2 = payroll.prepareStatement(sql_2);
            stmt_1.setInt(1, id);
            ResultSet pst = stmt_1.executeQuery();
            pst.next();
            if (pst.getString(1).equals("horista")) {
                removeEmployers.get(0).remove(payroll, id);
            } else if (pst.getString(1).equals("assalariado")) {
                removeEmployers.get(1).remove(payroll, id);
            } else if (pst.getString(1).equals("comissionado")) {
                removeEmployers.get(2).remove(payroll, id);
            }
            stmt_2.setInt(1, id);
            stmt_2.execute();
            stmt_1.close();
            stmt_2.close();
            pst.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int scanner_int(){
        return sc.nextInt();
    }

}
