package br.al.lucas.Menu;

import br.al.lucas.Connection.ConnectionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

public class ShowInfoTest {
    public ConnectionFactory connection;
    public Connection con;
    public ShowInfo showInfo;

    @Before
    public void setup(){
        connection = new ConnectionFactory();
        con = connection.getConnection();
        showInfo = new ShowInfo();
    }
    @After
    public void tearDown(){
        connection.closeConnection(con);
    }

    @Test
    public void testando_read_horista(){
        assertTrue(showInfo.info(con,3));
    }
    @Test
    public void testando_read_assalariado(){
        assertTrue(showInfo.info(con,1));
    }
    @Test
    public void testando_read_comissionado(){
        assertTrue(showInfo.info(con,2));
    }
    @Test public void testando_read_funcionario_inexistente(){
        assertFalse(showInfo.info(con,666));
    }
}
