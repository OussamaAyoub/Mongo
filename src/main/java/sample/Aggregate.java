package sample;

import com.mongodb.*;
import org.bson.Document;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Aggregate implements Serializable {
    private String name;
    private String description;
    private ArrayList<Document_item> list_items;
    private List<DBObject> list_object;

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

    public List<DBObject> getList() {
        return list_object;
    }

    public void setList(List<DBObject> list) {
        this.list_object = list;
    }

    public ArrayList<Document_item> getList_items() {
        return list_items;
    }

    public void setList_items(ArrayList<Document_item> list_items) {
        this.list_items = list_items;
    }

    public Aggregate(String name, String description,ArrayList<Document_item> list) {
        this.name = name;
        this.description = description;
        this.list_items = list;
        for (Document_item item: list_items) {
            DBObject object=(DBObject) new BasicDBObject(item.getType(),new Document_item(item.getCategory(),item.getValue()));
        }
    }
    private void add_dbobject(Document_item item){
        this.list_items.add(item);
    }

    private String ExecuteAggregate(){
        MongoClient mongo = new MongoClient(Config.localhost, Config.port);
        DB db = mongo.getDB("DBRestaurants");
        DBCollection collection = db.getCollection("InspectionRestaurant");
        Iterable<DBObject> output = collection.aggregate(list_object).results();
        String result="";
        for (DBObject dbObject : output)
        {
            result+=dbObject.toString()+"\n";
        }
        return result;
    }



}
