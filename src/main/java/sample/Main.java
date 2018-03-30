package sample;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.sun.org.apache.regexp.internal.RE;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.print.Doc;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    static ArrayList<String> lists;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/LoginPage.fxml"));
        primaryStage.setTitle("MongoDB Interface");
        primaryStage.setScene(new Scene(root, 1200, 1000));
        primaryStage.show();

        
    }


    public static void main(String[] args) {
        launch(args);
        /*ArrayList<Request> requests=new ArrayList<Request>();
        Document_item item=new Document_item("name","Startbucks Coffee");
        Document_item item1=new Document_item("borough","Bronx");
        MongoClient mongo = new MongoClient("localhost", 27017);
        DB db = mongo.getDB("RestaurantsInspections");
        ArrayList<Document_item> list=new ArrayList<Document_item>();
        list.add(item);
        list.add(item1);
        DBCollection col = db.getCollection("inspection");
        Request request=new Request("test","test",list);
        requests.add(request);
        SLfile sLfile=new SLfile();
        sLfile.SaveRequest(requests);*/

        /*BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("name", "Starbucks Coffee");
        searchQuery.put("borough", "Manhattan");
        String cuisine="Turkish";
        //DBCursor cursor = col.find(searchQuery);
        Iterable<DBObject> output = col.aggregate(Arrays.asList(
                (DBObject) new BasicDBObject("$match", new Document("cuisine", cuisine)),
                (DBObject) new BasicDBObject("$match", new Document("borough", "Brooklyn")),
                (DBObject) new BasicDBObject("$group", new Document("_id", "$address.street").append("tot",new BasicDBObject("$sum",1))),
                (DBObject) new BasicDBObject("$limit", 200)
        )).results();*/

// Print for demo
        /*for (DBObject dbObject : output)
        {
            System.out.println(dbObject);
        }
        DBCursor cursor;*/


        /*Document_item doc=new Document_item("name","Starbucks Coffee");
        Document_item doc1=new Document_item("borough","Manhattan");
        Request request =new Request("test","test",col);
        request.add_docItem(doc);
        request.add_docItem(doc1);
        cursor=request.createRequest();
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }*/

    }
}
