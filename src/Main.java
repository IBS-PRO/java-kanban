import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        int taskTestId = 1;
        int epicTestId = 6;

        Manager manager = new Manager();
        Task testUpdateTask;
        Epic testUpdateEpic;

        //Создаем подзадачи
        manager.createTask("Прочитать статью");
        manager.createTask("Сформулировать вопросы по статье");
        manager.createTask("Письменно ответить на получившиеся вопросы");
        manager.createTask("Работа над источником завершена");

        //Создаем подзадачу
        manager.createTask("Выпить кофе");

        //Создаем эпики
        manager.createEpic("Прочитать статью в \"The Economist\"");
        manager.createEpic("Прочее");

        //Добавляем подзадачи к эпику
        manager.linkTaskToEpic(manager.getTaskById(1), (Epic) manager.getEpicById(6));
        manager.linkTaskToEpic(manager.getTaskById(2), (Epic) manager.getEpicById(6));
        manager.linkTaskToEpic(manager.getTaskById(3), (Epic) manager.getEpicById(6));
        manager.linkTaskToEpic(manager.getTaskById(4), (Epic) manager.getEpicById(6));

        //Добавляем подзадачи к эпику
        manager.linkTaskToEpic(manager.getTaskById(5), (Epic) manager.getEpicById(7));

        //Получаем подзадачи эпика
        ArrayList<Task> getList;
        getList = manager.getSubtaskFromEpic(6);
        System.out.println("Подзадачи эпика " + getList);

        System.out.println("Все задачи " +manager.getListOfAllTasks());
        System.out.println("Все эпики " +manager.getListOfAllEpic());

        //Обновляем задачу вместе с статусом
        testUpdateTask = manager.getTaskById(taskTestId);
        testUpdateTask.setDescription("This is a new description");
        testUpdateTask.setStatus(Status.IN_PROGRESS);
        manager.updateTaskById(taskTestId, testUpdateTask);

        //Обновляем епик вместе с статусом
        testUpdateEpic = manager.getEpicById(epicTestId);
        testUpdateEpic.setDescription("New header for Epic");
        testUpdateEpic.setStatus(Status.IN_PROGRESS);
        manager.updateEpicById(epicTestId, testUpdateEpic);

        //Удаляем задачу по Ид
        manager.removeTaskById(taskTestId);
        manager.removeEpicById(taskTestId);
        //Удаляем все задачи
        manager.removeAllTask();
        manager.removeAllEpic();
    }
}