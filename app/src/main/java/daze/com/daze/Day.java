package daze.com.daze;

import java.util.List;

/**
 * Created by Daniel on 01/05/2015.
 */
public class Day {

    private List<CalendarEvent> schedule;

    public Day(List<CalendarEvent> schedule){
        this.schedule=schedule;

    }

    public void addEvent(CalendarEvent event){
        schedule.add(event);
    }
    public void removeEvent(CalendarEvent event){schedule.remove(event); }
}
