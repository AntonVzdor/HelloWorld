package rememberJavaProg;

import java.util.ArrayList;
import java.util.Comparator;

public class TaskManager {
    private final ArrayList<Task> tasks = new ArrayList<>();

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

    void viewCompletedTask(){

        boolean found = false;

        for (Task task: tasks) {
            if(task.getCompleted()){
                System.out.println(task);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Нет выполненых задач");
        }
    }

    void viewNotCompletedTask(){

        boolean found = false;

        for (Task task: tasks) {
            if(!task.getCompleted()){
                System.out.println(task);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Нет не выполненых задач");
        }
    }

    void viewTaskToName(String nameTitle){

        boolean found = false;

        for (Task task: tasks) {
            if(task.getTitle().equals(nameTitle)){
                System.out.println(task);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Такой задачи нет.");
        }
    }

    void viewPriorityTask(Priority priority){

        boolean found = false;

        for (Task task: tasks){
            if (task.getPriority() == priority){
                System.out.println(task);
                found = true;
            }
        }
        if(!found){
            System.out.println("Такого приоритета нет.");
        }
    }

    void sortId(){
        tasks.sort(Comparator.comparing(Task::getId));
    }

    void sortTitle(){
        tasks.sort(Comparator.comparing(Task::getTitle));
    }

    void sortPriority(){
        tasks.sort(Comparator.comparing(Task::getPriority));
    }
}
