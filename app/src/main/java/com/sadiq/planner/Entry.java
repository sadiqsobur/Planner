package com.sadiq.planner;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.List;

public class Entry extends Fragment {
    private Button button;
    public List<Event> events = new ArrayList<>();

    EditText eventName;
    EditText startTime;
    EditText endTime;
    EditText location;
    EditText day;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        button = button.findViewById(R.id.newEventButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Event event = new Event();
                eventName = eventName.findViewById(R.id.newEventText);
                startTime = startTime.findViewById(R.id.newEventStart);
                endTime = endTime.findViewById(R.id.newEventEnd);
                location = location.findViewById(R.id.newEventLocation);
                day = day.findViewById(R.id.newEventDay);
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
        return inflater.inflate(R.layout.entry_layout, container, false);
    }
}