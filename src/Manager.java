import java.util.ArrayList;
import java.util.HashMap;

public class Manager {

    private int idTaskCounter;

    private final HashMap<Integer, Epic> epicList = new HashMap<Integer, Epic>();
    private final HashMap<Integer, Task> taskList = new HashMap<Integer, Task>();

    /**
     *  Общая функциональность
     */
    private int idGenerator() {
        return ++idTaskCounter;
    }

    /**
     *  Функционал для работы с сущностью Epic
     */
    public void createEpic(String name) {
        Epic newEpic = new Epic(idGenerator(), name);
        epicList.put(newEpic.getId(), newEpic);
    }

    void updateEpicById(int id, Task newEpic) {
        Epic tempEpic = new Epic();
        tempEpic.setId(newEpic.getId());
        tempEpic.setDescription(newEpic.getDescription());
        tempEpic.setStatus(newEpic.getStatus());
        epicList.put(id, tempEpic);
    }

    public Epic getEpicById(int id) {
        return epicList.get(id);
    }

    public ArrayList<Epic> getListOfAllEpic() {
        return new ArrayList<>(epicList.values());
    }

    public void removeEpicById(int id) {
        epicList.remove(id);
    }

    void removeAllEpic() {
        epicList.clear();
    }

    public ArrayList<Task> getSubtaskFromEpic(int epicId) {
        Epic tempEpic = new Epic();
        tempEpic = epicList.get(epicId);
        return new ArrayList<>(tempEpic.subtaskList);
    }


    /**
     * Функционал для работы с сущностью Task
     */
    public void createTask(String content) {
        Task newTask = new Task(idGenerator(), content, Status.NEW);
        taskList.put(newTask.getId(), newTask);
    }

    public void linkTaskToEpic(Task task, Epic epic) {
        epic.subtaskList.add(task);
        task.linkToEpic(epic.getId());
    }

    // Метод получает запись по идентификатору
    public Task getTaskById(int id) {
        return taskList.get(id);
    }

    public ArrayList<Task> getListOfAllTasks() {
        return new ArrayList<>(taskList.values());
    }

    // Метод обновляет запись по идентификатору
    void updateTaskById(int id, Task newTask) {
        Task tempTask = new Task();
        tempTask.setId(newTask.getId());
        tempTask.setDescription(newTask.getDescription());
        tempTask.setStatus(newTask.getStatus());
        taskList.put(id, tempTask);
    }

    // Метод удаляет запись по идентификатору
    void removeTaskById(int id) {
        taskList.remove(id);
    }

    void removeAllTask() {
        taskList.clear();
    }

}