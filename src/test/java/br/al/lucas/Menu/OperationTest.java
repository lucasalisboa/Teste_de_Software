package br.al.lucas.Menu;

import br.al.lucas.Connection.ConnectionFactory;
import br.al.lucas.Exceptions.DomainExcepciotion;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class OperationTest {
    public ConnectionFactory connection;
    public Connection con;
    public Operation operation;
    public MyCalendar myCalendar;

    @Before
    public void setup(){
        connection = new ConnectionFactory();
        con = connection.getConnection();
        operation = new Operation();
        myCalendar = MyCalendar.getInstance();
    }

    @Test
    public void testando_finalizar_dia() throws DomainExcepciotion {
        Date aux = myCalendar.today;
        operation.operate(8,con,myCalendar);
        assertNotEquals(aux,myCalendar.today);
    }
    @Test
    public void testando_operacao_invalida(){
        try {
            operation.operate(-1,con,myCalendar);
            fail();
        } catch (DomainExcepciotion domainExcepciotion) {
            domainExcepciotion.printStackTrace();
            fail();
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Operacao Invalida");
            assertTrue(true);
        }
    }

}
