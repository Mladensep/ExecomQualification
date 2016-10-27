package com.ftn.timkodzo.execomqualification.model;

/**
 * Created by Mladen on 10/26/2016.
 */
public class TaskModel {

    private int id;
    private String taskName;
    private String taskContent;
    private boolean done;


    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}
