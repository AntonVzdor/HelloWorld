package rememberJavaProg;

public class MainClassRemember {
    public static void main(String[] args) {
        Task task1 = new Task(
                1,
                "поспать",
                "раздеться, лечь в кровать, закрыть глаза",
                false,
                Priority.HIGH
        );

        Task task2 = new Task(
                2,
                "радость",
                "раздеться, лечь в кровать, закрыть глаза",
                false,
                Priority.MEDIUM
        );

        Task task3 = new Task(
                3,
                "код",
                "раздеться, лечь в кровать, закрыть глаза",
                false,
                Priority.LOW
        );

        TaskManager taskManager = new TaskManager();
        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.addTask(task3);

        taskManager.viewAllTasks();

        task2.markCompleted();
        taskManager.sortId();
        taskManager.sortTitle();
        taskManager.sortPriority();

        taskManager.viewCompletedTask();
        taskManager.viewTaskToName("поспать");
        taskManager.viewTaskToName("спать");
        taskManager.viewNotCompletedTask();
        taskManager.viewPriorityTask(Priority.LOW);

        taskManager.viewAllTasks();
    }
}

class Task{
    private int id;
    private String title;
    private String description;
    private boolean completed;
    private Priority priority;

    public Task(
            int id,
            String title,
            String description,
            boolean completed,
            Priority priority
    ){
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean getCompleted() {
        return completed;
    }

    public Priority getPriority(){return priority;}

    public void setId(int newId) {
        this.id = newId;
    }
    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public void setDescription(String newDescription) {
        this.description = newDescription;
    }

    public void setCompleted(boolean newCompleted) {
        this.completed = newCompleted;
    }

    @Override
    public String toString() {
        return "Задача {" +
                "№ задачи = " + id +
                ", название = '" + title + '\'' +
                ", описание = '" + description + '\'' +
                ", статус = " + completed + ", " + priority +
                '}';
    }

    public void markCompleted() {
        this.completed = true;
    }
}
