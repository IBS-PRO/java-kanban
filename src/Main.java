import manager.HistoryManager;
import manager.Managers;
import manager.TaskManager;

import task.Status;
import task.Task;
import task.Epic;
import task.Subtask;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        TaskManager taskManager = Managers.getDefault();

        List<Task> taskCounter;

        System.out.println(" --------------------- ПРОВЕРКА ФУНКЦИОНАЛЬНОСТИ ИСТОРИИ--------------------- ");
        Task one    = new Task(Status.NEW, "Задача №1", "Описание для 1 задачи");
        Task two    = new Task(Status.NEW, "Задача №2", "Описание для 2 задачи");
        int oneTaskId   = taskManager.addTask(one);
        int twoTaskId   = taskManager.addTask(two);

        Epic seven  = new Epic(Status.NEW, "Эпик №1", "Описание эпика 1");
        Epic eight  = new Epic(Status.NEW, "Эпик №2", "Описание эпика 2");
        int sevenEpicId = taskManager.addEpic(seven);
        int eightEpicId = taskManager.addEpic(eight);

        Subtask nineSubtask   = new Subtask(sevenEpicId, Status.NEW, "Subtask #1", "ST1 epic 1");
        Subtask tenSubtask    = new Subtask(sevenEpicId, Status.NEW, "Subtask #2", "ST1 epic 1");
        Subtask elevenSubtask = new Subtask(sevenEpicId, Status.NEW, "Subtask #3", "ST1 epic 1");

        int nineSubtaskId = taskManager.addSubtask(nineSubtask);
        int tenSubtaskId = taskManager.addSubtask(tenSubtask);
        int elevenSubtaskId = taskManager.addSubtask(elevenSubtask);

        taskManager.getTask(oneTaskId);
        taskManager.getTask(twoTaskId);
        taskManager.getEpic(sevenEpicId);
        taskManager.getEpic(eightEpicId);
        taskManager.getSubtask(nineSubtaskId);
        taskManager.getSubtask(tenSubtaskId);
        taskManager.getSubtask(elevenSubtaskId);

        System.out.println("[START]  getHistory - 1");
        for (int i = 0; i < taskManager.getHistory().size(); i++) {
            System.out.println(taskManager.getHistory().get(i));
        }
        System.out.println("[FINISH] getHistory - 1\n");

        taskManager.getEpic(eightEpicId);
        taskManager.getSubtask(tenSubtaskId);
        taskManager.getEpic(sevenEpicId);
        taskManager.getSubtask(nineSubtaskId);
        taskManager.getTask(twoTaskId);
        taskManager.getSubtask(elevenSubtaskId);
        taskManager.getTask(oneTaskId);

        System.out.println("[START]  getHistory  - 2");
        for (int i = 0; i < taskManager.getHistory().size(); i++) {
            System.out.println(taskManager.getHistory().get(i));
        }
        System.out.println("[FINISH] getHistory  - 2\n");

        taskManager.getSubtask(tenSubtaskId);
        taskManager.getTask(oneTaskId);
        taskManager.getTask(twoTaskId);
        taskManager.getEpic(sevenEpicId);
        taskManager.getSubtask(nineSubtaskId);
        taskManager.getSubtask(elevenSubtaskId);
        taskManager.getEpic(eightEpicId);

        // getHistory
        System.out.println("[START]  getHistory - 3");
        for (int i = 0; i < taskManager.getHistory().size(); i++) {
            System.out.println(taskManager.getHistory().get(i));
        }
        System.out.println("[FINISH] getHistory - 3\n");

       // deleteTask
        System.out.println("[START]  deleteTask");
        taskCounter = taskManager.getTasks();
        System.out.println(" - сейчас " + taskCounter.size() + " таск-а/ки/ок. Ответ метода: " + taskManager.getTasks());
        System.out.println(" - удаление задачи с id " + oneTaskId);
        taskManager.deleteTask(oneTaskId);
        taskCounter = taskManager.getTasks();
        System.out.println(" - осталось " + taskCounter.size() + " таск-а/ки/ок. Ответ метода: " + taskManager.getTasks());
        System.out.println("[FINISH] deleteTask\n");

        // getHistory
        System.out.println("[START]  getHistory - 4");
        for (int i = 0; i < taskManager.getHistory().size(); i++) {
            System.out.println(taskManager.getHistory().get(i));
        }
        System.out.println("[FINISH] getHistory - 4\n");

        taskManager.deleteEpic(sevenEpicId);

        // getHistory
        System.out.println("[START]  getHistory - 5");
        for (int i = 0; i < taskManager.getHistory().size(); i++) {
            System.out.println(taskManager.getHistory().get(i));
        }
        System.out.println("[FINISH] getHistory - 5\n");

        System.out.println(" ------------------ КОНЕЦ. ПРОВЕРКА ФУНКЦИОНАЛЬНОСТИ ИСТОРИИ ------------------- ");
    }

}