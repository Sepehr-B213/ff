package com.company;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class Main extends Application {

    static boolean flag = true;
    static int count = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Label label = new Label();
        label.setTextFill(Paint.valueOf("RED"));

        Button button = new Button("login");
        button.setDisable(true);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                label.setText("invalid");
            }
        });

        PasswordField passField = new PasswordField();
        passField.setPromptText("password");
        passField.setMaxWidth(100);

        TextField usernameField = new TextField();
        usernameField.setPromptText("username");
        usernameField.setMaxWidth(100);

        CheckBox checkBox = new CheckBox();
        checkBox.setText("");
        checkBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                button.setDisable(false);
            }
        });

        Hyperlink link = new Hyperlink();
        link.setText("شرایط و قوانین");
        link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("بی ادبی ممنوع");
            }
        });

        HBox hbox = new HBox();
        hbox.getChildren().addAll(checkBox, link);
        hbox.setAlignment(Pos.CENTER);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(usernameField, passField, hbox, button, label);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);

        StackPane pane = new StackPane();
        pane.getChildren().addAll(vbox);
        pane.setPrefSize(400, 400);


        Scene scene = new Scene(pane);

        stage.setScene(scene);
        stage.show();

    }
}
