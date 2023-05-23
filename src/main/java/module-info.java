module trpl.lmss {
    requires javafx.controls;
    requires javafx.fxml;

    opens trpl.lms to javafx.fxml;
    opens trpl.classes to javafx.fxml;
    opens trpl.dataaccess to javafx.fxml;
    exports trpl.lms;
    exports trpl.classes;
    exports trpl.dataaccess;
}
