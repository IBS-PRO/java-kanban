import taskManager.HistoryManager;
import taskManager.Managers;
import taskManager.TaskManager;

import task.Status;
import task.Task;
import task.Epic;
import task.Subtask;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        TaskManager taskManager = Managers.getDefault();
        HistoryManager historyManager = Managers.getDefaultHistory();

        ArrayList<Task> taskCounter;
        ArrayList<Epic> epicCounter;
        ArrayList<Subtask> subtaskCounter;

        System.out.println(" --------------------- ПРОВЕРКА ФУНКЦИОНАЛЬНОСТИ ИСТОРИИ--------------------- ");
        Task one    = new Task(Status.NEW, "Задача №1", "Описание для 1 задачи");
        Task two    = new Task(Status.NEW, "Задача №2", "Описание для 2 задачи");
        Task three  = new Task(Status.NEW, "Задача №3", "Описание для 3 задачи");
        Task four   = new Task(Status.NEW, "Задача №4", "Описание для 4 задачи");
        Task five   = new Task(Status.NEW, "Задача №5", "Описание для 5 задачи");
        Task six    = new Task(Status.NEW, "Задача №6", "Описание для 6 задачи");
        int oneTaskId   = taskManager.addTask(one);
        int twoTaskId   = taskManager.addTask(two);
        int threeTaskId = taskManager.addTask(three);
        int fourTaskId  = taskManager.addTask(four);
        int fiveTaskId  = taskManager.addTask(five);
        int sixTaskId   = taskManager.addTask(six);
        Epic seven  = new Epic(Status.NEW, "Эпик №1", "Описание эпика 1");
        Epic eight  = new Epic(Status.NEW, "Эпик №2", "Описание эпика 2");
        int sevenEpicId = taskManager.addEpic(seven);
        int eightEpicId = taskManager.addEpic(eight);
        Subtask nineSubtask   = new Subtask(sevenEpicId, Status.NEW, "Subtask #1", "ST1 epic 1");
        Subtask tenSubtask    = new Subtask(sevenEpicId, Status.NEW, "Subtask #2", "ST1 epic 1");
        Subtask elevenSubtask = new Subtask(eightEpicId, Status.NEW, "Subtask #3", "ST1 epic 2");
        Subtask twelveSubtask = new Subtask(eightEpicId, Status.NEW, "Subtask #4", "ST1 epic 2");
        int nineSubtaskId = taskManager.addSubtask(nineSubtask);
        int tenSubtaskId = taskManager.addSubtask(tenSubtask);
        int elevenSubtaskId = taskManager.addSubtask(elevenSubtask);
        int twelveSubtaskId = taskManager.addSubtask(twelveSubtask);
        taskManager.getTask(oneTaskId);
        taskManager.getTask(twoTaskId);
        taskManager.getTask(threeTaskId);
        taskManager.getTask(fourTaskId);
        taskManager.getTask(fiveTaskId);
        taskManager.getTask(sixTaskId);
        taskManager.getEpic(sevenEpicId);
        taskManager.getEpic(eightEpicId);
        taskManager.getSubtask(nineSubtaskId);
        taskManager.getSubtask(tenSubtaskId);
        taskManager.getSubtask(elevenSubtaskId);
        taskManager.getSubtask(twelveSubtaskId);
        // getHistory
        System.out.println("[START]  getHistory");
        for (int i = 0; i < historyManager.getHistory().size(); i++) {
            System.out.println(historyManager.getHistory().get(i));
        }
        System.out.println("[FINISH] getHistory\n");
        System.out.println(" ------------------ КОНЕЦ. ПРОВЕРКА ФУНКЦИОНАЛЬНОСТИ ИСТОРИИ ------------------- ");

        System.out.println(" --------------------- ПРОВЕРКА БАЗОВОЙ ФУНКЦИОНАЛЬНОСТИ --------------------- ");

        // getTasks
        System.out.println("\n[START]  getTasks");
        int taskOneId;
        int secondTaskId;
        int thirdTaskId;
        System.out.println(" - таски не добавлены. Ответ метода: " + taskManager.getTasks());
        Task firstTask  = new Task(Status.NEW, "Задача №1", "Описание для первой задачи");
        Task secondTask = new Task(Status.NEW, "Задача №2", "Описание для второй задачи");
        Task thirdTask  = new Task(Status.NEW, "Задача №3", "Описание для третьей задачи");
        secondTaskId = taskManager.addTask(secondTask);
        taskOneId = taskManager.addTask(firstTask);
        thirdTaskId = taskManager.addTask(thirdTask);
        taskCounter = taskManager.getTasks();
        System.out.println(" - добавлено " + taskCounter.size() + " таск-а/ки/ок. Ответ метода: " + taskManager.getTasks());
        System.out.println("[FINISH] getTasks\n");

        // getEpics
        System.out.println("[START]  getEpics");
        int firstEpicId;
        int secondEpicId;
        System.out.println(" - эпики не добавлены. Ответ метода: " + taskManager.getEpics());
        Epic firstEpic  = new Epic(Status.NEW, "Эпик №1", "Описание эпика 1");
        Epic secondEpic = new Epic(Status.NEW, "Эпик №2", "Описание эпика 2");
        firstEpicId = taskManager.addEpic(firstEpic);
        secondEpicId = taskManager.addEpic(secondEpic);
        epicCounter = taskManager.getEpics();
        System.out.println(" - добавлено " + epicCounter.size() + " эпик-а/ов. Ответ метода: " + taskManager.getEpics());
        System.out.println("[FINISH] getEpics\n");

        // getSubtasks
        System.out.println("[START]  getSubtasks");
        int firstSubtaskId;
        int secondSubtaskId;
        int thirdSubtaskId;
        int fourSubtaskId;
        int fifthSubtaskId;
        int sixthSubtaskId;
        System.out.println(" - подзадачи не добавлены. Ответ метода: " + taskManager.getSubtasks());
        Subtask firstSubtask    = new Subtask(firstEpicId, Status.NEW, "Subtask #1", "ST1 epic 1");
        Subtask secondSubtask   = new Subtask(firstEpicId, Status.DONE, "Subtask #2", "ST2 epic 1");
        Subtask thirdSubtask    = new Subtask(firstEpicId, Status.NEW, "Subtask #3", "ST3 epic 1");
        Subtask fourSubtask     = new Subtask(secondEpicId, Status.NEW, "Subtask #4", "ST epic 2");
        Subtask fifthSubtask    = new Subtask(secondEpicId, Status.NEW, "Subtask #5", "ST epic 2");
        Subtask sixthSubtask    = new Subtask(secondEpicId, Status.NEW, "Subtask #6", "ST epic 2");
        firstSubtaskId = taskManager.addSubtask(firstSubtask);
        secondSubtaskId = taskManager.addSubtask(secondSubtask);
        thirdSubtaskId = taskManager.addSubtask(thirdSubtask);
        fourSubtaskId = taskManager.addSubtask(fourSubtask);
        fifthSubtaskId = taskManager.addSubtask(fifthSubtask);
        sixthSubtaskId = taskManager.addSubtask(sixthSubtask);
        subtaskCounter = taskManager.getSubtasks();
        System.out.println(" - добавлено " + subtaskCounter.size() + " подзадач. Ответ метода: " + taskManager.getSubtasks());
        System.out.println("[FINISH] getSubtasks\n");

        // getTask
        System.out.println("[START]  getTask");
        System.out.println(" - получение задачи c ID " + taskOneId + ". Ответ метода: " + taskManager.getTask(taskOneId));
        System.out.println("[FINISH] getTasks \n");

        // getEpic
        System.out.println("[START]  getEpic");
        System.out.println(" - получение эпика c ID " + firstEpicId + " Ответ метода: " + taskManager.getEpic(firstEpicId));
        System.out.println("[FINISH] getEpic\n");

        // getSubtask
        System.out.println("[START]  getSubtask");
        System.out.println(" - получение подзадачи. Ответ метода: " + taskManager.getSubtask(firstSubtaskId));
        System.out.println("[FINISH] getSubtask\n");

        // updateTask
        System.out.println("[START]  updateTask");
        System.out.println(" - сейчас " + taskCounter.size() + " таск-а/ки/ок. Ответ метода: " + taskManager.getTasks());
        System.out.println(" - обновление задачи с id " + taskOneId);
        Task taskForUpdate = taskManager.getTask(taskOneId);
        taskForUpdate.setStatus(Status.IN_PROGRESS);
        taskForUpdate.setDescription("Обрати внимание, изменился статус!");
        taskManager.updateTask(taskForUpdate);
        System.out.println(" - сейчас " + taskCounter.size() + " таск-а/ки/ок. Ответ метода: " + taskManager.getTasks());
        System.out.println("[FINISH] updateTask\n");

        // updateSubtask
        System.out.println("[START]  updateSubtask");
        System.out.println(" - сейчас " + subtaskCounter.size() + " подзадач. Ответ метода: " + taskManager.getSubtasks());
        System.out.println(" - обновление подзадачи с id " + fifthSubtaskId);
        Subtask subtaskForUpdate = taskManager.getSubtask(fifthSubtaskId);
        subtaskForUpdate.setStatus(Status.DONE);
        subtaskForUpdate.setDescription("Новое описание для подзадачи!");
        taskManager.updateSubtask(subtaskForUpdate);
        System.out.println(" - сейчас " + subtaskCounter.size() + " подзадач. Ответ метода: " + taskManager.getSubtasks());
        System.out.println("[FINISH] updateSubtask\n");

        // getSubtaskFromEpic
        System.out.println("[START]  getSubtaskFromEpic");
        System.out.println("GET EPIC " + taskManager.getSubtaskFromEpic(firstEpicId));
        System.out.println("[FINISH] getSubtaskFromEpic\n");

        // deleteTask
        System.out.println("[START]  deleteTask");
        System.out.println(" - сейчас " + taskCounter.size() + " таск-а/ки/ок. Ответ метода: " + taskManager.getTasks());
        System.out.println(" - удаление задачи с id " + taskOneId);
        taskManager.deleteTask(taskOneId);
        taskCounter = taskManager.getTasks();
        System.out.println(" - осталось " + taskCounter.size() + " таск-а/ки/ок. Ответ метода: " + taskManager.getTasks());
        System.out.println("[FINISH] deleteTask\n");

        System.out.println("[START] deleteSubtask");
        System.out.println(" - сейчас " + subtaskCounter.size() + " подзадач. Ответ метода: " + taskManager.getSubtasks());
        System.out.println(" - удаление подзадачи с id " + fourSubtaskId);
        taskManager.deleteSubtask(fourSubtaskId);
        subtaskCounter = taskManager.getSubtasks();
        System.out.println(" - осталось " + subtaskCounter.size() + " подзадач. Ответ метода: " + taskManager.getSubtasks());
        System.out.println("[FINISH] deleteSubtask\n");

        // deleteTasks
        System.out.println("[START]  deleteTasks");
        System.out.println(" - сейчас " + taskCounter.size() + " таск-а/ки/ок. Ответ метода: " + taskManager.getTasks());
        System.out.println(" - удаление всех задач");
        taskManager.deleteTasks();
        int mockTaskCounter;
        if (taskManager.getTasks() == null) {
            mockTaskCounter = 0;
        } else {
            mockTaskCounter = taskCounter.size();
        }
        System.out.println(" - осталось " + mockTaskCounter + " таск-а/ки/ок. Ответ метода: " + taskManager.getTasks());
        System.out.println("[FINISH] deleteTasks\n");

        // deleteEpics
        System.out.println("[START]  deleteEpics");
        System.out.println(" - сейчас " + epicCounter.size() + " эпик-а/ов. Ответ метода: " + taskManager.getEpics());
        System.out.println(" - удаление всех епиков");
        taskManager.deleteEpics();
        epicCounter = taskManager.getEpics();
        subtaskCounter = taskManager.getSubtasks();
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
        System.out.println(" - осталось " + mockEpicCounter + " эпик-а/ов. Ответ метода: " + taskManager.getEpics());
        System.out.println(" - осталось " + mockSubtaskCounter + " подзадач. Ответ метода: " + taskManager.getSubtasks());
        System.out.println("[FINISH] deleteEpics\n");

        // deleteSubtasks
        System.out.println("[START]  deleteSubtasks");
        Epic newEpic = new Epic(Status.NEW, "Эпик №3", "Описание эпика 3");
        int newEpicId = taskManager.addEpic(newEpic);
        Subtask newSubtask = new Subtask(newEpicId, Status.NEW, "Subtask #55", "STN epic 3");
        int newSubtaskId = taskManager.addSubtask(newSubtask);
        subtaskCounter = taskManager.getSubtasks();
        epicCounter = taskManager.getEpics();
        System.out.println(" - сейчас " + subtaskCounter.size() + " подзадача. Ответ метода: " + taskManager.getSubtasks());
        System.out.println(" - сейчас " + epicCounter.size() + " эпик-а/ов. Ответ метода: " + taskManager.getEpics());
        System.out.println(" - удаление подзадач");
        taskManager.deleteSubtasks();
        subtaskCounter = taskManager.getSubtasks();
        epicCounter = taskManager.getEpics();
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
        System.out.println(" - сейчас " + mockSubtaskCounterForDeleteSubtasks + " подзадач. Ответ метода: " + taskManager.getSubtasks());
        System.out.println(" - сейчас " + mockEpicCounterForDeleteEpics + " эпик-а/ов. Ответ метода: " + taskManager.getEpics());
        System.out.println("[FINISH] deleteSubtasks\n");

        System.out.println(" ------------------ КОНЕЦ. ПРОВЕРКА БАЗОВОЙ ФУНКЦИОНАЛЬНОСТИ ------------------- ");

    }

}