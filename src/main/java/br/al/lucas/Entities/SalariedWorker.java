package br.al.lucas.Entities;

import java.util.Calendar;
import java.util.Date;

public class SalariedWorker extends Worker {

    @Override
    public Calendar newPayDay_Pattern(Date today)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));

        int week = checkDay(cal);
        Calendar aux = cal;
        aux.add(Calendar.DAY_OF_MONTH,week);
        return aux;
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
}
