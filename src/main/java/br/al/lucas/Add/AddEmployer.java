package br.al.lucas.Add;

import br.al.lucas.Menu.MyCalendar;

import java.sql.Connection;

public interface AddEmployer {
    public boolean add(Connection payroll, String nome, String endereco, String metodo_pag, boolean sindicato, MyCalendar data_hoje, double salario, double hora_trabalho, int taxa_venda);

}