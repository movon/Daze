package daze.com.daze;

/**
 * Created by Tal on 5/1/2015.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tal on 5/1/2015.
 */
public class Calendar {

    static Map<String, Day> dateToDay = new HashMap<String, Day>();


    Date date;
    void initCalendar(){
        date = new Date(2015, 1,5);
        for(int i =0; i<3650;i++) {
            dateToDay.put(Date.formatDate(date), new Day(new ArrayList<CalendarEvent>(), date));
            date.incrementDay();
        }
    }

    public Calendar(){//get id of user
        initCalendar();
    }

    public static int currentYear(){
        return java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
    }
    public static int currentMonth(){
        return java.util.Calendar.getInstance().get(java.util.Calendar.MONTH)+1;
    }
    public static int currentDayOfMonth(){
        return java.util.Calendar.getInstance().get(java.util.Calendar.DAY_OF_MONTH);
    }

    public int findTime(Time startTime, Time endTime, int duration, CalendarEvent event) {
    Time scheduled = startTime;
    while(Time.cmpTimes(scheduled, endTime)==-1)
    {
        CalendarEvent events;
        Time midnight = new Time(startTime.getYear(),startTime.getMonth(),startTime.getDay(),0,0);
        //for(CalendarEvent events:Calendar.dateToDay.get(scheduled).getSchedule())
        for(int i=0;i<Calendar.dateToDay.get(scheduled).getSchedule().size();i++)
        {
            events = Calendar.dateToDay.get(scheduled).getSchedule().get(i);
            if()
            if(((getNextEvent(scheduled).getTime().minutesSinceDayStarted())-(events.getTime().minutesSinceDayStarted()+events.getDuration())>=duration))
            {
                event.setTime(scheduled);
                Calendar.dateToDay.get(scheduled).getSchedule().add(event);
                return 1;
            }
        }
        scheduled.incrementDay();
        midnight.incrementDay();
    }
    return 0;
}
}