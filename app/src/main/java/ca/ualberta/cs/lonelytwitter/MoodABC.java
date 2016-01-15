package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by hoye on 1/12/16.
 *
 * This is an abstract base class that represents a mood, and associates a date with that mood.
 * This base class has two constructors, one which takes a date as an argument, and another that
 * defaults the object's date field to today's date.
 * The mood variable is left uninitialized in the abstract class, since the subclasses will define
 * it in their constructors.
 * The member variables are encapsulated by protecting them, allowing only inheriting objects to
 * access them.
 * Getter & Setter methods are implemented for this class, and will also be available to any object
 * inheriting from MoodABC.
 * Two constructors are defined for this abstract base class, the default & date-specified ones.
 * A setter method for mood has been omitted because the string should be specific to the inheriting
 * type of mood, and should not be altered. (ie: a MoodAngry object should always have an "Angry"
 * string associated with it).
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

    // Setter method.
    public void setDate(Date date) {
        this.date = date;
    }
}
