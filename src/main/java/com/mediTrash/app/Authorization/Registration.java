package com.mediTrash.app.Authorization;

import  com.mediTrash.app.DBConnection.SQLConnect;
import  com.mediTrash.app.Data.User;
import  com.mediTrash.app.SQL_functions.DataControlFunctions;

import java.sql.*;


public class Registration extends SQLConnect {


    //Полная регистрация нового пользователя, на вступ идёт объект пользователя со всеми данными

    public void RegistrationForm(User s) throws SQLException{
        DataControlFunctions func = new DataControlFunctions();
        try (Connection connection = dataSource.getConnection()) {
            if (func.loginControl(s.getLogin())) {
                throw new SQLException();
            }
            String sql = String.format("INSERT INTO Uzivatel(FIR_ID,FIR_NAZEV,FIR_ULICE,FIR_MISTO,FIR_PSC,FIR_KOD,FIR_TEL,FIR_MAIL,FIR_FAX,FIR_PRAV,FIR_LOGIN,FIR_HESLO,FIR_PROVOZ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            PreparedStatement preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1,s.getId());
            preparedStatement.setString(2,s.getName());
            preparedStatement.setString(3,s.getUserAddress());
            preparedStatement.setString(4,s.getCity());
            preparedStatement.setString(5,s.getPostcode());
            preparedStatement.setString(6,s.getUserICO());
            preparedStatement.setString(7,s.getUserPhone());
            preparedStatement.setString(8,s.getEmail());
            preparedStatement.setString(9,s.getFax());
            preparedStatement.setString(10,s.getLegalPerson());
            preparedStatement.setString(11,s.getLogin());
            preparedStatement.setString(12,s.getPassword());
            preparedStatement.setString(13,s.getOfficeCode());
            preparedStatement.executeUpdate();
        }
    }

}
