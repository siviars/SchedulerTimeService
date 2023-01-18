package com.example.scheduler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskReader {

    private String separator;
    private String readTime;
    private String readDays;
    private String convertedDays;

    private final String symbol = ";";
    private final String fileName = "src/main/resources/config/task.csv";

    private List<TaskRecords> recordList = new ArrayList<>();

    public TaskReader() {
    }

    public List<TaskRecords> readFile() {
        recordList.clear();
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                separator = scanner.nextLine();
                readTime = separator.substring(0, separator.indexOf(symbol)).trim();
                readDays = separator.substring(separator.indexOf(symbol) + 1).trim();
                convertedDays = Integer.toBinaryString(Integer.parseInt(readDays));
                recordList.add(new TaskRecords(readTime, convertedDays));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return null;
        }
        return recordList;
    }

    public List<TaskRecords> getRecordList() {
        return recordList;
    }
}
