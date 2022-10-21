package com.mediTrash.app.TrashSorting;

import com.mediTrash.app.DBConnection.SQLConnect;
import com.mediTrash.app.Data.Trash;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TrashOutput extends SQLConnect {

    public void TrashOutput() throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            Statement stmt = connection.createStatement();
            String sql = ("SELECT * FROM Odpad");
            ResultSet rs = stmt.executeQuery(sql);
            String[] output = new String[4];
            output[0] = "Nazev";
            output[1] = "id odpadů";
            output[2] = "kategorie";
            output[3] = "uslkad množství";
            System.out.println(String.format(("%12s %20s %5s %5s"),output[0],output[1],output[2],output[3]));
            while (rs.next()) {
                System.out.println(String.format("%-24s %5s %8s %12s", rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }
        }
    }
    public ArrayList<Trash> TrashOutputList() throws SQLException {
        ArrayList<Trash> trash = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            Statement stmt = connection.createStatement();
            String sql = ("SELECT * FROM Odpad");
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                trash.add(new Trash(rs.getString(1), rs.getInt(4), rs.getString(2), rs.getFloat(3)));
            }
        } return trash;
    }
}
