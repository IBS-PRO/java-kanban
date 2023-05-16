package manager;

import task.Status;
import task.Task;
import task.Epic;
import task.Subtask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TaskManager {

    private int idTaskCounter;

    private final HashMap < Integer, Task > tasks = new HashMap < > ();
    private final HashMap < Integer, Epic > epics = new HashMap < > ();
    private final HashMap < Integer, Subtask > subtasks = new HashMap < > ();

    private int idGenerator() {
        return ++idTaskCounter;
    }

    public ArrayList < Task > getTasks() {
        return new ArrayList < > (tasks.values());
    }

    public HashMap<Integer, Epic> getEpics() {
        if (epics.isEmpty()) {
            return null;
        }
        return epics;
    }

    public HashMap<Integer, Subtask> getSubtasks() {
        if (subtasks.isEmpty()) {
            return null;
        }
        return subtasks;
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

    /*    public int addSubtask(Subtask subtask) {
            final int id = idGenerator();
            subtask.setId(id);
            subtasks.put(id, subtask);
            return id;
        }*/

    public Integer addSubtask(Subtask subtask) {
        int epicId = subtask.getEpicId();
        Epic epic = epics.get(epicId);
        if (epic == null) {
            return null;
        }
        int id = idGenerator();
        subtask.setId(id);
        subtasks.put(id, subtask);
        epic.addSubtaskId(subtask.getId());
        updateEpicStatus(epicId);
        return id;
    }

    public void deleteTask(int id) {
        tasks.remove(id);
    }

    public void deleteEpic(int id) {
        Epic epic = epics.remove(id);
        for (Integer subtaskId: epic.getSubtasksIds()) {
            subtasks.remove(subtaskId);
        }
        epics.remove(id);
    }

    public void deleteSubtask(int id) {
        Subtask subtask = subtasks.remove(id);
        if (subtask == null) {
            return;
        }
        Epic epic = epics.get(subtask.getEpicId());
        epic.deleteSubtask(id);
        updateEpicStatus(epic.getId());
    }

    public void deleteTasks() {
        tasks.clear();
    }

    public void deleteEpics() {
        epics.clear();
        subtasks.clear();
    }

    public void deleteSubtasks() {
        for (Epic epic: epics.values()) {
            epic.cleanSubtaskIds();
            updateEpicStatus(epic.getId());
        }
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

    private void updateEpicStatus(int epicId) {
        Epic epic = epics.get(epicId);
        ArrayList <Integer> subs = (ArrayList < Integer > ) epic.getSubtasksIds();
        if (subs.isEmpty()) {
            epic.setStatus(Status.NEW);
            return;
        }
        Status status = null;
        for (int id: subs) {
            final Subtask subtask = subtasks.get(id);
            if (status == null) {
                status = subtask.getStatus();
                continue;
            }
            if (status.equals(subtask.getStatus()) &&
                    !status.equals(Status.IN_PROGRESS)) {
                continue;
            }
            epic.setStatus(Status.IN_PROGRESS);
            return;
        }
        epic.setStatus(status);
    }

    public ArrayList < Subtask > getSubtaskFromEpic(int epicId) {
        ArrayList < Subtask > tasks = new ArrayList < > ();
        Epic epic = epics.get(epicId);
        if (epic == null) {
            return null;
        } else {
            for (int id: epic.getSubtasksIds()) {
                tasks.add(subtasks.get(id));
            }
        }
        return tasks;
    }

}