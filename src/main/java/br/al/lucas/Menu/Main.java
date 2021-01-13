package br.al.lucas.Menu;


import br.al.lucas.Connection.ConnectionFactory;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args)  {
        System.out.println("WELCOME\n");
        MyCalendar calendar = MyCalendar.getInstance();
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection payroll =  connectionFactory.getConnection();
        Operation op = new Operation();
        action(calendar,payroll,op);
    }

    private static void action(MyCalendar calendar, Connection payroll, Operation op)
    {
        System.out.println("TODAY IS:");
        System.out.println(calendar.data.format(calendar.today) + "," + calendar.dayWeek());
        System.out.println();
        System.out.println("CHOOSE YOUR OPERATION:");
        System.out.println("0- ADD NEW EMPLOYER");
        System.out.println("1- REMOVE A EMPLOYER");
        System.out.println("2- PUT THE POINT CARD");
        System.out.println("3- PUT THE SALE'S RESULT");
        System.out.println("4- CHANGE THE EMPLOYER INFORMATIONS");
        System.out.println("5- RUN THE PAYROLL");
        System.out.println("6 - SHOW THE WORKER INFORMATIONS");
        System.out.println("7- FINISH THE DAY");

        try{
            int operation;
            Scanner sc = new Scanner(System.in);
            operation = sc.nextInt();
            op.operate(operation,payroll,calendar);
        }
        catch(InputMismatchException e)
        {
            System.out.println("WRONG INPUT DETECTED");
        }
        catch(IndexOutOfBoundsException e)
        {
            System.out.println("INVALID OPERATION");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println();
        action(calendar, payroll, op);
    }





}
