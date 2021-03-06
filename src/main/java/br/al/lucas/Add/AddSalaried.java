package br.al.lucas.Add;

import br.al.lucas.Entities.HouristWorker;
import br.al.lucas.Entities.SalariedWorker;
import br.al.lucas.Menu.MyCalendar;
import br.al.lucas.Menu.Operation;

import java.sql.*;
import java.util.Calendar;

public class AddSalaried implements AddEmployer {

    @Override
    public boolean add(Connection payroll, String nome, String endereco, String metodo_pag, boolean sindicato, MyCalendar data_hoje, double salario, double hora_trabalho, int taxa_venda) {
        String sql = "insert into empregados(nome,endereco,metodo_pagamento,tipo_funcionario,pertence_sindicato,data_pagamento) values(?,?,?,?,?,?)";
        SalariedWorker assalariado = new SalariedWorker();
        Calendar data_pag = assalariado.newPayDay_Pattern(data_hoje.today);

        try {
            PreparedStatement stmt = payroll.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1,nome);
            stmt.setString(2,endereco);
            stmt.setString(3,metodo_pag);
            stmt.setString(4,"assalariado");
            if(sindicato){
                stmt.setString(5,"Sim");
            }
            else
            {
                stmt.setString(5,"Nao");

            }
            stmt.setDate(6, new Date(data_pag.getTime().getTime()));
            stmt.execute();
            ResultSet pst = stmt.getGeneratedKeys();
            int id = 0;
            if(pst.next()){
                id = pst.getInt(1);
            }
            sql = "insert into assalariado(salario,id_empregado) values(?,?)";
            PreparedStatement new_stmt = payroll.prepareStatement(sql);
            new_stmt.setDouble(1,salario);
            new_stmt.setInt(2,id);
            new_stmt.execute();
            stmt.close();
            new_stmt.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
