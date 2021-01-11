package br.al.lucas.Menu;

import br.al.lucas.Entities.Worker;
import br.al.lucas.Exceptions.DomainExcepciotion;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Operation {
    public ArrayList<Command> slot;

    public Operation() {
        this.slot = new ArrayList<Command>();
        slot.add(0,new Add());
        slot.add(1,new Remove());
        slot.add(2,new PointCard());
        slot.add(3,new SaleResult());
        slot.add(4,new ServiceTax());
        slot.add(5,new Information());
        slot.add(6,new RunPayroll());
        slot.add(7,new ShowPayment());
        slot.add(8,new NewPayment());
        slot.add(9,new ShowInfo());
        slot.add(10,new FinishDay());
    }

    public void operate(int index, Connection payroll, MyCalendar calendar) throws IndexOutOfBoundsException, DomainExcepciotion {
        slot.get(index).execute(payroll,calendar);
    }

    public int search(Connection payroll, String worker_id)
    {
        for(int i = 0; i < payroll.size(); i++)
        {
            if(payroll.get(i).id.equals(worker_id))
            {
                return i;
            }
        }
        System.out.println("THE WORKER DOESN'T EXIST");
        return -1;
    }

    public String scanner_search(){
        Scanner sc = new Scanner(System.in);
        System.out.println("WHAT'S THE WORKER ID?");
        String worker_id = sc.nextLine();
        return worker_id;
    }
}
