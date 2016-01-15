package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by hoye on 1/12/16.
 *
 * This interface ensures that all Mood-type objects that use it will have the interfaces required.
 */
public interface Moody {
    public Date getDate();
    public void setDate(Date date);
    public String getMood();
}
