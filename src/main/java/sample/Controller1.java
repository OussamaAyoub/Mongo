package sample;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;

public class Controller1 {
    @FXML
    TextArea result;
    @FXML
    TextField param1;
    @FXML
    TextField param2;
    @FXML
    Label nameparam1;
    @FXML
    Label nameparam2;
    @FXML
    Button btnResult;
    Request request;
    @FXML
    public void initialize(){
        Document_item item=new Document_item("name","");
        Document_item item1=new Document_item("borough","");
        MongoClient mongo = new MongoClient("localhost", 27017);
        DB db = mongo.getDB("RestaurantsInspections");
        DBCollection col = db.getCollection("inspection");
        request=new Request("test","test",col);
        request.add_docItem(item);
        request.add_docItem(item1);
        nameparam1.setText(request.getItems().get(0).getCategory());
        nameparam2.setText(request.getItems().get(1).getCategory());
    }
    public void Search(){
        request.getItems().get(0).setValue(param1.getText());
        request.getItems().get(1).setValue(param2.getText());
        DBCursor cursor=request.createRequest();
        StringBuilder fieldContent = new StringBuilder("");
        while (cursor.hasNext()) {
            fieldContent.append(cursor.next().toString()+"\n");
        }
        result.setText(fieldContent.toString());
    }
}
