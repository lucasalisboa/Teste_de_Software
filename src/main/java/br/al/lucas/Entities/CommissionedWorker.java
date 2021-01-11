package br.al.lucas.Entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

public class CommissionedWorker extends Worker {
    private double base_salary;
    private double sales;
    private double percent;

    public boolean newSale(Connection payroll, int worker_id,double valor_venda)
    {
        String sql_1 = "update comissionado set total_vendas=? where id_empregado=?";
        String sql_2 = "select * from comissionado where id_empregado = ?";
        try {
            PreparedStatement stmt_2 = payroll.prepareStatement(sql_2);
            stmt_2.setInt(1,worker_id);
            ResultSet pst = stmt_2.executeQuery();
            if(pst.next()){
                double taxa_venda = pst.getDouble(3);
                double aux_salario = pst.getDouble(4);
                aux_salario = aux_salario + (valor_venda * taxa_venda/100);
                PreparedStatement stmt_1 = payroll.prepareStatement(sql_1);
                stmt_1.setInt(2,worker_id);
                stmt_1.setDouble(1,aux_salario);
                stmt_1.executeQuery();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }
    public void setPercent()
    {
        System.out.println("HOW MANY PERCENTS FOR SALE?");
        percent = sc.nextDouble();
    }

    @Override
    public Calendar newPayDay_Pattern(Date today)
    {
        pay_schedule = Schedule.PATTERN;
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        int week = 6 - cal.get(Calendar.DAY_OF_WEEK);
        pay_day.setTime(today);
        if(week > 0)
        {
            pay_day.add(Calendar.DAY_OF_MONTH,week + 7);
        }
        else
        {
            pay_day.add(Calendar.DAY_OF_MONTH,14 + week);
        }
        return pay_day;
    }

    @Override
    public void payment(Date today)
    {
        double salary = base_salary + sales;
        System.out.println("PAYMENT: " +(salary - (salary*getSyndicate_tax()/100) ));
        check_schedule(today);
    }

    public double getBase_salary() {
        return base_salary;
    }

    public double getSales() {
        return sales;
    }

    public double getPercent() {
        return percent;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "CommissionedWorker{" +
                "base_salary=" + base_salary +
                ", sales=" + sales +
                ", percent=" + percent +
                '}';
    }
}
