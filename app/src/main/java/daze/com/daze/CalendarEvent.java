package daze.com.daze;

/**
 * Created by Tal on 5/1/2015.
 */
import java.util.List;

/**
 * Created by Tal on 5/1/2015.
 */
public class CalendarEvent {

    private Time time;
    private List<User> participants;
    private String description;

    public CalendarEvent(Time time, List<User> participants, String description){
        this.time = time;
        this.participants = participants;
        this.description = description;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
