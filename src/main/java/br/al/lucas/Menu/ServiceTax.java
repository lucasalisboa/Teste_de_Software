package br.al.lucas.Menu;

import br.al.lucas.Entities.CommissionedWorker;

import java.sql.Connection;

public class ServiceTax extends Operation implements Command {
    public ServiceTax() {
        super();
    }

    @Override
    public void execute(Connection payroll, MyCalendar calendar) {
        String worker_id = scanner_search();
        int index = search(payroll, worker_id);
        if(index != -1)
        {
            if(payroll.get(index) instanceof CommissionedWorker)
            {
                ((CommissionedWorker) payroll.get(index)).setPercent();
            }
            else
            {
                System.out.println("THIS WORKER IS NOT A COMMISSIONED");
            }
        }
    }
}
