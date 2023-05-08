public class Task {

    /**
     * Задача - это обьект который включает только идентификатор название задачи и статус,
     * задача используется в виде подзадачи.
     */

    private int id;
    private int linkToEpic;
    private String description;
    private Status status;

    public Task() {
    }

    public Task(int id) {
        this.id = id;
    }

    public Task(int id, String taskDescription, Status status) {
        this.description = taskDescription;
        this.id = id;
        this.status = status;
    }

    /**
     * Геттеры
     */

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    /**
     * Сеттеры
     */

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Методы
     */

    public void linkToEpic(int epicId) {
        linkToEpic = epicId;
    }

}