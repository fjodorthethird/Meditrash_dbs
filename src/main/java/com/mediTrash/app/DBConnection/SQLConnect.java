package com.mediTrash.app.DBConnection;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

// таке ничего не трогать

public class SQLConnect {

    protected SQLServerDataSource dataSource;

    public SQLConnect() {
        dataSource = new SQLServerDataSource();
        dataSource.setServerName(Config.serverName);
        dataSource.setDatabaseName(Config.dataBaseName);
        dataSource.setUser(Config.username);
        dataSource.setPassword(Config.password);
    }

}
