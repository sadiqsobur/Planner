package com.sadiq.planner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout constraintLayout = findViewById(R.id.constraintLayoutParent);

        List<Event> events = new ArrayList<>(); // example events for testing
        events.add(new Event("Math", "NAC", 8,13));
        events.add(new Event("English", "Steinman", 32, 37));

        for (Event e: events)
        {
            addEventTextView(constraintLayout, e);
        }
    }

    private void addEventTextView(ConstraintLayout c, Event e) {
        TextView eventTextView = new TextView(this);
        eventTextView.setText(e.getName());

        // Set layout parameters
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
        );
        eventTextView.setLayoutParams(layoutParams);

        // Add the view to the ConstraintLayout
        c.addView(eventTextView);

        // Set constraints based on event time
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(c);


        // Set top and bottom constraints based on event start and end times
        constraintSet.connect(eventTextView.getId(), ConstraintSet.TOP, c.getId(), ConstraintSet.TOP, e.getStart() * getResources().getDimensionPixelSize(R.dimen.time_block_height));
        constraintSet.connect(eventTextView.getId(), ConstraintSet.BOTTOM, c.getId(), ConstraintSet.TOP, e.getEnd() * getResources().getDimensionPixelSize(R.dimen.time_block_height));

        // Add more constraints as needed

        constraintSet.applyTo(c);
    }
}