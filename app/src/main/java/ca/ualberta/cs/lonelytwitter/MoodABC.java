package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by hoye on 1/12/16.
 *
 * This is an abstract base class that represents a mood, and associates a date with that mood.
 * This base class has two constructors, one which takes a date as an argument, and another that
 * defaults the objects date field to today's date.
 * The member variables are encapsulated by protecting them, allowing inheriting objects to access
 * them.
 * Getter & Setter methods are implemented for this class, and will also be available to any object
 * inheriting from this.
 * Two constructors are defined for this abstract base class, the default & date-specified ones.
 */

public abstract class MoodABC {
    // Member variables are set to protected for encapsulation.
    protected String mood;
    protected Date date;

    // Constructor methods.
    public MoodABC() {
        this.date = new Date();
    }

    public MoodABC(Date date) {
        this.date = date;
    }

    // Getter methods.
    public String getMood() {
        return mood;
    }

    public Date getDate() {
        return date;
    }

    // Setter methods.
    public void setMood(String mood) {
        this.mood = mood;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
