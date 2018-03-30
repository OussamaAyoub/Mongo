package sample;

import com.mongodb.BasicDBObject;
import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.table.TableColumn;
import java.io.IOException;
import java.util.ArrayList;

public class Controller  {
    @FXML
    Pane pane;
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
    MenuBar menuBar;
    @FXML
    TextArea AreaResult;

    private ArrayList<Request> requests;
    private ArrayList<Aggregate> aggregates;
    private Request currentRequest;

    @FXML
    public void initialize(){

        SLfile sLfile=new SLfile();
        requests=sLfile.LoadRequest();
        //aggregates=sLfile.LoadAggregate();
        int i=0;
        for (final Request request:requests) {
            i++;
            Menu menu=(Menu) menuBar.getMenus().get(0);
            MenuItem item=new MenuItem();
            item.setText(request.getName());
            item.setId("Query"+i);
            item.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    currentRequest=request;
                    int j=0;
                    for (Document_item doc_item:request.getItems()) {
                        j++;
                        String selector="#lblparam"+j;
                        Label label=(Label) menuBar.getScene().lookup(selector);
                        System.out.println(label.getId());
                        label.setText(doc_item.getCategory());
                    }
                }
            });
            menu.getItems().add(item);


        }
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


    public void click_admin(ActionEvent actionEvent) {
        showLoginScreen();
    }

    public void clickSearch(ActionEvent actionEvent) {
        int i=0;
        for (Document_item item:currentRequest.getItems()) {
            i++;
            String selector="#txtParam"+i;
            TextField txt=(TextField) menuBar.getScene().lookup(selector);
            System.out.println("SOHFELAZBJDPLCAJHZBKFJAZNAD");
            System.out.println(item.getValue().getClass());
            if(item.getValue().getClass().getName().equals("java.lang.String")){
                item.setValue(txt.getText());
            }
            else {
                int foo = Integer.parseInt(txt.getText());
                item.setValue(new BasicDBObject("$gt",foo));
            }


        }
        AreaResult.setText(currentRequest.ExecuteRequest());
    }


}
