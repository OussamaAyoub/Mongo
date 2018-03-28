package sample;

public class Document_item {
    private String type;
    private String category;
    private String value;

    public Document_item(String category, String value) {
        this.category = category;
        this.value = value;
    }

    public Document_item(String type, String category, String value) {
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
