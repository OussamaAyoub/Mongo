package sample;

import com.sun.org.apache.regexp.internal.RE;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.util.ArrayList;


public class LoginPageController {
    @FXML
    PasswordField passwordField;
    @FXML TextField userField;
    @FXML Button btnConnect;

    String user = "User";
    String password = "1234";

    public void handle_btnLogin(ActionEvent actionEvent) {

        //AlertHelper.showAlert(Alert.AlertType.CONFIRMATION, owner, "Registration Successful!","Welcome " + userField.getText());

        if ((userField.getText() == user )&&(passwordField.getText() == password)){
            ShowClientScreen();
        }

    }

    public void handle_btnAdmin(ActionEvent actionEvent) {
        showLoginScreen();

    }


    public void ShowClientScreen(){
        Stage stage=(Stage) passwordField.getScene().getWindow();
        stage.close();
        final Stage s = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/client.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        s.setTitle("MongoDB Interface");
        s.setScene(new Scene(root, 1200, 1000));
        s.show();


    }
    public void showLoginScreen() {
        Stage stage1=(Stage) passwordField.getScene().getWindow();
        stage1.close();
        final Stage stage = new Stage();

        VBox box = new VBox();

        box.setPadding(new Insets(10));
        box.setAlignment(Pos.CENTER);
        Label label = new Label("Enter username and password");
        final TextField textUser = new TextField();
        textUser.setPromptText("enter user name");
        TextField textPass = new TextField();
        textPass.setPromptText("enter password");
        Button btnLogin = new Button();
        btnLogin.setText("Login");

        btnLogin.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                final Stage s = new Stage();
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("/admin.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                s.setTitle("Administrator Page");
                s.setScene(new Scene(root, 1200, 1000));
                s.show();

            }

        });
        box.getChildren().add(label);
        box.getChildren().add(textUser);
        box.getChildren().add(textPass);
        box.getChildren().add(btnLogin);
        Scene scene = new Scene(box, 250, 150);
        stage.setScene(scene);
        stage.show();
    }
}
