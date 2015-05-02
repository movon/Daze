package daze.com.daze;

/**
 * Created by Tal on 5/1/2015.
 */
public class Time extends Date{
    private int minute;
    private int hour;
    private int day;
    private int month;
    private int year;


    public Time(int year, int month, int day, int hour, int minute){
        super(year,month,day);
        this.hour = hour;
        this.minute = minute;
    }

    public int minutesSinceDayStarted()
    {
        return hour*60 + minute;
    }

    public int getHour() { return hour;}

    public void setHour(int hour) { this.hour = hour; }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public static String dayToString(int day)
    {
        String msg;
        if(day == 1)
            msg = "1st";
        else
        {
            if(day==2)
                msg = "2nd";
            else
            {
                if(day==3)
                    msg = "3rd";
                else
                {
                    if(day==21)
                        msg = "21st";
                    else
                    {
                        if(day==22)
                            msg = "22nd";
                        else
                        {
                            if(day==23)
                                msg = "23rd";
                            else
                            {
                                if(day==31)
                                    msg = "31st";
                                else
                                    msg = day+"th";
                            }
                        }
                    }
                }
            }
        }
        return msg;
    }

    public void incrementHour(){
        hour++;
        if(hour>=24) {
            hour = 0;
            incrementDay();
        }
    }
    public void incrementMinute(int amount){
        minute+=amount;
        while(minute>=60) {
            minute-=60;
            incrementHour();
        }
    }



}
