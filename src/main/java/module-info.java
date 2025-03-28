module appli.todolistfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires java.sql;
    requires jbcrypt;
    requires jdk.jshell;
    requires java.desktop;


    opens appli to javafx.fxml;
    exports appli;
    exports appli.accueil;
    opens appli.accueil to javafx.fxml;
    opens model to javafx.base;
}