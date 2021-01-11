package br.al.lucas.Connection;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ConnectionFactoryTest {

    public ConnectionFactory connection;
    public Connection con;

    @Before
    public void setup(){
        connection = new ConnectionFactory();
        con = connection.getConnection();
    }

    @Test
    public void testando_abrindo_conexao() throws SQLException {
        assertFalse(con.isClosed());
    }

    @Test
    public void testando_fechando_conexao() throws SQLException {
        connection.closeConnection(con);
        assertTrue(con.isClosed());
    }

}
