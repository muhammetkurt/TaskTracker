package org.vaadin.data;

import org.apache.poi.ss.formula.functions.T;
import org.vaadin.assignee.Assignee;
import org.vaadin.enums.Priority;
import org.vaadin.reporter.Reporter;
import org.vaadin.work.Task;

import java.util.HashMap;

public class TaskProvider {
    private static HashMap<Integer, Task> taskMap;

    public HashMap<Integer, Task> getTaskMap() {
        return taskMap;
    }

    public static HashMap<Integer, Task> createTaskMap() {
        taskMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            Assignee assignee = new Assignee();
            Reporter reporter = new Reporter();
            Task task = new Task(i, Priority.HIGH, assignee.getName(), reporter.getName(), "11.11.2022");
//            Task task = new Task();
            taskMap.put(i, task);
        }
        return taskMap;
    }

}
