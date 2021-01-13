package br.al.lucas.Menu;

import br.al.lucas.Info.Info;
import br.al.lucas.Info.InfoCommissioned;
import br.al.lucas.Info.InfoHourist;
import br.al.lucas.Info.InfoSalaried;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ShowInfo implements Command  {

    public Scanner sc;
    ArrayList<Info> infos;

    public ShowInfo(){
        sc = new Scanner(System.in);
        infos = new ArrayList<>();
        infos.add(new InfoHourist());
        infos.add(new InfoSalaried());
        infos.add(new InfoCommissioned());
    }

    @Override
    public void execute(Connection payroll, MyCalendar calendar) {
        System.out.println("WHAT'S IS EMPLOYER ID?");
        int id = scanner_int();
        info(payroll,id);
    }

    public boolean info(Connection payroll, int worker_id){
        String sql = "select * from empregados where id_empregado = ?";
        try {
            PreparedStatement stmt = payroll.prepareStatement(sql);
            stmt.setInt(1,worker_id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            System.out.println("ID:"+ rs.getString(1));
            System.out.println("NAME:"+ rs.getString(2));
            System.out.println("ADRESS:"+ rs.getString(3));
            System.out.println("PAYMENT METHOD:"+ rs.getString(4));
            System.out.println("TYPE:"+ rs.getString(5));
            String type = rs.getNString(5);
            if (type.equals("horista")){
                infos.get(0).info(payroll,worker_id);
            }
            else if(type.equals("assalariado")){
                infos.get(1).info(payroll,worker_id);
            }
            else{
                infos.get(2).info(payroll,worker_id);
            }
            System.out.println("-----------");
            return true;
        } catch (SQLException e) {
            System.out.println("Erro na Consulta");
            System.out.println("-----------");
            return false;
        }
    }

    public int scanner_int(){
        return sc.nextInt();
    }

}
