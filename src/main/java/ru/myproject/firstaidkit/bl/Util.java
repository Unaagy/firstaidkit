package ru.myproject.firstaidkit.bl;

import java.sql.Date;
import java.util.Calendar;

public class Util {

    public static Date getDate(String stringDate) {
        System.out.println("!!!!!!! INCOMING DATE: " + stringDate);

        String[] parts = stringDate.split("-");

        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        return new Date(calendar.getTime().getTime());
    }

}
