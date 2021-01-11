package br.al.lucas.Menu;


import br.al.lucas.Exceptions.DomainExcepciotion;

import java.sql.Connection;
import java.util.Calendar;
import java.util.Scanner;

public class NewPayment extends Operation implements Command  {
    @Override
    public void execute(Connection payroll, MyCalendar calendar) throws DomainExcepciotion {
        String worker_id = scanner_search();
        int index = search(payroll,worker_id );
        if(index != -1)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("DO YOU WANT:");
            System.out.println("1 - PATTERN");
            System.out.println("2 - MONTH FIRST DAY");
            System.out.println("3 - MONTH DAY SEVEN");
            System.out.println("4 - MONTH LAST DAY");
            System.out.println("5 - WEEK ON MONDAYS");
            System.out.println("6 - WEEK ON FRIDAYS");
            System.out.println("7 - 2 WEEKS ON MONDAYS");
            int aux = sc.nextInt();

            Calendar cal_aux = Calendar.getInstance();
            cal_aux.setTime(calendar.today);

            if(aux == 1)
            {
                payroll.get(index).newPayDay_Pattern(calendar.today);
            }
            else if(aux == 2)
            {
                payroll.get(index).newPayDay_MFD(cal_aux);
            }
            else if(aux == 3)
            {
                payroll.get(index).newPayDay_MSD(cal_aux);
            }
            else if(aux == 4)
            {
                payroll.get(index).newPayDay_MLD(cal_aux);
            }
            else if(aux == 5)
            {
                payroll.get(index).newPayDay_WM(cal_aux);
            }
            else if(aux == 6)
            {
                payroll.get(index).newPayDay_WF(cal_aux);
            }
            else if(aux == 7)
            {
                payroll.get(index).newPayDay_2M(cal_aux);
            }
            else
            {
                throw new DomainExcepciotion("INVALID OPERATION");
            }
        }
    }
}
