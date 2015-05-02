package daze.com.daze;

/**
 * Created by Tal on 5/1/2015.
 */
import android.view.View;

import java.util.List;

/**
 * Created by Tal on 5/1/2015.
 */
public class CalendarEvent{

    private int duration; //IN MINUTES!
    private Time time;
    private List<User> participants;
    private String description;
    private Time duration;

    public CalendarEvent(Time time, List<User> participants, String description, int duration){
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

<<<<<<< HEAD
    public void setDuration(Time duration) {this.duration=duration;}

=======
>>>>>>> 4ea9885ede1cf0a1ef7d6dd0b6387a72e9ce7c09
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int minutes) {
        this.duration = minutes;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }
}
