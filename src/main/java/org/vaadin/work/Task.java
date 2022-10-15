package org.vaadin.work;

import org.vaadin.enums.Priority;
import org.vaadin.assignee.Assignee;
import org.vaadin.reporter.Reporter;

import java.io.Serializable;

public class Task implements Serializable {
    private static int counter = 0;
    Integer ID;
    Priority priority;
    String assignee;
    String reporter;
    String deadline;
    String content;



    public Task() {
        this.ID = counter;
        counter++;
        content = "This is " + ID + " content";
    }

    public Task(Integer ID, Priority priority, String assignee, String reporter, String deadline) {
        this.ID = ID;
        this.priority = priority;
        this.assignee = assignee;
        this.reporter = reporter;
        this.deadline = deadline;
        this.content = this.ID.toString() + " test content...";
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}
