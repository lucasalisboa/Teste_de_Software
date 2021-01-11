package br.al.lucas.Entities;

import java.util.Calendar;
import java.util.Date;

public class CommissionedWorker extends Worker {
    private double base_salary;
    private double sales;
    private double percent;

    public void newSale()
    {
        double new_sale;
        System.out.println("WHAT'S IS THE SALE PRICE?");
        new_sale = sc.nextDouble();
        sales += (new_sale*percent/100);

    }
    public void setPercent()
    {
        System.out.println("HOW MANY PERCENTS FOR SALE?");
        percent = sc.nextDouble();
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
            pay_day.add(Calendar.DAY_OF_MONTH,week + 7);
        }
        else
        {
            pay_day.add(Calendar.DAY_OF_MONTH,14 + week);
        }
        return pay_day;
    }

    @Override
    public void payment(Date today)
    {
        double salary = base_salary + sales;
        System.out.println("PAYMENT: " +(salary - (salary*getSyndicate_tax()/100) ));
        check_schedule(today);
    }

    public double getBase_salary() {
        return base_salary;
    }

    public double getSales() {
        return sales;
    }

    public double getPercent() {
        return percent;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "CommissionedWorker{" +
                "base_salary=" + base_salary +
                ", sales=" + sales +
                ", percent=" + percent +
                '}';
    }
}
