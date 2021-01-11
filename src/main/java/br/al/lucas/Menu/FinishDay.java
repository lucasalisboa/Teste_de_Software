package br.al.lucas.Menu;

import java.sql.Connection;

public class FinishDay implements Command {
    @Override
    public void execute(Connection payroll, MyCalendar calendar) {
        calendar.finishDay();
    }
}
