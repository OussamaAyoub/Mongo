package sample;

import com.mongodb.*;

import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Request implements Serializable {
    private String name;
    private String description;
    private ArrayList<Document_item> items;

    public Request(String name, String description) {
        this.name = name;
        this.description = description;

        items=new ArrayList<Document_item>();
    }

    public Request(String name,String description, ArrayList<Document_item> items) {
        this.name = name;
        this.description = description;
        this.items = items;
    }

    @Override
    public String toString() {
        return "Request{}";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Document_item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Document_item> items) {
        this.items = items;
    }


    public String ExecuteRequest(){
        MongoClient mongo = new MongoClient(Config.localhost, Config.port);
        DB db = mongo.getDB("DBRestaurants");
        DBCollection collection = db.getCollection("InspectionRestaurant");
        BasicDBObject searchQuery = new BasicDBObject();
        for (Document_item element:items) {
            searchQuery.put(element.getCategory(),element.getValue());
        }
        DBCursor cursor=collection.find(searchQuery);
        String result="";
        while (cursor.hasNext()) {
            result+=cursor.next()+"\n";
        }
        mongo.close();
        return result;
    }
    public void add_docItem(Document_item doc){
        items.add(doc);
    }

}
