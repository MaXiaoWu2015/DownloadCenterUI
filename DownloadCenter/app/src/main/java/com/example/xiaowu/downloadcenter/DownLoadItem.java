package com.example.xiaowu.downloadcenter;

/**
 * Created by xiaowu on 2016-5-16.
 */
public class DownLoadItem {
    private String name;
    private String size;
    private String state;
    private double completed;
    private double speed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getCompleted() {
        return completed;
    }

    public void setCompleted(double completed) {
        this.completed = completed;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
