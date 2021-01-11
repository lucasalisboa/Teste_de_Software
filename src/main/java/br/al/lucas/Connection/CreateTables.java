package br.al.lucas.Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTables {

    public Connection con;

    public CreateTables(Connection connection){
        con = connection;
    }

    public boolean createEmployers(){
        String sql = "create table empregados(id_empregado int primary key auto_increment, \n" +
                "    nome varchar(50) not null, \n" +
                "    endereco varchar (50) not null, \n" +
                "    metodo_pagamento varchar(50) not null, \n" +
                "    tipo_funcionario varchar(50) not null, \n" +
                "    pertence_sindicato varchar(50) not null,\n" +
                "    data_pagamento date not null\n" +
                ");";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.execute(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        }

    public boolean createHourist(){
        String sql = "create table horista(\n" +
                "    id_horista int key primary key auto_increment, \n" +
                "    hora_salario decimal (10, 2) not null, \n" +
                "    salario decimal (10, 2) not null default 0, \n" +
                "    id_empregado int not null unique, \n" +
                "    foreign key (id_empregado) references empregados(id_empregado)\n" +
                ");";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.execute(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean createSalaried(){
        String sql = "create table assalariado (\n" +
                "    id_assalariado int key primary key auto_increment, \n" +
                "    salario decimal(10, 2) not null, \n" +
                "    id_empregado int not null unique, \n" +
                "    foreign key (id_empregado) references empregados(id_empregado)\n" +
                ");";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.execute(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean createCommissioned(){
        String sql = "create table comissionado(\n" +
                "    id_comissionado int key primary key auto_increment, \n" +
                "    salario decimal(10, 2) not null, \n" +
                "    taxa_venda int not null, \n" +
                "    total_vendas decimal(10, 2) not null default 0, \n" +
                "    id_empregado int not null unique, \n" +
                "    foreign key (id_empregado) references empregados(id_empregado)\n" +
                ");";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.execute(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
