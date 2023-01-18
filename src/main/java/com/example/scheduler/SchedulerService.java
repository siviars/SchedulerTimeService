package com.example.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class SchedulerService {

    private TaskReader taskReader = new TaskReader();

    @Scheduled(cron = "${scheduler.time}")
    public void schedulerCycle() {
        if (taskReader.readFile() != null) {
            for (int record = 0; record < taskReader.getRecordList().size(); record++) {
                if (checkMatch(taskReader.getRecordList().get(record).getTime(),
                        taskReader.getRecordList().get(record).getBitmask())) {
                    createAction();
                }
            }
        }
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

    public void createAction() {
        System.out.println("Action is completed!");
    }

}
