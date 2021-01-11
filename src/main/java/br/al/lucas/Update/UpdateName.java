package br.al.lucas.Update;

import java.sql.Connection;

public class UpdateName implements Update {
    @Override
    public boolean change(Connection payroll, int id, String new_info) {
        return false;
    }
}
