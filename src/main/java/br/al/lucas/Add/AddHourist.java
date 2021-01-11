package br.al.lucas.Add;

import br.al.lucas.Entities.HouristWorker;
import br.al.lucas.Menu.MyCalendar;
import br.al.lucas.Menu.Operation;

import java.sql.*;
import java.util.Calendar;

public class AddHourist extends Operation implements AddEmployer {

    @Override
    public boolean add(Connection payroll, String nome, String endereco, String metodo_pag, boolean sindicato, MyCalendar data_hoje, double salario, double hora_trabalho, int taxa_venda) {
        String sql = "insert into empregados(nome,endereco,metodo_pagamento,tipo_funcionario,pertence_sindicato,data_pagamento) values(?,?,?,?,?,?)";
        HouristWorker horista = new HouristWorker();
        Calendar data_pag = horista.newPayDay_Pattern(data_hoje.today);
        try {
            PreparedStatement stmt = payroll.prepareStatement(sql);
            stmt.setString(1,nome);
            stmt.setString(2,endereco);
            stmt.setString(3,metodo_pag);
            stmt.setString(4,"horista");
            if(sindicato){
                stmt.setString(5,"Sim");
            }
            else
            {
                stmt.setString(5,"Nao");

            }
            stmt.setDate(6, (Date) data_pag.getTime());
            stmt.execute(sql);
            ResultSet pst = stmt.getGeneratedKeys();
            int id = 0;
            if(pst.next()){
                id = pst.getInt(1);
            }
            sql = "insert into horista(salario,hora_salario,id_empregado) values(?,?,?)";
            PreparedStatement new_stmt = payroll.prepareStatement(sql);
            new_stmt.setDouble(1,salario);
            new_stmt.setDouble(2,hora_trabalho);
            new_stmt.setInt(3,id);
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
