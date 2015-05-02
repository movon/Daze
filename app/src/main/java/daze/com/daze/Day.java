package daze.com.daze;

import android.provider.Settings;

import java.util.List;

/**
 * Created by Daniel on 01/05/2015.
 */
public class Day {



    private List<CalendarEvent> schedule;
    private Date date;
    public Day(List<CalendarEvent> schedule, Date date){
        this.schedule=schedule;
        this.date = date;
    }
    public List<CalendarEvent> getSchedule() {
        return schedule;
    }
    public Date getDate(){
        return date;
    }
    public void addEvent(CalendarEvent event){
        schedule.add(event);
    }
    public void removeEvent(CalendarEvent event){schedule.remove(event); }
}
