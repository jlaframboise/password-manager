package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {

    Stage window;
    Button addPass;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        window = primaryStage;
        window.setTitle("JPass - Home");
        window.setMinWidth(300);
        window.setMinHeight(500);

        Vault vault = new Vault();


        Button addPassButton = new Button("Add Password");
        addPassButton.setOnAction(e-> {
            vault.addPassword(PasswordAddForm.display());
        });

        Button viewVaultButton = new Button("View Passwords");
        viewVaultButton.setOnAction(e->{
            for (Password p : vault.getPasswords()){
                System.out.println(p.toString());
            }
        });


        Label vaultPathLabel = new Label("File path for vault");
        TextField vaultPathField = new TextField("Vault Path");
        Button saveVaultButton = new Button("Save vault");
        saveVaultButton.setOnAction(e->vault.saveVault(vaultPathField.getText()));

        VBox layout = new VBox(10);
        layout.getChildren().addAll(addPassButton, viewVaultButton, vaultPathLabel, vaultPathField, saveVaultButton);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
        //primaryStage.setScene(new Scene(root, 300, 275));
        //primaryStage.show();
    }


    public static void main(String[] args) {
//        System.out.println("Encrypting");
//        System.out.println(Encryption.encrypt("~", 1));
//        System.out.println("Decrypting");
//        System.out.println(Encryption.decrypt(" ", 1));
        launch(args);
    }
}
