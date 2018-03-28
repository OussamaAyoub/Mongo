package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.table.TableColumn;
import java.io.IOException;

public class Controller  {
    @FXML
    Label desc;
   @FXML
   Label lblparam1;
    @FXML
    Label lblparam2;
    @FXML
    Label lblparam3;
    @FXML
    Label lblparam4;
    @FXML
    Label lblparam5;
    @FXML
    Label lblparam6;
    @FXML
    MenuItem AggregQ1;






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


    public void click_admin(ActionEvent actionEvent) {
        showLoginScreen();
    }

    public void clickSearch(ActionEvent actionEvent) {
    }

    public void click_SimpleQ1(ActionEvent actionEvent) {
        desc.setText("Find a Restaurant ");
        lblparam1.setText("Name");
        lblparam2.setText("Cuisine");
        lblparam3.setText("Borough");
        lblparam4.setText("");
        lblparam5.setText("");
        lblparam6.setText("");
    }

    public void click_SimpleQ2(ActionEvent actionEvent) {
        desc.setText("Find a Restaurant with a high score ");
        lblparam1.setText("Cuisine");
        lblparam2.setText("Score above than :");
        lblparam3.setText("");
        lblparam4.setText("");
        lblparam5.setText("");
        lblparam6.setText("");

    }

    public void click_SimpleQ3(ActionEvent actionEvent) {
        lblparam1.setText("");
        lblparam2.setText("");
        lblparam3.setText("");
        lblparam4.setText("");
        lblparam5.setText("");
        lblparam6.setText("");

    }

    public void click_AggregQ1(ActionEvent actionEvent) {
        lblparam1.setText("");
        lblparam2.setText("");
        lblparam3.setText("");
        lblparam4.setText("");
        lblparam5.setText("");
        lblparam6.setText("");
    }

    public void click_AggregQ2(ActionEvent actionEvent) {
        lblparam1.setText("Test");
        lblparam2.setText("");
        lblparam3.setText("");
        lblparam4.setText("");
        lblparam5.setText("");
        lblparam6.setText("");
    }

    public void click_AggregQ3(ActionEvent actionEvent) {
        lblparam1.setText("");
        lblparam2.setText("");
        lblparam3.setText("");
        lblparam4.setText("");
        lblparam5.setText("");
        lblparam6.setText("");
    }
}
