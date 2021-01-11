package br.al.lucas.Entities;

import java.util.Calendar;
import java.util.Date;

public class SalariedWorker extends Worker {
    private double salary;


    @Override
    public Calendar newPayDay_Pattern(Date today)
    {
        pay_schedule = Schedule.PATTERN;
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));

        int week = checkDay(cal);
        pay_day = cal;
        pay_day.add(Calendar.DAY_OF_MONTH,week);
        return pay_day;
    }


    private int checkDay(Calendar cal)
    {
        int week = cal.get(Calendar.DAY_OF_WEEK);
        if(week == 7)
        {
            return -1;
        }
        else if(week == 1)
        {
            return -2;
        }
        return 0;
    }

    @Override
    public void payment(Date today)
    {
        System.out.println("PAYMENT: " +(salary - (salary*getSyndicate_tax()/100) ));
        check_schedule(today);
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "SalariedWorker{" +
                "salary=" + salary +
                '}';
    }
}
