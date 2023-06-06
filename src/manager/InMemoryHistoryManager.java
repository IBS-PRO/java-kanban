package manager;

import task.Task;

import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {

    private final CustomLinkedList taskHistory = new CustomLinkedList();

    @Override
    public void add(Task task) {
        if (task == null) {
            return;
        }
        taskHistory.removeId(task.getId());
        taskHistory.linkLast(task);
    }

    @Override
    public void remove(int id) {
        taskHistory.removeId(id);
    }

    @Override
    public List<Task> getHistory() {
        return taskHistory.getTasks();
    }
}
