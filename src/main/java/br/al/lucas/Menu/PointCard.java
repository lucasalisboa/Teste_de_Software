package br.al.lucas.Menu;

import br.al.lucas.Entities.HouristWorker;

import java.sql.Connection;
import java.util.Scanner;

public class PointCard implements Command {
    Scanner sc;
    HouristWorker houristWorker;

    public PointCard() {
        super();
        sc = new Scanner(System.in);
        houristWorker = new HouristWorker();
    }

    @Override
    public void execute(Connection payroll, MyCalendar calendar) {
        int worker_id = scanner_int();
        int horas_trabalhadas = scanner_int();
        houristWorker.point(payroll,worker_id,horas_trabalhadas);
    }
    public int scanner_int(){
        return sc.nextInt();
    }

}
