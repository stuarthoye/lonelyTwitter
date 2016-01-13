package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by hoye on 1/12/16.
 */
public abstract class Tweet{
    private String text;
    private Date date;
    protected Boolean isImportant;

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
