package br.al.lucas.Update;

import java.sql.Connection;

public class UpdateAdress implements Update {
    @Override
    public boolean change(Connection payroll, int id, String new_info) {
        return false;
    }
}
