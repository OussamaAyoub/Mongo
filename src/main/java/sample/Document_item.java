package sample;

import java.io.Serializable;

public class Document_item implements Serializable {
    private String type;
    private String category;
    private Object value;

    public Document_item(String category, Object value) {
        this.category = category;
        this.value = value;
    }

    public Document_item(String type, String category, Object value) {
        this.type = type;
        this.category = category;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
