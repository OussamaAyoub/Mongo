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
    Label txtDesc;
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
    @FXML
    Button btnSearch;

    private ArrayList<Request> requests;
    private ArrayList<Aggregate> aggregates;
    private Request currentRequest;
    private Aggregate currentAggregate;

    @FXML
    public void initialize(){
        currentRequest=null;
        currentAggregate=null;
        SLfile sLfile=new SLfile();
        try{
            requests=sLfile.LoadRequest();
            aggregates=sLfile.LoadAggregate();
        }
        catch (Exception e){
            AreaResult.setText("Files not found");
        }

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
                    btnSearch.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            clickSearch(event);
                        }
                    });
                    currentRequest=request;
                    txtDesc.setText(currentRequest.getDescription());
                    int j=0;
                    for (Document_item doc_item:request.getItems()) {
                        j++;
                        String selector="#lblparam"+j;
                        Label label=(Label) menuBar.getScene().lookup(selector);
                        label.setText(doc_item.getCategory());
                    }
                }
            });
            menu.getItems().add(item);
        }
        i=0;
        for (final Aggregate aggregate:aggregates) {
            i++;
            Menu menu=(Menu) menuBar.getMenus().get(1);
            MenuItem item=new MenuItem();
            item.setText(aggregate.getName());
            item.setId("Aggregate"+i);
            item.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    btnSearch.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            clickSearch(event);
                        }
                    });
                    currentAggregate=aggregate;
                    txtDesc.setText(currentAggregate.getDescription());
                    int j=0;
                    for (Document_item doc_item:aggregate.getList_items()) {
                        j++;
                        String selector="#lblparam"+j;
                        Label label=(Label) menuBar.getScene().lookup(selector);
                        label.setText(doc_item.getType()+" "+doc_item.getCategory());
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
        final TextField textPass = new TextField();
        textPass.setPromptText("enter password");
        Button btnLogin = new Button();
        btnLogin.setText("Login");
        btnLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if ((textUser.getText().equals(Config.adminName))&&(textPass.getText().equals(Config.adminPassword))) {
                    Stage stage1=(Stage) btnSearch.getScene().getWindow();
                    stage1.close();
                    final Stage s = new Stage();
                    stage.close();
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
                else{
                    stage.close();
                }
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
        try{
            currentRequest.equals(null);

        }
        catch (Exception e){
            AreaResult.setText("Select a query first !");
            return;
        }
        for (Document_item item:currentRequest.getItems()) {
            i++;
            String selector="#txtParam"+i;
            TextField txt=(TextField) menuBar.getScene().lookup(selector);
            if(txt.getText().equals("")){
                AreaResult.setText("Missing Fields");
                return;
            }
            if(item.getValue().getClass().getName().equals("java.lang.String")){
                item.setValue(txt.getText());
            }
            else {
                int foo=-1;
                try{
                    foo = Integer.parseInt(txt.getText());
                }
                catch (NumberFormatException e){
                    AreaResult.setText(e.toString());
                    return;
                }
                item.setValue(new BasicDBObject("$gt",foo));
            }


        }
        String result="";
        try{
            result=currentRequest.ExecuteRequest();
        }
        catch (Exception e){
            AreaResult.setText("The connection to the database didn't work,verify the host, port, name of the database and collection");
            return;
        }

        if(result!=""){
            AreaResult.setText(currentRequest.ExecuteRequest());
        }
        else{
            AreaResult.setText("No result !");
        }

    }


    public void click_quit(ActionEvent actionEvent) {
        Stage stage1=(Stage) pane.getScene().getWindow();
        stage1.close();
        final Stage s = new Stage();
        s.close();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/LoginPage.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        s.setTitle("MongoDB Interface");
        s.setScene(new Scene(root, 1200, 1000));
        s.show();
    }
}
