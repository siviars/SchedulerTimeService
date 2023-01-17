package com.example.schedulerTimeService;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.DayOfWeek;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class SchedulerService {
    int run = 0;
    private final String fileName = "src/main/java/com/example/schedulerTimeService/config/task.csv";
    private final String symbol = ";";

    List<String> recordList = new ArrayList<>();


    @Scheduled(cron = "${scheduler.time}")
    public void schedulerCycle() {
        readFile();
        for (int record = 0; record < recordList.size(); record++) {
            String readRecord = recordList.get(record);
            String time = getTime(readRecord);
            String binaryDays = convertDays(getDays(readRecord));
            if (checkMatch(time, binaryDays)) {
                createAction();
            }
        }
    }

    public void readFile() {
        recordList.clear();
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                recordList.add(scanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println("File not found");
        }
    }

    public String getTime(String readTime) {
        return readTime.substring(0, readTime.indexOf(symbol)).trim();
    }

    public String getDays(String readDay) {
        return readDay.substring(readDay.indexOf(symbol) + 1).trim();
    }

    public Boolean checkMatch(String time, String binaryDays) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        TimeZone.setDefault(TimeZone.getTimeZone("Africa/Lagos"));
        ZonedDateTime zone = ZonedDateTime.now();
        DayOfWeek dayOfWeek = DayOfWeek.from(zone);
        if (zone.format(formatter).equals(time)) {

            for (int dayCount = binaryDays.length() - 1; dayCount >= 0; dayCount--) {

                if (binaryDays.charAt(dayCount) == '1') {
                    if (dayOfWeek.equals(DayOfWeek.of(binaryDays.length() - dayCount))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public String convertDays(String days) {
        return Integer.toBinaryString(Integer.parseInt(days));
    }

    public void createAction() {
        System.out.println("Action is completed!");
    }

}
