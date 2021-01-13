package br.al.lucas.Menu;

import br.al.lucas.Connection.ConnectionFactory;
import br.al.lucas.Update.UpdateAdress;
import br.al.lucas.Update.UpdateMethod;
import br.al.lucas.Update.UpdateName;
import br.al.lucas.Update.UpdateSyndicate;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import static org.junit.Assert.*;

public class InformationTest {
    public ConnectionFactory connection;
    public Connection con;
    public UpdateName updateName;
    public UpdateAdress updateAdress;
    public UpdateMethod updateMethod;
    public UpdateSyndicate updateSyndicate;

    @Before
    public void setup(){
        connection = new ConnectionFactory();
        con = connection.getConnection();
        updateName = new UpdateName();
        updateAdress = new UpdateAdress();
        updateMethod = new UpdateMethod();
        updateSyndicate = new UpdateSyndicate();
    }

    @Test
    public void testando_update_nome(){
        assertTrue(updateName.change(con,2,"Pedro"));
    }
    @Test
    public void testando_update_endereco(){
        assertTrue(updateAdress.change(con,2,"Cruzeiro do Sul"));
    }
    @Test
    public void testando_update_metodo(){
        assertTrue(updateMethod.change(con,2,"Conta Poupanca"));
    }
    @Test
    public void testando_update_sindicato(){
        assertTrue(updateSyndicate.change(con,2,"Sim"));
    }

//    @Test
//    public void testando_update_funcionario_inexistente(){
//        assertFalse(updateName.change(con,666,"Falha"));
//    }

}
