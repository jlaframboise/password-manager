package sample;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PasswordAddForm {
    private static Password p;

    public static Password display(){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("JPass - Add Password");
        window.setMinWidth(200);
        window.setMinHeight(300);

        Group passwordEntryParts = new Group();

        Label titleLabel = new Label();
        titleLabel.setText("Enter the title for the entry: ");
        TextField titleField = new TextField("Title");
        passwordEntryParts.getChildren().addAll(titleLabel, titleField);


        Label usernameLabel = new Label();
        usernameLabel.setText("Enter the username for the entry: ");
        TextField usernameField = new TextField("Username");
        passwordEntryParts.getChildren().addAll(usernameLabel, usernameField);


        Label passwordLabel = new Label();
        passwordLabel.setText("Enter the password for the entry: ");
        TextField passwordField = new TextField("Password");
        passwordEntryParts.getChildren().addAll(passwordLabel, passwordField);


        Label urlLabel = new Label();
        urlLabel.setText("Enter the username for the entry: ");
        TextField urlField = new TextField("Web url");
        passwordEntryParts.getChildren().addAll(urlLabel, urlField);

        Button addPasswordButton = new Button("Add Password");
        addPasswordButton.setOnAction(e->{
            p = new Password();
            p.setSiteName(titleField.getText());
            p.setUserName(usernameField.getText());
            p.setPassword(passwordField.getText());
            p.setUrl(urlField.getText());
            window.close();
        });
        passwordEntryParts.getChildren().addAll(addPasswordButton);


        VBox layout = new VBox(10);
        layout.getChildren().addAll(passwordEntryParts.getChildren());
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return p;


    }
}
