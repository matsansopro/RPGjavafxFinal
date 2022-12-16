module com.example.rpgjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.rpgjavafx to javafx.fxml;
    exports com.example.rpgjavafx;
}