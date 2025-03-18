module com.tictactoegame {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.tictactoegame to javafx.fxml;
    exports com.tictactoegame;
}