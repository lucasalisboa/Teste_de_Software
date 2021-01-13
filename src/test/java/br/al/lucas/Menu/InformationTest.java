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
        assertEquals(1,updateName.change(con,2,"Pedro"),0.001);
    }
    @Test
    public void testando_update_endereco(){
        assertEquals(1,updateAdress.change(con,2,"Cruzeiro do Sul"),0.001);
    }
    @Test
    public void testando_update_metodo(){
        assertEquals(1,updateMethod.change(con,2,"Conta Poupanca"),0.001);
    }
    @Test
    public void testando_update_sindicato(){
        assertEquals(1, updateSyndicate.change(con,2,"Sim"),0.001);
    }

    @Test
    public void testando_update_funcionario_inexistente(){
        assertEquals(0,updateName.change(con,666,"Falha"),0.001);
    }

}
