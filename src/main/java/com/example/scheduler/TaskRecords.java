package com.example.scheduler;

public class TaskRecords {

    String time;
    String bitmask;

    public TaskRecords(String time, String bitmask) {
        this.time = time;
        this.bitmask = bitmask;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBitmask() {
        return bitmask;
    }

    public void setBitmask(String bitmask) {
        this.bitmask = bitmask;
    }
}
