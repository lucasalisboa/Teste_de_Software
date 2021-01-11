package br.al.lucas.Menu;


import br.al.lucas.Exceptions.DomainExcepciotion;

import java.sql.Connection;

public interface Command {
    public void execute(Connection payroll, MyCalendar calendar) throws DomainExcepciotion;
}
