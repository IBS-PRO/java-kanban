import manager.FileBackedTasksManager;
import manager.HistoryManager;
import manager.Managers;
import manager.TaskManager;

import task.Status;
import task.Task;
import task.Epic;
import task.Subtask;

import java.io.File;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {

        Path path = Path.of("data.csv");
        File file = new File(String.valueOf(path));
        FileBackedTasksManager manager = new FileBackedTasksManager(Managers.getDefaultHistory(), file);

        Task forstTask = new Task(Status.NEW, "Задача №1", "Описание для 1 задачи");
        int oneTaskId = manager.addTask(forstTask);
        Task secondTask = new Task(Status.NEW, "Задача №2", "Описание для 2 задачи");
        int twoTaskId = manager.addTask(secondTask);

        Epic firstEpic  = new Epic(Status.NEW, "Эпик №1", "Описание эпика 1");
        int firstEpicId = manager.addEpic(firstEpic);
        Epic secondEpic  = new Epic(Status.NEW, "Эпик №2", "Описание эпика 2");
        int secondEpicId = manager.addEpic(secondEpic);

        Subtask firstSubtask = new Subtask(firstEpicId, Status.NEW, "Subtask #1", "ST1 epic 1");
        int firstSubtaskId = manager.addSubtask(firstSubtask);
        Subtask secondSubtask = new Subtask(secondEpicId, Status.NEW, "Subtask #2", "ST1 epic 1");
        int secondSubtaskId = manager.addSubtask(secondSubtask);

        manager.getTask(oneTaskId);
        manager.getTask(twoTaskId);
        manager.getEpic(firstEpicId);
        manager.getEpic(secondEpicId);
        manager.getSubtask(firstSubtaskId);
        manager.getSubtask(secondSubtaskId);

    }
}