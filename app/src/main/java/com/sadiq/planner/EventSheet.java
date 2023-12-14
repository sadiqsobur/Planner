package com.sadiq.planner;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EventSheet extends Fragment {
    @RequiresApi(api = Build.VERSION_CODES.O)

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.event_layout, container, false);
    }
    public void onViewCreated(Bundle savedInstanceState) {
        View v = getView();
        ConstraintLayout constraintLayout = v.findViewById(R.id.constraintLayout);
        TableLayout tableLayout = v.findViewById(R.id.BigTable);
        // LinearLayout linearLayout = findViewById(R.id.linearLayout);

        List<Event> events = new ArrayList<>(); // example events for testing
        events.add(new Event("Math", "NAC", 8, 13, 2));
        events.add(new Event("English", "Shepard", 4, 10, 3));
        events.add(new Event("CSC 221", "Steinman", 2, 6, 2));
        events.add(new Event("Physics", "Steinman", 2, 4, 4));
        events.add(new Event("Art", "Steinman", 6, 7, 5));
        events.add(new Event("Science", "MR-3", 8, 16, 1));

        populateTable(tableLayout);

        Resources res = getResources(); // resources
        int[] colors = res.getIntArray(R.array.rainbow);

        for (Event e : events) {
            int cooler = colors[randColor()];
            for (int i = e.getStart(); i < e.getEnd(); i++) {
                // TextView creation and configuration
                TextView text = (TextView) getCell(tableLayout, i, e.getDay());
                text.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
                text.setEllipsize(TextUtils.TruncateAt.END);
                text.setWidth(30);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    text.setAutoSizeTextTypeUniformWithConfiguration(10, 16, 1, TypedValue.COMPLEX_UNIT_DIP);
                }
                text.setLines(2);
                text.setPadding(10, 10, 10, 0);
                // Setting the text
                String t = e.getName() + "\n" + e.getLocation();
                if (i == e.getStart()) {
                    text.setText(t);
                    text.setTextColor(0);
                }

                text.setBackgroundColor(cooler);
            }
        }
    }

    private int randColor() // NOT BLACK OR WHITE
    {
        Random rand = new Random();
        return rand.nextInt(13) + 2;
    }

    // Populates the table layout with TextViews that can be altered
    private void populateTable(TableLayout tableLayout)
    {
        for (int i = 0; i < 17; i++)
        {
            TableRow row = (TableRow) tableLayout.getChildAt(i);
            for (int j = 0; j < 6; j++)
            {
                if (getCell(tableLayout,i, j) == null)
                {
                    TextView t = new TextView(getActivity());
                    row.addView(t);
                }
            }
        }
    }

    // This is here to get the view at a position in the table
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