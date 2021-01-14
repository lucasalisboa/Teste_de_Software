package br.al.lucas.Menu;

import br.al.lucas.Connection.ConnectionFactory;
import br.al.lucas.Entities.HouristWorker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.sql.Connection;

public class PointCardTest {
    public ConnectionFactory connection;
    public Connection con;
    public HouristWorker houristWorker;

    @Before
    public void setup(){
        connection = new ConnectionFactory();
        con = connection.getConnection();
        houristWorker = new HouristWorker();
    }

    @After
    public void tearDown(){
        connection.closeConnection(con);
    }

    @Test
    public void testando_ponto_correto(){
        assertEquals(1000,houristWorker.point(con,3,5),0.001);
    }

    @Test
    public void testando_funcionario_inexiste(){
        assertEquals(-1,houristWorker.point(con,666,10),0.001);
    }

    @Test
    public void testando_hora_negativa(){
        assertEquals(-1,houristWorker.point(con,3,-1),0.001);
    }

    @Test
    public void testando_funcionario_nao_comissionado(){
        assertEquals(-1,houristWorker.point(con,1,5),0.001);
    }
}
