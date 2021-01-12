package br.al.lucas.Menu;


import br.al.lucas.Entities.CommissionedWorker;
import br.al.lucas.Entities.HouristWorker;
import br.al.lucas.Entities.SalariedWorker;
import br.al.lucas.Exceptions.DomainExcepciotion;
import br.al.lucas.Update.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

public class Information extends Operation implements Command {
   public Scanner sc;
   public ArrayList<Update> updateEmployers;
    public Information() {
        super();
        sc = new Scanner(System.in);
        updateEmployers = new ArrayList<>();
        updateEmployers.add(0,new UpdateName());
        updateEmployers.add(1, new UpdateAdress());
        updateEmployers.add(2,new UpdateMethod());
        updateEmployers.add(3, new UpdateSyndicate());
    }

    @Override
    public void execute(Connection payroll, MyCalendar calendar) throws DomainExcepciotion {
        System.out.println("WHAT THE EMPLOYER ID?");
        int id_worker = scanner_int();

        System.out.println("WHAT INFORMATION YOU WANT TO CHANGE?");
        System.out.println("1- NAME");
        System.out.println("2- ADDRESS");
        System.out.println("3- PAYMENT METHOD");
        System.out.println("4- SYNDICATED");
        int info = scanner_int();

        System.out.println("NEW INFO:");
        String new_info = scanner_String();

        updateEmployers.get(info).change(payroll,id_worker,new_info);

    }
    public int scanner_int(){
        return sc.nextInt();
    }

    public String scanner_String(){
        return sc.nextLine();
    }

}
