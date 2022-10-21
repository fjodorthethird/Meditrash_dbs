package com.mediTrash.app.AuthorisedPersonChange;

import  com.mediTrash.app.DBConnection.SQLConnect;
import  com.mediTrash.app.Data.AuthorisedPerson;
import com.mediTrash.app.Data.Trash;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Functions extends SQLConnect {

    public void Delete(String id) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "DELETE FROM Opravnena_osoba WHERE ODP_PARTNER =?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            preparedStatement.executeUpdate();
        }
    }

    public ArrayList<AuthorisedPerson> APOutputList() throws SQLException {
        ArrayList<AuthorisedPerson> trash = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            Statement stmt = connection.createStatement();
            String sql = ("SELECT * FROM Opravnena_osoba");
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                trash.add(new AuthorisedPerson(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5),rs.getString(6), rs.getDate(7),
                        rs.getString(8), rs.getString(9), rs.getString(10)));
            }
        } return trash;
    }
}
