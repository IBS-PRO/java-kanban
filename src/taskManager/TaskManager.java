package taskManager;

import task.Task;
import task.Epic;
import task.Subtask;

import java.util.ArrayList;

public interface TaskManager {

    Integer idGenerator();

    ArrayList<Task> getTasks();

    ArrayList<Epic> getEpics();

    ArrayList<Subtask> getSubtasks();

    Task getTask(int id);

    Subtask getSubtask(int id);

    Epic getEpic(int id);

    int addTask(Task task);

    int addEpic(Epic epic);

    Integer addSubtask(Subtask subtask);

    void deleteTask(int id);

    void deleteEpic(int id);

    void deleteSubtask(int id);

    void deleteTasks();

    void deleteEpics();

    void deleteSubtasks();

    void updateEpic(Epic epic);

    void updateTask(Task task);

    void updateSubtask(Subtask subtask);

    ArrayList<Subtask> getSubtaskFromEpic(int epicId);

    void updateEpicStatus(int epicId);

}