package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/LoginPage.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

        
    }


    public static void main(String[] args) {
        launch(args);
        /*ArrayList<Request> requests=new ArrayList<Request>();
        Document_item item=new Document_item("name","Startbucks Coffee");
        Document_item item1=new Document_item("borough","Bronx");
        MongoClient mongo = new MongoClient("localhost", 27017);
        DB db = mongo.getDB("RestaurantsInspections");

        DBCollection col = db.getCollection("inspection");*/

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
