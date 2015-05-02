package daze.com.daze;

import android.provider.Settings;

import java.util.List;

/**
 * Created by Daniel on 01/05/2015.
 */
public class Day {

    static Time getFittingTimeForActivity(List<CalendarEvent> schedule, Time wantedTime){
        return null;
    }

    static Time getFittingTimeFor2Schedules(List<CalendarEvent> schedule1, List<CalendarEvent> schedule2, Time estimatedTime){
        return null;
    }

    private List<CalendarEvent> schedule;
    private Date date;
    public Day(List<CalendarEvent> schedule, Date date){
        this.schedule=schedule;
        this.date = date;
    }
    public List<CalendarEvent> getSchedule() {
        return schedule;
    }
    public Date getDate(){return date;}
    public void addEvent(CalendarEvent event){
        schedule.add(event);
    }
    public void removeEvent(CalendarEvent event){schedule.remove(event); }

<<<<<<< HEAD
    public CalendarEvent getNextEvent(Time startTime) {
        int mindiff = 0;
        CalendarEvent nextevent = null;
        for (CalendarEvent event : Calendar.dateToDay.get(startTime).getSchedule()) {
            if(event.getTime().minutesSinceDayStarted()-startTime.minutesSinceDayStarted()>0)
            {
                if(mindiff==0)
                {
                    mindiff=event.getTime().minutesSinceDayStarted()-startTime.minutesSinceDayStarted();
                    nextevent = event;
                }
                else
                {
                    if(event.getTime().minutesSinceDayStarted()-startTime.minutesSinceDayStarted()<mindiff)
                    {
                        mindiff=event.getTime().minutesSinceDayStarted()-startTime.minutesSinceDayStarted();
                        nextevent = event;
                    }
                }
            }
        }
        if(mindiff==0)
        {
            return null;
        }
        else
        {
            return nextevent;
        }
    }
=======
    public CalendarEvent nextEvent(Time startTime){
        CalendarEvent nextevent = null;

        for(int i=0; i< schedule.size();i++){
            if(nextevent == null && Time.minutesDifference(schedule.get(i).getTime(), startTime) < 0)
                nextevent = schedule.get(i);
            if(Time.minutesDifference(schedule.get(i).getTime(), startTime) < 0)
                continue;
            else if (Time.minutesDifference(nextevent.getTime(), schedule.get(i).getTime()) > 0)
                nextevent = schedule.get(i);
        }
        return nextevent;
    }

>>>>>>> 205d7c240673dc738697125e6b5ef504f83bbf53

}
