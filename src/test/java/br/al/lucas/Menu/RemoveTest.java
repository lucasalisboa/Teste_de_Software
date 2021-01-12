package br.al.lucas.Menu;

import br.al.lucas.Connection.ConnectionFactory;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RemoveTest {
    public ConnectionFactory connection;
    public Connection con;
    public Remove remove;

    @Before
    public void setup(){
        connection = new ConnectionFactory();
        con = connection.getConnection();
        remove = new Remove();
    }


    @Test
    public void testar_remover_horista(){
        assertTrue(remove.remove(con,3));
    }
    @Test
    public void testar_remover_assalariado(){
        assertTrue(remove.remove(con,1));
    }
    @Test
    public void testar_remover_comissionado(){
        assertTrue(remove.remove(con,2));
    }
    @Test
    public void testar_remover_inexiste(){
        assertFalse(remove.remove(con,666));
    }
}
