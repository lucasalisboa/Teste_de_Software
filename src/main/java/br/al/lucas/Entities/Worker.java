package br.al.lucas.Entities;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public abstract class Worker {
    public int id;
    public String name;
    private String address;
    private String payment_method;
    private boolean syndicate;
    private String syndicate_id;
    private double syndicate_tax;
    protected Calendar pay_day;
    public Worker(){
    }

    public abstract Calendar newPayDay_Pattern(Date today);

    public abstract void payment(Date today);

    }

