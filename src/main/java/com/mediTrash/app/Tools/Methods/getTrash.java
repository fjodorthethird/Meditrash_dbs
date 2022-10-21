package com.mediTrash.app.Tools.Methods;

import com.mediTrash.app.DBConnection.SQLConnect;
import com.mediTrash.app.Data.Trash;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class getTrash extends SQLConnect {

    public List<Trash> getTrash(int state) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM Odpad";
            ResultSet rs = stmt.executeQuery(sql);
            List<Trash> trashList = new ArrayList<>();
            switch (state) {
                case 1: {
                    while (rs.next()) {
                        trashList.add(new Trash(rs.getString("ODP_NAZEV"), rs.getInt("ODP_MNOZ")));
                    }
                    return trashList;
                }
                case 2: {
                    while(rs.next()) {
                        trashList.add(new Trash(rs.getNString("ODP_NAZEV"),rs.getInt("ODP_MNOZ"), rs.getInt("ODP_ODPID")));
                    }
                    return trashList;
                }
            }

        }
        return null;
    }

}
