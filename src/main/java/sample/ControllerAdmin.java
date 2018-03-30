package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ControllerAdmin {
    @FXML
    ChoiceBox<String> boxParam;
    @FXML
    TextArea txtArea;
    @FXML
    Button btnAdd;

    String items ="";


    public void onclick(ActionEvent actionEvent) {
        String selected = boxParam.getSelectionModel().getSelectedItem().toString();
        items +=  selected + "\n";
        txtArea.setText(items);

    }


}
