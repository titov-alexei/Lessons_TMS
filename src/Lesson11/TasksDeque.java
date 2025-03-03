package Lesson11;

import java.util.ArrayDeque;

public class TasksDeque {
    private ArrayDeque<String> array;

    TasksDeque(){
        this.array = new ArrayDeque<>();
    }

    public void addTasks(String str) {
        array.addLast(str);
    }

    public void addUrgentTask(String str) {
        array.addFirst(str);
    }

    public void processTask() {
        System.out.println("Delete first task: " + array.peekFirst());
        array.removeFirst();
        System.out.println("First tasks: " + array.peekFirst());
    }

    public void showTasks(){
        System.out.println("TasksDeque: " + array);
    }
}
