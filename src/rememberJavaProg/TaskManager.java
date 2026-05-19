package rememberJavaProg;

import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> tasks = new ArrayList<Task>();

    void addTask(Task newTask){
        tasks.add(newTask);
    }

    void removeTask(int id){
        for (int i = 0; i < tasks.size(); i++) {
            if(tasks.get(i).getId() == id){
                tasks.remove(i);
                return;
            }
        }
    }

    void viewAllTasks(){
        for(Task task : tasks){
            System.out.println(task);
        }
    }

    void viewTask(int id){
        for (Task task : tasks) {
            if(task.getId() == id){
                System.out.println(task);
                return;
            }
        }
        System.out.println("задачи нет");
    }
}
