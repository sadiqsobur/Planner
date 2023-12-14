package com.sadiq.planner;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.List;

public class Entry extends AppCompatActivity {
    private Button button;
    public List<Event> events = new ArrayList<>();

    EditText eventName;
    EditText startTime;
    EditText endTime;
    EditText location;
    EditText day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entry_layout);
        button = findViewById(R.id.newEventButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Event event = new Event();
                eventName = findViewById(R.id.newEventText);
                startTime = findViewById(R.id.newEventStart);
                endTime = findViewById(R.id.newEventEnd);
                location = findViewById(R.id.newEventLocation);
                day = findViewById(R.id.newEventDay);
                event.setName(eventName.getText().toString());
                event.setLocation(location.getText().toString());
                String dayString = day.getText().toString();
                String startTimeString = startTime.getText().toString();
                String endTimeString = endTime.getText().toString();
                event.setEndTime(Integer.parseInt(endTimeString));
                event.setStartTime(Integer.parseInt(startTimeString));
                event.setDay(Integer.parseInt(dayString));
                events.add(event);
            }
        });
    }
}