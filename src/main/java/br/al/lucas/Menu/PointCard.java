package br.al.lucas.Menu;

import br.al.lucas.Entities.HouristWorker;

import java.sql.Connection;

public class PointCard extends Operation implements Command {
    public PointCard() {
        super();
    }

    @Override
    public void execute(Connection payroll, MyCalendar calendar) {
        String worker_id = scanner_search();
        int index = search(payroll, worker_id);
        if(index != -1)
        {
            if(payroll.get(index) instanceof HouristWorker)
            {
                ((HouristWorker) payroll.get(index)).point();
            }
            else
            {
                System.out.println("THIS WORKER IS NOT A HOURIST");
            }
        }
    }
}
