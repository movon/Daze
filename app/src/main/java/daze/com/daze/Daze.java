package daze.com.daze;

import android.animation.LayoutTransition;
import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.LayoutDirection;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.ArrayList;


public class Daze extends Activity {

    Calendar calendar;

    String[] months = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daze);

        calendar = new Calendar(new ArrayList<Year>());


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





        /*
        TableLayout prices = (TableLayout)findViewById(R.id.prices);
        prices.setStretchAllColumns(true);
        prices.bringToFront();
        for(int i = 0; i < drug.length; i++){
            TableRow tr =  new TableRow(this);
            TextView c1 = new TextView(this);
            c1.setText(drug[i].getName());
            TextView c2 = new TextView(this);
            c2.setText(String.valueOf(drug[i].getPrice()));
            TextView c3 = new TextView(this);
            c3.setText(String.valueOf(drug[i].getAmount()));
            tr.addView(c1);
            tr.addView(c2);
            tr.addView(c3);
            prices.addView(tr);
        }*/

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
