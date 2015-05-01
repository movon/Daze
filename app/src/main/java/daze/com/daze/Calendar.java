package daze.com.daze;

/**
 * Created by Tal on 5/1/2015.
 */
import java.util.List;

/**
 * Created by Tal on 5/1/2015.
 */
public class Calendar {
    private List<CalendarEvent> schedule;


    public Calendar() {     //get id of user

    }
    public List<CalendarEvent> getSchedule(){
        return schedule;
    }
    public void addEvent(CalendarEvent event){
        schedule.add(event);
    }
    public void removeEvent(CalendarEvent event){
        schedule.remove(event);
    }
}