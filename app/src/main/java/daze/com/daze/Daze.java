package daze.com.daze;

import android.app.Activity;
import android.content.ClipData;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/*
TODO LIST:
1.Slide between dates
2.Show whole week, month
3.Let user add an event
4.Expand day and show detailed schedule
5.Define default week
6.Save Calendar object
7.Check messages for events
8.Add Event chat
9.Add Event time sync
10.Add social event requests
11.Add scial event chat
12.Make new notification
13.Highlight and flash hours that have a notification
 */

public class Daze extends Activity{

    Calendar calendar;
    Button incrementDayButton;
    Date date;
    TextView dateTV;
    Button[] daysButtons;
    TableLayout tl;
    public static String[] months = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daze);

        calendar = new Calendar();


        daysButtons = new Button[3];
        for(int i =0; i < 3;i++) {
            daysButtons[i] = new Button(this);
            daysButtons[i].setTextSize(12);
        }

        dateTV = (TextView)findViewById(R.id.dateTV);
        date = new Date(Calendar.currentYear(), Calendar.currentMonth(), Calendar.currentDayOfMonth());
        incrementDayButton = (Button)findViewById(R.id.incrementDayButton);
        incrementDayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date.incrementDay();
                dateTV.setText(Date.dateToString(date));
                Date tempDate;
                tempDate = new Date(date.getYear(), date.getMonth(), date.getDay());
                for (int i = 0; i < 3; i++) {
                    daysButtons[i].setText(Date.dateToString(tempDate));
                    tempDate.incrementDay();
                }
                tempDate = null;
            }
        });



        Date tempDate = new Date(date.getYear(), date.getMonth(), date.getDay());
        for(int i =0; i < 3;i++) {
            daysButtons[i].setAllCaps(false);
            daysButtons[i].setText(Date.dateToString(tempDate));
            tempDate.incrementDay();
        }
        tempDate = null;

        tl = (TableLayout)findViewById(R.id.tableLayout);
        tl.bringToFront();







        Toast talsToast = Toast.makeText(getApplicationContext(), "Go mov_on", Toast.LENGTH_LONG);
        talsToast.show();






        TableRow tr = new TableRow(this);
        for(int i =0; i < 3;i++) {
                tr.addView(daysButtons[i]);
        }


        TableRow[] tableRows = new TableRow[3];
        for(int i=0;i<3;i++)
            tableRows[i] = new TableRow(getApplicationContext());

        date = new Date(Calendar.currentYear(), Calendar.currentMonth(), Calendar.currentDayOfMonth());

        Time time = new Time(2015,1,1,1,1);
        List<User> participants = new ArrayList<User>();
        String eventDescription = "Work with mov_on.";

        Calendar.dateToDay.get(Date.formatDate(date)).addEvent(new CalendarEvent(time, participants,eventDescription));


        Time time2 = new Time(2015,1,1,1,1);
        List<User> participants2 = new ArrayList<User>();
        String eventDescription2 = "Work on Weex.";

        Date tempDate2 = new Date(date.getYear(),date.getMonth(),date.getDay());
        tempDate2.incrementDay();
        Calendar.dateToDay.get(Date.formatDate(tempDate2)).addEvent(new CalendarEvent(time2, participants2, eventDescription2));



        for(int i = 1;i<=3;i++){
            List<CalendarEvent> schedule = Calendar.dateToDay.get(Date.formatDate(date)).getSchedule();
            for(int j =0; j< schedule.size();j++){
                if(schedule.get(j) != null)
                {
                    TextView description = new TextView(this);
                    description.setWidth(0);
                    description.setText(schedule.get(j).getDescription());
                    tableRows[j].addView(description);
                }
            }
            date.incrementDay();
        }

        tl.addView(tr);
        for(int i=0; i<tableRows.length;i++)
        {
           tl.addView(tableRows[i]);
        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_daze, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

