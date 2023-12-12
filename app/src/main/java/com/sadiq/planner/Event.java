// Events are things one can add to the planner. The planner will display these events
// on the time sheet.
package com.sadiq.planner;

public class Event { // Event model file
    // Divide day into 1 hours intervals, from 6 AM to 10 PM.
    // That makes 6 AM = 1, 10 PM = 16

    private String name; // event name, user can put whatever
    private String location; // event location, user can put whatever (room num, address, etc.)
    private int startTime;
    private int endTime;
    private int day;

    public Event(String name, String location, int startTime, int endTime, int day) {
        this.name = name;
        this.location = location;
        this.startTime = startTime;
        this.endTime = endTime;
        this.day = day;
    }
    public String getName() { return name; }
    public String getLocation() { return location; }
    public int getStart() { return startTime; }
    public int getEnd() { return endTime; }
    public int getDay() { return day; }
    public void setName(String name) { this.name = name; }

    public void setLocation(String location) { this.location = location; }

    public void setStartTime(int startTime) { this.startTime = startTime; }

    public void setEndTime(int endTime) { this.endTime = endTime; }
}