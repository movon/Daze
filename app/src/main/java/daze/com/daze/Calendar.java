package daze.com.daze;

/**
 * Created by Tal on 5/1/2015.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Tal on 5/1/2015.
 */
public class Calendar {

    Map<Date, Day> dateToDay = new HashMap<Date, Day>();
    private List<Year> years;


    void initCalendar(){
        Date date = new Date(2015, 1,5);
        for(int i =0; i<300;i++) {
            dateToDay.put(date, new Day(new ArrayList<CalendarEvent>()));
            date.incrementDay();
        }
    }

    public Calendar(){//get id of user
        initCalendar();
        this.years=years;
    }

    public List<Year> getSchedule(){
        return years;
    }
    //public getDayAsDate()
    public List<Year> getYears() {
        return years;
    }

    public static int currentYear(){
        return java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
    }
    public static int currentMonth(){
        return java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
    }
    public static int currentDayOfMonth(){
        return java.util.Calendar.getInstance().get(java.util.Calendar.DAY_OF_MONTH);
    }
}