import java.util.ArrayList;

public class Epic extends Task{

    String name;

    ArrayList<Task> subtaskList = new ArrayList<>();

    public Epic() {
    }

    public Epic(int id, String name) {
        super(id);
        this.name = name;
    }

}