package br.al.lucas.Pay;

import br.al.lucas.Menu.MyCalendar;

import java.sql.Connection;

public interface Payment {
    public double pay(Connection payroll, int id_worker, MyCalendar calendar);
}
