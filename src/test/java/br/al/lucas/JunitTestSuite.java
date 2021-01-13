package br.al.lucas;

import br.al.lucas.Connection.ConnectionFactoryTest;
import br.al.lucas.Connection.CreateTables;
import br.al.lucas.Connection.CreateTablesTest;
import br.al.lucas.Connection.DeleteTablesTest;
import br.al.lucas.Menu.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ConnectionFactoryTest.class,
        CreateTablesTest.class,
        AddTest.class,
        PointCardTest.class,
        SaleResultTest.class,
        ShowInfoTest.class,
        InformationTest.class,
        OperationTest.class,
        RunPayrollTest.class,
        RemoveTest.class,
        DeleteTablesTest.class
})
public class JunitTestSuite {
}
