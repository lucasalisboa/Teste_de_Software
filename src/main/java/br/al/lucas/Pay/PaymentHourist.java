package br.al.lucas.Pay;

import br.al.lucas.Entities.HouristWorker;
import br.al.lucas.Menu.MyCalendar;

import java.sql.*;
import java.util.Calendar;

public class PaymentHourist implements Payment {
    public HouristWorker houristWorker;

    public PaymentHourist(){
        houristWorker = new HouristWorker();
    }

    @Override
    public double pay(Connection payroll, int id_worker, MyCalendar calendar) {
        String sql_1 = "select salario from horista where id_empregado = ?";
        String sql_2 = "update salario=0 from horista where id_empregado = ?";
        String sql_3 = "update data_pagamento=? from empregado where id_empregado = ?";

        double salary;
        try {
            PreparedStatement stmt_1 = payroll.prepareStatement(sql_1);
            PreparedStatement stmt_2 = payroll.prepareStatement(sql_2);
            PreparedStatement stmt_3 = payroll.prepareStatement(sql_3);
            stmt_1.setInt(1,id_worker);
            stmt_2.setInt(1,id_worker);
            stmt_3.setInt(2,id_worker);
            ResultSet rs = stmt_1.executeQuery();
            salary =  rs.getDouble(1);
            Calendar new_date = houristWorker.newPayDay_Pattern(calendar.today);
            stmt_3.setDate(1,(Date)new_date.getTime());
            stmt_2.executeQuery();
            stmt_3.executeQuery();
            return salary;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
