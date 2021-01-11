package br.al.lucas.Menu;


import br.al.lucas.Entities.CommissionedWorker;
import br.al.lucas.Entities.HouristWorker;
import br.al.lucas.Entities.SalariedWorker;
import br.al.lucas.Exceptions.DomainExcepciotion;

import java.sql.Connection;
import java.util.Scanner;

public class Information extends Operation implements Command {
    public Information() {
        super();
    }

    @Override
    public void execute(Connection payroll, MyCalendar calendar) throws DomainExcepciotion {
        String worker_id = scanner_search();
        int index = search(payroll,worker_id);
        if(index != -1)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("WHAT INFORMATION YOU WANT TO CHANGE?");
            System.out.println("1- NAME");
            System.out.println("2- ADDRESS");
            System.out.println("4- PAYMENT METHOD");
            System.out.println("5- SYNDICATED");
            int info = sc.nextInt();

            if(info == 1)
            {
                payroll.get(index).changeName();
            }
            else if(info == 2)
            {
                payroll.get(index).changeAddress();
            }
            else if(info == 4)
            {
                payroll.get(index).changePayMethod();
            }
            else if(info == 5)
            {
                payroll.get(index).changeSyndicate();
            }
            else
            {
                throw new DomainExcepciotion("INVALID OPERATION");
            }
        }
    }
}
