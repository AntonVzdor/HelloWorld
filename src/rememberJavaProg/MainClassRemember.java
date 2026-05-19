package rememberJavaProg;

public class MainClassRemember {
    public static void main(String[] args) {
        Task task1 = new Task(
                1,
                "поспать",
                "раздеться, лечь в кровать, закрыть глаза",
                false
        );

        System.out.println(task1);

        task1.markCompleted();

        System.out.println(task1);
    }
}

class Task{
    private int id;
    private String title;
    private String description;
    private boolean completed;

    public Task(
            int id,
            String title,
            String description,
            boolean completed
    ){
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
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
                ", статус = " + completed +
                '}';
    }

    public void markCompleted() {
        this.completed = true;
    }
}
