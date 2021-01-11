package br.al.lucas.Remove;

import java.sql.Connection;

public interface RemoveEmployers {
    public boolean remove(Connection payroll,int id);
}
