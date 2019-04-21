package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {

    Stage window;
    Button addPass;
    public Accordion passwordViewer;
    public Vault vault;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        window = primaryStage;
        window.setTitle("JPass - Home");
        //window.setMinWidth(300);
        //window.setMinHeight(500);

        vault = new Vault();


        Button addPassButton = new Button("Add Password");
        addPassButton.setOnAction(e-> {
            vault.addPassword(PasswordAddForm.display());
            updatePasswordViewer();
        });

        Button removePassButton = new Button("Remove Selected Password");
        removePassButton.setOnAction(e->deleteSelectedPassword());

        Button clearVaultButton = new Button("Clear Vault");
        clearVaultButton.setOnAction(e->clearPasswords());

        Label vaultPathLabel = new Label("File path for vault");
        TextField vaultPathField = new TextField("Vault Path");
        Label vaultShiftLabel = new Label("Encryption key (#)");
        TextField vaultShiftField = new TextField("1");
        Button saveVaultButton = new Button("Save vault");
        saveVaultButton.setOnAction(e->vault.saveVault(vaultPathField.getText(), Integer.parseInt(vaultShiftField.getText())));

        Button loadVaultButton = new Button("Load Vault");
        loadVaultButton.setOnAction(e-> {
            vault.loadVault(vaultPathField.getText(), Integer.parseInt(vaultShiftField.getText()));
            updatePasswordViewer();
        });

        VBox vaultOptionsLayout = new VBox(10);
        vaultOptionsLayout.getChildren().addAll(vaultPathLabel, vaultPathField, vaultShiftLabel, vaultShiftField, saveVaultButton, loadVaultButton);
        vaultOptionsLayout.setAlignment(Pos.CENTER);
        vaultOptionsLayout.setPadding(new Insets(10,10,10,10));

        VBox centerLayout = new VBox(10);
        centerLayout.getChildren().addAll(addPassButton, removePassButton, clearVaultButton);
        centerLayout.setAlignment(Pos.CENTER);
        centerLayout.setPadding(new Insets(10,10,10,10));

        passwordViewer = new Accordion();

        VBox passViewerLayout = new VBox(10);
        passViewerLayout.getChildren().addAll(passwordViewer);
        passViewerLayout.setAlignment(Pos.CENTER);
        passViewerLayout.setPadding(new Insets(10,10,10,10));

        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(vaultOptionsLayout);
        borderPane.setCenter(centerLayout);
        borderPane.setRight(passViewerLayout);
        borderPane.setPrefWidth(400);
        borderPane.setPrefHeight(300);
        Scene scene = new Scene(borderPane);
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

    public void updatePasswordViewer(){
        passwordViewer.getPanes().removeAll(passwordViewer.getPanes());
        for (Password p : vault.getPasswords()){
            TitledPane tp = new TitledPane(p.getSiteTitle(), new Text(p.toString()));
            passwordViewer.getPanes().add(tp);
        }
        //passwordViewer.getPanes().addAll();
    }

    public void deleteSelectedPassword(){
        System.out.println(passwordViewer.getExpandedPane().getText());
        for (int i = 0; i< vault.getPasswords().size();i++){
            if (vault.getPasswords().get(i).getSiteTitle().equals(passwordViewer.getExpandedPane().getText())){
                vault.getPasswords().remove(vault.getPasswords().get(i));
                break;
            }
        }
        updatePasswordViewer();
    }

    public void clearPasswords(){
        vault.getPasswords().clear();
        updatePasswordViewer();
    }
}
