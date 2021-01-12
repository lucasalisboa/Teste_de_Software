package br.al.lucas.Pay;

import br.al.lucas.Entities.SalariedWorker;
import br.al.lucas.Menu.MyCalendar;

import java.sql.*;
import java.util.Calendar;

public class PaymentSalaried implements Payment {

    public SalariedWorker salariedWorker;

    public PaymentSalaried(){
        salariedWorker = new SalariedWorker();
    }
    @Override
    public double pay(Connection payroll, int id_worker, MyCalendar calendar) {
        String sql_1 = "select salario from assalariado where id_empregado = ?";
        String sql_2 = "update data_pagamento=? from empregado where id_empregado = ?";

        double salary;
        try {
            PreparedStatement stmt_1 = payroll.prepareStatement(sql_1);
            PreparedStatement stmt_2 = payroll.prepareStatement(sql_2);
            stmt_1.setInt(1,id_worker);
            stmt_2.setInt(2,id_worker);
            ResultSet rs = stmt_1.executeQuery();
            salary =  rs.getDouble(1);
            Calendar new_date = salariedWorker.newPayDay_Pattern(calendar.today);
            stmt_2.setDate(1,(Date)new_date.getTime());
            stmt_2.executeQuery();
            return salary;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
