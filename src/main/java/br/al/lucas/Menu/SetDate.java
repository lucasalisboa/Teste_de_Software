package br.al.lucas.Menu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SetDate implements Command {

    public Scanner sc;

    public SetDate(){
        sc = new Scanner(System.in);
    }

    @Override
    public void execute(Connection payroll, MyCalendar calendar) {
        System.out.println("WHAT'S IS EMPLOYER ID?");
        int id = scanner_int();
        String date_string = scanner_String();
        try {
            Date new_date = new SimpleDateFormat("dd/MM/yyyy").parse(date_string);
            setDate(payroll,id,new_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public int setDate(Connection payroll, int id, Date new_date){
        String sql = "update empregados set data_pagamento = ? where id_empregado = ?";
        try {
            PreparedStatement stmt = payroll.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(new_date.getTime()));
            stmt.setInt(2,id);
            int result = stmt.executeUpdate();
            stmt.close();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }

    }

    public int scanner_int(){
        return sc.nextInt();
    }

    public String scanner_String(){
        return sc.nextLine();
    }


}
