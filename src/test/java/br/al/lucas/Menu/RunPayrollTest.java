package br.al.lucas.Menu;

import br.al.lucas.Connection.ConnectionFactory;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.sql.Connection;

import static org.junit.Assert.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RunPayrollTest {
    public SetDate setDate;
    public RunPayroll runPayroll;
    public ConnectionFactory connection;
    public Connection con;
    public MyCalendar myCalendar;

    @Before
    public void setup(){
        connection = new ConnectionFactory();
        con = connection.getConnection();
        myCalendar = MyCalendar.getInstance();
        setDate = new SetDate();
        runPayroll  = new RunPayroll();
    }

    @Test
    public void testando_nova_data(){
        assertEquals(1,setDate.setDate(con,1,myCalendar.today),0.001);
        assertEquals(1,setDate.setDate(con,2,myCalendar.today),0.001);
        assertEquals(1,setDate.setDate(con,3,myCalendar.today),0.001);
    }

    @Test
    public void testando_rodar_folha(){
        assertTrue(runPayroll.pay(con,myCalendar));
    }
}
