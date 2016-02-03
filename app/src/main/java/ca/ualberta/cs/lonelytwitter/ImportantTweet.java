package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by hoye on 1/12/16.
 * @see Tweet Tweet for more information
 *
 * This class inherits from Tweet, and represents a very lonely but very important tweet.
 */
public class ImportantTweet extends Tweet implements Tweetable {

    /**
     * Allows the user to define the date that the tweet occurred on
     * @param date the date associated with a given tweet
     * @param text the message body of the tweet
     */
    public ImportantTweet(Date date, String text) {
        super(date, text);
    }

    /**
     * This constructor defaults the tweet's date to today's date
     * @param text is the body of the tweet message.
     */
    public ImportantTweet(String text) {
        super(text);
    }

    /**
     * This method allows the user to determine whether the tweet is important.
     * @return True 100% of the time, since this tweet will always be important.
     */
    @Override
    public Boolean getIsImportant() {
        return Boolean.TRUE;
    }

}
