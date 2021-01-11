package br.al.lucas.Menu;

import br.al.lucas.Add.AddCommissioned;
import br.al.lucas.Add.AddHourist;
import br.al.lucas.Add.AddSalaried;
import br.al.lucas.Connection.ConnectionFactory;
import br.al.lucas.Entities.CommissionedWorker;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


import java.sql.Connection;

public class AddTest {
    public ConnectionFactory connection;
    public Connection con;
    private static MyCalendar calendar;
    public AddHourist addHourist;
    public AddSalaried addSalaried;
    public AddCommissioned addCommissioned;

    @Before
    public void setup(){
        connection = new ConnectionFactory();
        con = connection.getConnection();
        calendar = MyCalendar.getInstance();
        addHourist = new AddHourist();
        addSalaried = new AddSalaried();
        addCommissioned = new AddCommissioned();
    }

    @Test
    public void testar_adicionar_horista(){
        assertTrue(addHourist.add(con,"Lucas", "Avenida Brasil, 150, Maceió, Alagoas, Brasil", "Dinheiro", true, calendar,0,200,0));
    }
}
