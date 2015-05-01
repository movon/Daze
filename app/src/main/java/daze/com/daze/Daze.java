package daze.com.daze;

import android.animation.LayoutTransition;
import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.LayoutDirection;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;


public class Daze extends Activity {

    Calendar calendar;
    Button incrementDayButton;
    Date date;
    TextView dateTV;
    public static String[] months = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daze);

        calendar = new Calendar();

        dateTV = (TextView)findViewById(R.id.dateTV);
        date = new Date(2015,1,5);
        incrementDayButton = (Button)findViewById(R.id.incrementDayButton);
        incrementDayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date.incrementDay();
                dateTV.setText(Date.dateToString(date));
            }
        });

        Button[] daysButtons = new Button[3];
        for(int i =0; i < 3;i++) {
            daysButtons[i] = new Button(this);
            daysButtons[i].setText(months[java.util.Calendar.getInstance().get(java.util.Calendar.MONTH)] + " " + Time.dayToString(java.util.Calendar.getInstance().get(java.util.Calendar.DAY_OF_MONTH) + i));
            daysButtons[i].setAllCaps(false);
        }



        TableLayout tl = (TableLayout)findViewById(R.id.tableLayout);
        tl.bringToFront();




        TableRow tr = new TableRow(this);
        for(int i =0; i < 3;i++) {
                tr.addView(daysButtons[i]);
        }

        tl.addView(tr);



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
