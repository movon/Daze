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


public class Daze extends Activity {

    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daze);

        calendar = new Calendar();

        //RelativeLayout rl = (RelativeLayout)findViewById(R.id.relativeLayout);

        Button today = new Button(this);
        today.setText("Today");

        TableLayout tl = (TableLayout)findViewById(R.id.tableLayout);
        tl.setX(0);
        tl.setY(0);
        TableLayout.LayoutParams tllp = new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT);



        TableRow tr = new TableRow(this);
        TableLayout.LayoutParams lp2 = new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.MATCH_PARENT);
        tr.addView(today, tllp);

        tl.addView(tr, lp2);



        //rl.addView(tl, tllp);


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
