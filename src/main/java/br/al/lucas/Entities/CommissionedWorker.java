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

    public double newSale(Connection payroll, int worker_id, double valor_venda) {
        if(valor_venda > 0){
            String sql_1 = "update comissionado set total_vendas=? where id_empregado=?";
            String sql_2 = "select * from comissionado where id_empregado = ?";
            try {
                PreparedStatement stmt_2 = payroll.prepareStatement(sql_2);
                stmt_2.setInt(1, worker_id);
                ResultSet pst = stmt_2.executeQuery();
                if (pst.next()) {
                    double taxa_venda = pst.getDouble(2);
                    double aux_salario = pst.getDouble(3);
                    aux_salario = aux_salario + (valor_venda * taxa_venda / 100);
                    PreparedStatement stmt_1 = payroll.prepareStatement(sql_1);
                    stmt_1.setInt(2, worker_id);
                    stmt_1.setDouble(1, aux_salario);
                    stmt_1.execute();
                    stmt_1.close();
                    stmt_2.close();
                    pst.close();
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
    public Calendar newPayDay_Pattern(Date today) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        int week = 6 - cal.get(Calendar.DAY_OF_WEEK);
        Calendar aux = Calendar.getInstance();
        aux.setTime(today);
        if (week > 0) {
            aux.add(Calendar.DAY_OF_MONTH, week + 7);
        } else {
            aux.add(Calendar.DAY_OF_MONTH, 14 + week);
        }
        return aux;
    }

    @Override
    public void payment(Date today) {
//        double salary = base_salary + sales;
//        System.out.println("PAYMENT: " +(salary - (salary*getSyndicate_tax()/100) ));
//        check_schedule(today);
    }
}
