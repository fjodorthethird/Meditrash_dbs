package com.mediTrash.app.Tools.Methods;

import com.mediTrash.app.DBConnection.SQLConnect;
import com.mediTrash.app.Data.AuthorisedPerson;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class getAPName extends SQLConnect {

    public String getAPName(int apID) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            Statement stmt = connection.createStatement();
            String sql = "SELECT ODP_NAZEVP FROM Opravnena_osoba WHERE ODP_ID = " + apID;
            ResultSet rs = stmt.executeQuery(sql);
            String name = "";
            while(rs.next()) {
                name = rs.getString("jmeno_opravnena_osoba");
                break;
            }
            return name;
        }
    }

    public String getDate(int apID) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            Statement stmt = connection.createStatement();
            String sql = "SELECT ODP_DATUMPOT FROM Opravnena_osoba WHERE ODP_ID = " + apID;
            ResultSet rs = stmt.executeQuery(sql);
            String date = "";
            while(rs.next()) {
                date = rs.getString("datum_potvrzeni");
                break;
            }
            return date;
        }
    }

}
