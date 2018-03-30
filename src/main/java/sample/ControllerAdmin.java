package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.print.Doc;
import java.io.IOException;
import java.util.ArrayList;

public class ControllerAdmin {
    @FXML
    TextField txtName;
    @FXML
    TextField txtDesc;
    @FXML
    ChoiceBox boxParam;
    @FXML
    TextArea txtArea;
    @FXML
    Button btnAdd;
    @FXML
    Button Confirm;
    @FXML
    Label error;

    String items ="";
    SLfile sLfile;
    private ArrayList<Request> requests;
    private ArrayList<Aggregate> aggregates;
    private Request currentRequest;
    ArrayList<Document_item> list_doc;

    @FXML
    public void initialize(){
        list_doc=new ArrayList<Document_item>();
        sLfile=new SLfile();
        requests=sLfile.LoadRequest();
        Confirm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{
                    if(txtName.getText().equals("") || txtDesc.getText().equals("") || items.equals("")){
                        throw new Exception();
                    }
                    Request request=new Request(txtName.getText(),txtDesc.getText(),list_doc);
                    requests.add(request);
                    sLfile.SaveRequest(requests);
                }
                catch (Exception e){
                    error.setText("Complete All Area");
                    return;
                }
                Stage stage=(Stage) txtArea.getScene().getWindow();
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
        });
    }
    public void onclick(ActionEvent actionEvent) {
        list_doc.add(new Document_item(boxParam.getSelectionModel().getSelectedItem().toString(),""));
        String selected = boxParam.getSelectionModel().getSelectedItem().toString();
        items +=  selected + "\n";
        txtArea.setText(items);

    }



}
