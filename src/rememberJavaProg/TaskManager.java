package rememberJavaProg;

import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> tasks = new ArrayList<Task>();

    void addTask(Task newTask){
        tasks.add(newTask);
    }

    void removeTask(int id){
        tasks.remove(id);
    }

    
}
