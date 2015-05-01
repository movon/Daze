package daze.com.daze;

/**
 * Created by Tal on 5/1/2015.
 */
import java.util.List;

/**
 * Created by Tal on 5/1/2015.
 */
public class Calendar {
    private List<Year> years;


    public Calendar(List<Year> years){this.years=years;}//get id of user

    public List<Year> getSchedule(){
        return years;
    }
    //public getDayAsDate()
}