package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginPageController {
    public void handle_btnLogin(ActionEvent actionEvent) {
        ShowClientScreen();
    }

    public void handle_btnAdmin(ActionEvent actionEvent) {
        showLoginScreen();

    }

    public void setLoggedInUser(String user) {

        //loggedInUser = user;

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Successful login");

        alert.setHeaderText("Successful login");

        String s = user + " logged in!";

        alert.setContentText(s);

        alert.show();

    }

    public void ShowClientScreen(){

        final Stage s = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/client.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        s.setTitle("MongoDB Interface");
        s.setScene(new Scene(root, 500, 500));
        s.show();


    }
    public void showLoginScreen() {

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

                //setLoggedInUser(textUser.getText());
                final Stage s = new Stage();
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("/admin.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                s.setTitle("Administrator Page");
                s.setScene(new Scene(root, 500, 500));
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
