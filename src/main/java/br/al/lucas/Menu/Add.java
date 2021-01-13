package br.al.lucas.Menu;

import br.al.lucas.Add.AddCommissioned;
import br.al.lucas.Add.AddEmployer;
import br.al.lucas.Add.AddHourist;
import br.al.lucas.Add.AddSalaried;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Add implements Command {

    public List<AddEmployer> addEmployers;
    Scanner sc;


    public Add() {
        addEmployers = new ArrayList<>();
        addEmployers.add(0, new AddHourist());
        addEmployers.add(1,new AddSalaried());
        addEmployers.add(2, new AddCommissioned());
        sc = new Scanner(System.in);
    }


    @Override
    public void execute(Connection payroll, MyCalendar calendar) {
        int type;
        double salario;
        double hora_trabalho;
        int taxa_venda;
        System.out.println("WHAT'S THE WORKER TYPE?");
        System.out.println("0- HOURLY; 1- SALARIED; 2- COMMISSIONED");
        type = sc.nextInt();
        sc.nextLine();
        if(type == 0){
            salario = 0;
            System.out.println("WHAT'S THE HOUR WORKED SALARY?");
            hora_trabalho = scanner_double();
            taxa_venda = 0;
        }
        else{
            salario = scanner_double();
            hora_trabalho = 0;
            if (type == 2){
                taxa_venda = scanner_int();
            }
            else{
                taxa_venda = 0;
            }
        }

        boolean result = addEmployers.get(type).add(payroll,scanner_string(),scanner_string(),scanner_string(),scanner_boolean(),calendar,salario,hora_trabalho,taxa_venda);
    }

    public String scanner_string(){
        return sc.nextLine();
    }

    public boolean scanner_boolean(){
        return sc.nextBoolean();
    }

    public double scanner_double(){
        return sc.nextDouble();
    }

    public int scanner_int(){
        return sc.nextInt();
    }

}
