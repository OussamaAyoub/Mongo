package sample;

import com.mongodb.*;
import com.sun.org.apache.regexp.internal.RE;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.bson.Document;

import javax.print.Doc;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
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
        /*ArrayList<Aggregate> requests=new ArrayList<Aggregate>();
        Document_item item=new Document_item("$match","cuisine","");
        Document_item item2=new Document_item("$match","borough","");
        Document_item item3=new Document_item("$group","_id","");
        Document_item item4=new Document_item("$limit","limit","");
        //MongoClient mongo = new MongoClient("localhost", 27017);
        //DB db = mongo.getDB("RestaurantsInspections");
        ArrayList<Document_item> list=new ArrayList<Document_item>();
        list.add(item);
        list.add(item2);
        list.add(item3);
        list.add(item4);
        Aggregate aggregate=new Aggregate("Aggregate1","Search",list);
        requests.add(aggregate);
        SLfile sLfile=new SLfile();
        sLfile.SaveAggregate(requests);
        //DBCollection col = db.getCollection("inspection");
        /*Request request=new Request("Search Score","Search by name and by grade's score grater than",list);
        requests.add(request);
        list=new ArrayList<Document_item>();
        list.add(item);
        list.add(item2);
        request=new Request("Search Restaurant","Find the address of your favorite restaurant.",list);
        requests.add(request);
        list=new ArrayList<Document_item>();
        list.add(item2);
        list.add(item3);
        request=new Request("Search Borough","Find all the restaurants of a cuisine in a specific borough.",list);
        requests.add(request);

        */
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
