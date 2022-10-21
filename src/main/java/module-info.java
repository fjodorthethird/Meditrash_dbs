module com.meditrashcorp.ui {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;
    requires com.microsoft.sqlserver.jdbc;
    requires poi;
    requires java.naming;

    opens com.meditrashcorp.ui to javafx.fxml;
    opens com.mediTrash.app.Data to javafx.fxml;
    opens com.mediTrash.app.SQL_functions to javafx.fxml;
    opens com.mediTrash.app.ZpusobNakladani to javafx.fxml;
    exports com.mediTrash.app.ZpusobNakladani;
    exports com.meditrashcorp.ui;
    exports com.mediTrash.app.Data;
    exports com.mediTrash.app.SQL_functions;
}