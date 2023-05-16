package task;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Epic extends Task {

    protected ArrayList<Integer> subtaskIds = new ArrayList<>();

    public Epic(Status status, String name, String description) {
        super(status, name, description);
    }

    public void addSubtask(int id) {
        subtaskIds.add(id);
    }

    public List<Integer> getSubtasksIds() {
        return subtaskIds;
    }

    public void deleteSubtasks() {
        subtaskIds.clear();
    }

    public void deleteSubtask(int id) {
        subtaskIds.remove((Integer) id);
    }


    public void addSubtaskId(int id) {
        subtaskIds.add(id);
    }

    public void cleanSubtaskIds() {
        subtaskIds.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Epic epic = (Epic) o;
        return Objects.equals(subtaskIds, epic.subtaskIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), subtaskIds);
    }

    @Override
    public String toString() {
        return "Epic{" +
                "subtaskIds=" + subtaskIds +
                ", id=" + id +
                ", status=" + status +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}