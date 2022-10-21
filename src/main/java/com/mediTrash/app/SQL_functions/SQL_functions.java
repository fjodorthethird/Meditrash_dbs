package com.mediTrash.app.SQL_functions;

import java.sql.SQLException;

public interface SQL_functions<T> {

    boolean loginControl(T t) throws SQLException;
    boolean passControl(T t) throws SQLException;
    int getID() throws SQLException;
    void DeleteUser(String username)  throws SQLException;

}
