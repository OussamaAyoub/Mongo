package sample;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import org.bson.Document;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Aggregate {
    private String name;
    private String description;
    private DBCollection col;
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

    public DBCollection getCol() {
        return col;
    }

    public void setCol(DBCollection col) {
        this.col = col;
    }

    public List<DBObject> getList() {
        return list_object;
    }

    public void setList(List<DBObject> list) {
        this.list_object = list;
    }

    public Aggregate(String name, String description, DBCollection col, ArrayList<Document_item> list) {
        this.name = name;
        this.description = description;
        this.col = col;
        this.list_items = list;
        for (Document_item item: list_items) {
            DBObject object=(DBObject) new BasicDBObject(item.getType(),new Document_item(item.getCategory(),item.getValue()));
        }
    }
    private void add_dbobject(Document_item item){
        this.list_items.add(item);
    }

    private Iterable<DBObject> createAggregate(){
        Iterable<DBObject> output = col.aggregate(list_object).results();
        return output;
    }



}
