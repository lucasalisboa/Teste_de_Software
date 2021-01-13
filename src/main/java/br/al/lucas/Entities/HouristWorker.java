package br.al.lucas.Entities;

import br.al.lucas.Menu.MyCalendar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class HouristWorker extends Worker {
    private double hour_salary;

    public double point(Connection payroll,int worker_id,int hours)
    {
        if(hours > 0){
            String sql_1 = "update horista set salario=? where id_empregado=?";
            String sql_2 = "select * from horista where id_empregado = ?";
            try {
                PreparedStatement stmt_2 = payroll.prepareStatement(sql_2);
                stmt_2.setInt(1,worker_id);
                ResultSet pst = stmt_2.executeQuery();
                if(pst.next()) {
                    double hora_salario = pst.getDouble(2);
                    double aux_salario = pst.getDouble(3);
                    aux_salario = aux_salario + (hora_salario * hours);
                    PreparedStatement stmt_1 = payroll.prepareStatement(sql_1);
                    stmt_1.setInt(2, worker_id);
                    stmt_1.setDouble(1, aux_salario);
                    stmt_1.execute();
                    stmt_1.close();
                    pst.close();
                    stmt_2.close();
                    return aux_salario;
                }
                else{
                    return -1;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return -1;
            }
        }
        else{
            return -1;
        }
    }

    @Override
    public Calendar newPayDay_Pattern(Date today)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        int week = 6 - cal.get(Calendar.DAY_OF_WEEK);
        Calendar aux = Calendar.getInstance();
        aux.setTime(today);
        if(week > 0)
        {
            aux.add(Calendar.DAY_OF_MONTH,week);
        }
        else
        {
            aux.add(Calendar.DAY_OF_MONTH,7 + week);
        }
        return aux;
    }

    @Override
    public void payment(Date today)
    {

    }

}
