package br.al.lucas.Connection;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Test;

import java.sql.Connection;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeleteTablesTest {

    public ConnectionFactory connection;
    public Connection con;
    public DeleteTables destructor;

    @Before
    public void setup(){
        connection = new ConnectionFactory();
        con = connection.getConnection();
        destructor = new DeleteTables(con);
    }
    @After
    public void tearDown(){
        connection.closeConnection(con);
    }

    @Test
    public void test1_delete_horista(){
        boolean result = destructor.deleteHourist();
        assertTrue(result);
    }

    @Test
    public void test2_delete_assalariado(){
        boolean result = destructor.deleteSalaried();
        assertTrue(result);
    }

    @Test
    public void test3_delete_comissionado(){
        boolean result = destructor.deleteCommissioned();
        assertTrue(result);
    }

    @Test
    public void test4_delete_empregados(){
        boolean result = destructor.deleteEmployers();
        assertTrue(result);
    }

}
