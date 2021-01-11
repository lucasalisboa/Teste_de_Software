package br.al.lucas.Menu;


import br.al.lucas.Entities.CommissionedWorker;

import java.sql.Connection;

public class SaleResult extends Operation implements Command {
    public SaleResult() {
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
                ((CommissionedWorker) payroll.get(index)).newSale();
            }
            else
            {
                System.out.println("THIS WORKER IS NOT A COMMISSIONED");
            }
        }
    }
}
