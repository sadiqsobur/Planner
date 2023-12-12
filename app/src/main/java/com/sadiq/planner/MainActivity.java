package com.sadiq.planner;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConstraintLayout constraintLayout = findViewById(R.id.constraintLayout);
        TableLayout tableLayout = findViewById(R.id.BigTable);
        // LinearLayout linearLayout = findViewById(R.id.linearLayout);

        List<Event> events = new ArrayList<>(); // example events for testing
        events.add(new Event("Math", "NAC", 8, 13, 2));
        events.add(new Event("English", "Shepard", 4, 10, 3));
        events.add(new Event("Science", "Steinman", 2, 6, 2));
        events.add(new Event("Physics", "Steinman", 2, 4, 4));
        events.add(new Event("Art", "Steinman", 6, 7, 5));
        events.add(new Event("Social Studies", "Steinman", 8, 16, 1));

        populateTable(tableLayout);
        Resources res = getResources(); // resources
        int[] colors = res.getIntArray(R.array.rainbow);
        for (Event e : events) {
            for (int i = e.getStart(); i < e.getEnd(); i++) {
                // TextView creation and configuration
                TextView text = (TextView) getCell(tableLayout, i, e.getDay());
                text.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
                text.setMaxWidth(30);
                text.setAutoSizeTextTypeUniformWithConfiguration(10, 16, 1, TypedValue.COMPLEX_UNIT_DIP);
                text.setLines(2);
                text.setPadding(10, 10, 10, 0);
                // Setting the text
                String t = e.getName() + "\n" + e.getLocation();
                if (i == e.getStart()) {
                    text.setText(t);
                    text.setTextColor(getColor(R.color.white));
                }
                text.setBackgroundColor(colors[e.getDay() + 2]);
            }
        }

        setContentView(constraintLayout);
    }

    private void populateTable(TableLayout tableLayout)
    {
        for (int i = 0; i < 17; i++)
        {
            TableRow row = (TableRow) tableLayout.getChildAt(i);
            for (int j = 0; j < 6; j++)
            {
                if (getCell(tableLayout,i, j) == null)
                {
                    TextView t = new TextView(this);
                    row.addView(t);
                }
            }
        }
    }
    private View getCell(TableLayout tableLayout, int row, int col)
    {
        TableRow tabRow = (TableRow) tableLayout.getChildAt(row);
        if (tabRow != null)
            return tabRow.getChildAt(col);

        return null;
    }


    // accessing row and column. Each row (TableRow) is a child of TableLayout. Each
    // column in the row is then a child of TableRow
    // So to access (or create a view) at a c
}