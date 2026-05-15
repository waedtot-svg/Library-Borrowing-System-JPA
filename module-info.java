module libraryBorrowingSystemJPA {

    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    requires java.sql;
    requires java.persistence;
    requires java.instrument;

    opens app to javafx.fxml;
    opens controllers to javafx.fxml;
    opens models;

    exports models;
    exports app;
}
