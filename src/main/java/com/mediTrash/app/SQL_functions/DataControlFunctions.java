package com.mediTrash.app.SQL_functions;

import com.mediTrash.app.DBConnection.SQLConnect;
import com.mediTrash.app.Data.Trash;
import com.mediTrash.app.Data.User;
import com.mediTrash.app.Data.WasteDisposal;

import java.sql.*;
import java.util.ArrayList;

public class DataControlFunctions extends SQLConnect implements SQL_functions {
    @Override
    public boolean loginControl(Object o) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            Statement stmt = connection.createStatement();
            String sql = ("SELECT * FROM Uzivatel");
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                if (o.equals(rs.getString("FIR_LOGIN"))) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean passControl(Object o) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            Statement stmt = connection.createStatement();
            String sql = ("SELECT * FROM Uzivatel");
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                if (o.equals(rs.getString("FIR_HESLO"))) {
                    return true;
                }
            }
        }
        return false;
    }
    @Override
    public int getID() throws SQLException {
        int res = 0;
        try (Connection connection = dataSource.getConnection()) {
            Statement stmt = connection.createStatement();
            String sql = ("SELECT MAX(FIR_ID) FROM Uzivatel");
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                res = rs.getInt(1);
                break;
            }
        }
        return res;
    }

    public String getZar(String name) throws SQLException {
        String res = "";
        try (Connection connection = dataSource.getConnection()) {
            Statement stmt = connection.createStatement();
            String sql = ("SELECT FIR_NAZEV FROM Uzivatel WHERE FIR_LOGIN = " + name);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                res = rs.getString(1);
                break;
            }
        }
        return res;
    }

    public void userNameChanger(String usernameOld, String usernameNew) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            String sql = ("UPDATE Uzivatel SET FIR_LOGIN=? WHERE FIR_LOGIN=?");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,usernameNew);
            preparedStatement.setString(2,usernameOld);
            preparedStatement.executeUpdate();
        }
    }
    @Override
    public void DeleteUser(String username) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "DELETE FROM Uzivatel WHERE FIR_LOGIN =?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.executeUpdate();
        }
    }

    public void nameofMedicalChanger(String username, String name) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            String sql = ("UPDATE Uzivatel SET FIR_NAZEV=? WHERE FIR_LOGIN=?");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,username);
            preparedStatement.executeUpdate();
        }
    }

    public void PwdChanger(String login, String pwd) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            String sql = ("UPDATE Uzivatel SET FIR_HESLO=? WHERE FIR_LOGIN=?");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,pwd);
            preparedStatement.setString(2,login);
            preparedStatement.executeUpdate();
        }
    }

    public int getTrashID() throws SQLException {
        int res = 0;
        try (Connection connection = dataSource.getConnection()) {
            Statement stmt = connection.createStatement();
            String sql = ("SELECT MAX(ODP_ODPID) FROM Odpad");
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                res = rs.getInt(1);
                break;
            }
        }
        return res;
    }

    public int getVHID() throws SQLException {
        int res = 0;
        try (Connection connection = dataSource.getConnection()) {
            Statement stmt = connection.createStatement();
            String sql = ("SELECT MAX(ODP_VHID) FROM Vyhazovani_Odpadu");
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                res = rs.getInt(1);
                break;
            }
        }
        return res;
    }


    public void InsertVyhazovani(int osobaId,  java.sql.Timestamp datum, int vhid, String zpnkl, int userID, int odpadID) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            String sql = String.format("INSERT INTO Vyhazovani_Odpadu(ODP_ID,ODP_DATUM,ODP_VHID,ODP_ZPNAKL, FIR_ID, ODP_ODPID) VALUES (?,?,?,?,?,?)");
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, osobaId);
            preparedStatement.setTimestamp(2, datum);
            preparedStatement.setInt(3, vhid);
            preparedStatement.setString(4, zpnkl);
            preparedStatement.setInt(5, userID);
            preparedStatement.setInt(6, odpadID);
            preparedStatement.executeUpdate();
        }
    }


    public ArrayList<WasteDisposal> waste(String login) throws SQLException {
        ArrayList<WasteDisposal> waste = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            String sql = ("select u.FIR_NAZEV, o.ODP_NAZEV, o.ODP_KATEG, o.ODP_MNOZ, oo.ODP_PARTNER, zn.ODP_ZPNAKL,  vo.ODP_VHID, vo.ODP_DATUM \n" +
                    "from Uzivatel u, Odpad o, Opravnena_osoba oo, Vyhazovani_Odpadu vo, Zpusob_nakladani zn \n" +
                    "where u.FIR_ID = vo.FIR_ID  and oo.ODP_ID = vo.ODP_ID and zn.ODP_ZPNAKL = vo.ODP_ZPNAKL and o.ODP_ODPID = vo.ODP_ODPID and u.FIR_LOGIN =?");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, login);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                waste.add(new WasteDisposal(rs.getInt(7),rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4),
                        rs.getInt(5), rs.getString(6), rs.getTimestamp(8)));
            }
        }
        return waste;
    }


    public User getCurUser(String login, String pswd) {
        User res = null;
        try (Connection connection = dataSource.getConnection()) {
            Statement stmt = connection.createStatement();
            String query = String.format("SELECT * FROM Uzivatel where FIR_LOGIN ='%s' and FIR_HESLO='%s'", login, pswd);
            String sql = (query);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                res = new User(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),
                        rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),
                        rs.getString(12),rs.getString(13));
                break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public void DeleteWasteDisposal(int VHID) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "DELETE FROM Vyhazovani_Odpadu WHERE ODP_VHID =?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,VHID);
            preparedStatement.executeUpdate();
        }
    }

    public void DeleteUserID(int FIR_ID) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "DELETE FROM Uzivatel WHERE FIR_ID =?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,FIR_ID);
            preparedStatement.executeUpdate();
        }
    }
}
