package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hoye on 1/12/16.
 *
 * This class very closely resembles the Tweet developed in-lab on Tuesday, January 12th, 2016.
 * This class has member variables to track the text of a tweet & the date of the tweet.
 * It also tracks whether the tweet is important with a Boolean.
 * Finally, the tweet holds an ArrayList to track a list of moods associated with it.
 *
 * Syntax for list declaration from StackOverflow:
 * http://stackoverflow.com/questions/858572/how-to-make-a-new-list-in-java
 * Accessed Jan 12, 2016
 * Author: Dan Vinton
 */

//  Try to implement an override of the compareTo method
//  Implement the Comparable interface
//  See: http://beginnersbook.com/2013/12/java-arraylist-of-object-sort-example-comparable-and-comparator/
//  Date: Jan 26, 2016

public abstract class Tweet {
    private String text;
    private Date date;
    protected Boolean isImportant;
    protected List<MoodABC> moods = new ArrayList<MoodABC>();

    public abstract Boolean getIsImportant();

    // Constructor methods.
    public Tweet(Date date, String text) {
        this.date = date;
        this.text = text;
    }

    public Tweet(String text) {
        this.date = new Date();
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

    @Override
    public String toString() {
        return this.date.toString() + " | " + this.text;
    }

}
