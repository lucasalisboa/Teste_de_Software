package br.al.lucas.Connection;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CreateTablesTest {

    public ConnectionFactory connection;
    public Connection con;
    public CreateTables creator;

    @Before
    public void setup(){
        connection = new ConnectionFactory();
        con = connection.getConnection();
        creator = new CreateTables(con);
    }

    @After
    public void tearDown(){
        connection.closeConnection(con);
    }

    @Test
    public void test1_criar_empregados(){
        boolean result = creator.createEmployers();
        assertTrue(result);
    }

    @Test
    public void test2_criar_horista(){
        boolean result = creator.createHourist();
        assertTrue(result);
    }

    @Test
    public void test3_criar_assalariado(){
        boolean result = creator.createSalaried();
        assertTrue(result);
    }

    @Test
    public void test4_criar_comissionado(){
        boolean result = creator.createCommissioned();
        assertTrue(result);
    }
    }
