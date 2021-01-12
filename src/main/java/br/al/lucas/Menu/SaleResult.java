package br.al.lucas.Menu;


import br.al.lucas.Entities.CommissionedWorker;
import br.al.lucas.Entities.HouristWorker;
import br.al.lucas.Entities.SalariedWorker;

import java.sql.Connection;
import java.util.Scanner;

public class SaleResult implements Command {
    Scanner sc;
    CommissionedWorker commissionedWorker;

    public SaleResult() {
        super();
        sc = new Scanner(System.in);
        commissionedWorker = new CommissionedWorker();
    }

    @Override
    public void execute(Connection payroll, MyCalendar calendar) {
        int worker_id = scanner_int();
        double valor_venda = scanner_double();
        commissionedWorker.newSale(payroll,worker_id,valor_venda);
    }
    public int scanner_int(){
        return sc.nextInt();
    }
    public double scanner_double(){
        return sc.nextDouble();
    }
}
