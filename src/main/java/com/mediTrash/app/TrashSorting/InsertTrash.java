package com.mediTrash.app.TrashSorting;

import com.mediTrash.app.DBConnection.SQLConnect;
import com.mediTrash.app.Data.Trash;

import java.sql.*;

public class InsertTrash extends SQLConnect {

    public void Insert(Trash t) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            String sql = String.format("INSERT INTO Odpad(ODP_NAZEV,ODP_KATEG,ODP_MNOZ,ODP_ODPID) VALUES (?,?,?,?)");
            PreparedStatement preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,t.getNameOfTrash());
            preparedStatement.setString(2,t.getCategory());
            preparedStatement.setFloat(3,t.getCountOfTrash());
            preparedStatement.setInt(4,t.getTrashId());
            preparedStatement.executeUpdate();
        }
    }



}

