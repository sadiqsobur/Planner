// Events are things one can add to the planner. The planner will display these events
// on the time sheet.
package com.sadiq.planner;

public class Event { // Event model file
    // Divide day into 15 minute intervals, making 96 intervals over 24 hours
    // However, we run the planner for only 16 hours, from 6 AM to 10 PM
    // This makes 16 * 4 = 64 intervals
    // Time = 0 corresponds to 6 AM, time = 1 corresponds to 6:15 AM
    // Days are 1 through 5. Monday = 1, Friday = 5

    private String name; // event name, user can put whatever
    private String location; // event location, user can put whatever (room num, address, etc.)
    private int startTime;
    private int endTime;

    public Event(String name, String location, int startTime, int endTime) {
        this.name = name;
        this.location = location;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public String getName() { return name; }
    public String getLocation() { return location; }
    public int getStart() { return startTime; }
    public int getEnd() { return endTime; }
    public void setName(String name) { this.name = name; }

    public void setLocation(String location) { this.location = location; }

    public void setStartTime(int startTime) { this.startTime = startTime; }

    public void setEndTime(int endTime) { this.endTime = endTime; }
}