package br.al.lucas.Menu;

import br.al.lucas.Connection.ConnectionFactory;
import br.al.lucas.Entities.CommissionedWorker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import static org.junit.Assert.*;


public class SaleResultTest {
    public ConnectionFactory connection;
    public Connection con;
    public CommissionedWorker commissionedWorker;

    @Before
    public void setup(){
        connection = new ConnectionFactory();
        con = connection.getConnection();
        commissionedWorker = new CommissionedWorker();
    }
    @After
    public void tearDown(){
        connection.closeConnection(con);
    }

    @Test
    public void testando_venda_correta(){
        assertEquals(25,commissionedWorker.newSale(con,2,100),0.001);
    }

    @Test
    public void testando_funcionario_inexiste(){
        assertEquals(-1,commissionedWorker.newSale(con,666,1000),0.001);
    }

    @Test
    public void testando_venda_negativa(){
        assertEquals(-1,commissionedWorker.newSale(con,2,-100),0.001);
    }

    @Test
    public void testando_funcionario_nao_comissionado(){
        assertEquals(-1,commissionedWorker.newSale(con,1,100),0.001);
    }
}
