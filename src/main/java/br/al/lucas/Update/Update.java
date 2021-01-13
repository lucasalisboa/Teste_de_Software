package br.al.lucas.Update;

import java.sql.Connection;

public interface Update {
    public int change(Connection payroll, int id, String new_info);
}
