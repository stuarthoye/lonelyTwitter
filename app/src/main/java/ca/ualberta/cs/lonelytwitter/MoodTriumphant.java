package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by hoye on 1/12/16.
 *
 * This mood is triumphant, and inherits from the MoodABC.
 * The two constructors are the default and date-specified constructors.  They reference the super's
 * constructors in order to complete their construction.
 * The format method returns a string with an appropriate exclamation mark to describe the mood.
 */

public class MoodTriumphant extends MoodABC implements Moody {
    // Constructor methods.
    public MoodTriumphant() {
        super();
        this.mood = "Triumphant";
    }

    public MoodTriumphant(Date date) {
        super(date);
        this.mood = "Triumphant";
    }

    // Mood-specific format method.
    public String getMood(){
        return this.mood + "!";
    }
}
