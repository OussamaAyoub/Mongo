package sample;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import java.awt.event.ActionEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Request {
    private String name;
    private String description;
    private ArrayList<Document_item> items;
    private DBCollection collection;

    public Request(String name, String description, DBCollection collection) {
        this.name = name;
        this.description = description;
        this.collection = collection;
        items=new ArrayList<Document_item>();
    }

    public Request(String name, String description, DBCollection collection, ArrayList<Document_item> items) {
        this.name = name;
        this.description = description;
        this.collection = collection;
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

    public DBCursor createRequest(){
        BasicDBObject searchQuery = new BasicDBObject();
        for (Document_item element:items) {
            searchQuery.put(element.getCategory(),element.getValue());
        }
        DBCursor cursor=collection.find(searchQuery);
        return cursor;
    }
    public void add_docItem(Document_item doc){
        items.add(doc);
    }

}
