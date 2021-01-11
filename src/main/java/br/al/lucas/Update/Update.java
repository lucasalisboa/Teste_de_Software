package br.al.lucas.Update;

import java.sql.Connection;

public interface Update {
    public boolean change(Connection payroll, int id, String new_info);
}
