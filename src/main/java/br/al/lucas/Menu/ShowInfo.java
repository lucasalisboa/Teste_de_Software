package br.al.lucas.Menu;

import br.al.lucas.Exceptions.DomainExcepciotion;
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
    public void execute(Connection payroll, MyCalendar calendar) throws DomainExcepciotion {
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
            System.out.println(rs);
            String type = rs.getNString(4);
            if (type.equals("horista")){
                infos.get(0).info(payroll,worker_id);
            }
            else if(type.equals("assalariado")){
                infos.get(1).info(payroll,worker_id);
            }
            else{
                infos.get(2).info(payroll,worker_id);
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int scanner_int(){
        return sc.nextInt();
    }

}
