package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by hoye on 1/12/16.
 * This mood is inquisitive, and inherits from the MoodABC.
 * The two constructors are the default and date-specified constructors.  They reference the super's
 * constructors in order to complete their construction.
 * The getMood() method returns a string with an appropriate ellipsis to describe the mood.
 */

public class MoodInquisitive extends MoodABC implements Moody {
    // Constructor methods.
    public MoodInquisitive() {
        super();
        this.mood = "Inquisitive";

    }

    public MoodInquisitive(Date date) {
        super(date);
        this.mood = "Inquisitive";
    }

    // Mood-specific format method.
    public String getMood(){
        return this.mood + "...";
    }
}
