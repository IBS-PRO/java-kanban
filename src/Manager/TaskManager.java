package Manager;

import Task.Task;
import Task.Epic;
import Task.Subtask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TaskManager {

    private int idTaskCounter;

    private final HashMap<Integer, Task> tasks = new HashMap<>();
    private final HashMap<Integer, Epic> epics = new HashMap<>();
    private final HashMap<Integer, Subtask> subtasks = new HashMap<>();

    private int idGenerator() {
        return ++idTaskCounter;
    }

    private void setTaskTypeForPrintUserMessage(String type) {
        String printType = "";
        if (type.equals("task")) {
            printType = "\"Задач\" ";
        } else if (type.equals("epic")) {
            printType = "\"Эпиков\" ";
        } else if (type.equals("subtask")) {
            printType = "\"Подзадач\" ";
        }
        System.out.println("В списке " + printType + "есть следующие элементы:");
    }

    public void getTasks() {
        if (!tasks.isEmpty()) {
            for (Map.Entry entry : tasks.entrySet()) {
                setTaskTypeForPrintUserMessage("task");
                System.out.println("Task id: " + entry.getKey() + ", Задача: " + entry.getValue());
            }
        } else {
            System.out.println("В Task пусто! Скорее добавь новую задачу, используй метод \"addTask\"");
        }
    }

    public void getEpics() {
        if (!epics.isEmpty()) {
            for (Map.Entry entry : epics.entrySet()) {
                setTaskTypeForPrintUserMessage("epic");
                System.out.println("Epic id: " + entry.getKey() + ", Епик: " + entry.getValue());
            }
        } else {
            System.out.println("В Epic пусто! Скорее добавь новый эпик, используй метод \"addEpic\"");
        }
    }

    public void getSubtasks() {
        if (!subtasks.isEmpty()) {
            for (Map.Entry entry : subtasks.entrySet()) {
                setTaskTypeForPrintUserMessage("subtask");
                System.out.println("Subtask id: " + entry.getKey() + " Подзадача: " + entry.getValue());
            }
        } else {
            System.out.println("В Subtask пусто! Скорее добавь новую подзадачу, используй метод \"addSubtask\"");
        }
    }

    public Task getTask(int id) {
        return tasks.get(id);
    }

    public Subtask getSubtask(int id) {
        return subtasks.get(id);
    }

    public Epic getEpic(int id) {
        return epics.get(id);
    }

    public int addTask(Task task) {
        final int id = idGenerator();
        task.setId(id);
        tasks.put(id, task);
        return id;
    }

    public int addEpic(Epic epic) {
        final int id = idGenerator();
        epic.setId(id);
        epics.put(id, epic);
        return id;
    }

    public int addSubtask(Subtask subtask) {
        final int id = idGenerator();
        subtask.setId(id);
        subtasks.put(id, subtask);
        return id;
    }

    public void deleteTask(int id) {
        tasks.remove(id);
    }

    public void deleteEpic(int id) {
        epics.remove(id);
    }

    public void deleteSubtask(int id) {
        subtasks.remove(id);
    }

    public void deleteTasks() {
        tasks.clear();
    }

    public void deleteEpics() {
        epics.clear();
    }

    public void deleteSubtasks() {
        subtasks.clear();
    }

    public void updateEpic(Epic epic) {
        final Epic savedEpic = epics.get(epic.getId());
        savedEpic.setName(epic.getName());
        savedEpic.setDescription(epic.getDescription());
    }

    public void updateTask(Task task) {
        final Task savedTask = tasks.get(task.getId());
        savedTask.setName(task.getName());
        savedTask.setDescription(task.getDescription());
    }

    public void updateSubtask(Subtask subtask) {
        final Subtask savedSubtask = subtasks.get(subtask.getId());
        savedSubtask.setName(subtask.getName());
        savedSubtask.setDescription(subtask.getDescription());
    }

        public void updateEpicStatus(Epic epic) {
        epics.put(epic.getId(), epic);
        ArrayList<Subtask> subtasks = new ArrayList<>();
        ArrayList<Status> subtaskStatuses = new ArrayList<>();
        subtasks = getSubtaskFromEpic(epic.getId());
        for (int i = 0; i < subtasks.size(); i++) {
            Subtask exchange;
            exchange = subtasks.get(i);
            subtaskStatuses.add(exchange.getStatus());
        }
        if (epic.getSubtasksIds() == null || subtaskStatuses.contains(Status.NEW)
                && !subtaskStatuses.contains(Status.IN_PROGRESS)
                && !subtaskStatuses.contains(Status.DONE)) {
            epic.setStatus(Status.NEW);
        } else if (!subtaskStatuses.contains(Status.NEW)
                && !subtaskStatuses.contains(Status.IN_PROGRESS)
                && subtaskStatuses.contains(Status.IN_PROGRESS)) {
            epic.setStatus(Status.DONE);
        } else {
            epic.setStatus(Status.IN_PROGRESS);
        }
    }

    public Integer addNewSubtaskToeEpic(Subtask subtask) {
        Epic epic = (Epic) getEpic(subtask.getEpicId());
        if (epic == null) {
            System.out.println("Эпика не существует - " + subtask.getEpicId());
            return -1;
        } else {
            System.out.println("В Эпик - " + subtask.getEpicId() + " добавлена подзадача " + subtask);
        }
        subtask.setStatus(Status.NEW);
        epic.addSubtask(subtask.getId());
        subtasks.put(subtask.getId(), subtask);
        return subtask.getId();
    }

    public ArrayList<Subtask> getSubtaskFromEpic(int epicId) {
        ArrayList<Subtask> tasks = new ArrayList<>();
        Epic epic = epics.get(epicId);
        if (epic == null) {
            return null;
        } else {
            for (int id : epic.getSubtasksIds()) {
                tasks.add(subtasks.get(id));
            }
        }
        return tasks;
    }

}