package daze.com.daze;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tal on 5/1/2015.
 */
public class Date {



    private int year;
    private int month;
    private int day;

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    private static Map<Integer, Integer> months;
    private static Map<Integer, Integer> leapMonths;

    public Date(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;

        months = new HashMap<Integer, Integer>();
        months.put(1, 31);
        months.put(2, 28);
        months.put(3, 31);
        months.put(4, 30);
        months.put(5, 31);
        months.put(6, 30);
        months.put(7, 31);
        months.put(8, 31);
        months.put(9, 30);
        months.put(10, 31);
        months.put(11, 30);
        months.put(12, 31);
        leapMonths = new HashMap<Integer, Integer>();
        leapMonths.put(1, 31);
        leapMonths.put(2, 29);
        leapMonths.put(3, 31);
        leapMonths.put(4, 30);
        leapMonths.put(5, 31);
        leapMonths.put(6, 30);
        leapMonths.put(7, 31);
        leapMonths.put(8, 31);
        leapMonths.put(9, 30);
        leapMonths.put(10, 31);
        leapMonths.put(11, 30);
        leapMonths.put(12, 31);
    }
    public void incrementDay(){
        day++;
        int daysinmonth = getDaysInMonth(month);
        if(day > daysinmonth){
            day = 1;
            if(month >= 12){
                month =1;
                year++;
            }
            else
                month++;
        }
    }
    public void decrementDay(){
        day--;
        if(day == 0)
        {
            if(month > 1)
            {
                month--;
                day = getDaysInMonth(month);
            }
            else{
                year--;
                month = 12;
                day = getDaysInMonth(month);
            }
        }
    }

    private int getDaysInMonth(int month){
        boolean leapYear;
        if (year % 4 != 0)
            leapYear = false;
        else
        if (year % 100 != 0)
            leapYear = true;
        else
        if (year%400 != 0)
            leapYear= false;
        else
            leapYear = true;
        int daysinmonth;
        if(!leapYear)
            daysinmonth = months.get(month);
        else
            daysinmonth = leapMonths.get(month);
        return daysinmonth;
    }

    @Override
    public String toString() {
        return formatDate(this);
    }
    public static String formatDate(Date date){
        String year = date.getYear()+"";
        while(year.length() < 4)
            year = "0" + year;
        String month = date.getMonth()+"";
        while(month.length() < 2)
            month = "0" + month;
        String day = date.getDay()+"";
        while(day.length() < 2)
            day = "0" + day;
        return year+month+day;
    }

    public static String dateToString(Date date){
        return (date.getYear() + " ") + Daze.months[date.getMonth()-1] + " " + Time.dayToString(date.getDay());
    }

}
