package com.example.rpgjavafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private Button playButton;

    @FXML
    protected void onHelloButtonClick() throws IOException {
        //aller à la page du jeu
        Stage stage = new Stage();
        Stage stage1 = (Stage) playButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Page Game.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Page du jeu");

        stage.setScene(scene);
        stage.show();
        stage1.close();

        }

    }