package br.al.lucas.Entities;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class HouristWorker extends Worker {
    private double hour_salary;
    private int hours;
    Scanner sc = new Scanner(System.in);

    public void point()
    {
        System.out.println("HOW MANY HOURS THE WORKER WORKED TODAY?");
        int new_hours = sc.nextInt();
        hours += new_hours;
    }

    @Override
    public Calendar newPayDay_Pattern(Date today)
    {
        pay_schedule = Schedule.PATTERN;
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        int week = 6 - cal.get(Calendar.DAY_OF_WEEK);
        pay_day.setTime(today);
        if(week > 0)
        {
            pay_day.add(Calendar.DAY_OF_MONTH,week);
        }
        else
        {
            pay_day.add(Calendar.DAY_OF_MONTH,7 + week);
        }
        return pay_day;
    }

    @Override
    public void payment(Date today)
    {
        double salary = hours * hour_salary;
        System.out.println("PAYMENT: " +(salary - (salary*getSyndicate_tax()/100) ));
        check_schedule(today);
    }

    public double getHour_salary() {
        return hour_salary;
    }

    public int getHours() {
        return hours;
    }

    @Override
    public String toString() {
        return super.toString() +
                "HouristWorker{" +
                "hour_salary=" + hour_salary +
                ", hours=" + hours +
                '}';
    }
}
