package pcru.phattara.campson_project;

public class Visitor {
    int id;
    String name;
    int age;
    String time_stamp;
    public Visitor(String name, int age, String time_stamp) {
        this.name = name;
        this.age = age;
        this.time_stamp = Utility.get_ts();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getTime_stamp() {
        return time_stamp;
    }
    public void setTime_stamp() {
        this.time_stamp = Utility.get_ts();
    }
}
