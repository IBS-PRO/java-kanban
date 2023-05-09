import Manager.Status;
import Manager.TaskManager;
import Task.Task;
import Task.Epic;
import Task.Subtask;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        TaskManager manager = new TaskManager();
        Task checkGetTask;
        Epic checkGetEpic;
        Epic checkUpdate;
        Subtask checkGetSubtask;

        manager.getTasks();
        manager.getEpics();
        manager.getSubtasks();
        System.out.println("\n");

        Task taskOne = new Task(Status.NEW,"Купить билет", "Купить билет на рейс Сочи-Москва");
        int taskOneId = manager.addTask(taskOne);
        checkGetTask = manager.getTask(taskOneId);
        System.out.println("Проверка метода getTask: " + checkGetTask + "\n");
        System.out.println("Проверка метода getTasks: ");
        manager.getTasks();
        System.out.println("\n");

        Epic epicOne = new Epic(Status.NEW, "Проведать друзей в Москве", "Список");
        Epic epicTwo = new Epic(Status.NEW, "Проверить обновление епика", "Просто текс");
        int epicOneId = manager.addEpic(epicOne);
        int epicTwoId = manager.addEpic(epicTwo);

        checkGetEpic = manager.getEpic(epicOneId);
        System.out.println("Проверка метода getEpic: " + checkGetEpic + "\n");
        System.out.println("Проверка метода getEpic: ");
        manager.getEpics();
        System.out.println("\n");

        Subtask subtaskOne = new Subtask(0, Status.NEW, "Subtask #1", "Hello!");
        Subtask subtaskTwo = new Subtask(0, Status.NEW, "Subtask #2", "Hello!");
        int subtaskOneId = manager.addSubtask(subtaskOne);
        int subtaskTwoId = manager.addSubtask(subtaskTwo);
        checkGetSubtask = manager.getSubtask(subtaskOneId);
        System.out.println("Проверка метода getSubtask: " + checkGetSubtask + "\n");
        System.out.println("Проверка метода getSubtask: ");
        manager.getSubtasks();
        System.out.println("\n");

        subtaskOne.setEpicId(epicOneId);
        subtaskTwo.setEpicId(epicOneId);
        manager.addNewSubtaskToeEpic(subtaskOne);
        manager.addNewSubtaskToeEpic(subtaskTwo);

        System.out.println("\nПроверка метода getEpics: ");
        manager.getEpics();
        System.out.println("\n");

        ArrayList<Subtask> epicSubtasks = new ArrayList<>();
        epicSubtasks = manager.getSubtaskFromEpic(epicOneId);
        System.out.println("Проверка метода getSubtaskFromEpic: " + epicSubtasks);

        checkUpdate = manager.getEpic(epicTwoId);
        checkUpdate.setStatus(Status.IN_PROGRESS);
        checkUpdate.setName("Это новый текст после выполнения обновления");
        checkUpdate.setDescription("Просто новый текст");
        manager.updateEpic(checkUpdate);

        manager.updateEpicStatus(epicOne);

        manager.deleteTask(taskOneId);
        manager.deleteEpic(epicTwoId);
        manager.deleteSubtask(epicOneId);

        manager.deleteTasks();
        manager.deleteEpics();
        manager.deleteSubtasks();
        epicOne.deleteSubtasks();

        manager.getTasks();
        manager.getEpics();
        manager.getSubtasks();

    }
}