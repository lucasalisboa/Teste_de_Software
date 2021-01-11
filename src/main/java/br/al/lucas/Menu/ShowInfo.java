package br.al.lucas.Menu;

import br.al.lucas.Exceptions.DomainExcepciotion;

import java.sql.Connection;

public class ShowInfo extends Operation implements Command  {
    @Override
    public void execute(Connection payroll, MyCalendar calendar) throws DomainExcepciotion {
        String worker_id = scanner_search();
        int index = search(payroll, worker_id);
        if(index != -1)
        {
            System.out.println(payroll.get(index).toString());
        }
    }
}
