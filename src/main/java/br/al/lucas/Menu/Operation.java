package br.al.lucas.Menu;

import br.al.lucas.Entities.Worker;
import br.al.lucas.Exceptions.DomainExcepciotion;

import java.sql.Connection;
import java.util.ArrayList;

public class Operation {
    public ArrayList<Command> slot;

    public Operation() {
        this.slot = new ArrayList<Command>();
        slot.add(0,new Add());
        slot.add(1,new Remove());
        slot.add(2,new PointCard());
        slot.add(3,new SaleResult());
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

}
