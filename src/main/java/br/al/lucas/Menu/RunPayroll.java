package br.al.lucas.Menu;


import br.al.lucas.Entities.Worker;

import java.sql.Connection;

public class RunPayroll implements Command {
    public int c;

    @Override
    public void execute(Connection payroll, MyCalendar calendar) {
        c = 0;
        for (Worker worker : payroll) {
            if (calendar.cal.compareTo(worker.getPay_day()) == 0) {
                System.out.println("ID: " + worker.id);
                System.out.println("NAME: " + worker.name);
                worker.payment(calendar.today);
                c++;
                System.out.println();
            }
        }
        System.out.println(c + " WORKERS WERE PAID TODAY");
    }
}
