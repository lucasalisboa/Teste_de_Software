package br.al.lucas.Menu;

import br.al.lucas.Entities.Worker;
import br.al.lucas.Exceptions.DomainExcepciotion;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class OperationTest {
    private static ArrayList<Worker> payroll;
    private static Operation op;
    private static MyCalendar calendar;

//    @Rule
//    public ErrorCollector error = new ErrorCollector();

    @BeforeClass
    public static void setup(){
        payroll = new ArrayList<Worker>();
        op  = new Operation(payroll);
        calendar = MyCalendar.getInstance();

    }

    @Test
    public void index_maior_que_escopo(){
        try {
            op.operate(20,this.payroll,this.calendar);
            fail("Deveria ter acusado exception");
        } catch (DomainExcepciotion domainExcepciotion) {
            assertEquals(1,1);
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("INVALID OPERATION");
            assertEquals(1,1);
        }
    }

    @Test
    public void index_menor_que_escopo(){
        try {
            op.operate(-2,this.payroll,this.calendar);
            fail("Deveria ter acusado exception");
        } catch (DomainExcepciotion domainExcepciotion) {
            assertEquals(1,1);
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("INVALID OPERATION");
            assertEquals(1,1);
        }
    }

    @Test
    public void funcionario_inexistente(){
        int result = op.search(payroll,"falha");
        assertEquals(result,-1);
    }

    @Test
    public void finalizar_dia() throws IndexOutOfBoundsException,DomainExcepciotion {
        String dia_de_hoje = calendar.dayWeek();
        op.operate(10,payroll,calendar);
        String dia_de_amanha = calendar.dayWeek();
        assertNotEquals(dia_de_amanha,dia_de_hoje);
    }

    @Test
    public void command_funcionando(){
        assertFalse(op.slot.isEmpty());
    }
}
