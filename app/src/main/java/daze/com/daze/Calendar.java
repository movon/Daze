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

    public int findTime(Time startTime, Time endTime, int duration, CalendarEvent source) {
        Time newtime = startTime;
        //newtime.setHour(0);
        //newtime.setMinute(0);
        while(Time.cmpTimes(newtime, endTime)==-1)
        {
            Time midnight = new Time(newtime.getYear(),newtime.getMonth(),newtime.getDay(),0,0);
            CalendarEvent event;
            Calendar.dateToDay.get(newtime).getNextEvent(midnight);
            //for(CalendarEvent events:Calendar.dateToDay.get(newtime).getSchedule())
            for(int i=0;i<Calendar.dateToDay.get(newtime).getSchedule().size();i++)
            {
                event = Calendar.dateToDay.get(newtime).getSchedule().get(i);
                if(((Calendar.dateToDay.get(newtime).nextEvent(event.getTime()).getTime().minutesSinceDayStarted())-(event.getTime().minutesSinceDayStarted()+event.getDuration())>=duration))
                {
                    source.setTime(event.getTime());
                    source.getTime().incrementMinute(event.getDuration());

                    Calendar.dateToDay.get(newtime).getSchedule().add(source);
                    return 1;
                }
            }
            newtime.incrementDay();
            //midnight.incrementDay();
        }
        return 0;
    }
}