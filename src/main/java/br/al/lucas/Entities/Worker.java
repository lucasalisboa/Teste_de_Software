package br.al.lucas.Entities;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public abstract class Worker {

    public abstract Calendar newPayDay_Pattern(Date today);
}

