package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.print.Doc;
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
                Request request=new Request(txtName.getText(),txtDesc.getText(),list_doc);
                requests.add(request);
                sLfile.SaveRequest(requests);
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
