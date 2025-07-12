package com.taskmanager.taskmanager_api.model;

public class Task {
    private int id;
    private String name;
    private String type;
    private String date;
    private double duration;
    private String period;

    public Task() {
    }

    public Task(int id, String name, String type, String date, double duration, String period) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.date = date;
        this.duration = duration;
        this.period = period;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getPeriod(){
        return period;
    }

    public void setPeriod(String period){
        this.period = period;
    }
}
