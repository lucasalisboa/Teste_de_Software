package br.al.lucas.Menu;


import java.sql.Connection;

public interface Command {
    public void execute(Connection payroll, MyCalendar calendar);
}
