package br.al.lucas.Menu;


import br.al.lucas.Pay.Payment;
import br.al.lucas.Pay.PaymentCommissioned;
import br.al.lucas.Pay.PaymentHourist;
import br.al.lucas.Pay.PaymentSalaried;

import java.sql.*;
import java.util.ArrayList;

public class RunPayroll implements Command {
    public ArrayList<Payment> payments;

    public RunPayroll(){
        payments = new ArrayList<>();
        payments.add(0,new PaymentHourist());
        payments.add(1,new PaymentSalaried());
        payments.add(2,new PaymentCommissioned());
    }

    @Override
    public void execute(Connection payroll, MyCalendar calendar) {
        pay(payroll,calendar);
    }
    public boolean pay(Connection payroll, MyCalendar calendar){
        String sql_1 = "select nome,id_empregado,tipo_funcionario,pertence_sindicato from empregados where data_pagamento = ?";
        try {
            PreparedStatement stmt_1 = payroll.prepareStatement(sql_1);
            stmt_1.setDate(1, new Date(calendar.today.getTime()));
            ResultSet result = stmt_1.executeQuery();
            while (result.next()){
                String name = result.getString(1);
                int id_worker = result.getInt(2);
                String type = result.getNString(3);
                boolean syndicate;
                double salary;
                if(result.getString(4).equals("Sim")){
                    syndicate = true;
                }
                else{
                    syndicate = false;
                }
                if (type.equals("horista")){
                    salary = payments.get(0).pay(payroll,id_worker,calendar);
                }
                else if(type.equals("assalariado")){
                    salary = payments.get(1).pay(payroll,id_worker,calendar );
                }
                else{
                    salary = payments.get(2).pay(payroll,id_worker,calendar );
                }
                System.out.println("NAME:"+name);
                System.out.println("ID:"+id_worker);
                System.out.println("GROSS SALARY:"+salary);
                if (syndicate){
                    salary = salary - salary*0.125;
                }
                System.out.println("NET SALARY:"+salary);
                System.out.println("----------");
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
}
