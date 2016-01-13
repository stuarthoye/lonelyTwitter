package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hoye on 1/12/16.
 *
 * This class very closely resembles the Tweet developed in-lab on Tuesday, January 12th.
 * This class has member variables to track the text of a tweet & the date of the tweet.
 * It also track whether the tweet is important with a Boolean.
 * Finally, the tweet holds an ArrayList to tack a list of moods associated with it.
 */
public abstract class Tweet{
    private String text;
    private Date date;
    protected Boolean isImportant;
    private List<MoodABC> moods = new ArrayList<MoodABC>();

    public abstract Boolean getIsImportant();

    // Constructor methods.
    public Tweet(Date date, String text) {
        this.date = date;
        this.text = text;
    }

    public Tweet(String text) {
        this.text = text;
    }

    // Getter methods.
    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }

    // Setter methods.
    public void setText(String text) throws Exception {
        if (text.length() > 140) {
            throw new TweetTooLongException();
        }
        this.text = text;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}
