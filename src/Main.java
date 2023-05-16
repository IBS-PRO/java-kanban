import manager.TaskManager;

import task.Status;
import task.Task;
import task.Epic;
import task.Subtask;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        TaskManager manager = new TaskManager();
        ArrayList<Task> taskCounter;
        HashMap<Integer, Epic> epicCounter;
        HashMap<Integer, Subtask> subtaskCounter;

        System.out.println("\n-------- [START] Проверка работы метода getTasks --------");
        System.out.println(" - таски не добавлены. Ответ метода: " + manager.getTasks());
        //Создаем задачу №1
        Task firstTask = new Task(Status.NEW,"Задача №1", "Описание для первой задачи");
        int taskOneId = manager.addTask(firstTask);
        //Создаем задачу №2
        Task secondTask = new Task(Status.NEW, "Задача №2", "Описание для второй задачи");
        int secondTaskId = manager.addTask(secondTask);
        //Создаем задачу №3
        Task thirdTask= new Task(Status.NEW, "Задача №3", "Описание для третьей задачи");
        int thirdTaskId = manager.addTask(thirdTask);
        taskCounter = manager.getTasks();
        System.out.println(" - добавлено " + taskCounter.size() + " таск-а/ки/ок. Ответ метода: " + manager.getTasks());
        System.out.println("-------- [FINISH] Проверка работы метода getTasks -------- \n");

        System.out.println("-------- [START] Проверка работы метода getEpics -------- ");
        System.out.println(" - эпики не добавлены. Ответ метода: " + manager.getEpics());
        //Создаем эпик №1
        Epic firstEpic = new Epic(Status.NEW, "Эпик №1", "Описание эпика 1");
        int firstEpicId = manager.addEpic(firstEpic);
        //Создаем эпик №2
        Epic secondEpic = new Epic(Status.NEW, "Эпик №2", "Описание эпика 2");
        int secondEpicId = manager.addEpic(secondEpic);
        epicCounter = manager.getEpics();
        System.out.println(" - добавлено " + epicCounter.size() + " эпик-а/ов. Ответ метода: " + manager.getEpics());
        System.out.println("-------- [FINISH] Проверка работы метода getEpics -------- \n");

        System.out.println("-------- [START] Проверка работы метода getSubtasks --------");
        System.out.println(" - подзадачи не добавлены. Ответ метода: " + manager.getSubtasks());
        Subtask firstSubtask = new Subtask(firstEpicId, Status.NEW, "Subtask #1", "ST1 epic 1");
        int firstSubtaskId = manager.addSubtask(firstSubtask);
        Subtask secondSubtask = new Subtask(firstEpicId, Status.DONE, "Subtask #2", "ST2 epic 1");
        int secondSubtaskId = manager.addSubtask(secondSubtask);
        Subtask thirdSubtask = new Subtask(firstEpicId, Status.NEW, "Subtask #3", "ST3 epic 1");
        int thirdSubtaskId = manager.addSubtask(thirdSubtask);
        Subtask fourSubtask = new Subtask(secondEpicId, Status.NEW, "Subtask #4", "ST epic 2");
        int fourSubtaskId = manager.addSubtask(fourSubtask);
        Subtask fifthSubtask = new Subtask(secondEpicId, Status.NEW, "Subtask #5", "ST epic 2");
        int fifthSubtaskId = manager.addSubtask(fifthSubtask);
        Subtask sixthSubtask = new Subtask(secondEpicId, Status.NEW, "Subtask #6", "ST epic 2");
        int sixthSubtaskId = manager.addSubtask(sixthSubtask);
        subtaskCounter = manager.getSubtasks();
        System.out.println(" - добавлено " + subtaskCounter.size() + " подзадач. Ответ метода: " + manager.getSubtasks());
        System.out.println("-------- [FINISH] Проверка работы метода getSubtasks -------- \n");

        System.out.println("-------- [START] Проверка работы метода getTask --------");
        System.out.println(" - получение задачи. Ответ метода: " + manager.getTask(taskOneId));
        System.out.println("-------- [FINISH] Проверка работы метода getTasks -------- \n");
        System.out.println("-------- [START] Проверка работы метода getEpic --------");
        System.out.println(" - получение эпика. Ответ метода: " + manager.getEpic(firstEpicId));
        System.out.println("-------- [FINISH] Проверка работы метода getEpic -------- \n");
        System.out.println("-------- [START] Проверка работы метода getSubtask --------");
        System.out.println(" - получение подзадачи. Ответ метода: " + manager.getSubtask(firstSubtaskId));
        System.out.println("-------- [FINISH] Проверка работы метода getSubtask -------- \n");

        System.out.println("-------- [START] Проверка работы метода updateTask --------");
        System.out.println(" - сейчас " + taskCounter.size() + " таск-а/ки/ок. Ответ метода: " + manager.getTasks());
        System.out.println(" - обновление задачи с id " + taskOneId);
        Task taskForUpdate = manager.getTask(taskOneId);
        taskForUpdate.setStatus(Status.IN_PROGRESS);
        taskForUpdate.setDescription("Обрати внимание, изменился статус!");
        manager.updateTask(taskForUpdate);
        System.out.println(" - сейчас " + taskCounter.size() + " таск-а/ки/ок. Ответ метода: " + manager.getTasks());
        System.out.println("-------- [FINISH] Проверка работы метода updateTask -------- \n");

        System.out.println("-------- [START] Проверка работы метода updateSubtask --------");
        System.out.println(" - сейчас " + subtaskCounter.size() + " подзадач. Ответ метода: " + manager.getSubtasks());
        System.out.println(" - обновление подзадачи с id " + fifthSubtaskId);
        Subtask subtaskForUpdate = manager.getSubtask(fifthSubtaskId);
        subtaskForUpdate.setStatus(Status.DONE);
        subtaskForUpdate.setDescription("Новое описание для подзадачи!");
        manager.updateSubtask(subtaskForUpdate);
        System.out.println(" - сейчас " + subtaskCounter.size() + " подзадач. Ответ метода: " + manager.getSubtasks());
        System.out.println("-------- [FINISH] Проверка работы метода updateSubtask -------- \n");

        System.out.println("-------- [START] Проверка работы метода getSubtaskFromEpic --------");
        System.out.println("GET EPIC " + manager.getSubtaskFromEpic(firstEpicId));
        System.out.println("-------- [FINISH] Проверка работы метода getSubtaskFromEpic -------- \n");

        System.out.println("-------- [START] Проверка работы метода deleteTask --------");
        System.out.println(" - сейчас " + taskCounter.size() + " таск-а/ки/ок. Ответ метода: " + manager.getTasks());
        System.out.println(" - удаление задачи с id " + taskOneId);
        manager.deleteTask(taskOneId);
        taskCounter = manager.getTasks();
        System.out.println(" - осталось " + taskCounter.size() + " таск-а/ки/ок. Ответ метода: " + manager.getTasks());
        System.out.println("-------- [FINISH] Проверка работы метода deleteTask -------- \n");

        System.out.println("-------- [START] Проверка работы метода deleteEpic --------");
        System.out.println(" - сейчас " + epicCounter.size() + " эпик-а/ов. Ответ метода: " + manager.getEpics());
        System.out.println(" - удаление епика с id " + firstEpicId);
        manager.deleteEpic(firstEpicId);
        epicCounter = manager.getEpics();
        System.out.println(" - осталось " + epicCounter.size() + " эпик-а/ов. Ответ метода: " + manager.getEpics());
        System.out.println("-------- [FINISH] Проверка работы метода deleteEpic -------- \n");

        System.out.println("-------- [START] Проверка работы метода deleteSubtask --------");
        System.out.println(" - сейчас " + subtaskCounter.size() + " подзадач. Ответ метода: " + manager.getSubtasks());
        System.out.println(" - удаление подзадачи с id " + fourSubtaskId);
        manager.deleteSubtask(fourSubtaskId);
        subtaskCounter = manager.getSubtasks();
        System.out.println(" - осталось " + subtaskCounter.size() + " подзадач. Ответ метода: " + manager.getSubtasks());
        System.out.println("-------- [FINISH] Проверка работы метода deleteSubtask -------- \n");

        System.out.println("-------- [START] Проверка работы метода deleteTasks --------");
        System.out.println(" - сейчас " + taskCounter.size() + " таск-а/ки/ок. Ответ метода: " + manager.getTasks());
        System.out.println(" - удаление всех задач");
        manager.deleteTasks();
        taskCounter = manager.getTasks();
        System.out.println(" - осталось " + taskCounter.size() + " таск-а/ки/ок. Ответ метода: " + manager.getTasks());
        System.out.println("-------- [FINISH] Проверка работы метода deleteTasks -------- \n");

        System.out.println("-------- [START] Проверка работы метода deleteEpics --------");
        System.out.println(" - сейчас " + epicCounter.size() + " эпик-а/ов. Ответ метода: " + manager.getEpics());
        System.out.println(" - удаление всех епиков");
        manager.deleteEpics();
        epicCounter = manager.getEpics();
        subtaskCounter = manager.getSubtasks();
        int mockEpicCounter;
        int mockSubtaskCounter;
        //много if, но так просто быстро
        if (epicCounter == null) {
            mockEpicCounter = 0;
        } else {
            mockEpicCounter = epicCounter.size();
        }
        if (subtaskCounter == null) {
            mockSubtaskCounter = 0;
        } else {
            mockSubtaskCounter = subtaskCounter.size();
        }
        System.out.println(" - осталось " + mockEpicCounter + " эпик-а/ов. Ответ метода: " + manager.getEpics());
        System.out.println(" - осталось " + mockSubtaskCounter + " подзадач. Ответ метода: " + manager.getSubtasks());
        System.out.println("-------- [FINISH] Проверка работы метода deleteEpics -------- \n");

        System.out.println("-------- [START] Проверка работы метода deleteSubtasks --------");
        Epic newEpic = new Epic(Status.NEW, "Эпик №3", "Описание эпика 3");
        int newEpicId = manager.addEpic(newEpic);
        Subtask newSubtask = new Subtask(newEpicId, Status.NEW, "Subtask #55", "STN epic 3");
        int newSubtaskId = manager.addSubtask(newSubtask);
        subtaskCounter = manager.getSubtasks();
        epicCounter = manager.getEpics();
        System.out.println(" - сейчас " + subtaskCounter.size() + " подзадач. Ответ метода: " + manager.getSubtasks());
        System.out.println(" - сейчас " + epicCounter.size() + " эпик-а/ов. Ответ метода: " + manager.getEpics());
        System.out.println(" - удаление подзадач");
        manager.deleteSubtasks();
        subtaskCounter = manager.getSubtasks();
        epicCounter = manager.getEpics();
        int mockEpicCounterForDeleteEpics;
        int mockSubtaskCounterForDeleteSubtasks;
        //много if, но так просто быстро
        if (epicCounter == null) {
            mockEpicCounterForDeleteEpics = 0;
        } else {
            mockEpicCounterForDeleteEpics = epicCounter.size();
        }
        if (subtaskCounter == null) {
            mockSubtaskCounterForDeleteSubtasks = 0;
        } else {
            mockSubtaskCounterForDeleteSubtasks = subtaskCounter.size();
        }
        System.out.println(" - сейчас " + mockSubtaskCounterForDeleteSubtasks + " подзадач. Ответ метода: " + manager.getSubtasks());
        System.out.println(" - сейчас " + mockEpicCounterForDeleteEpics + " эпик-а/ов. Ответ метода: " + manager.getEpics());
        System.out.println("-------- [FINISH] Проверка работы метода deleteSubtasks -------- \n");

    }
}