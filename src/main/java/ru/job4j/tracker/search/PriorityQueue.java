package ru.job4j.tracker.search;

import java.util.LinkedList;

public class PriorityQueue {

    private final LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        int index = 0;
        for (Task element : tasks) {
            if (element.getPriority() <= task.getPriority()) {
               index++;
            } else {
                break;
            }
        }
        this.tasks.add(index, task);
    }

    public Task take() {
        return tasks.poll();
    }
}
