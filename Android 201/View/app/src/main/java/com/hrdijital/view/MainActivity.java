package com.hrdijital.view;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.icu.util.TimeZone;
import android.os.Build;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.ListView;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    ListView date_list_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Date myDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMMM yyyy");
        String date = dateFormat.format(myDate);
        Log.d(date, "date: ");

        date_list_view = findViewById(R.id.date_list_view);
        Calendar mCalendar = Calendar.getInstance();
        Log.d(String.valueOf(mCalendar.getTimeInMillis()), "mCalendar: ");
        int dayvalues=mCalendar.get(Calendar.DAY_OF_WEEK);
        Log.d(String.valueOf(dayvalues), "dayvalues: ");
        Log.d(String.valueOf(mCalendar.getFirstDayOfWeek() +1 ), "getFirstDayOfWeek: ");
        Log.d(String.valueOf(mCalendar.get(Calendar.DAY_OF_WEEK)),"");

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        cal.set(Calendar.DAY_OF_WEEK, cal.MONDAY);
        String firstWkDay = String.valueOf(cal.getTime());
        Log.d("firstWkDay", firstWkDay);
        //cal.set(Calendar.DAY_OF_WEEK, cal.SUNDAY);
        cal.add(Calendar.DAY_OF_WEEK, 6);
        String lastWkDay =  String.valueOf(cal.getTime());
        Log.d("lastWkDay", lastWkDay);
    }
    private String getDate(long time) {
        Calendar cal = Calendar.getInstance(Locale.ENGLISH);
        cal.setTimeInMillis(time * 1000);
        String date = DateFormat.format("dd-MM-yyyy", cal).toString();
        return date;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String month = in.next();
        String day = in.next();
        String year = in.next();
        System.out.println(getDay(day, month, year));
    }

    private static String getDay(String day, String month, String year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
        return calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());

    }
}