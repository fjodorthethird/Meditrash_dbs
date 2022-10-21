package com.mediTrash.app.Tools.Methods;

import com.mediTrash.app.DBConnection.SQLConnect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class getAPid extends SQLConnect {

    public int getAPid(int trashId) throws SQLException {
        try(Connection connection = dataSource.getConnection()) {
            Statement stmt = connection.createStatement();
            String sql = "SELECT ODP_ID FROM Vyhazovani_Odpadu WHERE ODP_ODPID = " + trashId;
            ResultSet rs = stmt.executeQuery(sql);
            int apID = 0;
            while(rs.next()) {
                apID = (rs.getInt("ODP_ID"));
                break;
            }
            return apID;
        }
    }


}
