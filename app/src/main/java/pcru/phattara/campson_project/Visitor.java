package pcru.phattara.campson_project;

public class Visitor {
    private String name;
    private String age;
    private String dateTime;

    public Visitor(String name, String age, String dateTime) {
        this.name = name;
        this.age = age;
        this.dateTime = dateTime;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
