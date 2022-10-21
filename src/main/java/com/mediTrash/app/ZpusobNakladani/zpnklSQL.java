package com.mediTrash.app.ZpusobNakladani;

import com.mediTrash.app.DBConnection.SQLConnect;
import com.mediTrash.app.Data.AuthorisedPerson;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class zpnklSQL extends SQLConnect {

    public ArrayList<ZpusobNakladani> zpnklOutputList() throws SQLException {
        ArrayList<ZpusobNakladani> trash = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            Statement stmt = connection.createStatement();
            String sql = ("SELECT * FROM Zpusob_nakladani");
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                trash.add(new ZpusobNakladani(rs.getString(1), rs.getString(2)));
            }
        }
        return trash;
    }
}
