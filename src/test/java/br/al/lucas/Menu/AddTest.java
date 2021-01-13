package br.al.lucas.Menu;

import br.al.lucas.Add.AddCommissioned;
import br.al.lucas.Add.AddHourist;
import br.al.lucas.Add.AddSalaried;
import br.al.lucas.Connection.ConnectionFactory;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;


import java.sql.Connection;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
    public void testar_adicionar_assalariado(){
        assertTrue(addSalaried.add(con,"João", "UFAL Alagoas", "Conta Corrente", false, calendar,3250.5,0,0));
    }

    @Test
    public void testar_adicionar_comissionado(){
        assertTrue(addCommissioned.add(con,"Vitor", "Praca Centenario", "Cheque", false, calendar,2000,0,25));
    }

    @Test
    public void testar_adicionar_horista(){
        assertTrue(addHourist.add(con,"Lucas", "Avenida Brasil, 150, Maceió, Alagoas, Brasil", "Dinheiro", true, calendar,0,200,0));
    }
    
}
