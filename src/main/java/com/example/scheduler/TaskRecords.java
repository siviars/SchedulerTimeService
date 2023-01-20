package com.example.scheduler;

public class TaskRecords {

    private String time;
    private String bitmask;

    public TaskRecords(String time, String bitmask) {
        this.time = time;
        this.bitmask = bitmask;
    }

    public String getTime() {
        return time;
    }

    public String getBitmask() {
        return bitmask;
    }

}
