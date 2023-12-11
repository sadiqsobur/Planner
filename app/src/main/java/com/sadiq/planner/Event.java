// Events are things one can add to the planner. The planner will display these events
// on the time sheet.
package com.sadiq.planner;

public class Event { // Event model file
    // Divide day into 15 minute intervals, making 96 intervals over 24 hours
    // Minute 0 is at 0:00. Minute 1439 is 23:59
    // Days are 1 through 5. Monday = 1, Friday = 5

    private String name; // event name, user can put whatever
    private String location; // event location, user can put whatever (room num, address, etc.)
    private int startTime;
    private int endTime;
    private int day;

    public String getName() { return name; }
    public String getLoc() { return location; }
    public int getStart() { return startTime; }

    public int getDay() { return day; }

    public void setName(String name) { this.name = name; }

    public void setLocation(String location) { this.location = location; }

    public void setStartTime(int startTime) { this.startTime = startTime; }

    public void setEndTime(int endTime) { this.endTime = endTime; }

    public void setDay(int day) { this.day = day; }
}